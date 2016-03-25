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
            type(By.name("email"), contactData.getEmail1_contact());
        } else {
            type(By.name("firstname"), contactData.getFirstname());
            type(By.name("lastname"), contactData.getLastname());
            Assert.assertFalse(isElementPresent(By.name("new_group")));

        }


    }


    public void submit() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }


    public void delete(ContactData contact) {

        selectById(contact.getId());
        click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
        contactCash = null;
        wd.switchTo().alert().accept();

    }


    public void modify(int id, ContactData contact) {
        selectToEditContact(id);
        fillNewContact(contact, false);
        submit();
        contactCash = null;
        click(By.id("logo"));
    }

    public void modify(ContactData contact) {
        selectToEditContact(contact.getId());
        fillNewContact(contact, false);
        submit();
        contactCash = null;
        click(By.id("logo"));
    }

    public void create(ContactData contact) {
        click(By.linkText("add new"));
        fillNewContact(contact, true);
        submitNewContact();
        contactCash = null;
    }


    public boolean isThereContact() {

        return isElementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    }

    public void createSomeOne() {
        click(By.linkText("add new"));
        fillNewContact(new ContactData().withFirstname("UserName1").withMiddlename("UserMidldleName1").withLastname("UserLastName1").withGroup("test").withNickname("User").withTitle_contact("mr.").withCompany("Home").withAddress("ul. Lenina 1 kv.1").withMobile_phone("+380972233311").withHome_phone("+7 774 777 77").withFax_phone("+380972233311").withWhere_work("KGB").withEmail("usermail@mail.ru"), true);
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


    private Contacts contactCash = null;


    public Contacts all() {
        if (contactCash != null) {
            return new Contacts(contactCash);

        }
        contactCash = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String address = cells.get(3).getText();
            String allEmail = cells.get(4).getText();
            String allPhones = cells.get(5).getText();

            // String[] phones = allPhones.split("\n");
            contactCash.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName).withAllEmail(allEmail).withAllPhones(allPhones));

        }

        return new Contacts(contactCash);
    }


    public ContactData infoFromEditForm(ContactData contact) {
        selectToEditContact(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
        String company = wd.findElement(By.name("company")).getAttribute("value");
        String title = wd.findElement(By.name("title")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email1 = wd.findElement(By.name("email2")).getAttribute("value");
        String email2 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
      //  String address2 = wd.findElement(By.name("address2")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withNickname(nickname).withMiddlename(middlename).withCompany(company).withTitle_contact(title).withHome_phone(home).withMobile_phone(mobile).withWorkPhone(work).withEmail(email).withEmail1(email1).withEmail2(email2).withAddress(address);


    }
    public String infoFromViewForm(ContactData contact) {
        selectToViewContact(contact.getId());
        String allViewInfo = wd.findElement(By.xpath("//*[@id='content']")).getText();
        String exeptInfo = wd.findElement(By.xpath("//*[@id='content']/i")).getText();
        String neadInfo = allViewInfo.replace(exeptInfo,"");
        String clearViewInfo = neadInfo.replaceAll("\\s*\\(www\\..*?\\)", "");
        return clearViewInfo;

    }

    public void selectToEditContact(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

//        Другие способы:
//        wd.findElement(By.xpatch(String.format("//input[@value='%s']./../../td[8]/a", id))).click();
        //
//        wd.findElement(By.xpatch(String.format("//tr[.//input[@value='%s']./../../td[8]/a", id))).click();
        //
//        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
        //
    }

    public void selectToViewContact(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(6).findElement(By.tagName("a")).click();

    }


}
