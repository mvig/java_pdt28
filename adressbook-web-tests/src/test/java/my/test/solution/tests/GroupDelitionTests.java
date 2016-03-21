package my.test.solution.tests;

import my.test.solution.model.GroupData;
import my.test.solution.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDelitionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0)
            app.group().create(new GroupData().withName("test").withHeader("test2").withFooter("test3"));
    }

    @Test
    public void testGroupDelitions() {

        Groups before = app.group().all();
        GroupData deleteGroup = before.iterator().next();
        app.group().delete(deleteGroup);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deleteGroup)));


    }


}
