package my.test.solution.tests;

import my.test.solution.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDelitionTests extends TestBase {

    @Test
    public void testGroupDelitions() {

        app.getNavigationHelper().gotoGroupPage();
        GroupData group = new GroupData("test", "test2", "test3");
        int before = app.getGroupHelper().getGroupCount();
        if(!app.getGroupHelper().isThereGroup()) app.getGroupHelper().createGroup(group);
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before-1);
    }

}
