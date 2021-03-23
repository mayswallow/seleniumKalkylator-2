package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions {
	
	private WebDriver driver;
		
	@Given("I have entered https:\\/\\/www.marshu.com\\/articles\\/calculate-addition-calculator-add-two-numbers.php")
	public void i_have_entered_https_www_marshu_com_articles_calculate_addition_calculator_add_two_numbers_php() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
	    driver = new ChromeDriver(); // Starta Chrome
	    driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php"); // Gå till webbsidan	
	    //Thread.sleep(5000);
	}
		
		@Given("I have entered {int} into the calculator")
		public void i_have_entered_into_the_calculator(Integer int1) throws InterruptedException {
		    WebElement addFirst = driver.findElement(By.name("n01")); // Nummer 1
		    addFirst.sendKeys(String.valueOf(int1));
		}
		
		@Given("I have also entered {int} into the calculator")
		public void i_have_also_entered_into_the_calculator(Integer int1) throws InterruptedException {
			WebElement addFirst = driver.findElement(By.name("n02")); // Nummer 2
		    addFirst.sendKeys(String.valueOf(int1));
		}
		@When("I press add")
		public void i_press_add() throws InterruptedException {
			//driver.findElement(By.xpath("//input[@type='button']")).click();
			//driver.findElement(By.cssSelector("input[type=button]")).click();
			click(driver, By.cssSelector("input[type=button]"));
			
			/*List<WebElement> elements = driver.findElements(By.className("regfont"));

					for(WebElement e : elements) {
						System.out.println(e.getAttribute("name"));
			
			List<WebElement> elements = driver.findElements(By.tagName("input"));
			System.out.println("Hur många inputs finns det?" + elements.size());*/
					
		}
		
		@Then("the result should be {int} on the screen")
		public void the_result_should_be_on_the_screen(Integer int1) throws InterruptedException {
			WebElement result = driver.findElement(By.name("answer"));
			assertEquals(String.valueOf(int1), result.getAttribute("value"));
			Thread.sleep(2000);
			driver.quit();
		}
		
		private void click(WebDriver driver, By by) {
			(new WebDriverWait(driver, 1)).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		}



}
