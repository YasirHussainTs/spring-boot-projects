package com.adcbbank.app.controller;

import com.adcbbank.app.dto.AccountDto;
import com.adcbbank.app.dto.TransactionDto;
import com.adcbbank.app.dto.TransferFundDto;
import com.adcbbank.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    //Dependancy Injected
    public AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add account REST API

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get account REST API

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    //Deposit account REST API

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAccount(@PathVariable Long id, @RequestBody Map<String,Double> request) {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.depositAccount(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //Withdraw account REST API

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawAccount(@PathVariable Long id,
                                                      @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdrawAccount(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //Get all account REST API

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccount() {
        List<AccountDto> account = accountService.getAllAccount();
        return ResponseEntity.ok(account);
    }

    //Delete account REST API

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }

    //Build transfer REST API

    @PostMapping("/transfer")
    public ResponseEntity<String> transferTransfer(@RequestBody TransferFundDto transferFundDto){
        accountService.transferFunds(transferFundDto);
        return ResponseEntity.ok("Amounts transferred successfully");
    }

    //Build Transactions REST API

    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<TransactionDto>> fetchAccountTransactions(@PathVariable("id") Long id){
        List<TransactionDto> transactions = accountService.getAccountTransactions(id);
        return ResponseEntity.ok(transactions);
    }
}
