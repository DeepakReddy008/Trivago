package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class search {
 WebDriver driver=null;
	
	@Given("Browse is open")
	public void browse_is_open() {
		 System.setProperty("webdriver.chrome.driver","C:/Users/deepa_j4d8n93/eclipse-workspace/com.Trivago.O001/src/main/resources/Drivers/chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
 driver.get("https://www.trivago.in/");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    
	}

	@When("user click on textfield")
	public void user_click_on_textfield() {
		driver.findElement(By.xpath("//input[@id='input-auto-complete']"));
	}

	@And("user enter the valid credentials")
	public void user_enter_the_valid_credentials() {
		WebElement textField=	driver.findElement(By.xpath("//input[@id='input-auto-complete']"));
		textField.sendKeys("Bangkok");
		WebElement textFieldClick =  driver.findElement(By.xpath("(//li[@class='cursor-pointer'])[1]"));
		textFieldClick.click();
	}

	@When("user click on check in")
	public void user_click_on_check_in() {
		 WebElement check_In=driver.findElement(By.xpath("//span[@data-testid='checkin-calendar-label']"));
		 WebDriverWait wait= new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(check_In));
	}

	@And("user should be able to fix dates")
	public void user_should_be_able_to_fix_dates() {
		String month= "March 2023";
		String exc_date="20";
		
		// To Select the month and year from calendar
		while (true)		{
		String text=driver.findElement(By.xpath("(//button[@class=\"cursor-auto font-bold\"])[1]")).getText();
		 if(text.equals(month))
			 {
				 break;
		 }
		 else
		 {
			// Thread.sleep(4000);
			 driver.findElement(By.xpath("//button[@data-testid='calendar-button-next']")).click();
			 }
		}
		
		// TO Select the random date from calendar
	List<WebElement>	allDays=driver.findElements(By.xpath("//button[@data-testid='valid-calendar-day']")) ;

	 for(WebElement date:allDays )
	 {
		
	String Date_text=	date.getText();
	
	if(Date_text.equals(exc_date))
	{
		date.click();
		break;
	}
	 }
	 WebElement	 checkout=	 driver.findElement(By.xpath("//button[@data-testid='calendar-checkout']"));
	 checkout.click();
	    
	}

	@When("user clicks on rooms")
	public void user_clicks_on_rooms() {
		 WebElement Guest_Selector=driver.findElement(By.xpath("//button[@data-testid='guest-selector']"));
	 	 Guest_Selector.click();
	  
	}

	@And("user should be able to add the guests")
	public void user_should_be_able_to_add_the_guests() {
		WebElement plus_Button=	driver.findElement(By.xpath("//button[@data-testid='adults-amount-plus-button']"));
	 	plus_Button.click();
	}

	@When("user clicks on search")
	public void user_clicks_on_search() {
		WebElement	selector_apply=	driver.findElement(By.xpath("//button[@data-testid='guest-selector-apply']"));
	 	selector_apply.click();
	 	
	}

	@Then("user should be able to see the related hotel search page")
	public void user_should_be_able_to_see_the_related_hotel_search_page() throws Exception {
		Thread.sleep(35000);
		WebElement search_button= driver.findElement(By.xpath("//button[@data-testid='search-button']"));
		 WebDriverWait wait= new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(search_button));
		 driver.findElement(By.xpath("//button[@data-testid='search-button']")).click();
	}

	@When("user click on Price or night")
	public void user_click_on_price_or_night() {
		driver.findElement(By.xpath("//div[@data-testid='slider-handle-min']"));
	}

	@And("price or night should be able to be dragged from right to left by the user")
	public void price_or_night_should_be_able_to_be_dragged_from_right_to_left_by_the_user() {
		
		WebElement slider1=driver.findElement(By.xpath("//div[@data-testid='slider-handle-min']"));
		Actions action=new Actions(driver);
		action.dragAndDropBy(slider1, 80, 0).perform();
	}

	@When("user clicks on drop down")
	public void user_clicks_on_drop_down() {
		driver.findElement(By.xpath("//select[@id='sorting-selector']"));
	}

	@And("user should be able to select all filters present in dropdown")
	public void user_should_be_able_to_select_all_filters_present_in_dropdown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;

		WebElement sortBy = driver.findElement(By.xpath("//select[@id='sorting-selector']"));
		js.executeScript("arguments[0].scrollIntoView();",sortBy );
		Select select = new Select(sortBy);
		
		List<WebElement> option=select.getOptions();
		for (int i=0; i<option.size(); i++)
		{
		WebElement sortBy1=driver.findElement(By.xpath("//select[@id='sorting-selector']"));
		Select select1=new Select(sortBy1);
		select1.selectByIndex(i);
		//Thread.sleep(4000);
		}
	   
	}

	@When("user click on favourite icon")
	public void user_click_on_favourite_icon() {
		driver.findElement(By.xpath("(//button[@data-testid='accommodation-card-favourite-button'])[4]"));
	}

	@And("user should be able to see favourite hotel page")
	public void user_should_be_able_to_see_favourite_hotel_page() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement favourites_Click=driver.findElement(By.xpath("(//button[@data-testid='accommodation-card-favourite-button'])[4]"));
		
		js.executeScript("arguments[0].scrollIntoView();",favourites_Click );
		favourites_Click.click();
		
		
		WebElement favourites=driver.findElement(By.xpath("(//div[@class='flex justify-center'])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", favourites);
		driver.navigate().back();
	}

	@When("user click on view deal")
	public void user_click_on_view_deal() {
		
		driver.findElement(By.xpath("(//button[@data-testid='champion-deal'])[1]")).click();
	}

	@And("user should be able see best hotele page")
	public void user_should_be_able_see_best_hotele_page() {
		
	   System.out.println("User is successfully able to the best hotel page");
	}

	@And("browser is closed")
	public void browser_is_closed() {
	   driver.quit();
		
	}


}
