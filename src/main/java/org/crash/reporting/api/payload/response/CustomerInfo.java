package org.crash.reporting.api.payload.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerInfo {

    private int id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String number;

    private byte expiryMonth;

    private short expiryYear;

    private byte startMonth;

    private short startYear;

    private String email;

    private LocalDate birthday;

    private boolean gender;

    private String billingTitle;

    private String billingFirstName;

    private String billingLastName;

    private String billingCompany;

    private String billingAddress1;

    private String billingAddress2;

    private String billingCity;

    private String billingPostCode;

    private String billingState;

    private String billingCountry;

    private String billingPhone;

    private String billingFax;

    private String shippingTitle;

    private String shippingFirstName;

    private String shippingLastName;

    private String shippingCompany;

    private String shippingAddress1;

    private String shippingAddress2;

    private String shippingCity;

    private String shippingPostCode;

    private String shippingState;

    private String shippingCountry;

    private String shippingPhone;

    private String shippingFax;

    public CustomerInfo(){

    }

    public CustomerInfo(int id, LocalDateTime createdAt, LocalDateTime updatedAt, String number,
                        byte expiryMonth, short expiryYear, byte startMonth, short startYear,
                        String email, LocalDate birthday, boolean gender, String billingTitle,
                        String billingFirstName, String billingLastName, String billingCompany,
                        String billingAddress1, String billingAddress2, String billingCity,
                        String billingPostCode, String billingState, String billingCountry,
                        String billingPhone, String billingFax, String shippingTitle,
                        String shippingFirstName, String shippingLastName, String shippingCompany,
                        String shippingAddress1, String shippingAddress2, String shippingCity,
                        String shippingPostCode, String shippingState, String shippingCountry,
                        String shippingPhone, String shippingFax) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.number = number;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.billingTitle = billingTitle;
        this.billingFirstName = billingFirstName;
        this.billingLastName = billingLastName;
        this.billingCompany = billingCompany;
        this.billingAddress1 = billingAddress1;
        this.billingAddress2 = billingAddress2;
        this.billingCity = billingCity;
        this.billingPostCode = billingPostCode;
        this.billingState = billingState;
        this.billingCountry = billingCountry;
        this.billingPhone = billingPhone;
        this.billingFax = billingFax;
        this.shippingTitle = shippingTitle;
        this.shippingFirstName = shippingFirstName;
        this.shippingLastName = shippingLastName;
        this.shippingCompany = shippingCompany;
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingCity = shippingCity;
        this.shippingPostCode = shippingPostCode;
        this.shippingState = shippingState;
        this.shippingCountry = shippingCountry;
        this.shippingPhone = shippingPhone;
        this.shippingFax = shippingFax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public byte getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(byte expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public short getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(short expiryYear) {
        this.expiryYear = expiryYear;
    }

    public byte getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(byte startMonth) {
        this.startMonth = startMonth;
    }

    public short getStartYear() {
        return startYear;
    }

    public void setStartYear(short startYear) {
        this.startYear = startYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getBillingTitle() {
        return billingTitle;
    }

    public void setBillingTitle(String billingTitle) {
        this.billingTitle = billingTitle;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    public String getBillingCompany() {
        return billingCompany;
    }

    public void setBillingCompany(String billingCompany) {
        this.billingCompany = billingCompany;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public void setBillingAddress1(String billingAddress1) {
        this.billingAddress1 = billingAddress1;
    }

    public String getBillingAddress2() {
        return billingAddress2;
    }

    public void setBillingAddress2(String billingAddress2) {
        this.billingAddress2 = billingAddress2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingPostCode() {
        return billingPostCode;
    }

    public void setBillingPostCode(String billingPostCode) {
        this.billingPostCode = billingPostCode;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public String getBillingFax() {
        return billingFax;
    }

    public void setBillingFax(String billingFax) {
        this.billingFax = billingFax;
    }

    public String getShippingTitle() {
        return shippingTitle;
    }

    public void setShippingTitle(String shippingTitle) {
        this.shippingTitle = shippingTitle;
    }

    public String getShippingFirstName() {
        return shippingFirstName;
    }

    public void setShippingFirstName(String shippingFirstName) {
        this.shippingFirstName = shippingFirstName;
    }

    public String getShippingLastName() {
        return shippingLastName;
    }

    public void setShippingLastName(String shippingLastName) {
        this.shippingLastName = shippingLastName;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public void setShippingAddress1(String shippingAddress1) {
        this.shippingAddress1 = shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public void setShippingAddress2(String shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingPostCode() {
        return shippingPostCode;
    }

    public void setShippingPostCode(String shippingPostCode) {
        this.shippingPostCode = shippingPostCode;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    public String getShippingFax() {
        return shippingFax;
    }

    public void setShippingFax(String shippingFax) {
        this.shippingFax = shippingFax;
    }
}
