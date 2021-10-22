package testRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources/functionalTest",
				glue= {"stepDefinitions"},
				monochrome = true,
		        strict = true
		)
public class TestRunner {

}
