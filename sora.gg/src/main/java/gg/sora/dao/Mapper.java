package gg.sora.dao;

import java.util.ArrayList;

import gg.sora.dto.userID;
import gg.sora.otherDTO.challlist;

public interface Mapper {

	public int challlistreg(challlist c);

	public ArrayList<challlist> getchall(challlist c);

	public int join(userID u);

	public userID getUserByID(userID u);
}
