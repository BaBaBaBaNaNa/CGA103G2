package com.functions.model;
import java.util.*;

public interface FunctionsDAO_interface {
	public void insert(FunctionsVO functionsVO);
    public void update(FunctionsVO functionsVO);
    public void delete(Integer functions_id);
    public FunctionsVO findByPrimaryKey(Integer functions_id);
    public List<FunctionsVO> getAll();
}
/* */