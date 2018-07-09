package PartTwo;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends PageObject{

    @FindBy(name = "q")
    private WebElement input;

    @FindBy(name = "btnK")
    private WebElement search;

    public GooglePage(WebDriver driver){
        super(driver);
    }

    public void search(String query){
        input.click();
        input.clear();
        input.sendKeys(query);
        search.click();
    }
}
