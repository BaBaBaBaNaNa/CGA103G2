package com.functions.model;
import java.util.*;

public interface FunctionsDAO_interface {
	public void insert(FunctionsVO functionsVO);
    public void update(FunctionsVO functionsVO);
    public void delete(Integer functionID);
    public FunctionsVO findByPrimaryKey(Integer functionID);
    public List<FunctionsVO> getAll();
}
