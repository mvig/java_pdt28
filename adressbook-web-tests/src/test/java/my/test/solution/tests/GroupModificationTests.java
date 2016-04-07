package my.test.solution.tests;

import my.test.solution.model.GroupData;
import my.test.solution.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tirex on 28.02.2016.
 */
public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.db().groups().size()==0)
            app.group().create(new GroupData().withName("test").withHeader("test2").withFooter("test3"));
        /*if (app.group().all().size() == 0)
            app.group().create(new GroupData().withName("test").withHeader("test2").withFooter("test3"));*/
    }

    @Test()
    public void testsGroupModification() {

        //Groups before = app.group().all();
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test111").withHeader("test2222").withFooter("test3333");
        app.group().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        //Groups after = app.group().all();
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
        verifyGroupListInUI();
    }


}
