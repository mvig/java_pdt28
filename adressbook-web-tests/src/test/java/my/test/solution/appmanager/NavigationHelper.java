package my.test.solution.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Tirex on 28.02.2016.
 */
public class NavigationHelper {
    FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd=wd;
    }

    public void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void goAddNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }
}
