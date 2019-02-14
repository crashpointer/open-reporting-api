package org.crash.reporting.api.payload.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

public class TransactionReportRequest {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fromDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String toDate;

    private int merchant = 0;

    private int acquirer = 0;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getMerchant() {
        return merchant;
    }

    public void setMerchant(int merchant) {
        this.merchant = merchant;
    }

    public int getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(int acquirer) {
        this.acquirer = acquirer;
    }
}
