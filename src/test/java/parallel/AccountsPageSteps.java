package parallel;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.Pages.AccountsPage;
import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountspage;
	

	@Given("User is already logged in to application")
	public void user_is_already_logged_in_to_application(DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String userName = credList.get(0).get("username");
		String passWord = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://familycentral.com");
		//if(DriverFactory.getDriver().findElements(By.cssSelector("a[routerlink='/login']")).size() > 0)
//{
		 accountspage = loginpage.doLogin(userName, passWord);
//}
	}

	@Given("User is on Accounts page")
	public void user_is_on_accounts_page() {
          System.out.println("Feature: Account Page feature");
		String title = accountspage.getAccountsPageTitle();
		System.out.println(">>>Accounts Page Title is: "+title);
	}

//	@SuppressWarnings("unlikely-arg-type")
	@When("user gets account section")
	public void user_gets_account_section(DataTable sectionTable) throws InterruptedException {
		
		List<String> expAccountSectionsList = sectionTable.asList();
		System.out.println(">>>expected account sectiion list : "+expAccountSectionsList);
		
		List<String> ActualAccountSectionList = accountspage.getAccountsSectionsList();
		System.out.println(">>>Actual account sectiion list : "+ActualAccountSectionList);
		
//		Assert.assertTrue(ActualAccountSectionList.containsAll(expAccountSectionsList));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(ActualAccountSectionList.containsAll(expAccountSectionsList));
		

//		Assert.assertTrue(expAccountSectionsList.contains(ActualAccountSectionList));
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer expectedSectionCount) throws InterruptedException {
		int count = accountspage.getAccountsSectionCount();
//		Assert.assertTrue(count==expectedSectionCount);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(count==expectedSectionCount);
		System.out.println(">>>getAccountsSectionCount: "+count);
		Thread.sleep(2000);
	}
	
	@Then("Page title should be {string}")
	public void page_title_should_be(String string) {
		
		String title = accountspage.getAccountsPageTitle();
		System.out.println(">>>Accounts page title is "+title);
	}
	
}
