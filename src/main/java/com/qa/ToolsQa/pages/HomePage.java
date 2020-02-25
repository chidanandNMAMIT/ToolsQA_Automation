package com.qa.ToolsQa.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ToolsQa.base.TestBase;
import com.qa.ToolsQa.util.GenericUtils;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[text()='Automation Practice Switch Windows']")
	WebElement TextLink;

	@FindBy(xpath="//button[text()='New Browser Tab']")
	WebElement NewBrowserTab;
	
	@FindBy(xpath="(//span[text()='Tutorial' ])[1]")
	WebElement Tutorial;
	
	@FindBy(xpath="//span[@class='Agile & Scrum']")
	WebElement AgileLink;
	
	@FindBy(id="alert")
	WebElement alertPopUp;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void brokenLinkTest() throws MalformedURLException, IOException {
		GenericUtils.BrokenLinks();
	}
	
	public void newWindow() throws InterruptedException {
		TextLink.click();
		NewBrowserTab.click();
		GenericUtils.switchToNewWindow();
		driver.findElement(By.xpath("(//span[text()='HOME'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Tutorial' ])[1]")).click();
		GenericUtils.switchToParentWindow();
		GenericUtils.refresh();
		alertPopUp.click();
		GenericUtils.checkAlert_Accept();
		
	}

}
