package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"./src/test/java/features/"},
		glue = {"stepDefinitions"},
				dryRun = false,
				monochrome = true
		
		)

public class CucumberRunner extends AbstractTestNGCucumberTests {

}
