package e2e.pages;

import e2e.stepDefinitions.PageInitializer;
import e2e.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonMethods {


    public HomePage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h1[.='Search Flight']")
    private WebElement searchFlightText;





    public String getHomePageTitle() {
        return driver.getTitle();
    }
    public String getSearchFlightText() {
        return  searchFlightText.getText();
    }
}
