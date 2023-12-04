package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RotatingButtonPage extends PageBase{

	public RotatingButtonPage(AndroidDriver appiumDriverFromTestBase) {
		super(appiumDriverFromTestBase);
	}
	
	@AndroidFindBy(id = "io.appium.android.apis:id/rotationX")
	private WebElement sliderX;
	
	public WebElement getSliderX() {
		return sliderX;
	}
	
}
