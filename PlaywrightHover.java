package day4;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlaywrightHover {
    @Test
    public  void hoverTooltip() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://automatenow.io/sandbox-automation-testing-practice-website/");

        String title=page.title();
        assertThat(page).hasTitle("Automation Testing Practice Website | automateNow |");
        System.out.println("Title is expected: "+title);


        page.click("text=Hover");
        page.hover("#mouse_over");

        String text1=page.textContent("#mouse_over");

        System.out.println(text1);

        page.close();
        playwright.close();
    }
}
