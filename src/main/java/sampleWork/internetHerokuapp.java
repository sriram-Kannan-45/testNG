package sampleWork;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class internetHerokuapp {

	public static void main(String[] args)
	
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		WebElement dynamicLoading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[text()=\"Dynamic Loading\"]")));
		
		dynamicLoading.click();
		
		WebElement dyanmic_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),\"Example 1\")]")));
		
		dyanmic_1.click();
		
		WebElement start = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()=\"Start\"]")));
		
		start.click();
		
		String str = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/child::h4[text()=\"Hello World!\"]"))).getText();
		
		System.out.println(str);
		
		driver.navigate().to("https://the-internet.herokuapp.com/");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Dynamic Controls\"]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"checkbox\"]/input"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Remove\"]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]"))).getText();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Enable\"]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id=\"input-example\"]/input"))).sendKeys("Hi");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Disable\"]"))).click();
		
		String enable =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Enable\"]"))).getText();
		
		System.out.println(enable);
	
		driver.navigate().to("https://the-internet.herokuapp.com/");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Dropdown\"]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select"))).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//select/option"));
		
		String op = "";
		
		for (WebElement option : list)
		{
			if (option.getText().equals("Option 2"))
			{
				op = option.getText();
				
				option.click();
			}
		}
		
		System.out.println(op);
		
		driver.navigate().to("https://the-internet.herokuapp.com/");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"JavaScript Alerts\"]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Click for JS Alert\"]"))).click();
		
		Alert alt = driver.switchTo().alert();
		
		System.out.println(alt.getText());
		
		alt.accept();
		
		
	}
	
        
}
