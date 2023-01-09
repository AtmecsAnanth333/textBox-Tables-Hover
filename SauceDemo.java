package day2;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SauceDemo {

    Page page;
    Playwright playwright;

    @Test
    public void launch() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com/");

        String title = page.title();
        assertThat(page).hasTitle("Swag Labs");
        System.out.println("Title is expected: " + title);

        page.click("#user-name");
        page.fill("#user-name", "standard_user");

        page.click("#password");
        page.fill("#password", "secret_sauce");

        page.click("#login-button");

        page.locator("#login-button");

            page.close();
            playwright.close();
        }
    }

