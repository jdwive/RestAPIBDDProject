package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources/functionalTest",
				glue= {"stepDefinitions"},
				monochrome = true,
		        strict = true
		)
public class TestRunner {

}
