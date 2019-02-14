package org.crash.reporting.api.service;

import org.crash.reporting.api.payload.request.TransactionReportRequest;
import org.crash.reporting.api.payload.request.TransactionRequest;
import org.crash.reporting.api.payload.response.CustomerInfo;
import org.crash.reporting.api.payload.response.TransactionInfo;
import org.crash.reporting.api.payload.response.TransactionReport;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    public Optional<List<TransactionReport>> transactionReport(TransactionReportRequest reportRequest);

    public Optional<TransactionInfo> transaction(TransactionRequest transactionRequest);

    public Optional<CustomerInfo> client(TransactionRequest transactionRequest);

}
