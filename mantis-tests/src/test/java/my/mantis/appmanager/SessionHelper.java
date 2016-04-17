package my.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Tirex on 17.04.2016.
 */

public class SessionHelper extends HelperBase {

    public SessionHelper(ApplicationManager app) {
        super(app);

    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));

    }

    public void loginAsAdministrator() {
        login(app.getProperty("webAdminLogin"), app.getProperty("webAdminPassword"));

    }

    public boolean isLoggedInAs(String username) {
        String page = wd.getPageSource();
        return page.contains(String.format("<span class=\"italic\">%s</span>", username));

    }
}


