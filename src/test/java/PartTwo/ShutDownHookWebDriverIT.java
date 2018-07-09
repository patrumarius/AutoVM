package PartTwo;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ShutDownHookWebDriverIT {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception{
        driver = new InternetExplorerDriver();
        Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
    }
}
