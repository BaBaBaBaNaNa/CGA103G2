package com.mem.model;
import java.util.*;

import com.emp.model.EmpVO;
import com.mem.model.MemLoginVO;

public interface MemDAO_interface {
	public boolean loginAdmin (MemLoginVO admin);
          public void insert(MemVO memVO);
          public void update(MemVO memVO);
          public void delete(Integer memNo);
          public MemVO findByPrimaryKey(Integer memNo);
          public List<MemVO> getAll();
//          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<MemVO> getAll(Map<String, String[]> map); 
		boolean loginAdmin(MemVO admin);
	    public MemVO findByMemAccount(String memAccount);
	   
}
