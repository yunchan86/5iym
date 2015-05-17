package com.iyoumei.action;

import com.iyoumei.bean.CommonServiceResult;
import com.iyoumei.modeldriver.RewardMd;
import com.iyoumei.service.IEventRewardService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class RewardAction extends ParentAction implements ModelDriven<RewardMd>{
	
	private RewardMd md = new RewardMd() ;
	
	private IEventRewardService eventRewardService ;

	public String execute() {
		String result = "fail." ;
		CommonServiceResult<?> serviceResult = null ;
		if(md==null||md.getUserId()<1) return result ;
		else if(md.getUserId()==0) {
			serviceResult = eventRewardService.service() ;
		}else {
			serviceResult = eventRewardService.service(md.getUserId()) ;
		}
		//TODO 返回值的处理
		return result ;
	}
	
	public String dayStat() {
		String result = null ;
		
		return result ;
	}
	
	public String weekStat() {
		String result = null ;
		
		return result ;
	}
	
	public String monthStat() {
		String result = null ;
		
		return result ;
	}
	
	public RewardMd getModel() {
		return md;
	}

	public IEventRewardService getEventRewardService() {
		return eventRewardService;
	}

	public void setEventRewardService(IEventRewardService eventRewardService) {
		this.eventRewardService = eventRewardService;
	}

	
	
}
