import org.junit.*;

import customTools.DBDaltonAccounts;
import customTools.DBDaltonCustomers;
import customTools.DBDaltonTransactions;
import model.Daltonaccount;
import model.Daltoncustomer;

import static org.junit.Assert.*;

import java.util.List;

public class jUnitTest {

	@Test
	public void test_totalNumberOfTransactions() {
		long totalNumberOfTransactions = DBDaltonTransactions.getTotalNumberOfTransactions();
		assertTrue(totalNumberOfTransactions == 99);
	}

	@Test
	public void test_totalNumberOfTransactions_Deposits() {
		long totalNumberOfTransactionsDeposits = DBDaltonTransactions.getTotalNumberOfTransactions(1);
		assertTrue(totalNumberOfTransactionsDeposits == 21);
	}

	@Test
	public void test_totalNumberOfTransactions_Withdrawals() {
		long totalNumberOfTransactionsWithdrawals = DBDaltonTransactions.getTotalNumberOfTransactions(2);
		totalNumberOfTransactionsWithdrawals += DBDaltonTransactions.getTotalNumberOfTransactions(3);
		totalNumberOfTransactionsWithdrawals += DBDaltonTransactions.getTotalNumberOfTransactions(4);
		assertTrue(totalNumberOfTransactionsWithdrawals == 78);
	}

	@Test
	public void test_totalNumberOfTransactions_Withdrawals_BankFee() {
		long totalNumberOfTransactionsWithdrawalsBankFee = DBDaltonTransactions.getTotalNumberOfTransactions(2);
		assertTrue(totalNumberOfTransactionsWithdrawalsBankFee == 30);
	}

	@Test
	public void test_transactionAmount_BankFee() {
		long transactionAmountBankFee = DBDaltonTransactions.getTransactionAmount(2);
		assertTrue(transactionAmountBankFee == 145969212);
	}

	@Test
	public void test_totalNumberOfAccounts_Checking() {
		long totalNumberOfAccounts = DBDaltonAccounts.getTotalNumberOfAccounts(1);
		assertTrue(totalNumberOfAccounts == 54);
	}

	@Test
	public void test_totalNumberOfAccounts_Savings() {
		long totalNumberOfAccounts = DBDaltonAccounts.getTotalNumberOfAccounts(2);
		assertTrue(totalNumberOfAccounts == 44);
	}

	@Test
	public void test_customerAccountBalance() {
		List<Daltoncustomer> customerList = DBDaltonCustomers.getCustomerAccountBalance(20);
		int numberOfAccounts = customerList.get(0).getDaltonaccounts().size();
		int totalBalance = 0;
		for (int i = 0; i < numberOfAccounts; i++) {
			int numberOfTransactions = customerList.get(0).getDaltonaccounts().get(i).getDaltontransactions().size();
			for (int j = 0; j < numberOfTransactions; j++) {
				totalBalance += customerList.get(0).getDaltonaccounts().get(i).getDaltontransactions().get(j)
						.getAmount();
			}
		}
		assertTrue(totalBalance == 17322742);
	}

	@Test
	public void test_accountsCustomersBalanceTransaction() {
		List<Daltonaccount> accounts = DBDaltonAccounts.getAccountsCustomersBalanceTransaction(2);
		int numberOfAccounts = accounts.size();
		int balance = 0;
		for (int j = 0; j < numberOfAccounts; j++) {
			int numberOfTransactions = accounts.get(j).getDaltontransactions().size();
			balance = 0;
			for (int i = 0; i < numberOfTransactions; i++) {
				balance += accounts.get(j).getDaltontransactions().get(i).getAmount();
			}
		}
		assertTrue(balance == 0);
		assertTrue(numberOfAccounts == 44);
	}
	
	@Test
	public void test_accountsDepositsWithdrawalsTransactions() {
		List<Daltonaccount> accounts = DBDaltonAccounts.getAccountsDepositsWithdrawalsTransactions(1);
		int numberOfAccounts = accounts.size();
		int balance = 0;
		int totalNumberOfTransactions = 0;
		for (int j = 0; j < numberOfAccounts; j++) {
			int numberOfTransactions = accounts.get(j).getDaltontransactions().size();
			totalNumberOfTransactions += numberOfTransactions;
			balance = 0;
			for (int i = 0; i < numberOfTransactions; i++) {
				balance += accounts.get(j).getDaltontransactions().get(i).getAmount();
			}
		}
		assertTrue(balance == 0);
		assertTrue(numberOfAccounts == 44);
		assertTrue(totalNumberOfTransactions == 60);
	}
}