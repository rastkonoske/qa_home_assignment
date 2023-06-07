package assignments;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Assignment2 extends BasePage {

    //I have made BasePage class where I put common methods for both assignments and dynamic element for changing the browser drivers
    //BasePage class is in the location user.dir/src/main/java/base

    public Assignment2() throws IOException {
    }

    @BeforeTest //activating the driver and getting the target link
    public void setup() throws IOException{
        driver = getDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest //turning off the browser and driver
    public void turnOff() {
        driver.close();
        driver = null;
    }

    @Test //I didn't made assertations, because, in this case, with test annotation we can confirm that the requirements are fulfilled
    public void fileUpload() throws IOException {
        WebElement upload = driver.findElement(By.id("file-upload"));
        upload.sendKeys("D:\\Selenium\\QA Home Assignment\\src\\main\\resources\\File.txt");
        takeSnapShot(driver);

    }
}
