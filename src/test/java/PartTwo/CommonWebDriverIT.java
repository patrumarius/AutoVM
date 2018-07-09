package PartTwo;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonWebDriverIT {

    private final WebDriver driver = new ChromeDriver();

    @After
    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public void checkTheRegistrationPage() throws Exception{
        //
    }
}
