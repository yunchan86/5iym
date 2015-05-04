package com.iyoumei.domain;

import java.io.Serializable;
import java.util.Date;

public class UserRelationsDomain   implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId1;

    private Long userId2;
    
    private Boolean isBlacklist;

    private String tag;

    private String label;

    private String source;

    private Date linkTime;

    private Date applyTime;
    
    private int regularFriend ;
    private int friendCircle1;
    private int friendCircle2;
    private int friendMap;

    public Boolean getIsBlacklist() {
        return isBlacklist;
    }

    public void setIsBlacklist(Boolean isBlacklist) {
        this.isBlacklist = isBlacklist;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Date getLinkTime() {
        return linkTime;
    }

    public void setLinkTime(Date linkTime) {
        this.linkTime = linkTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

	public Long getUserId1() {
		return userId1;
	}

	public void setUserId1(Long userId1) {
		this.userId1 = userId1;
	}

	public Long getUserId2() {
		return userId2;
	}

	public void setUserId2(Long userId2) {
		this.userId2 = userId2;
	}

	public int getRegularFriend() {
		return regularFriend;
	}

	public void setRegularFriend(int regularFriend) {
		this.regularFriend = regularFriend;
	}

	public int getFriendCircle1() {
		return friendCircle1;
	}

	public void setFriendCircle1(int friendCircle1) {
		this.friendCircle1 = friendCircle1;
	}

	public int getFriendCircle2() {
		return friendCircle2;
	}

	public void setFriendCircle2(int friendCircle2) {
		this.friendCircle2 = friendCircle2;
	}

	public int getFriendMap() {
		return friendMap;
	}

	public void setFriendMap(int friendMap) {
		this.friendMap = friendMap;
	}
    
    
}