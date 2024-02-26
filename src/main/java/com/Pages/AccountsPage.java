package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private WebDriver driver;
    
    
   //Locators
    private By accountSections = By.xpath("//div[@id='accordion']/div");
   //Locators
    
    
    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    

    public String getAccountsPageTitle() {
        return driver.getTitle();
    }

    public int getAccountsSectionCount() {
        return driver.findElements(accountSections).size();
        
    }

    public List<String> getAccountsSectionsList() throws InterruptedException {
    	Thread.sleep(5000);
        List<String> accountList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements(accountSections);

        for (WebElement e : accountsHeaderList) {
            String text = e.getText().trim();
            System.out.println(text);
            accountList.add(text);
        }
        return accountList;
    }
}
