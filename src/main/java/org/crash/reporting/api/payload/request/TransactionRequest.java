package org.crash.reporting.api.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransactionRequest {

    @NotNull
    @NotBlank
    private String transactionUUID;

    public String getTransactionUUID() {
        return transactionUUID;
    }

    public void setTransactionUUID(String transactionUUID) {
        this.transactionUUID = transactionUUID;
    }

}
