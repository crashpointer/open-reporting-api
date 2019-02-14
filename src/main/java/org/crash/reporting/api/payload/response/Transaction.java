package org.crash.reporting.api.payload.response;

import java.time.LocalDateTime;

public class Transaction {

    private int id;

    private String transactionUUID;

    private String referenceNo;

    private String status;

    private String channel;

    private String customData;

    private String chainId;

    private String operation;

    private String code;

    private String message;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    Transaction(int id, String transactionUUID, String referenceNo, String status,
                String channel, String customData, String chainId,
                String operation, String code, String message,
                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.transactionUUID = transactionUUID;
        this.referenceNo = referenceNo;
        this.status = status;
        this.channel = channel;
        this.customData = customData;
        this.chainId = chainId;
        this.operation = operation;
        this.code = code;
        this.message = message;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionUUID() {
        return transactionUUID;
    }

    public void setTransactionUUID(String transactionUUID) {
        this.transactionUUID = transactionUUID;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
