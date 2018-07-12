package PartTwo;

import org.apache.xpath.SourceTree;
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
            //driver.get(baseUrl.toString());
            //driver.wait(9000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(baseUrl.toString());
            Thread.sleep(5000);
            WebElement contactsPage = driver.findElement(By.xpath("//a[contains(@class, 'ng-scope') and text() ='CONTACTS']"));
            contactsPage.click();
            Thread.sleep(3000);
    }
}
