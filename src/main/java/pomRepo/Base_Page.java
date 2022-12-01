package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.UtilityMethods;

public class Base_Page extends UtilityMethods{
	
	public Base_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
