package com.cg.paytm.repo;

import com.cg.paytm.beans.Customer;

public interface WalletRepo {
	
	public boolean save(Customer customer);

	public Customer findOne(String mobileNo);

}
