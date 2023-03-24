package e2e.pages;

import e2e.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends CommonMethods {

    public AccountPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(partialLinkText = "Sign")
    private WebElement signUpButton;

    @FindBy(xpath = "//h1[contains(text(), 'Sign Up')]")
    private WebElement signUpText;


}
