package my.test.solution.tests;

import my.test.solution.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDelitionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().list().size()==0)
            app.group().create(new GroupData("test", "test2", "test3"));
    }

    @Test
    public void testGroupDelitions() {

        List<GroupData> before = app.group().list();
        int index =before.size() - 1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(),before.size() - 1);
        before.remove(index);
//        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(byId);
//        after.sort(byId);
        Assert.assertEquals(before, after);


    }



}
