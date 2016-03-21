package my.test.solution.tests;

import my.test.solution.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactDelitionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.contact().isThereContact()) {
            createOneGroupIfGroupsEmpty();
            app.contact().createSomeOne();
        }
    }
    @Test
    public void testsContactDelition() {

        List<ContactData> before = app.contact().contacts();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().contacts();

        before.remove(index);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

    }
}
