package com.plworks.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import models.Music;

public class MusicParser {
	
	public static Music  parseLine(String line) throws Exception {
		String[] tokens=line.split("[\\s ]+");
		Music tempMusic=new Music();
		//set music object from line 
		tempMusic.setPlayId(tokens[0].getBytes());
		tempMusic.setSongId(Integer.parseInt(tokens[1]));
		tempMusic.setClientId(Integer.parseInt(tokens[2]));
		String StringDate = null;
		
		SimpleDateFormat formatter;
		if(tokens.length>=5) {
			StringDate=tokens[3]+" "+tokens[4];
			formatter = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		}else {
			StringDate=tokens[3];
			formatter = new SimpleDateFormat("dd/mm/yyyy");
		}
		   
		
		
		Date  date=formatter.parse(StringDate);

		tempMusic.setPlayDate(date);
		
		return tempMusic;
	
	    
	}
	
	
}
