package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends PageBase{

	public HomePage(AndroidDriver appiumDriverFromTestBase) {
		super(appiumDriverFromTestBase);
	}

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
    private WebElement homePageTitleAndroid;
    @iOSXCUITFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
    private WebElement homePageTitleIos;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Access'ibility\"]")
    private WebElement accessBtnAndroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc=\"Access'ibility\"]")
    private WebElement accessBtnIos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Accessibility']")
    private WebElement accessibilityBtnAndroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc='Accessibility']")
    private WebElement accessibilityBtnIos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Animation']")
    private WebElement animationBtnAnroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc='Animation']")
    private WebElement animationBtnIos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='App']")
    private WebElement appBtnAnroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc='App']")
    private WebElement appBtnIos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Content']")
    private WebElement contentBtnAnroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc='Content']")
    private WebElement contentBtnIos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Graphics']")
    private WebElement graphicsBtnAnroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc='Graphics']")
    private WebElement graphicsBtnIos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Media']")
    private WebElement mediaBtnAnroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc='Media']")
    private WebElement mediaBtnIos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='NFC']")
    private WebElement nfcBtnAnroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc='NFC']")
    private WebElement nfcBtnIos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='OS']")
    private WebElement osBtnAnroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc='OS']")
    private WebElement osBtnIos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Preference']")
    private WebElement preferenceBtnAndroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc='Preference']")
    private WebElement preferenceBtnIos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Text']")
    private WebElement textBtnAndroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc=\"Text\"]")
    private WebElement textBtnIos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Views\"]")
    private WebElement viewsBtnAndroid;
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc=\"Views\"]")
    private WebElement viewsBtnIos;
	
	public WebElement getHomePageTitle () {
		return homePageTitleAndroid;
	}
	
	public WebElement getAccessBtn () {
		return accessBtnAndroid;
	}
	
	public WebElement getViewsBtn () {
		return viewsBtnAndroid;
	}
	
	public WebElement getAccessibilityBtn () {
		return accessibilityBtnAndroid;
	}
	
	public WebElement getAnimationBtn () {
		return animationBtnAnroid;
	}
	
	public WebElement getAppBtn () {
		return appBtnAnroid;
	}
	
	public WebElement getContentBtn () {
		return contentBtnAnroid;
	}
	
	public WebElement getGraphicsBtn () {
		return graphicsBtnAnroid;
	}
	
	public WebElement getMediaBtn () {
		return mediaBtnAnroid;
	}
	
	public WebElement getNFCBtn () {
		return nfcBtnAnroid;
	}
	
	public WebElement getOSBtn () {
		return osBtnAnroid;
	}
	
	public WebElement getPreferenceBtn () {
		return preferenceBtnAndroid;
	}
	
	public WebElement getTextBtn () {
		return textBtnAndroid;
	}
	
	public HomePage clickViewsBtn () {
		this.click(this.getViewsBtn());
		return null;
	}
	
	public String getViewsBtnText () {
		String text = this.getText(this.getViewsBtn());
		return text;
	}
}
