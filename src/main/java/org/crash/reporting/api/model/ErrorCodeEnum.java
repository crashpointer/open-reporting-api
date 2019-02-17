package org.crash.reporting.api.model;

public enum ErrorCodeEnum {

    DO_NOT_HONOR("Do not honor"),
    INVALID_TRANSACTION("Invalid transaction"),
    INVALID_CARD("Invalid Card"),
    NOT_SUFFICIENT_FUNDS("Not sufficient funds"),
    INCORRECT_PIN("Incorrect PIN"),
    INVALID_COUNTRY_ASSOCIATION("Invalid country association"),
    CURRENCY_NOT_ALLOWED("Currency not allowed"),
    D3_SECURE_TRANSPORT_ERROR("3-D Secure Transport Error"),
    TRANSACTION_NOT_PERMITTED_TO_CARDHOLDER("Transaction not permitted to cardholder");

    private String value;

    ErrorCodeEnum(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
