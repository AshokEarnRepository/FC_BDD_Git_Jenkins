package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
	    features = {"return:target/failedrerun.txt"},
	    glue = {"parallel"},
//	   tags = "@smoke",
	    dryRun=false,
	    publish = true,
	    plugin   = {"pretty", "html:target/CucumberReport.html",
	    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	    		"return:target/failedrerun.txt"
	    		
	    		}
	)
public class FailedRun extends AbstractTestNGCucumberTests{
	
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		
		return super.scenarios();
	}

}