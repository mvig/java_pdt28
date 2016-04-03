package my.test.solution.tests;

import my.test.solution.appmanager.ApplicationManager;
import my.test.solution.model.GroupData;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Tirex on 28.02.2016.
 */
public class TestBase {
    Logger loger = LoggerFactory.getLogger(TestBase.class);
    //protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod()
    public void logTestStart(Method m, Object[] p){
        loger.info("Start test: " + m.getName()+ " with parameters "+ Arrays.asList(p));
    }
    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m){
        loger.info("Stop test: " + m.getName());
    }
    public void createOneGroupIfGroupsEmpty() {
        app.goTo().groupPage();
        if (!app.group().isThereGroup())
            app.group().create(new GroupData().withName("test").withHeader("test2").withFooter("test3"));
        app.goTo().goHome();
    }
}
