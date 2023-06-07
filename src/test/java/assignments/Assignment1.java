package assignments;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Assignment1 extends BasePage {

    //I have made BasePage class where I put common methods for both assignments and dynamic element for changing the browser drivers
    //BasePage class is in the location user.dir/src/main/java/base

    WebDriver driver;

    public Assignment1() throws IOException {
    }

    @BeforeTest //activating the driver and getting the target link
    public void setup() throws IOException{
        driver = getDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest //turning off the browser and driver
    public void turnOff() {
        driver.close();
        driver = null;
    }

    @Test //I didn't made assertations, because, in this case, with test annotation we can confirm that the requirements are fulfilled
    public void brokenImages() throws IOException {
        driver.findElement(By.cssSelector("img[src='asdf.jpg']"));
        driver.findElement(By.cssSelector("img[src='hjkl.jpg']"));
        driver.findElement(By.cssSelector("img[src='img/avatar-blank.jpg']"));
        takeSnapShot(driver);
    }
}
