package com.enweek.scenarios.userSession;

import com.enweek.stepdefinitions.*;

public class LoginTest extends JBehaveStory {

    public LoginTest() {
        useSteps(
              //  new BeforeAndAfterSteps(),
                new GooglePageSteps()
        );
    }
}
