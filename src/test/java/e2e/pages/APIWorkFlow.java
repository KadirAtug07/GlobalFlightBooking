package e2e.pages;

import com.github.javafaker.Faker;
import e2e.utils.APIConstants;
import e2e.utils.APIPayloadConstants;
import e2e.utils.CommonMethods;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static io.restassured.RestAssured.given;

public class APIWorkFlow extends CommonMethods {

    Faker faker = new Faker();

    String userName="";
    String userLastName="";
    String userEmail="";
    String userPhoneNumber="";
    String userPassword="Password1";
    String userGender="";
    String userImage="";

    RequestSpecification requestSpecification;

    Response response;

    public APIWorkFlow() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "input[name='userEmail']")
    private WebElement email;
    @FindBy(css = "input[name='userPassword']")
    private WebElement password;

    public void setAPIBody() {
        userName=faker.name().firstName();
        userLastName=faker.name().lastName();
        userEmail=faker.internet().emailAddress();
        userPhoneNumber=faker.phoneNumber().cellPhone().replaceAll("[^0-9]", "");
        userGender="MALE";
        userImage=null;

        requestSpecification=given().header(APIConstants.Content_Type_Value,APIConstants.Header_Content_Type).
                body(APIPayloadConstants.signUp(userName,userLastName,userEmail,userPhoneNumber,userPassword,userGender,userImage));
    }
    public void sendRequest() {
        response=requestSpecification.post(APIConstants.signUp);
    }
    public void verifyPayload(Integer status) {
        System.out.println(response.body().prettyPrint());
        response.then().assertThat().statusCode(status);
        String verifyResponseFirstName=response.body().jsonPath().getString("userFirstName");
        Assert.assertEquals(verifyResponseFirstName,userName);
    }
     public void loginWithUI() {
        accountPage.setLoginButtonOnHeader();
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        accountPage.setLoginButtonOnBottom();
     }



}
