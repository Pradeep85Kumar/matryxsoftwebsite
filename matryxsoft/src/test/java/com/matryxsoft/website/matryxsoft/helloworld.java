package com.matryxsoft.website.matryxsoft;

import org.testng.Assert;
import org.testng.annotations.Test;


public class helloworld {
	
  @Test
  public void MatryxsoftWebsite() 
  {
	  System.out.println ("Hello Matryxsoft");
	 Assert.assertTrue(true);
  }
  
  @Test
  public void MatryxsoftWebsite2() 
  {
	  System.out.println ("Hello Matryxsoft");
	 Assert.assertTrue(false);
  }
  
}