package com.example.expandableview;

public class Product {
	//产品属性
	private  String ShopName;
	private  String ProductName;
	private  String ImageUrl;
	private    Integer  Image;
	
	private  String Price;
	//点击属性
	private  boolean isSecleted;
	public String getShopName() {
		return ShopName;
	}
	public void setShopName(String shopName) {
		ShopName = shopName;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	public Integer getImage() {
		return Image;
	}
	public void setImage(Integer image) {
		Image = image;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public boolean isSecleted() {
		return isSecleted;
	}
	public void setSecleted(boolean isSecleted) {
		this.isSecleted = isSecleted;
	}
}
