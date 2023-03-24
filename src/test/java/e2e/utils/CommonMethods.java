package e2e.utils;

import e2e.stepDefinitions.PageInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public static void openAndLunchApplication() {

        ConfigReader.readProperties(Constants.Configuration_FilePath);

        switch (ConfigReader.getPropertyValues("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValues("url"));
        driver.manage().timeouts().implicitlyWait(Constants.implicit_wait, TimeUnit.SECONDS);

        initializeObjects();

    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static byte[] takeScreenShots(String fileName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        byte[] picBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.Screenshot_FilePath + fileName + " "
                    + getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picBytes;
    }
}
