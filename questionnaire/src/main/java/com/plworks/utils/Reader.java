package com.plworks.utils;

public interface Reader {
	public String getParentLocation();
	public void close();
	public boolean hasNextLine();
	public String readLine() ;
}
