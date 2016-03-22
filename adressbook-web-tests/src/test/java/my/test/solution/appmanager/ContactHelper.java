package my.test.solution.appmanager;

import my.test.solution.model.ContactData;
import my.test.solution.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Tirex on 28.02.2016.
 */
public class ContactHelper extends BaseHelper {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewContact() {
        click(By.name("submit"));
        click(By.id("logo"));

    }

    public void fillNewContact(ContactData contactData, boolean creation) {
        if (creation) {
            type(By.name("firstname"), contactData.getFirstname());
            type(By.name("middlename"), contactData.getMiddlename());
            type(By.name("lastname"), contactData.getLastname());
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            type(By.name("nickname"), contactData.getNickname());
            type(By.name("title"), contactData.getTitle_contact());
            type(By.name("company"), contactData.getCompany());
            type(By.name("address"), contactData.getAddress());
            type(By.name("home"), contactData.getHome_phone());
            type(By.name("mobile"), contactData.getMobile_phone());
            type(By.name("work"), contactData.getWhere_work());
            type(By.name("fax"), contactData.getFax_phone());
            type(By.name("email"), contactData.getEmail_contact());
        } else {
            type(By.name("firstname"), contactData.getFirstname());
            type(By.name("lastname"), contactData.getLastname());
            Assert.assertFalse(isElementPresent(By.name("new_group")));

        }


    }


    public void selectTo(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }

    public void submit() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }




    public void delete(ContactData contact) {

        selectById(contact.getId());
        click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();

    }


    public void modify(int id, ContactData contact) {
        selectTo(id);
        fillNewContact(contact, false);
        submit();
        click(By.id("logo"));
    }

    public void modify(ContactData contact) {
        selectTo(contact.getId());
        fillNewContact(contact, false);
        submit();
        click(By.id("logo"));
    }

    public void create(ContactData contact) {
        click(By.linkText("add new"));
        fillNewContact(contact, true);
        submitNewContact();
    }


    public boolean isThereContact() {

        return isElementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    }

    public void createSomeOne() {
        click(By.linkText("add new"));
        fillNewContact(new ContactData().withFirstname("UserName1").withMiddlename("UserMidldleName1").withLastname("UserLastName1").withGroup("test").withNickname("User").withTitle_contact("mr.").withCompany("Home").withAddress("ul. Lenina 1 kv.1").withMobile_phone("+380972233311").withHome_phone("+7 774 777 77").withFax_phone("+380972233311").withWhere_work("KGB").withEmail_contact("usermail@mail.ru"), true);
        submitNewContact();
    }


    public void select(int index) {
        click(By.id("logo"));
        wd.findElements(By.name("selected[]")).get(index).click();

    }

    public void selectById(int id) {
        click(By.id("logo"));
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();


    }




    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));

        }

        return contacts;
    }


}
