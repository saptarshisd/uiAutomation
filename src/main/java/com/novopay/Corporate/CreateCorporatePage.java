package com.novopay.Corporate;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;
import utils.Log;

public class CreateCorporatePage extends BasePage {
	
	@FindBy(xpath = "//*[@class=\"page-title\"]")
	WebElement createCorporatePageTitle;
	
	@FindBy(xpath = "//*[@id=\"corporate-code-id\"]")
	WebElement corporateCode;
	
	@FindBy(xpath = "//*[@id=\"corporate-name-id\"]")
	WebElement corporateName;
	
	@FindBy(xpath = "//*[@id=\"tax-identification-number\"]")
	WebElement taxId;
	
	@FindBy(xpath = "//*[@id=\"trade-license-number\"]")
	WebElement tradeLicense;
	
	@FindBy(xpath = ".//button[@class = \"btnpicker btnpickerenabled\" ]")
	WebElement tradeLicenseExpCalenderButton;
	
	@FindBy(xpath = "//*[@id=\"business-registration-number\"]")
	WebElement businessRegNo;
	
	@FindBy(xpath ="//*[@id=\"corp-section-additional-details-aob\"]")
	WebElement ageOfBusiness;
	
	@FindBy(xpath = "//*[@id=\"corp-section-additional-details-at\"]")
	WebElement annualTurnover;
	
	@FindBy(xpath =".//button[contains(text(),'Submit')]")
	WebElement nextPage;
	
	@FindBy(xpath = "//*[@id=\"custom-hamburger\"]")
	WebElement sideNavHamburg;
	
	@FindBy(xpath = "//*[@class=\"np-sidenav-submenu ng-star-inserted\"]")
	WebElement sideNavCorpManagement;
	
	@FindBy(xpath = "//*[@id=\"organisation-corporate-management\"]")
	WebElement corporateSideNav;
	
	@FindBy(xpath = "//*[@class=\"button button-primary ng-star-inserted\"]")
	WebElement createCorporate;
	
	
	
	
	//Defining implicit super constructor BasePage() for default constructor
	public CreateCorporatePage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}
	
	public void createCorpTest() throws InterruptedException {
		try {
				waitUntilElementAppears(createCorporatePageTitle);
				waitUntilBlockUI();
				sideNavHamburg.click();
				sideNavCorpManagement.click();
				corporateSideNav.click();
				waitUntilBlockUI();
				createCorporate.click();
				createCorp();
		
		}catch (java.util.NoSuchElementException e) {
			Log.info("Not on Create Corp page", true);
		}
	}
	
	private void createCorp() {
		try {
			waitUntilElementAppears(createCorporatePageTitle);
			corporateCode.click();
			
			
			
			
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
	}

}



