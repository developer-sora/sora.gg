package gg.sora.dto;


public class matchlistDTO {
private long gameId;
private String queue;
private String timestamp;
private String championKr;
private String championEn;
private String position;

public matchlistDTO() {
}

public long getGameId() {
	return gameId;
}

public void setGameId(long gameId) {
	this.gameId = gameId;
}

public String getQueue() {
	return queue;
}

public void setQueue(String queue) {
	this.queue = queue;
}

public String getTimestamp() {
	return timestamp;
}

public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
}

public String getChampionKr() {
	return championKr;
}

public void setChampionKr(String championKr) {
	this.championKr = championKr;
}

public String getChampionEn() {
	return championEn;
}

public void setChampionEn(String championEn) {
	this.championEn = championEn;
}

public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
}

public matchlistDTO(long gameId, String queue, String timestamp, String championKr, String championEn,
		String position) {
	super();
	this.gameId = gameId;
	this.queue = queue;
	this.timestamp = timestamp;
	this.championKr = championKr;
	this.championEn = championEn;
	this.position = position;
}


}
