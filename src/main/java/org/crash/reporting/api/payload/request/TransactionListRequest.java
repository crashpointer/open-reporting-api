package org.crash.reporting.api.payload.request;

import org.crash.reporting.api.model.PaymentMethodEnum;
import org.crash.reporting.api.model.StatusEnum;
import org.crash.reporting.api.validator.Enum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.util.Date;

public class TransactionListRequest {

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date fromDate;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date toDate;

    @Size(max = 64)
    @Enum(enumClass = StatusEnum.class)
    private String status;

    @Size(max = 64)
    private String operation;

    private int merchantId;

    private int acquirerId;

    @Size(max = 32)
    @Enum(enumClass = PaymentMethodEnum.class)
    private String paymentMethod;

    @Size(max = 256)
    private String errorCode;

    @Size(max = 128)
    private String filterField;

    @Size(max = 256)
    private String filterValue;

    private int page;

}
