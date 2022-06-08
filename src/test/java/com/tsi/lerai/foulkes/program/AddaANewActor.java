package com.tsi.lerai.foulkes.program;

import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
features = "src/test/resources/cuccumber" ,
glue = "com.tsi.lerai.foulkes.program"

)
public class AddaANewActor {

}
