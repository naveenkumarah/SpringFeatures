package com.sample.selenium;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;

/**
 * Search Google example.
 *
 * @author Rahul
 */
public class GoogleSearch {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    public static void main(String[] args) {
    	//SafariOptions options = new SafariOptions();
    	// options.setUseCleanSession(true);
    	System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
    	
    	
    	//wait = new WebDriverWait(driver, 30);
        driver.get("http://www.google.com/");

        
    }

    
}