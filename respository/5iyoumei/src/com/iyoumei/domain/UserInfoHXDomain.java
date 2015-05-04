package com.iyoumei.domain;

import java.io.Serializable;

public class UserInfoHXDomain  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;

    private String password;
    
    private String hxUUID ;
    
    private String hxUsername ;
    
    private boolean activated=true;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public String getHxUUID() {
		return hxUUID;
	}

	public void setHxUUID(String hxUUID) {
		this.hxUUID = hxUUID;
	}

	public String getHxUsername() {
		return hxUsername;
	}

	public void setHxUsername(String hxUsername) {
		this.hxUsername = hxUsername;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
    
    
}