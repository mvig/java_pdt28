/*
* Данные для заполнения формы нового контакта.
*/
package my.test.solution.model;

public class ContactData {
    private int id;
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
    private String where_work;
    private String fax_phone;
    private String email_contact;

    public ContactData(String firstname, String middlename, String lastname, String group, String nickname, String title_contact, String company, String address, String home_phone, String mobile_phone, String where_work, String fax_phone, String email_contact) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.group = group;
        this.nickname = nickname;
        this.title_contact = title_contact;
        this.company = company;
        this.address = address;
        this.home_phone = home_phone;
        this.mobile_phone = mobile_phone;
        this.where_work = where_work;
        this.fax_phone = fax_phone;
        this.email_contact = email_contact;
    }



    public ContactData(int id, String firstname, String lastname) {
        this.id=id;
        this.firstname = firstname;
        this.lastname = lastname;
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
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
