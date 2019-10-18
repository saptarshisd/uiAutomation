package com.novopay.Corporate;

import java.util.HashMap;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BasePage;
import utils.Log;

public class LoginPage  extends BasePage{
	
	@FindBy(id = "email")
	WebElement userNamefield;

	@FindBy(id = "pswd")
	WebElement passwordfield;

	@FindBy(xpath = "//button[contains(text(), 'LOGIN')]")
	WebElement logInButton;
	
	WebDriverWait wait=new WebDriverWait(wdriver, 15);
	
	public LoginPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}
	
	public void login(HashMap<String,String> usrData) {
		try {
			sendKeys(userNamefield,usrData.get("Username"));
			sendKeys(passwordfield,usrData.get("Password"));
			logInButton.click();
		}catch(NoSuchElementException e) {
			Log.info("User already logged in",true);
		}
	}
	
	

}
