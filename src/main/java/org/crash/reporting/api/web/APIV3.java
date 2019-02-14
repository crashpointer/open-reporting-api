package org.crash.reporting.api.web;

import org.crash.reporting.api.payload.request.LoginRequest;
import org.crash.reporting.api.payload.request.TransactionReportRequest;
import org.crash.reporting.api.payload.request.TransactionRequest;
import org.crash.reporting.api.payload.response.CustomerInfoResponse;
import org.crash.reporting.api.payload.response.TokenResponse;
import org.crash.reporting.api.payload.response.TransactionInfo;
import org.crash.reporting.api.payload.response.TransactionReportResponse;
import org.crash.reporting.api.security.JWTTokenProvider;
import org.crash.reporting.api.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v3", method = RequestMethod.POST)
public class APIV3 {

    @Autowired
    JWTTokenProvider tokenProvider;

    @Autowired
    TransactionService transactionService;

    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(value = "/merchant/user/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(tokenProvider.createToken(authentication));
        return ResponseEntity.ok(tokenResponse);
    }

    @RequestMapping(value = "/transactions/report", method = RequestMethod.POST)
    public TransactionReportResponse transactionReport(
            @Valid @RequestBody TransactionReportRequest transactionReportRequest) {
        TransactionReportResponse transactionReportResponse = new TransactionReportResponse();

        transactionService
                .transactionReport(transactionReportRequest)
                .ifPresent(transactionReportResponse::setResponse);
        return transactionReportResponse;
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public TransactionInfo transaction(
            @Valid @RequestBody TransactionRequest transactionRequest) {
        return transactionService
                .transaction(transactionRequest)
                .get();
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public CustomerInfoResponse client(
            @Valid @RequestBody TransactionRequest transactionRequest) {
        CustomerInfoResponse customerInfoResponse = new CustomerInfoResponse();

        transactionService
                .client(transactionRequest)
                .ifPresent(customerInfoResponse::setCustomerInfo);
        return customerInfoResponse;
    }

}
