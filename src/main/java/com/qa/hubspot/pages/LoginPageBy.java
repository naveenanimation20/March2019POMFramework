package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.JavaScriptUtil;

public class LoginPageBy {

	WebDriver driver;
	ElementActions elementActions;
	JavaScriptUtil jsUtil;

	// 1. define page objects with the help of By locator
	// 2. page actions/methods of the feature

	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");

	public LoginPageBy(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	// 2. define your actions/methods:
	public String getLoginPageTitle() {
		return elementActions.getPageTitle();
	}

	public boolean verifySignUpLink() {
		return elementActions.getElement(signUpLink).isDisplayed();
	}

	public HomePage doLogin(String un, String pwd) {
		elementActions.sendKeysElement(username, un);
		elementActions.sendKeysElement(password, pwd);
		//elementActions.clickOnElement(loginBtn);
		jsUtil.clickElementByJS(elementActions.getElement(loginBtn));
		
		return new HomePage(driver);
	}

}
