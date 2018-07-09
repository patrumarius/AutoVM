package PartTwo;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

@Configuration
public class WebDriverConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DesiredCapabilities desiredCapabilities(
            @Value("${webdriver.capabilities.browserName:internet explorer}") String browserName
    ){
        return new DesiredCapabilities(browserName, "", Platform.ANY);
    }

    @Bean(destroyMethod = "quit")
    public WebDriver webDriver(DesiredCapabilities desiredCapabilities){
                switch (desiredCapabilities.getBrowserName()){
                    case BrowserType.IE:
                        return new ChromeDriver(desiredCapabilities);
                    case BrowserType.FIREFOX:
                        return new FirefoxDriver(desiredCapabilities);
                    default:
                        throw new IllegalStateException("unknown browser " + desiredCapabilities.getBrowserName());
                }


    }

    private WebDriver localDriver(DesiredCapabilities desiredCapabilities) throws IOException {
        switch (desiredCapabilities.getBrowserName()) {
            case BrowserType.CHROME:
                return new ChromeDriver(desiredCapabilities);
            case BrowserType.FIREFOX:
                return new FirefoxDriver(desiredCapabilities);
            case BrowserType.HTMLUNIT:
                return new HtmlUnitDriver(desiredCapabilities);
            case BrowserType.IE:
                return new InternetExplorerDriver(desiredCapabilities);
            default:
                throw new IllegalStateException("unknown browser " + desiredCapabilities.getBrowserName());
        }
    }

    private WebDriver remoteDriver(URL remoteUrl, DesiredCapabilities desiredCapabilities){
        return new Augmenter().augment(new RemoteWebDriver(remoteUrl, desiredCapabilities));
    }

    @Bean(destroyMethod = "quit")
    public WebDriver webDriver(
            @Value("${webdriver.remote:false}") boolean remoteDriver,
                    @Value("${webdriver.remote.url:http://localhost:4444/wd/hub}") URL remoteUrl,
                    DesiredCapabilities desiredCapabilities) throws Exception {
        return remoteDriver ?
                remoteDriver(remoteUrl, desiredCapabilities) :
                localDriver(desiredCapabilities);
    }

    @Bean
    @Primary
    @Scope("prototype")
    public WebDriver cleanWebDriver(WebDriver driver) throws Exception{
        driver.manage().deleteAllCookies();

        return driver;
    }

    @Bean
    public URI baseUrl(@Value("${webdriver.baseUrl:https://baseinvestisseurs.dev.echonet/biv/app/index.html#!/biv/home}")URI value){
        return value;
    }
}
