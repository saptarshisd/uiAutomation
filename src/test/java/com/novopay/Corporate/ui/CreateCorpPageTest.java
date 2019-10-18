package com.novopay.Corporate.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.BasePage;

public class CreateCorpPageTest {
	public AndroidDriver<MobileElement> mdriver;
	public WebDriver wdriver;
	private BasePage mBasePage = new BasePage(wdriver);
	private CreateCorpRunner_Positive corpPage;
	public String sheetname = "CorpPage", workbook = "UITestData";

	@Test
	public void corpPageTest() throws InterruptedException {
		if (wdriver == null) {
			System.out.println("Launching the web browser ");
			wdriver = mBasePage.launchBrowser();
		}
			corpPage = new CreateCorpRunner_Positive(wdriver);
			corpPage.createCorporateTest();
		}
	}

