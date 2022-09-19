package com.tabletype.model;

import com.emp.model.EmpVO;

public interface TableTypeDAOInterface {
    public void insertTableType(TableTypeVO tabletypeVO);
    public void update(TableTypeVO tabletypeVO);
    public void delete(Integer tableTypeID);
}
