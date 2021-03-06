package com.iyoumei.entity.view;

public class UserCircleReward {

	private Integer ruleId;

    private Long userId;
    
    private Long currentTotalAmt;
    
    private Integer leftTotalNum ;
    private Integer rightTotalNum ;
    
    public UserCircleReward(){}
    public UserCircleReward(Integer ruleId,Long userId,Long currentTotalAmt
    		,Integer leftTotalNum,Integer rightTotalNum) {
    	this.ruleId = ruleId ;
    	this.userId = userId ;
    	this.currentTotalAmt = currentTotalAmt ;
    	this.leftTotalNum = leftTotalNum ;
    	this.rightTotalNum = rightTotalNum ;
    }

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCurrentTotalAmt() {
		return currentTotalAmt;
	}

	public void setCurrentTotalAmt(Long currentTotalAmt) {
		this.currentTotalAmt = currentTotalAmt;
	}
	public Integer getLeftTotalNum() {
		return leftTotalNum;
	}
	public void setLeftTotalNum(Integer leftTotalNum) {
		this.leftTotalNum = leftTotalNum;
	}
	public Integer getRightTotalNum() {
		return rightTotalNum;
	}
	public void setRightTotalNum(Integer rightTotalNum) {
		this.rightTotalNum = rightTotalNum;
	}
    
}
