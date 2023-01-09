package day4;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class PlaywrightTables {

    @Test
    public  void tables() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://automatenow.io/sandbox-automation-testing-practice-website/");


        page.click("text=Tables");
        String title = page.title();
        System.out.println("page Title is" + title);


        page.click("//*[@id=\"tablepress-1_filter\"]/label/input");
        page.fill("//*[@id=\"tablepress-1_filter\"]/label/input","india");

        Locator row= page.locator ("table#tablepress-1 ");
        row.locator(":scope",new Locator.LocatorOptions().setHasText("2"));

        row.locator(":scope").allInnerTexts().forEach(e->System.out.println(e));

         page.close();
         playwright.close();

    }
}
