package com.SWC.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java",
		glue="com.SWC.tests"
		)
public class SmokeTest {

}
