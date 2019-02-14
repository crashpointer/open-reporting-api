package org.crash.reporting.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address_id")
    @SequenceGenerator(name = "seq_address_id", sequenceName = "seq_address_id", allocationSize = 1)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    @Size(max = 256)
    @Column(length = 256)
    private String title;

    @NotNull
    @Size(max = 64)
    @Column(length = 64, nullable = false)
    private String firstName;

    @NotNull
    @Size(max = 64)
    @Column(length = 64, nullable = false)
    private String lastName;

    @Size(max = 256)
    @Column(length = 256)
    private String company;

    @NotNull
    @Size(max = 512)
    @Column(length = 512, nullable = false)
    private String address1;

    @Size(max = 512)
    @Column(length = 512)
    private String address2;

    @NotNull
    @Size(max = 32)
    @Column(length = 512, nullable = false)
    private String city;

    @Size(max = 16)
    @Column(length = 16)
    private String postCode;

    @Size(max = 32)
    @Column(length = 32)
    private String state;

    @NotNull
    @Size(max = 4)
    @Column(length = 4, nullable = false)
    private String country;

    @Size(max = 16)
    @Column(length = 16)
    private String phone;

    @Size(max = 16)
    @Column(length = 16)
    private String fax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
