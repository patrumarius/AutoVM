package PartTwo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebDriverConfig.class)
public class LoginRobot {

    @Inject
    private WebDriver driver;

    @Inject
    private URI baseUrl;

    /*public LoginRobot(){

    }*/

    /*public LoginRobot(WebDriver driver){
        this.driver = driver;
    }*/

    @Before
    public void setUp() throws Exception {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl.toString());
        //"https://baseinvestisseurs.dev.echonet/biv/app/index.html#!/biv/home"
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.manage().window().maximize();
        System.out.println("Robot OK");

        WebDriverWait wait = new WebDriverWait(driver,3, 100);
        WebElement projectPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'project-name')]")));

        assertEquals("BASE INVEST",projectPage.getText());
    }

}
