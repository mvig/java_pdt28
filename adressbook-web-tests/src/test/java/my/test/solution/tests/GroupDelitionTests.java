package my.test.solution.tests;

import my.test.solution.model.GroupData;
import org.testng.annotations.Test;

public class GroupDelitionTests extends TestBase {

    @Test
    public void testGroupDelitions() {
        GroupData group = new GroupData("test", "test2", "test3");
        app.getNavigationHelper().gotoGroupPage();
        if(!app.getGroupHelper().isThereGroup()) app.getGroupHelper().createGroup(group);
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
