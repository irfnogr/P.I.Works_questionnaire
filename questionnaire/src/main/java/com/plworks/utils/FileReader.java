package com.plworks.utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader implements Reader {
	
	
	private Scanner scanner ;
	

	public FileReader(String fileName) throws IOException  {
		File file = null;
		String parentLocation=getParentLocation();
		file=getFile(parentLocation+fileName);
		scanner= new Scanner(file);
			
	}

	
	
	
	 private File getFile(String fileName) throws IOException{
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;				
	
	 }


	 @Override
	 public String readLine() {
		 if(scanner==null) {
			 return null;
		 }
		 
		String line = scanner.nextLine();
		return line;
		
		
	 }

	 @Override
	 public boolean hasNextLine() {
		 return scanner.hasNextLine();
	 }

	 @Override
	 public void close() {
		 scanner.close();
	 }

	 public void ignorefirstLine() throws IOException {
		//read first line so cursor is now second line 
		 String firstLine=readLine();
	 }
	 

	 @Override
	public String getParentLocation() {
		 return "files/";
	}

}
