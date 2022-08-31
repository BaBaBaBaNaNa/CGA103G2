package com.queuer.model;

import java.util.List;


public interface QueuerDAO_interface {
	public void insert(QueuerVO queuerVO);
	public void delete(Integer quequerID);
	public void update(QueuerVO queuerVO);
    public QueuerVO findByPrimaryKey(Integer queuerID);
    public List<QueuerVO> getAll();
}
