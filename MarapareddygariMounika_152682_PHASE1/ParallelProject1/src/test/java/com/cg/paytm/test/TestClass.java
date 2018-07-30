package com.cg.paytm.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.paytm.beans.Customer;
import com.cg.paytm.beans.Wallet;
import com.cg.paytm.exception.InvalidInputException;
import com.cg.paytm.service.WalletService;
import com.cg.paytm.service.WalletServiceImpl;



public class TestClass  {
	WalletService service;
	Customer cust1, cust2, cust3;

	@Before
	public void initData() {
		Map<String, Customer> data = new HashMap<String, Customer>();
		cust1 = new Customer("Mouni", "9900112212", new Wallet(new BigDecimal(9000)));
		cust2 = new Customer("Anush", "9963242422", new Wallet(new BigDecimal(6000)));
		cust3 = new Customer("Pavi", "9922950519", new Wallet(new BigDecimal(7000)));

		data.put("9900112212", cust1);
		data.put("9963242422", cust2);
		data.put("9922950519", cust3);
		service = new WalletServiceImpl(data);

	}

	@Test
	public void testCreateAccount1() {

		Customer c = new Customer();
		Customer cust = new Customer();
		cust = service.createAccount("Mouni", "9900112213", new BigDecimal(7000));
		c.setMobileNo("9900112213");
		c.setName("Mouni");
		c.setWallet(new Wallet(new BigDecimal(7000)));
		Customer actual = c;
		Customer expected = cust;
		assertEquals(expected, actual);

	}

	@Test
	public void testCreateAccount2() {

		Customer cust = new Customer();
		cust = service.createAccount("Mouni", "9900112213", new BigDecimal(7000));
		assertEquals("Mouni", cust.getName());

	}

	@Test
	public void testCreateAccount3() {

		Customer cust = new Customer();
		cust = service.createAccount("Mouni", "9900112213", new BigDecimal(7000));
		assertEquals("9900112213", cust.getMobileNo());
	}

	@Test
	public void testShowBalance2() {

		Customer cust = new Customer();

		cust = service.showBalance("9922950519");
		assertEquals(cust, cust3);

	}

	@Test(expected = NullPointerException.class)

	public void testCreateAccount() {

		service.createAccount(null, null, null);
	}

	@Test(expected = InvalidInputException.class)
	public void testShowBalance() {
		@SuppressWarnings("unused")
		Customer cust = new Customer();
		cust = service.showBalance("9579405744");

	}

	@Test(expected = InvalidInputException.class)
	public void testFundTransfer() {
		service.fundTransfer(null, null, new BigDecimal(7000));
	}

	@Test(expected = InvalidInputException.class)
	public void testDeposit() {
		service.depositAmount("900000000", new BigDecimal(2000));
	}

	@Test(expected = InvalidInputException.class)
	public void testWithdraw() {
		service.withdrawAmount("900000000", new BigDecimal(2000));
	}

	@Test
	public void testShowBalance3() {

		Customer cust = new Customer();
		cust = service.showBalance("9900112212");
		BigDecimal actual = cust.getWallet().getBalance();
		BigDecimal expected = new BigDecimal(9000);
		assertEquals(expected, actual);

	}

	@Test
	public void testFundTransfer2() {
		cust1 = service.fundTransfer("9900112212", "9963242422", new BigDecimal(2000));
		BigDecimal actual = cust1.getWallet().getBalance();
		BigDecimal expected = new BigDecimal(8000);
		assertEquals(expected, actual);
	}

	@Test
	public void testDeposit2() {
		cust1 = service.depositAmount("9963242422", new BigDecimal(2000));
		BigDecimal actual = cust1.getWallet().getBalance();
		BigDecimal expected = new BigDecimal(8000);
		assertEquals(expected, actual);
	}

	@Test
	public void testWithdraw2() {
		cust1 = service.withdrawAmount("9963242422", new BigDecimal(2000));
		BigDecimal actual = cust1.getWallet().getBalance();
		BigDecimal expected = new BigDecimal(4000);
		assertEquals(expected, actual);
	}

	@Test
	public void TestValidate() {
		Customer customer = new Customer("Vaish", "8796543210", new Wallet(new BigDecimal(10)));
		service.acceptCustomerDetails(customer);
	}

	@After
	public void testAfter() {
		service = null;
	}





}
