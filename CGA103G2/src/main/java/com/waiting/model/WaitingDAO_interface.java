package com.waiting.model;

import java.util.List;


public interface WaitingDAO_interface {
	public void insert(WaitingVO waitingVO);
	public void delete(Integer waiting_id);
	public void update(WaitingVO waitingVO);
    public WaitingVO findByPrimaryKey(Integer waiting_id);
    public List<WaitingVO> getAll();
	
}
