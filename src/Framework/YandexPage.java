package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class YandexPage {

    public static WebDriver instance;

    public static void goTo() {
        instance = new FirefoxDriver();
        instance.manage().window().maximize();
        instance.get("http://ya.ru");
    }

    public static void searchText(String findText) {
        instance.findElement(By.id("text")).sendKeys(findText);
        instance.findElement(By.xpath("//button[@class='button button_theme_websearch arrow2 arrow2_size_l arrow2_theme_websearch-button suggest2-form__button i-bem button_js_inited']")).click();
    }

    public static void goToPage(int number) throws InterruptedException {
        Wait();
        WebElement element = instance.findElement(By.xpath("//span[contains(.,'" + number + "') and @class='button__text']/.."));
        element.click();
    }

    public static boolean hasCorrectLinks(String findText) {
        boolean result = true;
        List<WebElement> elements = instance.findElements(By.xpath("//a[@class='b-link b-link_cropped_no serp-item__title-link']"));
        for (WebElement element : elements) {
            String text = element.getText().toLowerCase();
            if (!text.contains(findText)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void close() {
        instance.quit();
    }

    public static void Wait() throws InterruptedException {
        Thread.sleep(1000);
    }
}
