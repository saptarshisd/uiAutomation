package com.novopay.Corporate.ui;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.novopay.Corporate.LoginPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.BasePage;

public class LoginPageTest {
	public AndroidDriver<MobileElement> mdriver;
	public WebDriver wdriver;
	private BasePage mBasePage = new BasePage(wdriver);
	private LoginPage loginPage;
	public String sheetname = "LoginPage", workbook = "UITestData";
	
	
	
	public void loginPageTest(HashMap<String, String> usrData) {
		String testOn = usrData.get("TESTON");
		if (testOn.toUpperCase().equals("MOBILE")) {
			System.out.println("LAUNCHING THE MOBILE APP FOR FLOW : " + usrData.get("TCID"));
			if (mdriver == null) {
				try {
					mdriver = mBasePage.launchApp(usrData.get("DEVICE"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if (testOn.toUpperCase().equals("WEB")) {
			if (wdriver == null) {
				System.out.println("Launching the web browser for the test case : " + usrData.get("TCID"));
				wdriver = mBasePage.launchBrowser();
			} else if ((wdriver != null)) {
				System.out.println("Using the web browser for the test case : " + usrData.get("TCID"));
			}
			loginPage = new LoginPage(wdriver);
			loginPage.login(usrData);
		}
	}

}
