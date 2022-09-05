package com.botqa.model;
import java.util.List;

public class BotqaService {
	private BotqaDAO_interface dao;
	
	public BotqaService () {
		dao = new BotqaDAO();
	}
	public BotqaVO addBotqa(String keywordName,String keywordContext){
		BotqaVO botqaVO = new BotqaVO();
		
		botqaVO.setKeywordName(keywordName);
		botqaVO.setKeywordContext(keywordContext);
		
		
		dao.insert(botqaVO);
		
		return botqaVO;
	}
	
	public BotqaVO updateBotqa(Integer keywordID,String keywordName,String keywordContext) {
		BotqaVO botqaVO = new BotqaVO();
		
		botqaVO.setKeywordID(keywordID);
		botqaVO.setKeywordName(keywordName);
		botqaVO.setKeywordContext(keywordContext);
		
		dao.update(botqaVO);
		return dao.findByPrimaryKey(keywordID);
	}
	public void updateBotqa(BotqaVO botqaVO){
		dao.update(botqaVO);
		
	}
	
	public void deletDotqa(Integer keywordID) {
		dao.delete(keywordID);
	}
	public BotqaVO getOneBotqa(Integer keywordID) {
		return dao.findByPrimaryKey(keywordID);
	}
	
	public List<BotqaVO>getAll(){
		return dao.getAll();
	}
	
	
}
