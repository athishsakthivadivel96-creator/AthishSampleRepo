package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Admin\\eclipse-workspace\\ORanger_HR_Demo\\src\\test\\resources\\features\\login.feature",
		glue = "steps",
		plugin = {"pretty"},
		monochrome = true
		
		)

public class TestRunner {

}
