package com.enweek.stepdefinitions;

import org.eclipse.jetty.util.log.Log;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;


public class BeforeAndAfterSteps extends BaseSteps {

    @BeforeScenario
    public void start() {
      //
    }

    @AfterScenario
    public void tearDownScenario() throws Exception {
        // perhaps logout here
     
    }

    @AfterScenario(uponOutcome = AfterScenario.Outcome.FAILURE)
    public void tearDownFailedScenario() throws Exception {
       // selenium.stop();
    }
}