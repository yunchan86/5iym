package com.iyoumei.entity.view;

public class UserCircleReward {

	private Integer ruleId;

    private Long userId;
    
    private Long currentTotalAmt;
    
    private Long leftTotalNum ;
    private Long rightTotalNum ;

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

	public Long getLeftTotalNum() {
		return leftTotalNum;
	}

	public void setLeftTotalNum(Long leftTotalNum) {
		this.leftTotalNum = leftTotalNum;
	}

	public Long getRightTotalNum() {
		return rightTotalNum;
	}

	public void setRightTotalNum(Long rightTotalNum) {
		this.rightTotalNum = rightTotalNum;
	}
    
    
}
