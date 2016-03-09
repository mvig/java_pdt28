package my.test.solution.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tirex on 28.02.2016.
 */
public class NavigationHelper extends BaseHelper {


    public NavigationHelper(WebDriver wd) {
        super(wd);

    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void goAddNewContact() {
        click(By.linkText("add new"));
    }

    public void goHome() {
        click(By.linkText("home page"));
    }
}
