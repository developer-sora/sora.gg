package gg.sora.community;

import java.util.List;

import gg.sora.dto.CSearch;

public interface BoardMapper {

	public int writeMsg(CMsg m);

	public List<CMsg> getAllMsg(CMsg m);

	public int delMsg(CMsg m);

	public List<CMsg> getMsg(CSearch cs);
	
}
