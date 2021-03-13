package gg.sora.dao;

import java.util.List;

import gg.sora.dto.tip;

public interface TipMapper {

	public List<tip> getAllTip(tip t);

	public int regTip(tip t);

	public int delTip(tip t);

}
