package e2e.stepDefinitions;

import e2e.pages.*;
import io.cucumber.java.an.Dada;

public class PageInitializer {

    public static AccountPage accountPage;
    public static HomePage homePage;

    public static LoginPage loginPage;

    public static DataBase dataBase;

    public static APIWorkFlow apiWorkFlow;



    public static void initializeObjects() {
        accountPage=new AccountPage();
        homePage=new HomePage();
        loginPage= new LoginPage();
        dataBase=new DataBase();
        apiWorkFlow= new APIWorkFlow();
    }
}
