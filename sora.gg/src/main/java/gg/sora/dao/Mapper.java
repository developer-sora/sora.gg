package gg.sora.dao;

import java.util.ArrayList;
import java.util.List;

import gg.sora.dto.tip;
import gg.sora.dto.userID;
import gg.sora.otherDTO.GameId;
import gg.sora.otherDTO.challchampban;
import gg.sora.otherDTO.challchampick;
import gg.sora.otherDTO.challlist;

public interface Mapper {

	public int challlistreg(challlist c);

	public ArrayList<challlist> getchall(challlist c);

	public int join(userID u);

	public userID getUserByID(userID u);
	public int gameidreg(GameId g);

	public ArrayList<GameId> getchallgameid(GameId g);

	public int banreg(challchampban cb);

	public int pickreg(challchampick cp);

	public ArrayList<challchampban> getchallban(challchampban cb);

	public ArrayList<challchampick> getchallpick(challchampick cp);

<<<<<<< HEAD
	public List<tip> getAllTip(tip t);
=======
	public int monthpickreg(challchampick cp);

	public int monthbanreg(challchampban cb);

	public int monthgameidreg(GameId g);
	public ArrayList<GameId> monthgetchallgameid(GameId g);
	public ArrayList<challchampban> monthgetchallban(challchampban cb);

	public ArrayList<challchampick> monthgetchallpick(challchampick cp);
>>>>>>> branch 'main' of https://github.com/developer-sora/sora.gg.majimak.git


	
}
