package com.pearl.auto.android.tests;

import org.junit.jupiter.api.Assertions;

import com.pearl.auto.android.main.AppiumBaseTest;
import com.pearl.auto.android.page.GoogleTranslatePage;

public class GoogleTranslateTest extends AppiumBaseTest<GoogleTranslatePage> {
	
    @Override
	public void init() {
        userDir = System.getProperty("user.dir");
        localApp = "/app/Google Translate.apk";

		capabilities.setCapability("appActivity", "com.google.android.apps.translate.TranslateActivity");
		capabilities.setCapability("appWaitActivity", "com.google.android.apps.translate.OnboardingActivity");
		
		page = new GoogleTranslatePage();
    }
    
    @org.junit.Test
    public void TestTranslateFunctionality() throws Exception {
    		page.clickDone();
    		String translatedWord = page.translate("Hello");
    		Assertions.assertEquals("Hola", translatedWord);
    }
    
    @org.junit.Test
    public void TestCase_003() throws Exception {
    	
    }
    
    @org.junit.Test
    public void TestCase_004() throws Exception {
    	
    }
    
    @org.junit.Test
    public void TestCase_005() throws Exception {
    	
    }
}
