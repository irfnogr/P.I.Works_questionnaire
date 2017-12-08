package models;

import java.util.Date;

public class Music {
	
	private byte[] playId;
	private Integer songId;
	private Integer clientId;
	private Date playDate;
	
	public Music(){
		playId= new byte[16];
	}
	
	public byte[] getPlayId() {
		return playId;
	}
	public void setPlayId(byte[] playId) {
		this.playId = playId;
	}
	public Integer getSongId() {
		return songId;
	}
	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Date getPlayDate() {
		return playDate;
	}
	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}

	
	
	
	
	

}
