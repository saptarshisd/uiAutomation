package com.novopay.Corporate.ui;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BasePage;
import utils.JavaUtils;
import utils.Log;

public class CreateCorpRunner_Positive extends BasePage {

	// LoginPage Elements

	@FindBy(id = "email")
	WebElement userNamefield;

	@FindBy(id = "pswd")
	WebElement passwordfield;

	@FindBy(xpath = "//button[contains(text(), 'LOGIN')]")
	WebElement logInButton;

	// Create Corp Page

	@FindBy(xpath = "//*[@class=\"page-title\"]")
	WebElement createCorporatePageTitle;
	
	@FindBy(xpath = "//*[@class='ng-busy-default-sign']")
	WebElement loadingObject;

	@FindBy(xpath = "//*[@id='corporate-code-id']")
	WebElement corporateCode;

	@FindBy(xpath = "//*[@id='corporate-name-id']")
	WebElement corporateName;

	@FindBy(xpath = "//*[@id='tax-identification-number']")
	WebElement taxId;

	@FindBy(xpath = "//*[@id='trade-license-number']")
	WebElement tradeLicense;

	@FindBy(xpath = ".//button[@class ='btnpicker btnpickerenabled']")
	WebElement tradeLicenseExpCalenderButton;

	@FindBy(xpath = "//*[@id=\"business-registration-number\"]")
	WebElement businessRegNo;

	@FindBy(xpath = "//*[@id=\"corp-section-additional-details-aob\"]")
	WebElement ageOfBusiness;

	@FindBy(xpath = "//*[@id=\"corp-section-additional-details-at\"]")
	WebElement annualTurnover;

	@FindBy(xpath = ".//button[contains(text(),'Submit')]")
	WebElement nextPage;

	@FindBy(xpath = "//*[@id=\"custom-hamburger\"]")
	WebElement sideNavHamburg;

	@FindBy(xpath = "//*[@title=\"Corporate Management\"]")
	WebElement sideNavCorpManagement;

	@FindBy(xpath = "//*[@id=\"organisation-corporate-management\"]")
	WebElement corporateSideNav;

	@FindBy(xpath = ".//button[contains(text(),'Create Corporate')]")
	WebElement createCorporate;
	
	@FindBy(xpath = "//*[@id=\"type-of-business\"]")
	WebElement drpDownTypBusiness;
	
	@FindBy(xpath = "//*[@class=\'select2-results__option\']")
	WebElement drpDownOptions;
	
	@FindBy(xpath = "//*[@id='corporate-classification']")
	WebElement corpClassi;
	
	@FindBy(xpath = "//*[@role='treeitem'][1]")
	WebElement coropClassiSelection;
	
	
	@FindBy(xpath = "//*[@id=\"corp-section-business-details-pccn\"]")
	WebElement parentCorp;
	
	@FindBy(xpath = "//*[@class='select2-results__option' and contains(text(),'Tenant')]")
	WebElement parentCorpOptions;

	@FindBy(xpath = "//*[@id=\'corp-section-business-details-bo\']")
	WebElement baseOffice;
	
	@FindBy(xpath = "//*[@class='select2-results__option' and contains(text(),'SU123 - Suryoday_Office_1')]")
	WebElement baseOfficeSelection;
	
	@FindBy(xpath = "//*[@id=\'corp-business-details-form\']//span[contains(text(),'Add New Address')]")
	WebElement addAddress;
	
	@FindBy(xpath = "//*[@id=\'address-modal-address-line-one\']")
	WebElement addressline;
	
	@FindBy(xpath = "//*[@id='np-address-component']")
	WebElement addressModal;
	
	@FindBy(xpath = "//*[@id=\'country\']")
	WebElement country;
	
	@FindBy(xpath ="//*[@role='treeitem']")
	WebElement countrySelection;
	
	@FindBy(xpath ="//*[@id=\'hierarchy_elements_2\']")
	WebElement state;
	
	@FindBy(xpath = "//*[@role='treeitem']")
	WebElement stateSelection;
	
	@FindBy(xpath ="//*[@id=\'hierarchy_elements_3\']")
	WebElement district;
	
	@FindBy(xpath ="//*[@role='treeitem']")
	WebElement districtSelection;
	
	@FindBy(xpath = "//*[@id='hierarchy_elements_4']")
	WebElement subDistrict;
	
	@FindBy(xpath ="//*[@role='treeitem']")
	WebElement subDistrictSelection;
	
	@FindBy(xpath = "//*[@id='hierarchy_elements_5']")
	WebElement vtc;
	
	@FindBy(xpath ="//*[@role='treeitem']")
	WebElement vtcSelection;
	
	@FindBy(xpath = "//*[@id=\'address-modal-address-postal-code\']")
	WebElement postalCode;
	
	@FindBy(xpath = "//*[@id='employee-mobile-country-code']")
	WebElement countryCode;
	
	@FindBy(xpath ="//*[@id='employee-mobile-number'][1]")
	WebElement mobileNumber;
	
	
	@FindBy(xpath = "//*[@id=\'address-email\']")
	WebElement email;
	
	@FindBy(xpath = "//span[@class='ng-star-inserted' and text()='Next']")
	WebElement next;
	
	
	
	
	@FindBy(xpath = ".//button[contains(text(),'Submit')]")
	WebElement submitButton;
	
//	@FindBy(xpath = "//*[@id=\'np-address-component\']/div[1]/div[2]/div[2]/div")
//	WebElement mapComonent;
	
	
	//Basic Details Page
	
	@FindBy(xpath = "//*[@id='type-of-business']")
	WebElement salutation;
	
	@FindBy(xpath ="//*[@role='treeitem'][1]")
	WebElement salutationSelection;
	
	@FindBy(xpath ="//*[@id='first-name-id']")
	WebElement firstName;
	
	@FindBy(xpath = "//*[@id='last-name-id']")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id='corp-section-basic-details-gender-MALE']")
	WebElement gender;
	
	@FindBy(xpath = "//*[@id='corp-personal-details-form']//span[contains(text(),'Add New Address')]")
	WebElement personalAddressForm;
	
	
	
	
	
	
	
	
	
	
	
	
	
	Properties prop;
	JavaUtils javaUtils = new JavaUtils();

	// Defining implicit super constructor BasePage() for default constructor
	public CreateCorpRunner_Positive(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}

	// WebDriverWait wait = new WebDriverWait(wdriver, 15);

	@BeforeMethod
	public void init() {
		try (InputStream is = new FileInputStream("./configuration.properties")) {
			System.out.println("Reading properties");
			prop = new Properties();
			prop.load(is);
		} catch (NoSuchElementException e) {
			Log.info("User already logged in", true);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void createCorporateTest() {
		init();
		login();
		createCorpTest();
	}

	public void login() {

		sendKeys(userNamefield, prop.getProperty("Username"));
		sendKeys(passwordfield, prop.getProperty("Password"));
		logInButton.click();
	}

	// Corporate Page

	private void createCorp() {
		try {
			waitUntilElementAppears(createCorporatePageTitle);
			waitUntilElementNotDisplayed("//*[@class='ng-busy-default-sign']");
			corporateCode.click();
			sendKeys(corporateCode, javaUtils.generateRandomNo(5));
			
			corporateName.click();
			corporateName.sendKeys(javaUtils.generateRandomAlphaString(5));
			
			drpDownTypBusiness.click();
			waitUntilBlockUI();
			
			drpDownOptions.click();
			waitUntilBlockUI();
			
			corpClassi.click();
			waitUntilBlockUI();
			
			coropClassiSelection.click();
			waitUntilBlockUI();
			
			parentCorp.click();
			waitUntilBlockUI();
			
			parentCorpOptions.click();
			waitUntilBlockUI();
			
			baseOffice.click();
			waitUntilBlockUI();
			
			baseOfficeSelection.click();
			waitUntilBlockUI();
			
			addAddress.click();
			waitUntilBlockUI();
			
			//Address popup
			 waitUntilElementAppears(addressline);
			 
			 wdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			 
			 waitUntilBlockUI();
			 
//			 waitUntilElementClickable(mapComonent);
			 
			 
			
			
			
			addressline.click();
			addressline.sendKeys(javaUtils.generateRandomAlphaString(6));
			waitUntilBlockUI();
			
			
			country.click();
			waitUntilBlockUI();
			
			countrySelection.click();
			waitUntilBlockUI();
			
			
			state.click();
			waitUntilBlockUI();
			
			stateSelection.click();
			waitUntilBlockUI();
			
			district.click();
			waitUntilBlockUI();
			districtSelection.click();
			waitUntilBlockUI();
			
			subDistrict.click();
			waitUntilBlockUI();
			subDistrictSelection.click();
			waitUntilBlockUI();
			
			vtc.click();
			waitUntilBlockUI();
			vtcSelection.click();
			waitUntilBlockUI();
			
			postalCode.click();
			postalCode.sendKeys("560035");
			
			countryCode.click();
			countryCode.sendKeys("91");
			
			mobileNumber.click();
			mobileNumber.sendKeys("9061772825");
			
			
			email.click();
			sendKeys(email, "biscuit@novopay.in");
			
			try {
				scrollDown();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
			waitUntilBlockUI();
			
			
			submitButton.click();
			waitUntilBlockUI();
			
//			try {
//				scrollToWebElement(next);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			waitUntilBlockUI();
			next.click();

		} catch (NoSuchElementException e) {
			e.printStackTrace();

		}
		
		//Basic Details Page
		
		salutation.click();
		waitUntilBlockUI();
		
		salutationSelection.click();
		
		firstName.click();
		firstName.sendKeys(javaUtils.generateRandomAlphaString(6));
		
		lastName.click();
		lastName.sendKeys(javaUtils.generateRandomAlphaString(5));
		
		try {
			scrollToWebElement(gender);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		((JavascriptExecutor) wdriver).executeScript("arguments[0].click();", gender);
		
		
		countryCode.click();
		countryCode.sendKeys("91");
		
		mobileNumber.click();
		mobileNumber.sendKeys("9073536478");
		
		try {
			scrollDown();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
		personalAddressForm.click();
		
		 waitUntilElementAppears(addressline);
		 
		 wdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		 
		 waitUntilBlockUI();
		
		
		
		//Address page
		
		addressline.click();
		addressline.sendKeys(javaUtils.generateRandomAlphaString(6));
		waitUntilBlockUI();
		
		
		country.click();
		waitUntilBlockUI();
		
		countrySelection.click();
		waitUntilBlockUI();
		
		state.click();
		waitUntilBlockUI();
		
		stateSelection.click();
		waitUntilBlockUI();
		
		district.click();
		waitUntilBlockUI();
		districtSelection.click();
		waitUntilBlockUI();
		
		subDistrict.click();
		waitUntilBlockUI();
		subDistrictSelection.click();
		waitUntilBlockUI();
		
		vtc.click();
		waitUntilBlockUI();
		vtcSelection.click();
		waitUntilBlockUI();
		
		
		
		postalCode.click();
		postalCode.sendKeys("560035");
		
		
	
		try {
			scrollDown();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		waitUntilBlockUI();
		
		
		submitButton.click();
		waitUntilBlockUI();
		
		waitUntilBlockUI();
		next.click();
		
		
		
		
	}

	public void createCorpTest() {
		try {
//			waitUntilElementAppears(createCorporatePageTitle);
			waitUntilBlockUI();
			waitUntilElementAppears(sideNavHamburg);
			sideNavHamburg.click();
			waitUntilElementAppears(sideNavCorpManagement);
			sideNavCorpManagement.click();
			corporateSideNav.click();
			waitUntilBlockUI();
			sideNavHamburg.click();
			waitUntilBlockUI();
//			JavascriptExecutor js = (JavascriptExecutor)wdriver;
			waitUntilElementClickable(createCorporate);

			((JavascriptExecutor) wdriver).executeScript("arguments[0].click();", createCorporate);
//			createCorporate.click();
			createCorp();

		} catch (java.util.NoSuchElementException e) {
			Log.info("Not on Create Corp page", true);
		}
	}

}
