package my.test.solution.tests;

import my.test.solution.model.GroupData;
import my.test.solution.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        GroupData group = new GroupData().withName("test222").withHeader("test1").withFooter("test2");
        if (!app.group().isThereGroup()) app.group().create(group);
        Groups before = app.group().all();
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        GroupData group = new GroupData().withName("test222").withHeader("test1").withFooter("test2'");
        if (!app.group().isThereGroup()) app.group().create(group);
        Groups before = app.group().all();
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));

    }
}
