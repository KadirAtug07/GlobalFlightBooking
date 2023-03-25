package e2e.pages;

import e2e.utils.CommonMethods;
import e2e.utils.DBUtils;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase extends CommonMethods {

      public DataBase() {
          PageFactory.initElements(driver,this);
      }

      public void verifyDB() throws SQLException {
          DBUtils.createDbConnection();
          ResultSet resultSet=DBUtils.runQuery("select * from users");
          resultSet.last();
          String verifyEmail=resultSet.getString("user_email");
          String verifyFirstName=resultSet.getString("user_first_name");
          String verifyLastName=resultSet.getString("user_last_name");
          String verifyPhoneNumber=resultSet.getString("user_phone_number");
          System.out.println(verifyEmail +" " + verifyFirstName + " " + verifyLastName + " " + verifyPhoneNumber);
          Assert.assertEquals(verifyEmail,accountPage.userEmail);
          Assert.assertEquals(verifyFirstName,accountPage.userName);
          Assert.assertEquals(verifyLastName,accountPage.userLastName);
          Assert.assertEquals(verifyPhoneNumber,accountPage.userPhoneNumber);

          DBUtils.closeDbConnection();

      }
}
