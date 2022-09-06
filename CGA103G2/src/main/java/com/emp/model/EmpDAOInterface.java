package com.emp.model;
import java.util.*;

import com.login.model.EmpLoginVO;

public interface EmpDAOInterface {
    public void insert(EmpVO empVO);
    public void update(EmpVO empVO);
    public void delete(Integer empno);
    public EmpVO findByPrimaryKey(Integer empID);
    public List<EmpVO> getAll();
    public EmpVO checkRepeatEmpAccount(String empAccount);
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
    public List<EmpVO> getAll(Map<String, String[]> map); 
    
    public EmpVO findByEmpAccount(String empAccount);
}