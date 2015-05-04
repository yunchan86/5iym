package com.iyoumei.util.bean;


import java.util.Date;

import com.iyoumei.util.StringUtil;

/**
 * 日志内容的记录
 * @author CHY
 *
 */
public class LogBean {

	/*******************************************以下为日志数据字段 ***********************************************/
	private String serialId ;//唯一的序列ID，对应一个唯一的线程处理
	private String key ;//关键字
	private String classMethod ;//相关类的方法
	private String params ;//调用的参数
	private String content ;//内容
	private Exception exception ;//抛出的异常对象
	private long timeId ;
	private StringBuffer logAppend ;
	private String errorCode ;
	
	/*******************************************以下为控制配置字段 ***********************************************/
	private String printStepFlag = "0" ;//0-表示只打印本次的content，1-表示打印所有的步骤的日志。
	private String printContentFlag = "1" ;//0-表示打印短内容，1-表示打印所有的内容.
	private int infoCount = 0 ;
	private int errorCount = 0 ;
	private int debugCount = 0 ;
	private int traceCount = 0 ;
	private String currentLevel = "DEBUG" ;
	private String errorCodePrint = "0" ;//0-未打印,1-已经打印
	
	
	public LogBean(String classMethod,String key,String params,String content) {
		this.serialId = StringUtil.generateUUID() ;
		this.classMethod = classMethod ;
		this.key = key ;
		this.params = params ;
		this.content = content ;
		this.timeId = new Date().getTime() ;
		if(logAppend==null) logAppend = new StringBuffer() ;
	}
	public LogBean(String classMethod,String key,String params,String content,Exception exception) {
		this(classMethod, key, params, content) ;
		this.exception = exception ;
	}
	/**
	 * 设置发生异常的数据显示，默认是对logAppend字符串进行附加的。
	 * @param content
	 * @param e
	 */
	public void setContentException(String content,Exception exception) {
		boolean append = true ;
		this.setContentException(content, exception, append) ;
	}
	
	public void setContentException(String content,Exception exception,boolean append) {
		this.content = content ;
		if(exception!=null) this.exception = exception ;
		if(exception!=null) this.printStepFlag="1" ;
		if(StringUtil.isNull(content)) return ;
		if(append) {
			String contentFlow = "[seq_no="+this.serialId+"]"+content ;
			this.logAppend.append(contentFlow+"\n") ;
		}
	}
	
	public void setErrorContentException(String errorCode,String content,Exception exception,boolean append) {
		if(!StringUtil.isNull(errorCode)) {
			if(!StringUtil.equals(errorCode, this.errorCode)) {
				this.errorCodePrint = "0" ;//重置为需要打印
			}
			this.errorCode = errorCode ;
		}
		this.content = content ;
		if(exception!=null) this.exception = exception ;
		if(exception!=null) this.printStepFlag="1" ;
		if(StringUtil.isNull(content)) return ;
		if(append) {
			String contentFlow = "[seq_no="+this.serialId+"]"+content ;
			//if(!StringUtil.isNull(this.errorCode)) contentFlow = this.errorCode + contentFlow ;
			this.logAppend.append(contentFlow+"\n") ;
		}
	}
	//设置控制日志打印的控制
	private void setConfigData() {
		if(StringUtil.equals(currentLevel, "TRACE")) {
			traceCount++ ;
			if(traceCount==1) printContentFlag = "1" ;
		}else if(StringUtil.equals(currentLevel, "DEBUG")) {
			debugCount++ ;
			if(debugCount==1) printContentFlag = "1" ;
		}else if(StringUtil.equals(currentLevel, "INFO")) {
			infoCount++ ;
			if(infoCount==1) printContentFlag = "1" ;
		}else if(StringUtil.equals(currentLevel, "ERROR")) {
			errorCount++ ;
			if(errorCount==1) printContentFlag = "1" ;
		}
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getClassMethod() {
		return classMethod;
	}
	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	
	public String getPrintStepFlag() {
		return printStepFlag;
	}
	public void setPrintStepFlag(String printStepFlag) {
		this.printStepFlag = printStepFlag;
	}
	
	public String getPrintContentFlag() {
		return printContentFlag;
	}
	public void setPrintContentFlag(String printContentFlag) {
		this.printContentFlag = printContentFlag;
	}
	public String toStringLog() {
		setConfigData() ;
		StringBuffer sb = new StringBuffer() ;
		if((!StringUtil.isNull(this.errorCode))&&StringUtil.equals(currentLevel, "ERROR")&&StringUtil.equals(this.errorCodePrint, "0")) {
			this.errorCodePrint = "1" ;//已经打印,下次不打印
			sb.append("\n+++"+this.errorCode+"[seq_no="+this.serialId+"]"+"\n") ;
		}
		sb.append("[seq_no="+this.serialId+"]") ;
		if(StringUtil.equals(this.printContentFlag, "1")) {
			sb.append("[time_id="+this.timeId+"]") ;
			sb.append("[class_method="+this.classMethod+"]") ;
			sb.append("[key="+this.key+"]") ;
			sb.append("[params="+this.params+"]") ;
		}
		if(StringUtil.equals(currentLevel, "ERROR")) sb.append(this.logAppend.toString()) ;//打印前面运行步骤的内容
		if(!StringUtil.isNull(content)) sb.append(this.content) ;
		return sb.toString() ;
	}
	public String getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}
	
}
