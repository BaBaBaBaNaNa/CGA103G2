package com.news.model;

import java.sql.Timestamp;
import java.util.List;

public class NewsService {

	private NewsDAO_interface dao;
	
	public NewsService() {
		dao = new NewsDAO();
	}

	public NewsVO addNews(Integer empID,Timestamp newsDate,String newsTitle,
			String newsInformation,Integer newsControl,byte[] newsPictures) {

		NewsVO newsVO = new NewsVO();

		newsVO.setEmpID(empID);
		newsVO.setNewsDate(newsDate);
		newsVO.setNewsTitle(newsTitle);
		newsVO.setNewsInformation(newsInformation);
		newsVO.setNewsControl(newsControl);
		newsVO.setNewsPictures(newsPictures);
		final Integer newsID = dao.insert(newsVO);
		newsVO.setNewsID(newsID);
		return newsVO;
	}

	public NewsVO updateNews(Integer newsID, Integer empID, Timestamp newsDate, String newsTitle,
			String newsInformation, Integer newsControl, byte[] newsPictures) {

		NewsVO newsVO = new NewsVO();

		newsVO.setNewsID(newsID);
		newsVO.setEmpID(empID);
		newsVO.setNewsDate(newsDate);
		newsVO.setNewsTitle(newsTitle);
		newsVO.setNewsInformation(newsInformation);
		newsVO.setNewsControl(newsControl);
		newsVO.setNewsPictures(newsPictures);
		dao.update(newsVO);

		return newsVO;
	}

	public void deleteNews(Integer newsID) {
		dao.delete(newsID);
	}
	
	public NewsVO getOneNews(Integer newsID) {
		return dao.findByPrimaryKey(newsID);
	}
	
	public List<NewsVO> getAll(){
		return dao.getAll();
	}
	
}
