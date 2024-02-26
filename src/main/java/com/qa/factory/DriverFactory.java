package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // This Method is used to initialize the threadLocal driver based on the given browser
    public static WebDriver init_driver(String browser) {

        System.out.println("browser value is :" + browser);

        if (browser.contains("chrome")) {
        	ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--use-fake-ui-for-media-stream");

            // Set up ChromeDriver with ChromeOptions
            tlDriver.set(new ChromeDriver(chromeOptions));
            
        } else if (browser.contains("firefox")) {
        	System.out.println("Setting up FirefoxOptions and disabling notifications");
        	// Create FirefoxOptions and set preferences as needed
        	FirefoxOptions firefoxOptions = new FirefoxOptions();
        	firefoxOptions.addPreference("media.navigator.streams.fake", true);

            // Add preferences if needed
            // ...

            // Set up FirefoxDriver with FirefoxOptions
            tlDriver.set(new FirefoxDriver(firefoxOptions));
            
        } else if (browser.contains("edge")) {
            tlDriver.set(new EdgeDriver());
            EdgeOptions edgeOptions = new EdgeOptions();
        	edgeOptions.setCapability("allowCamera", true);
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    // This is used to get the driver with ThreadLocal
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
