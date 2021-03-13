package gg.sora.community;

import java.util.List;

public interface BoardMapper {

	public int writeMsg(CMsg m);

	public List<CMsg> getAllMsg(CMsg m);

	public int delMsg(CMsg m);

	
	public List<CMsg> getMsg(CMsg m);
	
}
