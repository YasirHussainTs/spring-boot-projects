package com.adcbbank.app.service;

import com.adcbbank.app.dto.AccountDto;
import com.adcbbank.app.dto.TransactionDto;
import com.adcbbank.app.dto.TransferFundDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto depositAccount(Long id, double amount);

    AccountDto withdrawAccount(Long id, double amount);

    List<AccountDto> getAllAccount();

    void deleteAccount(Long id);

    void transferFunds(TransferFundDto transferFundDto);

    List<TransactionDto> getAccountTransactions(Long id);
}
