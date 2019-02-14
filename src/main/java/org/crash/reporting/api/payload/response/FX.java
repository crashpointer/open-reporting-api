package org.crash.reporting.api.payload.response;

public class FX {

    private int id;

    private int originalAmount;

    private String originalCurrency;

    FX(int id, int originalAmount, String originalCurrency) {
        this.id = id;
        this.originalAmount = originalAmount;
        this.originalCurrency = originalCurrency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(int originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

}
