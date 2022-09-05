package com.botqa.model;
import java.util.List;


public interface BotqaDAO_interface {
	public void insert(BotqaVO botqaVO);
    public void update(BotqaVO botqaVO);
    public void delete(Integer keywordID);
    public BotqaVO findByPrimaryKey(Integer keywordID);
    public List<BotqaVO> getAll();
}
