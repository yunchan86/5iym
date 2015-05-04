package com.iyoumei.domain;

import java.io.Serializable;

public class UserInfoHXLogDomain  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;

    private String password;

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

    
    
}