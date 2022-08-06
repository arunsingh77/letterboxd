package com.letterboxd.model;

public class User {
	int userId;
	String userName;
	String phnNo;
	String status;
	
	public User(int userId, String userName, String phnNo, String status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phnNo = phnNo;
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhnNo() {
		return phnNo;
	}

	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", phnNo=" + phnNo + ", status=" + status + "]";
	}
	
	

}
