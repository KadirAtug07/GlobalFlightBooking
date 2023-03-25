package e2e.pages;

import com.github.javafaker.Faker;
import e2e.utils.CommonMethods;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class AccountPage extends CommonMethods {

    public AccountPage() {
        PageFactory.initElements(driver,this);
    }
    Faker faker=new Faker();
    String userName="";
    String userLastName="";
    String userEmail="";
    String userPhoneNumber="";

    String userPassword="Password1";

    @FindBy(partialLinkText = "Sign")
    private WebElement signUpButton;

    @FindBy(xpath = "//h1[contains(text(), 'Sign Up')]")
    private WebElement signUpText;
    @FindBy(css = "input[name='userFirstName']")
    private WebElement firstName;
    @FindBy(css = "input[name='userLastName']")
    private WebElement lastName;
    @FindBy(css = "input[name='userEmail']")
    private WebElement email;
    @FindBy(css = "input[name='userPhoneNumber']")
    private WebElement phoneNumber;
    @FindBy(css = "input[name='userPassword']")
    private WebElement password;
    @FindBy(css = "input[name='userPasswordRepeat']")
    private WebElement repeatPassword;
    @FindBy(css = "div[class='form-check row '] label")
    private List<WebElement> gender;
    @FindBy(css = ".btn.btn-primary.mt-3")
    private WebElement signUp;
    @FindBy(css = ".alert.alert-success")
    private WebElement alertMessage;
    @FindBy(xpath = "//div[contains(text(),'Minimum eight characters, at least one uppercase letter, one lowercase letter, one number ')]")
    private WebElement wrongPassword;
    @FindBy(partialLinkText = "Login")
    private WebElement loginButtonOnHeader;
    @FindBy(css = ".btn.btn-primary.mt-2")
    private WebElement loginButtonOnBottom;


     public void setSignUpButton() {
         signUpButton.click();
     }
     public String signUpText() {
         return signUpText.getText();
     }
      public void setFirstName() {
         userName=faker.name().firstName();
         firstName.sendKeys(userName);
      }
      public void setLastName() {
         userLastName=faker.name().lastName();
         lastName.sendKeys(userLastName);
      }
      public void setEmail() {
         userEmail=faker.internet().emailAddress();
         email.sendKeys(userEmail);
      }
      public void setPhoneNumber() {
         userPhoneNumber=faker.phoneNumber().cellPhone().replace("-","");
         phoneNumber.sendKeys(userPhoneNumber);
      }

      public void setPassword() {
         password.sendKeys("password1");
      }
      public void setRepeatPassword() {
         repeatPassword.sendKeys("password1");
      }
      public void setGender() {
         for (WebElement element: gender) {
             if (Objects.equals(element.getText(), "Female")){
                 Actions actions= new Actions(driver);
                 actions.doubleClick(element).build().perform();
                 System.out.println("Radio button for Male is Selected");
             }else {
                 System.out.println("Radio button is not selected");
             }
         }
      }
      public void setSignUp()  {
         click(signUp);
      }

      public String setAlertMessage() {
         Assert.assertTrue(wrongPassword.isDisplayed());
         if (wrongPassword.isDisplayed()){
             password.clear();
             password.sendKeys(userPassword);
             repeatPassword.clear();
             repeatPassword.sendKeys(userPassword);
             click(signUp);
         }
         return alertMessage.getText();

      }
      public void setLoginButtonOnHeader() {
         click(loginButtonOnHeader);
      }
      public void setValidCredentials() {
         email.sendKeys(userEmail);
         password.sendKeys(userPassword);
      }
      public void setLoginButtonOnBottom() {
         click(loginButtonOnBottom);
      }

      public void verifyAccountName() {
         Assert.assertEquals(loginPage.setAccountName(),userName);
      }








}
