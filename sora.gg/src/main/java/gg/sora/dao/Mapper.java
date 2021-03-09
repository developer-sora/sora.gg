package gg.sora.dao;

import java.util.ArrayList;

import gg.sora.otherDTO.GameId;
import gg.sora.otherDTO.challchampban;
import gg.sora.otherDTO.challchampick;
import gg.sora.otherDTO.challlist;

public interface Mapper {

	public int challlistreg(challlist c);

	public ArrayList<challlist> getchall(challlist c);

	public int gameidreg(GameId g);

	public ArrayList<GameId> getchallgameid(GameId g);

	public int banreg(challchampban cb);

	public int pickreg(challchampick cp);

	public ArrayList<challchampban> getchallban(challchampban cb);

	public ArrayList<challchampick> getchallpick(challchampick cp);

	
}
