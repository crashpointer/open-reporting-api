package org.crash.reporting.api.payload.response;

import org.crash.reporting.api.model.StatusEnum;

public abstract class AbstractResponse {

    protected String status = StatusEnum.APPROVED.toString();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
