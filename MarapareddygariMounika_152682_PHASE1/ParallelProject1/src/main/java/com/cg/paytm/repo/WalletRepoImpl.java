package com.cg.paytm.repo;

import java.util.HashMap;
import java.util.Map;

import com.cg.paytm.beans.Customer;
import com.cg.paytm.exception.InvalidInputException;

public class WalletRepoImpl implements WalletRepo {

	private Map<String, Customer> data = new HashMap<String, Customer>();

	public Map<String, Customer> getData() {
		return data;
	}

	public void setData(Map<String, Customer> data) {
		this.data = data;
	}

	Customer cust = new Customer();

	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		this.data = data;
	}

	public WalletRepoImpl() {

	}

	public boolean save(Customer customer) {

		String mobileNo = customer.getMobileNo();
		if (data.get(mobileNo) == null) {
			data.put(mobileNo, customer);
			return true;
		} else
			return false;
	}

	public Customer findOne(String mobileNo) {

		cust = data.get(mobileNo);
		if (cust == null)
			throw new InvalidInputException("Account not found!!");
		else
			return cust;
	}

}
