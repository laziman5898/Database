package com.tsi.lerai.foulkes.program;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" },
        features = "src/test/resources/cucumber",
        glue = "com/tsi/lerai/foulkes/program/stepDefs")

public class RunCucumberTests {
}
