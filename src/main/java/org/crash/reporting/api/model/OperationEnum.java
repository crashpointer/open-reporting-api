package org.crash.reporting.api.model;

public enum OperationEnum {

    DIRECT("DIRECT"),
    REFUND("REFUND"),
    D3("3D"),
    D3AUTH("3DAUTH"),
    STORED("STORED");

    private String value;

    OperationEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }

}
