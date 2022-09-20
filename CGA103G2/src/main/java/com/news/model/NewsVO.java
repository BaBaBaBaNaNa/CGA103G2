package com.news.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class NewsVO implements Serializable{
	private Integer newsID;
	private Integer empID;
	private Timestamp newsDate;
	private String newsTitle;
	private String newsInformation;
	private Integer newsControl;
	private byte[] newsPictures;
	
	public Integer getNewsID() {
		return newsID;
	}
	public void setNewsID(Integer newsID) {
		this.newsID = newsID;
	}
	public Integer getEmpID() {
		return empID;
	}
	public void setEmpID(Integer empID) {
		this.empID = empID;
	}
	public Timestamp getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Timestamp newsDate) {
		this.newsDate = newsDate;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsInformation() {
		return newsInformation;
	}
	public void setNewsInformation(String newsInformation) {
		this.newsInformation = newsInformation;
	}
	public Integer getNewsControl() {
		return newsControl;
	}
	public void setNewsControl(Integer newsControl) {
		this.newsControl = newsControl;
	}
	public byte[] getNewsPictures() {
		return newsPictures;
	}
	public void setNewsPictures(byte[] newsPictures) {
		this.newsPictures = newsPictures;
	}
}
