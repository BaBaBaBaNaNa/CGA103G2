package com.mem.model;
import java.util.*;

public interface MemDAO_interface {
          public void insert(MemVO memVO);
          public void update(MemVO memVO);
          public void delete(Integer memno);
        public MemVO findByPrimaryKey(Integer Memno);
     public List<MemVO> getAll();
//          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
