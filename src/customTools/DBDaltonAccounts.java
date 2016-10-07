package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import UserData.DBUtil;
import model.Daltonaccount;

public class DBDaltonAccounts {
	public static long getTotalNumberOfAccounts(int accountType) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		TypedQuery<Long> query = em.createQuery("SELECT count(a) FROM Daltonaccount a where a.accounttype = :accountType", Long.class);
		query.setParameter("accountType", accountType);
		long totalNumberOfAccounts = 0;
		try {
			totalNumberOfAccounts = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return totalNumberOfAccounts;
	}

	public static List<Daltonaccount> getAccountsCustomersBalanceTransaction() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		TypedQuery<Daltonaccount> query = em.createQuery("SELECT a FROM Daltonaccount a", Daltonaccount.class);
		List<Daltonaccount> accounts = null;
		try {
			accounts = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return accounts;
	}
	
	public static List<Daltonaccount> getAccountsCustomersBalanceTransaction(int accountType) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		TypedQuery<Daltonaccount> query = em.createQuery("SELECT a FROM Daltonaccount a where a.accounttype = :accountType", Daltonaccount.class);
		query.setParameter("accountType", accountType);
		List<Daltonaccount> accounts = null;
		try {
			accounts = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return accounts;
	}
	public static List<Daltonaccount> getAccountsDepositsWithdrawalsTransactions(int accountType) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		TypedQuery<Daltonaccount> query = em.createQuery("SELECT a FROM Daltonaccount a where a.accounttype = :accountType", Daltonaccount.class);
		query.setParameter("accountType", accountType);
		List<Daltonaccount> accounts = null;
		try {
			accounts = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return accounts;
	}
}
