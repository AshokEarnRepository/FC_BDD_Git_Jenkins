//package com.Pages;
//
//public class PersonalVault_ShareUploadLink {
//
//	
//	
//	    private By sharefile = By.xpath("/html/body/app-root/div/app-user/div/div[2]/div[3]/app-files/div[2]/div[1]/app-folder-list/div[2]/div[1]/div/button/span/img");
//		private By firstname=By.xpath("//input[@placeholder='First Name']");
//		private By lastname=By.xpath("//input[@placeholder='Last Name']");
//		private By email=By.xpath("//input[@type='email']");
//		private By flag=By.xpath("/html/body/ngb-modal-window/div/div/app-share-upload-link/div/div/div/form/div[3]/app-phone-input/form/ngx-intl-tel-input/div/div/div/div[1]");
//		private By searchcountry=By.xpath("//div//input[@placeholder='Search Country']");
//		private By us=By.xpath("//div//span[text()='United States']");
//		private By phone=By.xpath("//*[@id=\"phone\"]");
//		private By validuntil=By.xpath("  //*[@id=\"dp\"]");
//		private By validTill=By.xpath("/html/body/ngb-modal-window/div/div/app-share-upload-link/div/div/div/form/div[4]/select/option[4]");
//		private By share=By.xpath("//button[text()='Share']");
//		private By enteremail=By.xpath("//input[@id='login']");
//		private By click=By.xpath("//*[@id=\"refreshbut\"]/button/i");
////		private By refresh =By.xpath("/html/body/div[1]/div/div/main/div[2]/div[1]/div/div[1]/div[6]/button");
//	    private By emaillink=By.xpath("//span[text()='Family Central']");     
//	    private By frame=By.xpath("//*[@id=\"ifmail\"]");
//	    private By signin=By.xpath("//*[@id=\"mail\"]/div/center/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[6]/td/table/tbody/tr/td/div/a/span");
//	    private By otp=By.xpath("/html/body/main/div/div/div/center/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[6]/td");
//	    private By entercode=By.xpath("  //input[@class='otp-input ng-pristine ng-valid ng-star-inserted ng-touched']");
//	    private By submit=By.xpath("//button[@type='submit']");
//	    private By file=By.xpath("//span[text()='Select a file to upload']");
//	    private By send=By.xpath("//button[text()=' Send ']");
//	
//	
//	
//	public void sharefile() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(sharefile).click();
//		
//	}
//	
//	public void firstname() {
//		driver.findElement(firstname).sendKeys("Ramya");
//	}
//	
//	
//	public void lastname() {
//		driver.findElement(lastname).sendKeys("test");
//	}
//	
//	
//	public void email() {
//		driver.findElement(email).sendKeys("nramya24@yopmail.com");;
//	}
//	
//	
//	public void flag() {
//		driver.findElement(flag).click();
//	}
//	
//	
//	public void searchcountry() {
//		driver.findElement(searchcountry).sendKeys("United States");
//	}
//	
//	
//	public void us() {
//		driver.findElement(us).click();
//	}
//	
//	
//	public void phone() {
//		driver.findElement(phone).sendKeys("+12292127375");
//	}
//	
//	
//	public void validuntil() {
//		driver.findElement(validuntil).click();
//	}
//	
//	
//	public void validTill() {
//		driver.findElement(validTill).click();
//	}
//	
//	// file sharing a share upload link from the peresonal vault
//	public void share() {
//		driver.findElement(share).click();
//		
//	}
// 
//	// from here we are opening yopmail window
//	public void yopmail() {
//		
//		((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");
//	    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//		
//		 driver.switchTo().window(tabs.get(1));
//	    driver.get("https://yopmail.com/en/");
//	    driver.navigate().refresh();
// 
//	}
// 
//	
//	// from here we are entering email into search
//	public void enteremail() {
//		
//		driver.findElement(enteremail).sendKeys("nramya24@yopmail.com");
//		
//	}
//	
//	// from here we are clicking on arrow option
//	public void click() {
//		driver.findElement(click).click();
//		
//	}
//	
//	// switching to iframe of received email
//	public void frame() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        
//		driver.findElement(frame).click();
//		
//	}
//	// from refresh the email and clicking on received email
//	public void emaillink() {
//		driver.navigate().refresh();
//		driver.findElement(emaillink).click();
//		
//	}
//	
//	// here switching to ifrome2 the click on sing in option
//	public void signin() throws Throwable {
//		
//		driver.switchTo().frame(2);
//		driver.findElement(signin).click();
//		 Thread.sleep(5000);
//		
//		
//	}
//	
//	// here new window opened and entering yopmail otp by switching to yopmail
//	public void code() throws Throwable {
//		  ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//			   driver.switchTo().window(tabs.get(1));
//			  Thread.sleep(5000);
//			   driver.navigate().refresh();
//			   driver.switchTo().frame(2);
//			   String otpText=driver.findElement(otp).getText();
//			   String OtpValue=otpText.concat(otpText);			
//			   driver.switchTo().window(tabs.get(2));
//               driver.findElement(entercode).sendKeys(OtpValue);
//			   driver.findElement(submit).click();
//}
