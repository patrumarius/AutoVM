package PartTwo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebDriverConfig.class)
public class InjectedDriverIT {

    //GooglePage googlePage;

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
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_TAB);

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

            ss = new StringSelection("Password05*");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            ss = new StringSelection("pisici");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);


            driver.switchTo().window(originalWindow);
            
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.delay(1000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            //driver.get(baseUrl.toString());

           /* //googlePage = new GooglePage(driver);
            //googlePage.search("Pisici");
        *//*String originalWindow = driver.getWindowHandle();
        driver.switchTo().window(originalWindow);*//*
        //driver.switchTo().defaultContent();
        WebElement input = driver.findElement(By.id("lst-ib"));
        //new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(input));
        input.click();
        input.clear();
        input.sendKeys("Marius Patru Linkedin");
        WebElement search = driver.findElement(By.name("btnK"));
        search.click();*/
    }
}
