package my.test.solution.appmanager;

import my.test.solution.model.GroupData;
import my.test.solution.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Tirex on 28.02.2016.
 */
public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void toGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData, boolean creation) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void goNew() {
        click(By.name("new"));
    }

    public void clickDelete() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }

    private void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

    }

    public void goEdit() {
        click(By.name("edit"));
    }

    public void submit() {
        click(By.name("update"));
    }

    public boolean isThereGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(GroupData group) {
        goNew();
        fillGroupForm(group, true);
        submitGroupCreation();
        toGroupPage();

    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        goEdit();
        fillGroupForm(group, false);
        submit();
        toGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        clickDelete();
        toGroupPage();
    }


    public Groups all() {
        Groups groups = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));

        }

        return groups;
    }


}
