package PartTwo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebDriverConfig.class)
public class InjectedDriverIT {

    GooglePage googlePage;

    @Inject
    private WebDriver driver;

    @Inject
    private URI baseUrl;

    @Test
    public void loadIndexPage() throws Exception{

            driver.get(baseUrl.toString());
            String originalWindow = driver.getWindowHandle();
            Robot robot = new Robot();

            //robot.keyPress(KeyEvent.VK_ALT);
            //robot.keyPress(KeyEvent.VK_TAB);

            robot.delay(1000);
            /*robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_TAB);*/

            robot.delay(1000);
            StringSelection ss = new StringSelection("b79630  ");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            //robot.keyPress(KeyEvent.VK_ENTER);
            //robot.keyRelease(KeyEvent.VK_ENTER);

            ss = new StringSelection("Password05*");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.delay(3000);
            ss = new StringSelection("Password05*");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(2000);

            //driver.getWindowHandle();
            driver.getCurrentUrl();
            /*driver.get(baseUrl.toString());
            //((JavascriptExecutor) driver).executeScript("windows.focus();");
            googlePage = new GooglePage(driver);
            ((JavascriptExecutor) driver).executeScript("windows.focus();");
            //googlePage.search("pisici");
            //WebElement connect = driver.findElement(By.id("gb_70"));
            //connect.click();
            googlePage.search();*/
    }
}
