package com.cg.paytm.service;

import java.math.BigDecimal;

import com.cg.paytm.beans.Customer;

public interface WalletService {
	public Customer createAccount(String name, String mobileno, BigDecimal amount);

	public Customer showBalance(String mobileno);

	public void acceptCustomerDetails(Customer cust);

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount);

	public Customer depositAmount(String mobileNo, BigDecimal amount);

	public Customer withdrawAmount(String mobileNo, BigDecimal amount);

}
