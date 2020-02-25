package com.qa.ToolsQa.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ToolsQa.base.TestBase;

public class GenericUtils extends TestBase {

	public static WebDriverWait wait;
	public static Alert alert;
	public static Actions action;
	public static Select selectitem;

	@SuppressWarnings("deprecation")
	public static void waitFor_elementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	@SuppressWarnings("deprecation")
	public static void waitTillElementFound(WebElement element, int seconds) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void navigate_forward() {
		driver.navigate().forward();
	}

	public static void navigate_back() {
		driver.navigate().back();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static boolean checkAlert_Accept() {
		try {
			alert = driver.switchTo().alert();
			String str = alert.getText();
			System.out.println(str);
			alert.accept();
			return true;
		} catch (Exception e) {

			System.out.println("no alert Present " + e);
			return false;
		}
	}

	public static boolean checkAlert_Dismiss() {
		try {
			alert = driver.switchTo().alert();
			String str = alert.getText();
			System.out.println(str);
			alert.dismiss();
			return true;
		} catch (Exception e) {
			System.out.println("no alerts present " + e);
			return false;
		}
	}

	public static void dragAndDrop(WebElement SourceElement, WebElement TargetElement) {
		action = new Actions(driver);
		action.dragAndDrop(SourceElement, TargetElement);
	}

	public static void drag_Drop_clickHold(WebElement SourceElement, WebElement TargetElement) {
		action.clickAndHold(SourceElement).moveToElement(TargetElement).release(TargetElement).build().perform();
	}

	public static void mouseOver_OnElemnt(WebElement Element) {
		action.moveToElement(Element).build().perform();
	}

	public static void switchToNewWindow() {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		driver.switchTo().window(w2);
	}

	public static void switchToParentWindow() {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		driver.switchTo().window(w1);
	}

	public static void radiobutton_Select(WebElement RadioBtn) {
		boolean checkstatus;
		checkstatus = RadioBtn.isSelected();
		if (checkstatus == true) {
			System.out.println("RadioButton is already checked");
		} else {
			RadioBtn.click();
			System.out.println("Selected the Radiobutton");
		}
	}

	public static void radioButton_Deselect(WebElement RadioBtn) {
		boolean checkstatus;
		checkstatus = RadioBtn.isSelected();
		if (checkstatus == true) {
			RadioBtn.click();
			System.out.println("Radio Button is deselected");
		} else {
			System.out.println("Radio Button was already Deselected");
		}
	}

	public static void selectByName(WebElement element, String Name) {
		selectitem = new Select(element);
		selectitem.selectByVisibleText(Name);
	}

	public static void selectByValue(WebElement element, String value) {
		selectitem = new Select(element);
		selectitem.selectByValue(value);
	}

	public static void selectElementByIndexMethod(WebElement element, int index) {
		selectitem = new Select(element);
		selectitem.selectByIndex(index);
	}

	public static void BrokenLinks() throws MalformedURLException, IOException {
		List<WebElement> Linkslist = driver.findElements(By.tagName("a"));
		Linkslist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total no Links--->" + Linkslist.size());

		HttpURLConnection connection = null;
		for (WebElement Element : Linkslist) {
			String url = Element.getAttribute("href");
			if (url != null && !url.contains("javascript")) {
				connection = (HttpURLConnection) (new URL(url)).openConnection();
				connection.connect();
				int Responsecode = connection.getResponseCode();
				connection.disconnect();
				System.out.println("connection status of URL" + url + "---->" + Responsecode);
			}
		}
	}

}
