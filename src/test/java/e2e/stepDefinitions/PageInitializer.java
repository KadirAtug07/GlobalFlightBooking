package e2e.stepDefinitions;

import e2e.pages.AccountPage;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;

public class PageInitializer {

    public static AccountPage accountPage;
    public static HomePage homePage;

    public static LoginPage loginPage;



    public static void initializeObjects() {
        accountPage=new AccountPage();
        homePage=new HomePage();
        loginPage= new LoginPage();
    }
}
