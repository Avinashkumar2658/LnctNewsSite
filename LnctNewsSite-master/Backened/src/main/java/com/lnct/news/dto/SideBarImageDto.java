package com.lnct.news.dto;

public class SideBarImageDto {
	private String sidebarImageId;
	private String userId;
	private String side;

	public SideBarImageDto() {
		super();

	}

	public SideBarImageDto(String sidebarImageId, String userId, String side) {
		super();
		this.sidebarImageId = sidebarImageId;
		this.userId = userId;
		this.side = side;
	}

	public String getSidebarImageId() {
		return sidebarImageId;
	}

	public void setSidebarImageId(String sidebarImageId) {
		this.sidebarImageId = sidebarImageId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "SideBarImageDto [sidebarImageId=" + sidebarImageId + ", userId=" + userId + ", side=" + side + "]";
	}

}
