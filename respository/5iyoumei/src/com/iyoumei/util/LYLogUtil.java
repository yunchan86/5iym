package com.iyoumei.util;

import org.apache.commons.logging.Log;

import com.iyoumei.util.bean.LogBean;
/**
 * 雅酷日志工具类
 * @author CHY
 *
 */
public class LYLogUtil {
	
	//==================================DEBUG===============================
	/**
	 * 直接记录内容到日志文件中
	 * @param log		日志对象
	 * @param content	日志内容
	 */
	public static void debug(Log log,String content) {
		if(log!=null) log.debug(content) ;
	}
	/**
	 * 将错误日志记录到日志文件中
	 * @param log		日志对象
	 * @param content	日志内容
	 * @param e			抛出异常对象
	 */
	public static void debug(Log log,String content,Exception e) {
		if(log!=null) log.debug(content,e) ;
	}
	/**
	 * 将包含有线程ID的内容日志记录到日志文件中
	 * @param log		日志对象
	 * @param threadId	线程ID
	 * @param content	日志内容
	 */
	public static void debug(Log log,String threadId,String content) {
		if(log!=null) {
			content = "[seq_no="+threadId+"]"+content ;
			LYLogUtil.debug(log,content) ;
		}
	}
	/**
	 * 记录包含线程ID、参数的日志信息到日志文件中
	 * @param log
	 * @param threadId
	 * @param params
	 * @param content
	 */
	public static void debug(Log log,String threadId,String params,String content) {
		if(log!=null) {
			content = "["+params+"]"+content ;
			LYLogUtil.debug(log,threadId,content) ;
		}
	}
	/**
	 * 记录包含线程ID的异常日志信息
	 * @param log		日志对象
	 * @param threadId	线程ID
	 * @param content	日志内容
	 * @param e			Exception异常对象
	 */
	public static void debug(Log log,String threadId,String content,Exception e) {
		if(log!=null) {
			content = "[seq_no="+threadId+"]"+content ;
			LYLogUtil.info(log,content,e) ;
		}
	}
	/**
	 * 记录包含线程ID、参数的异常日志信息
	 * @param log		日志对象
	 * @param threadId	线程ID
	 * @param params	参数数据
	 * @param content	日志内容
	 * @param e			Exception异常对象
	 */
	public static void debug(Log log,String threadId,String params,String content,Exception e) {
		if(log!=null) {
			content = "["+params+"]"+content ;
			LYLogUtil.debug(log,threadId,content,e) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param keyId
	 * @param params
	 * @param content
	 */
	public static void debug(Log log,String threadId,String keyId,String params,String content) {
		if(log!=null) {
			content = "["+keyId+"]["+params+"]"+content ;
			LYLogUtil.debug(log,threadId,content) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param keyId
	 * @param params
	 * @param content
	 */
	public static void debug(Log log,String threadId,String keyId,String params,String content,Exception e) {
		if(log!=null) {
			content = "[key="+keyId+"]["+params+"]"+content ;
			LYLogUtil.debug(log,threadId,content,e) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param classmethod
	 * @param keyId
	 * @param params
	 * @param content
	 */
	public static void debug(Log log,String threadId,String classmethod,String keyId,String params,String content) {
		if(log!=null) {
			content = "[method="+classmethod+"][key="+keyId+"]["+params+"]"+content ;
			LYLogUtil.debug(log,threadId,content) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param classmethod
	 * @param keyId
	 * @param params
	 * @param content
	 * @param e
	 */
	public static void debug(Log log,String threadId,String classmethod,String keyId,String params,String content,Exception e) {
		if(log!=null) {
			content = "[method="+classmethod+"][key="+keyId+"]["+params+"]"+content ;
			LYLogUtil.debug(log,threadId,content,e) ;
		}
	}
	/**
	 * 记录实体bean的日志
	 * @param log
	 * @param logbean
	 */
	public static void debug(Log log,LogBean logbean) {
		if(log!=null&&logbean!=null) {
			logbean.setCurrentLevel("DEBUG") ;
			if(logbean.getException()!=null)
				LYLogUtil.debug(log,logbean.toStringLog(),logbean.getException()) ;
			else LYLogUtil.debug(log,logbean.toStringLog()) ;
		}
	}
	/**
	 * 同时记录对象的异常日志
	 * @param log
	 * @param logbean
	 * @param exceptionFlag	true-表示记录异常，false-不是不记录异常
	 */
	public static void debug(Log log,LogBean logbean,boolean exceptionFlag) {
		if(log!=null&&logbean!=null) {
			logbean.setCurrentLevel("DEBUG") ;
			if(exceptionFlag&&logbean.getException()!=null)
				LYLogUtil.debug(log,logbean.toStringLog(),logbean.getException()) ;
			else LYLogUtil.debug(log,logbean.toStringLog()) ;
		}
	}
	//==================================INFO===============================
	/**
	 * 直接记录内容到日志文件中
	 * @param log		日志对象
	 * @param content	日志内容
	 */
	public static void info(Log log,String content) {
		if(log!=null) log.info(content) ;
	}
	/**
	 * 将错误日志记录到日志文件中
	 * @param log		日志对象
	 * @param content	日志内容
	 * @param e			抛出异常对象
	 */
	public static void info(Log log,String content,Exception e) {
		if(log!=null) log.info(content,e) ;
	}
	/**
	 * 将包含有线程ID的内容日志记录到日志文件中
	 * @param log		日志对象
	 * @param threadId	线程ID
	 * @param content	日志内容
	 */
	public static void info(Log log,String threadId,String content) {
		if(log!=null) {
			content = "[seq_no="+threadId+"]"+content ;
			LYLogUtil.info(log,content) ;
		}
	}
	/**
	 * 记录包含线程ID、参数的日志信息到日志文件中
	 * @param log
	 * @param threadId
	 * @param params
	 * @param content
	 */
	public static void info(Log log,String threadId,String params,String content) {
		if(log!=null) {
			content = "["+params+"]"+content ;
			LYLogUtil.info(log,threadId,content) ;
		}
	}
	/**
	 * 记录包含线程ID的异常日志信息
	 * @param log		日志对象
	 * @param threadId	线程ID
	 * @param content	日志内容
	 * @param e			Exception异常对象
	 */
	public static void info(Log log,String threadId,String content,Exception e) {
		if(log!=null) {
			content = "[seq_no="+threadId+"]"+content ;
			LYLogUtil.info(log,content,e) ;
		}
	}
	/**
	 * 记录包含线程ID、参数的异常日志信息
	 * @param log		日志对象
	 * @param threadId	线程ID
	 * @param params	参数数据
	 * @param content	日志内容
	 * @param e			Exception异常对象
	 */
	public static void info(Log log,String threadId,String params,String content,Exception e) {
		if(log!=null) {
			content = "["+params+"]"+content ;
			LYLogUtil.info(log,threadId,content,e) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param keyId
	 * @param params
	 * @param content
	 */
	public static void info(Log log,String threadId,String keyId,String params,String content) {
		if(log!=null) {
			content = "["+keyId+"]["+params+"]"+content ;
			LYLogUtil.info(log,threadId,content) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param keyId
	 * @param params
	 * @param content
	 */
	public static void info(Log log,String threadId,String keyId,String params,String content,Exception e) {
		if(log!=null) {
			content = "[key="+keyId+"]["+params+"]"+content ;
			LYLogUtil.info(log,threadId,content,e) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param classmethod
	 * @param keyId
	 * @param params
	 * @param content
	 */
	public static void info(Log log,String threadId,String classmethod,String keyId,String params,String content) {
		if(log!=null) {
			content = "[method="+classmethod+"][key="+keyId+"]["+params+"]"+content ;
			LYLogUtil.info(log,threadId,content) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param classmethod
	 * @param keyId
	 * @param params
	 * @param content
	 * @param e
	 */
	public static void info(Log log,String threadId,String classmethod,String keyId,String params,String content,Exception e) {
		if(log!=null) {
			content = "[method="+classmethod+"][key="+keyId+"]["+params+"]"+content ;
			LYLogUtil.info(log,threadId,content,e) ;
		}
	}
	/**
	 * 记录实体bean的日志
	 * @param log
	 * @param logbean
	 */
	public static void info(Log log,LogBean logbean) {
		if(log!=null&&logbean!=null) {
			logbean.setCurrentLevel("INFO") ;
			if(logbean.getException()!=null)
				LYLogUtil.info(log,logbean.toStringLog(),logbean.getException()) ;
			else LYLogUtil.info(log,logbean.toStringLog()) ;
		}
	}
	/**
	 * 同时记录对象的异常日志
	 * @param log
	 * @param logbean
	 * @param exceptionFlag	true-表示记录异常，false-不是不记录异常
	 */
	public static void info(Log log,LogBean logbean,boolean exceptionFlag) {
		if(log!=null&&logbean!=null) {
			logbean.setCurrentLevel("INFO") ;
			if(exceptionFlag&&logbean.getException()!=null)
				LYLogUtil.info(log,logbean.toStringLog(),logbean.getException()) ;
			else LYLogUtil.info(log,logbean.toStringLog()) ;
		}
	}
	
	//==================================TRACE===============================
		/**
		 * 直接记录内容到日志文件中
		 * @param log		日志对象
		 * @param content	日志内容
		 */
		public static void trace(Log log,String content) {
			if(log!=null) log.trace(content) ;
		}
		/**
		 * 将错误日志记录到日志文件中
		 * @param log		日志对象
		 * @param content	日志内容
		 * @param e			抛出异常对象
		 */
		public static void trace(Log log,String content,Exception e) {
			if(log!=null) log.trace(content,e) ;
		}
		/**
		 * 将包含有线程ID的内容日志记录到日志文件中
		 * @param log		日志对象
		 * @param threadId	线程ID
		 * @param content	日志内容
		 */
		public static void trace(Log log,String threadId,String content) {
			if(log!=null) {
				content = "[seq_no="+threadId+"]"+content ;
				LYLogUtil.trace(log,content) ;
			}
		}
		/**
		 * 记录包含线程ID、参数的日志信息到日志文件中
		 * @param log
		 * @param threadId
		 * @param params
		 * @param content
		 */
		public static void trace(Log log,String threadId,String params,String content) {
			if(log!=null) {
				content = "["+params+"]"+content ;
				LYLogUtil.trace(log,threadId,content) ;
			}
		}
		/**
		 * 记录包含线程ID的异常日志信息
		 * @param log		日志对象
		 * @param threadId	线程ID
		 * @param content	日志内容
		 * @param e			Exception异常对象
		 */
		public static void trace(Log log,String threadId,String content,Exception e) {
			if(log!=null) {
				content = "[seq_no="+threadId+"]"+content ;
				LYLogUtil.trace(log,content,e) ;
			}
		}
		/**
		 * 记录包含线程ID、参数的异常日志信息
		 * @param log		日志对象
		 * @param threadId	线程ID
		 * @param params	参数数据
		 * @param content	日志内容
		 * @param e			Exception异常对象
		 */
		public static void trace(Log log,String threadId,String params,String content,Exception e) {
			if(log!=null) {
				content = "["+params+"]"+content ;
				LYLogUtil.trace(log,threadId,content,e) ;
			}
		}
		/**
		 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
		 * @param log
		 * @param threadId
		 * @param keyId
		 * @param params
		 * @param content
		 */
		public static void trace(Log log,String threadId,String keyId,String params,String content) {
			if(log!=null) {
				content = "["+keyId+"]["+params+"]"+content ;
				LYLogUtil.trace(log,threadId,content) ;
			}
		}
		/**
		 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
		 * @param log
		 * @param threadId
		 * @param keyId
		 * @param params
		 * @param content
		 */
		public static void trace(Log log,String threadId,String keyId,String params,String content,Exception e) {
			if(log!=null) {
				content = "[key="+keyId+"]["+params+"]"+content ;
				LYLogUtil.trace(log,threadId,content,e) ;
			}
		}
		/**
		 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
		 * @param log
		 * @param threadId
		 * @param classmethod
		 * @param keyId
		 * @param params
		 * @param content
		 */
		public static void trace(Log log,String threadId,String classmethod,String keyId,String params,String content) {
			if(log!=null) {
				content = "[method="+classmethod+"][key="+keyId+"]["+params+"]"+content ;
				LYLogUtil.trace(log,threadId,content) ;
			}
		}
		/**
		 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
		 * @param log
		 * @param threadId
		 * @param classmethod
		 * @param keyId
		 * @param params
		 * @param content
		 * @param e
		 */
		public static void trace(Log log,String threadId,String classmethod,String keyId,String params,String content,Exception e) {
			if(log!=null) {
				content = "[method="+classmethod+"][key="+keyId+"]["+params+"]"+content ;
				LYLogUtil.trace(log,threadId,content,e) ;
			}
		}
		/**
		 * 记录实体bean的日志
		 * @param log
		 * @param logbean
		 */
		public static void trace(Log log,LogBean logbean) {
			if(log!=null&&logbean!=null) {
				logbean.setCurrentLevel("TRACE") ;
				if(logbean.getException()!=null)
					LYLogUtil.trace(log,logbean.toStringLog(),logbean.getException()) ;
				else LYLogUtil.trace(log,logbean.toStringLog()) ;
			}
		}
		/**
		 * 同时记录对象的异常日志
		 * @param log
		 * @param logbean
		 * @param exceptionFlag	true-表示记录异常，false-不是不记录异常
		 */
		public static void trace(Log log,LogBean logbean,boolean exceptionFlag) {
			if(log!=null&&logbean!=null) {
				logbean.setCurrentLevel("TRACE") ;
				if(exceptionFlag&&logbean.getException()!=null)
					LYLogUtil.trace(log,logbean.toStringLog(),logbean.getException()) ;
				else LYLogUtil.trace(log,logbean.toStringLog()) ;
			}
		}
	//==================================ERROR===============================
	/**
	 * 直接记录内容到日志文件中
	 * @param log		日志对象
	 * @param content	日志内容
	 */
	public static void error(Log log,String content) {
		if(log!=null) log.error(content) ;
	}
	/**
	 * 将错误日志记录到日志文件中
	 * @param log		日志对象
	 * @param content	日志内容
	 * @param e			抛出异常对象
	 */
	public static void error(Log log,String content,Exception e) {
		if(log!=null) log.error(content,e) ;
	}
	/**
	 * 将包含有线程ID的内容日志记录到日志文件中
	 * @param log		日志对象
	 * @param threadId	线程ID
	 * @param content	日志内容
	 */
	public static void error(Log log,String threadId,String content) {
		if(log!=null) {
			content = "[seq_no="+threadId+"]"+content ;
			LYLogUtil.error(log,content) ;
		}
	}
	/**
	 * 记录包含线程ID、参数的日志信息到日志文件中
	 * @param log
	 * @param threadId
	 * @param params
	 * @param content
	 */
	public static void error(Log log,String threadId,String params,String content) {
		if(log!=null) {
			content = "["+params+"]"+content ;
			LYLogUtil.error(log,threadId,content) ;
		}
	}
	/**
	 * 记录包含线程ID的异常日志信息
	 * @param log		日志对象
	 * @param threadId	线程ID
	 * @param content	日志内容
	 * @param e			Exception异常对象
	 */
	public static void error(Log log,String threadId,String content,Exception e) {
		if(log!=null) {
			content = "[seq_no="+threadId+"]"+content ;
			LYLogUtil.error(log,content,e) ;
		}
	}
	/**
	 * 记录包含线程ID、参数的异常日志信息
	 * @param log		日志对象
	 * @param threadId	线程ID
	 * @param params	参数数据
	 * @param content	日志内容
	 * @param e			Exception异常对象
	 */
	public static void error(Log log,String threadId,String params,String content,Exception e) {
		if(log!=null) {
			content = "["+params+"]"+content ;
			LYLogUtil.error(log,threadId,content,e) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param keyId
	 * @param params
	 * @param content
	 */
	public static void error(Log log,String threadId,String keyId,String params,String content) {
		if(log!=null) {
			content = "["+keyId+"]["+params+"]"+content ;
			LYLogUtil.error(log,threadId,content) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param keyId
	 * @param params
	 * @param content
	 */
	public static void error(Log log,String threadId,String keyId,String params,String content,Exception e) {
		if(log!=null) {
			content = "[key="+keyId+"]["+params+"]"+content ;
			LYLogUtil.error(log,threadId,content,e) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param classmethod
	 * @param keyId
	 * @param params
	 * @param content
	 */
	public static void error(Log log,String threadId,String classmethod,String keyId,String params,String content) {
		if(log!=null) {
			content = "[method="+classmethod+"][key="+keyId+"]["+params+"]"+content ;
			LYLogUtil.error(log,threadId,content) ;
		}
	}
	/**
	 * 记录包含线程ID、数据组合键ID、参数的异常日志信息
	 * @param log
	 * @param threadId
	 * @param classmethod
	 * @param keyId
	 * @param params
	 * @param content
	 * @param e
	 */
	public static void error(Log log,String threadId,String classmethod,String keyId,String params,String content,Exception e) {
		if(log!=null) {
			content = "[method="+classmethod+"][key="+keyId+"]["+params+"]"+content ;
			LYLogUtil.error(log,threadId,content,e) ;
		}
	}
	/**
	 * 记录实体bean的日志
	 * @param log
	 * @param logbean
	 */
	public static void error(Log log,LogBean logbean) {
		if(log!=null&&logbean!=null) {
			logbean.setCurrentLevel("ERROR") ;
			if(logbean.getException()!=null)
				LYLogUtil.error(log,logbean.toStringLog(),logbean.getException()) ;
			else LYLogUtil.error(log,logbean.toStringLog()) ;
		}
	}
	/**
	 * 同时记录对象的异常日志
	 * @param log
	 * @param logbean
	 * @param exceptionFlag	true-表示记录异常，false-不是不记录异常
	 */
	public static void error(Log log,LogBean logbean,boolean exceptionFlag) {
		if(log!=null&&logbean!=null) {
			logbean.setCurrentLevel("ERROR") ;
			if(exceptionFlag&&logbean.getException()!=null)
				LYLogUtil.error(log,logbean.toStringLog(),logbean.getException()) ;
			else LYLogUtil.error(log,logbean.toStringLog()) ;
		}
	}
}
