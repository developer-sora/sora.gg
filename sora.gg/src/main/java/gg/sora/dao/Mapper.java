package gg.sora.dao;

import java.util.ArrayList;

<<<<<<< HEAD
import gg.sora.dto.userID;
=======
import gg.sora.otherDTO.GameId;
import gg.sora.otherDTO.challchampban;
import gg.sora.otherDTO.challchampick;
>>>>>>> refs/remotes/origin/main
import gg.sora.otherDTO.challlist;

public interface Mapper {

	public int challlistreg(challlist c);

	public ArrayList<challlist> getchall(challlist c);

<<<<<<< HEAD
	public int join(userID u);

	public userID getUserByID(userID u);
=======
	public int gameidreg(GameId g);

	public ArrayList<GameId> getchallgameid(GameId g);

	public int banreg(challchampban cb);

	public int pickreg(challchampick cp);

	public ArrayList<challchampban> getchallban(challchampban cb);

	public ArrayList<challchampick> getchallpick(challchampick cp);

	
>>>>>>> refs/remotes/origin/main
}
