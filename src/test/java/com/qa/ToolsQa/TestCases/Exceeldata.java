package com.qa.ToolsQa.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ToolsQa.util.TestUtil;

public class Exceeldata {

	
	
@DataProvider
public Object[][] printexcel() {
	Object[][] data=TestUtil.getTestdata("AddAddress");
	return data;
}

@Test(dataProvider="printexcel")
public void readexcel(String Name,long MObileNo,int Pincode, String Address) {
	System.out.println( Name+" "+MObileNo+" "+Pincode+" "+Address);
	
}

}
