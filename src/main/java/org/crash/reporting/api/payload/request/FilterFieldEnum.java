package org.crash.reporting.api.payload.request;

public enum FilterFieldEnum {

    TRANSACTION_UUID("Transaction UUID"),
    CUSTOMER_EMAIL("Customer Email"),
    REFERENCE_NO("Reference No"),
    CUSTOM_DATA("Custom Data"),
    CARD_PAN("Card PAN");

    private String value;

    FilterFieldEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

}
