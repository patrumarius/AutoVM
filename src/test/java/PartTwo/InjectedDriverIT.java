package PartTwo;

import org.apache.xpath.SourceTree;
import org.junit.Assert;
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
import org.junit.Assert.*;
import org.junit.Test;
import sun.rmi.runtime.Log;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebDriverConfig.class)
public class InjectedDriverIT extends LoginRobot{

    @Inject
    private URI baseUrl;

    @Test
    public void loadIndexPage() throws Exception{
        LoginRobot loginRobot = new LoginRobot();
    }

    @Test
    public void loadIndexPage2() throws Exception{
        LoginRobot loginRobot = new LoginRobot();
    }
}
