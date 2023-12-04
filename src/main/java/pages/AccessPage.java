package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AccessPage extends PageBase{

	public AccessPage(AndroidDriver appiumDriverFromTestBase) {
		super(appiumDriverFromTestBase);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility Node Provider\"]")
	private WebElement accessNodeProBtnAndroid;
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility Node Provider\"]")
	private WebElement accessNodeProBtnIos;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Enable TalkBack and Explore-by-touch from accessibility settings. Then touch the colored squares.\"]")
	private WebElement accessNodeProTextAndroid;
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc=\"Enable TalkBack and Explore-by-touch from accessibility settings. Then touch the colored squares.\"]")
	private WebElement accessNodeProTextIos;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"io.appium.android.apis:id/button\"]")
	private WebElement accessNodeProText_BtnAndroid;
	@iOSXCUITFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"io.appium.android.apis:id/button\"]")
	private WebElement accessNodeProText_BtnIos;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility Node Querying\"]")
	private WebElement accessNodeQueBtnAndroid;
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility Node Querying\"]")
	private WebElement accessNodeQueBtnIos;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility Service\"]")
	private WebElement accessServiceBtnAndroid;
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility Service\"]")
	private WebElement accessServiceBtnIos;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Custom View\"]")
	private WebElement customViewBtnAndroid;
	
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc=\"Custom View\"]")
	private WebElement customViewBtnIos;
	
	public WebElement getAccNodeProBtn (String type) {
		if (type == "Android") {
			return accessNodeProBtnAndroid;
		}
		
		else if (type == "iOS") {
			return accessNodeProBtnIos;
		}
		
		else {
			return null;
		}
	}
	
	public WebElement getAccessNodeProText (String type) {
		if (type == "Android") {
			return accessNodeProText_BtnAndroid;
		}
		else if (type == "iOS") {
			return accessNodeProText_BtnIos;
		}
		else {
			return null;
		}
	}
	
	public WebElement getAccessNodeProText_Btn (String type) {
		if (type == "Android") {
			return accessNodeProText_BtnAndroid;
		}
		else if (type == "iOS") {
			return accessNodeProText_BtnIos;
		}
		else {
			return null;
		}
		
	}
	
	public WebElement getAccNodeQueBtn (String type) {
		if (type == "Android") {
			return accessNodeQueBtnAndroid;
		}
		else if (type == "iOS") {
			return accessNodeQueBtnIos;
		}
		else {
			return null;
		}
	}
	
	public WebElement getAccServiceBtn (String type) {
		if (type == "Android") {
			return accessServiceBtnAndroid;
		}
		else if (type == "iOS") {
			return accessServiceBtnIos;
		}
		else {
			return null;
		}
	}
	
	public WebElement customViewBtn (String type) {
		if (type == "Android") {
			return customViewBtnAndroid;
		}
		else if (type == "iOS") {
			return customViewBtnIos;
		}
		else {
			return null;
		}
	}

}
