package com.pearl.auto.android.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Helpers {

	public static AndroidDriver<MobileElement> driver;
	public static WebDriverWait driverWait;
	
	public static MobileElement find(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<MobileElement> findElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static MobileElement findByText(String text) {
		return driver.findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", text));
	}
	
	public static void implicitWait(int duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
	
	public static void pressBack() {
		driver.navigate().back();
	}
	
	public static void goToHome() {
		driver.pressKeyCode(AndroidKeyCode.HOME);
	}
}