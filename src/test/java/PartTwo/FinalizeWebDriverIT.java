package PartTwo;

import org.openqa.selenium.WebDriver;

public class FinalizeWebDriverIT {

    private WebDriver driver;

    @Override
    protected void finalize() throws Exception{
        driver.quit();
    }
}
