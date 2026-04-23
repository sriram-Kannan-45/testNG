package com.newTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import com.utilities.ExcelUtils;
import com.listeners.SimpleListener;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Listeners(SimpleListener.class)
public class LoginDemoBlaze {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger log = LogManager.getLogger(LoginDemoBlaze.class);

    @BeforeMethod
    public void setup() {
        try {
            log.debug("Starting browser");
            driver.set(new ChromeDriver());
        } catch (Exception e) {
            log.error("Error while launching browser", e);
            throw e;
        }
    }

    @Test(dataProvider = "validData", dataProviderClass = ExcelUtils.class)
    public void loginCheck(String name, String pass) {

        try {
            WebDriver driver1 = driver.get();
            log.info("Valid login test started");

            driver1.manage().window().maximize();
            driver1.get("https://www.demoblaze.com/");

            WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));

            log.debug("Opening login popup");
            driver1.findElement(By.id("login2")).click();

            log.debug("Entering credentials");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))).sendKeys(pass);

            driver1.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]")).click();

            WebElement user = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
            );

            Assert.assertTrue(user.getText().contains("Welcome"));

            log.info("Valid login passed");

        } catch (Exception e) {
            log.error("Valid login test failed", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @Test(dataProvider = "invalidData", dataProviderClass = ExcelUtils.class)
    public void loginInvalCheck(String name, String pass) {

        try {
            WebDriver driver1 = driver.get();
            log.info("Invalid login test started");

            driver1.manage().window().maximize();
            driver1.get("https://www.demoblaze.com/");

            WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));

            driver1.findElement(By.id("login2")).click();

            log.debug("Entering invalid credentials");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))).sendKeys(pass);

            driver1.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]")).click();

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String msg = alert.getText();
            log.error("Login failed message: {}", msg);

            Assert.assertEquals(msg, "Wrong password.");

            alert.accept();

            log.info("Invalid login passed");

        } catch (Exception e) {
            log.error("Invalid login test failed", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void teardown() {
        try {
            WebDriver driver1 = driver.get();

            if (driver1 != null) {
                driver1.quit();
                log.debug("Browser closed");
            }
        } catch (Exception e) {
            log.error("Error during browser teardown", e);
        }
    }
}