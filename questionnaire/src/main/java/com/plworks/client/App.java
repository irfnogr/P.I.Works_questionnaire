package com.plworks.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.plworks.utils.FileReader;
import com.plworks.utils.MusicParser;

import models.Music;


/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws Exception
    {
    	//first operation
    	String fileName="exhibitA-input.csv";
    	List<Music> firstOps=new ArrayList<Music>();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Date aDate=sdf.parse("10/08/2016");
    	try {
			FileReader reader=new FileReader(fileName);
			reader.ignorefirstLine();
			int counter=0;	
			while(reader.hasNextLine()) {
				counter++;
				String line= reader.readLine();
				System.out.println(counter+"  "+line);
				Music music=MusicParser.parseLine(line);
				if(sdf.format(aDate).equals(sdf.format(music.getPlayDate()))) {
					firstOps.add(music);
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	//second operation
    	//hashset cantain client id and and distict song id
    	Map<Integer,HashSet<Integer>> secondOps=new HashMap<Integer,HashSet<Integer>>();
    	for(Music music:firstOps) {
    		HashSet<Integer> hs=secondOps.get(music.getClientId());
    		if(hs== null) {	
    			secondOps.put(music.getClientId(), new HashSet<Integer>());
    			hs=secondOps.get(music.getClientId());
    		}
			hs.add(music.getSongId());
    	}
    	//third operation
    	Map<Integer,HashSet<Integer>> thirdOps=new HashMap<Integer,HashSet<Integer>>();
    	for(Map.Entry<Integer, HashSet<Integer>> entry : secondOps.entrySet()) {
    		Integer clientId=entry.getKey();
    		Integer songCount=entry.getValue().size();
    		
    		HashSet<Integer> hs=thirdOps.get(songCount);
    		if(hs== null) {	
    			thirdOps.put(songCount, new HashSet<Integer>());
    			hs=thirdOps.get(songCount);
    		}
			hs.add(clientId);	
    	}
    	//display result
    	for(Map.Entry<Integer, HashSet<Integer>> entry : thirdOps.entrySet()) {
    		Integer clientCount=entry.getKey();
    		Integer songCount=entry.getValue().size();
    		
    		System.out.println("client Count:"+clientCount+" songs count:"+songCount);
    	}
  
		
    		
    		
    	
    	
    	
    	
    }
}
