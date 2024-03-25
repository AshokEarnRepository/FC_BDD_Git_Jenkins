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
    public static synchronized WebDriver init_driver(String browser) {
       

        if (tlDriver.get() == null) {
        	 System.out.println("browser value is :" + browser);
        	 
            WebDriver driver;

            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--use-fake-ui-for-media-stream");

                // Set up ChromeDriver with ChromeOptions
                driver = new ChromeDriver(chromeOptions);
            } else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("media.navigator.streams.fake", true);

                // Set up FirefoxDriver with FirefoxOptions
                driver = new FirefoxDriver(firefoxOptions);
            } else if (browser.equalsIgnoreCase("edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
//                edgeOptions.setCapability("allowCamera", true);

                // Set up EdgeDriver with EdgeOptions
                driver = new EdgeDriver(edgeOptions);
            } else {
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
            }

            tlDriver.set(driver);
            getDriver().manage().window().maximize();
        }
        return getDriver();
    }

    // This is used to get the driver with ThreadLocal
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
