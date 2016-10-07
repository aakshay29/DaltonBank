import org.junit.* ;

import customTools.DBDaltonAccounts;
import customTools.DBDaltonTransactions;

import static org.junit.Assert.* ;

public class jUnitTest {

   @Test
   public void test_totalNumberOfTransactions() {
	  long totalNumberOfTransactions = DBDaltonTransactions.getTotalNumberOfTransactions();
      assertTrue(totalNumberOfTransactions == 99) ;
   }
   @Test
   public void test_totalNumberOfTransactions_Deposits() {
	  long totalNumberOfTransactionsDeposits = DBDaltonTransactions.getTotalNumberOfTransactions(1);
      assertTrue(totalNumberOfTransactionsDeposits == 21) ;
   }
   @Test
   public void test_totalNumberOfTransactions_Withdrawals() {
	  long totalNumberOfTransactionsWithdrawals = DBDaltonTransactions.getTotalNumberOfTransactions(2);
	  totalNumberOfTransactionsWithdrawals += DBDaltonTransactions.getTotalNumberOfTransactions(3);
	  totalNumberOfTransactionsWithdrawals += DBDaltonTransactions.getTotalNumberOfTransactions(4);
      assertTrue(totalNumberOfTransactionsWithdrawals == 78) ;
   }
   @Test
   public void test_totalNumberOfTransactions_Withdrawals_BankFee() {
	  long totalNumberOfTransactionsWithdrawalsBankFee = DBDaltonTransactions.getTotalNumberOfTransactions(2);
      assertTrue(totalNumberOfTransactionsWithdrawalsBankFee == 30) ;
   }
   @Test
   public void test_transactionAmount_BankFee() {
	  long transactionAmountBankFee = DBDaltonTransactions.getTransactionAmount(2);
      assertTrue(transactionAmountBankFee == 145969212) ;
   }
   @Test
   public void test_totalNumberOfAccounts_Checking() {
	  long totalNumberOfAccounts = DBDaltonAccounts.getTotalNumberOfAccounts(1);
      assertTrue(totalNumberOfAccounts == 54) ;
   }
   @Test
   public void test_totalNumberOfAccounts_Savings() {
	  long totalNumberOfAccounts = DBDaltonAccounts.getTotalNumberOfAccounts(2);
      assertTrue(totalNumberOfAccounts == 44) ;
   }
}