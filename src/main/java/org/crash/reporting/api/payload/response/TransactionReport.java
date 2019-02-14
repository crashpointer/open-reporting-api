package org.crash.reporting.api.payload.response;

public class TransactionReport {

    private long count;

    private long total;

    private String currency;

    public TransactionReport(String currency, long count, long total) {
        this.currency = currency;
        this.count = count;
        this.total = total;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
