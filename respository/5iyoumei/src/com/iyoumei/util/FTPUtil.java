package com.iyoumei.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUtil {
	private final static Log logger = LogFactory.getLog(FTPUtil.class);
	private static Long lastModify = 0l;// 文件的最后修改时间，用于更新配置文件数据
	private static final String propFilePath = FTPUtil.class.getResource("/") + "resources/ftp-config.properties";// prop文件路径

	private static String url;// ftp connect url
	private static int port;// ftp port
	private static String username;// 用户名
	private static String pwd;// 密码

	/**
	 * 初始化
	 */
	private static void init() {
		if (System.currentTimeMillis() - lastModify < 30000)// 每30秒检查一次
			return;
		Properties properties = new Properties();
		AtomicBoolean ab = new AtomicBoolean(false);
		if (ab.compareAndSet(false, true)) {
			FileInputStream fis = null;
			try {
				File file = new File(new URI(propFilePath));

				if (file != null && file.exists() && (lastModify == null || lastModify != file.lastModified())) {// 文件存在且文档有更新
					fis = new FileInputStream(file);
					properties.load(fis);
					port = Integer.parseInt(properties.getProperty("ws.ftp.port", "21"), 10);
					url = properties.getProperty("ws.ftp.url");
					username = properties.getProperty("ws.ftp.username");
					pwd = properties.getProperty("ws.ftp.pwd");
				}
			} catch (Exception e) {
				logger.error("", e);
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						logger.error("ftp-config.properties配置文件通道关闭失败", e);
					}
				}
				ab.set(false);
			}
		}
	}

	/**
	 * 新建ftp连接
	 * 
	 * @return
	 */
	private static FTPClient connect() throws Exception {
		init();
		FTPClient ftp = null;
		ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8");
		FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
		conf.setServerLanguageCode("zh");
		ftp.connect(url, port);// 连接FTP服务器
		ftp.enterLocalActiveMode();// 设置为主动连接模式
		ftp.login(username, pwd);
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		return ftp;
	}

	/**
	 * 关闭ftp连接
	 * 
	 * @param ftp
	 */
	private static void disconnect(FTPClient ftp) throws Exception {
		if (ftp != null && ftp.isConnected()) {
			ftp.logout();
			ftp.disconnect();
		}
	}

	/**
	 * 上传图片
	 * 
	 * @param path
	 *            ftp服务器的文件夹
	 * @param subpath
	 *            基于path下的子目录
	 * @param filename
	 *            上传到ftp服务上文件名称
	 * @param data
	 *            文件的字节数据
	 * @return
	 */
	public static boolean uploadFile(String path, String subpath, String filename, byte[] data) throws Exception {
		boolean b = false;
		FTPClient ftp = null;
		InputStream in = null;
		try {
			if (data.length > 1024 * 1024 * 2) {
				throw new Exception("上传文件太大，请不要超过2M");
			}
			int reply;
			ftp = connect();
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				throw new Exception("ftp文件上传连接失败，请查看配置参数");
			}
			ftp.changeWorkingDirectory(path);
			ftp.makeDirectory(subpath);
			FTPFile[] files = ftp.listFiles(subpath);
			for (int i = 0; i < files.length; i++) {
				String fname = files[i].getName();
				if (fname.equals(filename)) {// 如果相等则执行备份或者是删除操作
					ftp.deleteFile(subpath + "/" + filename);
				}
			}
			in = new ByteArrayInputStream(data);
			b = ftp.storeFile(subpath + "/" + filename, in); // 上传文件
		} finally {
			disconnect(ftp);
			if (in != null)
				in.close();
		}
		return b;
	}

	public static boolean deleteFile(String path, String subpath, String filename) throws Exception {
		boolean b = false;
		FTPClient ftp = null;
		try {
			int reply;
			ftp = connect();
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				throw new Exception("ftp文件上传连接失败，请查看配置参数");
			}
			ftp.changeWorkingDirectory(path);
			ftp.makeDirectory(subpath);
			FTPFile[] files = ftp.listFiles(subpath);
			for (int i = 0; i < files.length; i++) {
				String fname = files[i].getName();
				if (fname.equals(filename)) {
					ftp.deleteFile(subpath + "/" + filename);
				}
			}
		} finally {
			disconnect(ftp);
		}
		return b;
	}

}
