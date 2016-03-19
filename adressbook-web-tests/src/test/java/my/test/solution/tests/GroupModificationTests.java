package my.test.solution.tests;

import my.test.solution.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Tirex on 28.02.2016.
 */
public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereGroup())
            app.getGroupHelper().createGroup(new GroupData("test", "test2", "test3"));
    }

    @Test
    public void testsGroupModification() {

        List<GroupData> before = app.getGroupHelper().getGroupList();
        int index =before.size() - 1;
        GroupData group = new GroupData(before.get(index).getId(), "test111", "test2222", "test3333");
        app.getGroupHelper().modifyGroup(index, group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
