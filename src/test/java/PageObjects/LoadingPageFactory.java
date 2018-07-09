package PageObjects;

//import javafx.scene.shape.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//import java.nio.file.Path;

public class LoadingPageFactory {
    public static <T> T get(WebDriver driver, Class<T> pageObjectClass){

        driver.get(pageObjectClass.getAnnotation(Path.class).value());

        Verify verify = pageObjectClass.getAnnotation(Verify.class);

        String expectedPageTitle = verify.title();
        if(!expectedPageTitle.equals(Verify.INVALID_TITLE)){
            String actualPageTitle = driver.getTitle();
            if(!expectedPageTitle.equals(actualPageTitle)){
                String.format(
                        "expected page title %s but was %s",
                        expectedPageTitle,
                        actualPageTitle
                );
            }
        }

        String xpath = verify.xpath();
        if(!expectedPageTitle.equals(Verify.INVALID_XPATH)){
            if(driver.findElements(By.xpath(xpath)).isEmpty()){
                throw new IllegalArgumentException((String.format("expected XPATH %s", xpath)));
            }
        }
        return PageFactory.initElements(driver, pageObjectClass);
    }
}
