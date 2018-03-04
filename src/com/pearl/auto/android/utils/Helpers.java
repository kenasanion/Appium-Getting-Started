package com.pearl.auto.android.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Helpers {

	public static AndroidDriver<MobileElement> driver;
	public static WebDriverWait driverWait;
	
	public static MobileElement find(By locator) {
		return driver.findElement(locator);
	}
	
	public static void implicitWait(int duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
	
	public static void pressBack() {
		driver.navigate().back();
	}
	
}