package my.test.solution.tests;

import my.test.solution.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDelitionTests extends TestBase {

    @Test
    public void testGroupDelitions() {

        app.getNavigationHelper().gotoGroupPage();
        GroupData group = new GroupData("test", "test1", "test2");
        if (!app.getGroupHelper().isThereGroup()) app.getGroupHelper().createGroup(group);
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);


    }

}
