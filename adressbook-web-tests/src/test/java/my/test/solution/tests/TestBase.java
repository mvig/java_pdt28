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
        app.goTo().groupPage();
        if (!app.group().isThereGroup()) app.group().create(new GroupData().withName("test").withHeader("test2").withFooter("test3"));
        app.goTo().goHome();
    }
}
