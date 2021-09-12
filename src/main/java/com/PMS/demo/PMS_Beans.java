package com.PMS.demo;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Component
@Entity

@Table (name ="PRODUCTS_PRICE")
public class PMS_Beans {
	
	@Id @Column (name ="prodId")
	private String prodId;
	@Column (name ="productName")
	private String productName;
	@Column (name ="productPrice")
	private String productPrice;
	
	
	public String getProdId()
	{
		return prodId;
	}
	public void setProdId(String prodId)
	{
		this.prodId = prodId;
	}
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public String getProductPrice()
	{
		return productPrice;
	}
	public void setProductPrice(String productPrice)
	{
		this.productPrice = productPrice;
	}
	
}
