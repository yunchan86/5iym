package com.iyoumei.util.clientversion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author lijf
 * 
 */
public class ClientVersionControler {
	private static String clientInfoFileName = ClientVersionControler.class.getResource("/")
			+ "resources/clientVersionControler.xml";
	private static long lastModified = 0l;// 文件的最后修改时间
	private static Map<String, List<AppClientInfo>> appMap = null;

	private static AtomicBoolean ab = new AtomicBoolean(false);

	private static Map<String, ClientUpdateInfo> infoMap = new HashMap<String, ClientUpdateInfo>();

	/**
	 * 得到版本信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void init(String callType, int v) throws Exception {
		boolean mustCheck = false;
		if (infoMap.get(callType + v) == null)
			mustCheck = true;
		if (!mustCheck && System.currentTimeMillis() - lastModified > 30 * 1000) {
			return;
		}
		if (ab.compareAndSet(false, true)) {
			try {
				File file = new File(new URI(clientInfoFileName));
				file = new File(new URI(clientInfoFileName));
				if (file.exists() && lastModified != file.lastModified()) {

					XStream xs = new XStream(new DomDriver());
					xs.alias("item", AppClientInfo.class);
					xs.alias("rows", List.class);
					FileInputStream fis = null;
					try {
						fis = new FileInputStream(file);
						Object obj = xs.fromXML(fis);
						appMap = (Map<String, List<AppClientInfo>>) obj;
						lastModified = file.lastModified();
					} finally {
						try {
							if (fis != null)
								fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				List<AppClientInfo> appInfoList = appMap.get(callType);
				AppClientInfo newestInfo = null;// 最新版本信息
				boolean isMustUpdate = false;// 是否必须更新（客户端当前版本与服务器最新版本之间有一个必须更新的版本，则必须更新）
				if (appInfoList != null && appInfoList.size() > 0) {
					for (AppClientInfo info : appInfoList) {
						if (newestInfo == null)
							newestInfo = info;
						else if (info.getVersion() > newestInfo.getVersion()) {
							newestInfo = info;
							if (info.isMustUpdate() && !isMustUpdate) {
								isMustUpdate = true;
							}
						}

					}

					ClientUpdateInfo info = new ClientUpdateInfo();
					if (v >= newestInfo.getVersion()) {
						info.setFresh(true);
						info.setFilePath(newestInfo.getFilePath());
						info.setMustUpdate(false);
						info.setUpdateTime(newestInfo.getUpdateTime());
						info.setVersion(newestInfo.getVersion());
						info.setVersionCode(newestInfo.getVersionCode());
						info.setContent(newestInfo.getContent().trim().replaceAll("\t", ""));
					} else {
						info.setFresh(false);
						info.setFilePath(newestInfo.getFilePath());
						info.setMustUpdate(isMustUpdate);
						info.setUpdateTime(newestInfo.getUpdateTime());
						info.setVersion(newestInfo.getVersion());
						info.setVersionCode(newestInfo.getVersionCode());
						info.setContent(newestInfo.getContent().trim().replaceAll("\t", ""));
					}
					infoMap.put(callType + v, info);
				}
			} finally {
				ab.set(false);
			}

		}
	}

	/**
	 * 获取版本更新信息
	 * 
	 * @param callType
	 * @param v
	 * @return
	 * @throws Exception
	 */
	public static ClientUpdateInfo getClientVersionInfo(String callType, int v) throws Exception {
		init(callType, v);
		return infoMap.get(callType + v);
	}

}
