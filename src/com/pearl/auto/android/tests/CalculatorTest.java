package com.pearl.auto.android.tests;

import static com.pearl.auto.android.utils.Helpers.driver;
import static com.pearl.auto.android.utils.Helpers.find;
import static com.pearl.auto.android.utils.Helpers.findByText;
import static com.pearl.auto.android.utils.Helpers.goToHome;

import java.time.Duration;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import com.pearl.auto.android.main.AppiumBaseTest;
import com.pearl.auto.android.page.CalculatorPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CalculatorTest extends AppiumBaseTest<CalculatorPage> {
	
	@Override
	public void init() {
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		page = new CalculatorPage();
	}

	public void MultiplicationTest() {
		findByText("5".toString()).click();
		find(By.id("multiply")).click();
		findByText("2".toString()).click();
		find(By.id("equals")).click();
		
		String result = find(By.id("com.android.calculator2:id/display"))
							.findElement(By.className("android.widget.EditText"))
								.getText();
		
		Assertions.assertEquals(10, Integer.parseInt(result));
	}

	@Test
	public void CreateShortcut() {
		goToHome();
		
		find(By.id("Apps")).click();
		MobileElement calcApp = findByText("Calculator");
		
		// We tell the compiler to ignore the Generic for now using this annotation
		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction<>(driver)
				.longPress(PointOption.point(calcApp.getRect().x, calcApp.getRect().y))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(calcApp.getRect().x, calcApp.getRect().y + 350))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.perform();
			
		action.release().perform();
	}
}
