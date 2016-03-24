/*
* Данные для заполнения формы нового контакта.
*/
package my.test.solution.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String middlename;
    private String lastname;
    private String group;
    private String nickname;
    private String title_contact;
    private String company;
    private String address;
    private String home_phone;
    private String mobile_phone;
    private String work_phone;
    private String fax_phone;
    private String where_work;
    private String email_contact;
    private String allPhones;

    public String getWork_phone() {
        return work_phone;
    }

    public ContactData withWorkPhone(String work_phone) {
        this.work_phone = work_phone;
        return this;
    }


    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }


    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle_contact(String title_contact) {
        this.title_contact = title_contact;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHome_phone(String home_phone) {
        this.home_phone = home_phone;
        return this;
    }

    public ContactData withMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
        return this;
    }

    public ContactData withWhere_work(String where_work) {
        this.where_work = where_work;
        return this;
    }

    public ContactData withFax_phone(String fax_phone) {
        this.fax_phone = fax_phone;
        return this;
    }

    public ContactData withEmail_contact(String email_contact) {
        this.email_contact = email_contact;
        return this;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle_contact() {
        return title_contact;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public String getWhere_work() {
        return where_work;
    }

    public String getFax_phone() {
        return fax_phone;
    }

    public String getEmail_contact() {
        return email_contact;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }


}

