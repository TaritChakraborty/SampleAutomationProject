package pmBackgroundStepDefinition;

import io.cucumber.java.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class setup {

    public static WebDriver setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\Drivers\\selenium_driver\\124.0.6367.78\\chromedriver.exe");
        WebDriver DRIVER = new ChromeDriver();
        DRIVER.manage().window().maximize();
        DRIVER.manage().deleteAllCookies();
        DRIVER.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return DRIVER;
    }

}
