package my.test.solution.tests;

import my.test.solution.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by Tirex on 28.02.2016.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void testsGroupModification() {
        GroupData group = new GroupData("test", "test2", "test3");

        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereGroup()) app.getGroupHelper().createGroup(group);
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test11", "test22", "test33"), false);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
