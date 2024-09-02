package com.adcbbank.app.dto;

public record TransferFundDto(Long fromAccountId, Long toAccountId, double amount) {
}
