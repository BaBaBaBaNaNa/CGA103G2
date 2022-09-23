package com.news.model;

import java.util.List;

public interface NewsDAO_interface {

	public Integer insert(NewsVO newsVO);

	public void update(NewsVO newsVO);

	public void delete(Integer newsID);

	public NewsVO findByPrimaryKey(Integer newsID);

	public List<NewsVO> getAll();

//	public List<NewsVO> getAll(Map<String, String[]> map);
}
