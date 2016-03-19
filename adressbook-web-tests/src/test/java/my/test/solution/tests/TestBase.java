package my.test.solution.tests;

import my.test.solution.appmanager.ApplicationManager;
import my.test.solution.model.GroupData;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Tirex on 28.02.2016.
 */
public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    public void createOneGroupIfGroupsEmpty() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereGroup()) app.getGroupHelper().createGroup(new GroupData("test", "test2", "test3"));
        app.getNavigationHelper().goHome();
    }
}
