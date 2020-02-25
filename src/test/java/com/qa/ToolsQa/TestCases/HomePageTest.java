package com.qa.ToolsQa.TestCases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ToolsQa.base.TestBase;
import com.qa.ToolsQa.pages.HomePage;




public class HomePageTest extends TestBase {

	
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		Initialization();
	 homepage=new HomePage();
	}
	
	//@Test(priority=1)
	public void BrokenLinkTest() throws MalformedURLException, IOException {
		homepage.brokenLinkTest();
	}
	
	@Test(priority=2)
	public void newWindowTest() throws InterruptedException {
		homepage.newWindow();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
	driver.quit();
	}
}
