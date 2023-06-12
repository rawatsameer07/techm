package com.uiSpec;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UIStepDefCore {

	public static String url;
	private WebDriver driver;
	
	@Given("I launch the browser and open the URL")
    public void launchBrowserAndOpenURL() {
        // Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        // Create a new instance of ChromeDriver
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Launch the URL
        driver.get("https://reqres.in/");
        // Wait until the page is fully loaded
        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
        wait.until(ExpectedConditions.titleIs("Reqres - A hosted REST-API ready to respond to your AJAX requests".trim()));
    }
	
	@When("I scroll to the console section")
    public void scrollToConsole() {
		WebElement element = driver.findElement(By.id("console"));
	    scrollToElement(element);
	}
    
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
	@Then("I verify list of endpoints are present")
	public void verifyEndpoints() {
		// Verify list of endpoints under the console section
		List<WebElement> endpoints = driver
				.findElements(By.xpath("//div[@class='endpoints']/ul/li[@data-key='endpoint']"));
		if (endpoints.size() > 0) {
			System.out.println("List of endpoints is present under the console section.");
		} else {
			System.out.println("List of endpoints is not present under the console section.");
		}
	}
    
    
}
