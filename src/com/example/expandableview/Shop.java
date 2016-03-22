package com.example.expandableview;

public class Shop {
	//µÍ Ù–‘
	private  String ShopName;
	private    Integer  Image;
	
	//µ„ª˜ Ù–‘
	private  boolean isSecleted;

	public String getShopName() {
		return ShopName;
	}

	public void setShopName(String shopName) {
		ShopName = shopName;
	}
	public Integer getImage() {
		return Image;
	}
	public void setImage(Integer image) {
		Image = image;
	}
	public boolean isSecleted() {
		return isSecleted;
	}

	public void setSecleted(boolean isSecleted) {
		this.isSecleted = isSecleted;
	}
}
