package Tests;

import Framework.YandexPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class YandexTest {

    @Test
    public void Test1() throws InterruptedException {
        String findText = "playstation";

        YandexPage.goTo();
        YandexPage.searchText(findText);

        for (int i = 1; i < 6; i++ ) {
            YandexPage.goToPage(i);
        }

        Assert.assertTrue(YandexPage.hasCorrectLinks(findText));
    }

    @After
    public void Clean() {
        YandexPage.close();
    }
}
