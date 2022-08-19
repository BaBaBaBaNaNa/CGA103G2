package com.permission.model;
import java.util.*;

public interface PermissionDAO_interdace {
	public void insert(PermissionVO permissionVO);
    public void update(PermissionVO permissionVO);
    public void delete(Integer functions_id);
    public PermissionVO findByPrimaryKey(Integer functions_id);
    public List<PermissionVO> getAll();
}
