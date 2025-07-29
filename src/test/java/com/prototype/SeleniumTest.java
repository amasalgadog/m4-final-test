package com.prototype;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class SeleniumTest {

    WebDriver driver;
    WebDriverWait wait;

    //Before test method to create a new instance of ChromeDriver
    @Before
    public void CreateConnection(){
    
        // Create a new instance of ChromeDriver
        driver = new ChromeDriver(new ChromeOptions()
                .addArguments("--headless") // Run in headless mode
        );

        // Navigate to the specified URL
        driver.get("https://github.com");

        //wait instance
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Actual test method for Selenium
    @Test
    public void Assert() throws InterruptedException {
        WebElement titleElement = driver.findElement(By.id("hero-section-brand-heading"));

        assert titleElement.getText().contains("Build and ship software on a single, collaborative platform");
        
        //If IsDisplayed is true then it pass the test else it will fail the test.
        assertTrue(titleElement.isDisplayed());
    }

    //After test method to close the connection
    @After
    public void CloseConnection()
    {
        driver.quit();
    }
}