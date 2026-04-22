package com.newTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.utilities.ExcelUtils;

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

public class LoginDemoBlaze {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger log = LogManager.getLogger(LoginDemoBlaze.class);

    @BeforeMethod
    public void setup() {
        log.debug("Starting browser");
        driver.set(new ChromeDriver());
    }

    @Test(dataProvider = "validData", dataProviderClass = ExcelUtils.class)
    public void loginCheck(String name, String pass) {

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

        log.debug("Verifying login success");

        WebElement user = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        );

        Assert.assertTrue(user.getText().contains("Welcome"));

        log.info("Valid login passed");
    }

    @Test(dataProvider = "invalidData", dataProviderClass = ExcelUtils.class)
    public void loginInvalCheck(String name, String pass) {

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

        log.debug("Waiting for alert");

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String msg = alert.getText();
        log.error("Login failed message: {}", msg);

        Assert.assertEquals(msg, "Wrong password.");

        alert.accept();

        log.info("Invalid login passed");
    }

    @AfterMethod
    public void teardown() {
        WebDriver driver1 = driver.get();

        if (driver1 != null) {
            driver1.quit();
            log.debug("Browser closed");
        }
    }
}