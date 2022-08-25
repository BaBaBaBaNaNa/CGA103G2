package com.permission.model;
import java.util.*;

public interface PermissionDAO_interface {
	public void insert(PermissionVO permissionVO);
    public void update(PermissionVO permissionVO);
    public void delete(Integer functionID);
    public PermissionVO findByPrimaryKey(Integer functionID);
    public List<PermissionVO> getAll();
}
