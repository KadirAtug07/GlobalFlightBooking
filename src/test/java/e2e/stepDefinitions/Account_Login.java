package e2e.stepDefinitions;

import e2e.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class Account_Login extends CommonMethods {




    @Then("User clicks login button")
    public void user_clicks_login_button() {
       accountPage.setLoginButtonOnHeader();
    }
    @Then("User enters email and password")
    public void user_enters_email_and_password() {
       accountPage.setValidCredentials();
    }
    @Then("click login with provided credentials")
    public void click_login_with_provided_credentials() {
       accountPage.setLoginButtonOnBottom();
    }
    @Then("verify username on header")
    public void verify_username_on_header() {
        accountPage.verifyAccountName();
    }
}
