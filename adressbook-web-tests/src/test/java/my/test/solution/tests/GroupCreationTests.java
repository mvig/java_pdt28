package my.test.solution.tests;

import my.test.solution.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {


        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("test", "test2", "test3"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
