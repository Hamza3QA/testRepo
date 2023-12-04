package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ViewsPage extends PageBase{

	public ViewsPage(AndroidDriver appiumDriverFromTestBase) {
		super(appiumDriverFromTestBase);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Grid\"]")
	private WebElement gridBtnAndroid;
	
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@content-desc=\"Grid\"]")
	private WebElement gridBtnIos;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Rotating Button\"]")
	private WebElement rotatingBtnAndroid;
	
	public WebElement getGridBtn(String type) {
		if (type == "Android") {
			return gridBtnAndroid;
		}
		
		else if (type == "Ios") {
			return gridBtnIos;
		}
		
		else {
			return null;
		}
	}
	
	public WebElement getRotatingElement() {
		return rotatingBtnAndroid;
	}
	
	
}
