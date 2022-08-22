package com.queuer.model;

import java.util.List;


public interface QueuerDAO_interface {
	public void insert(QueuerVO queuerVO);
	public void delete(Integer quequer_id);
	public void update(QueuerVO queuerVO);
    public QueuerVO findByPrimaryKey(Integer queuer_id);
    public List<QueuerVO> getAll();
}
