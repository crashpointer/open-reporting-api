package org.crash.reporting.api.payload.response;

import java.util.List;

public class TransactionReportResponse extends AbstractResponse {

    private List response;

    public List getResponse() {
        return response;
    }

    public void setResponse(List response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
