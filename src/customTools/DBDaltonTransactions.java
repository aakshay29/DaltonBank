package customTools;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import UserData.DBUtil;

public class DBDaltonTransactions {
	
	public static long getTotalNumberOfTransactions() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Long> query = em.createQuery("SELECT count(t) FROM Daltontransaction t", Long.class);
		long totalNumberOfTransactions = 0;
		try {
			totalNumberOfTransactions = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return totalNumberOfTransactions;
	}
	public static long getTotalNumberOfTransactions(int transactionType) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Long> query = em.createQuery("SELECT count(t) FROM Daltontransaction t where t.transacttype = :transactionType", Long.class);
		query.setParameter("transactionType", transactionType);
		long totalNumberOfTransactions = 0;
		try {
			totalNumberOfTransactions = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return totalNumberOfTransactions;
	}
	public static long getTransactionAmount(int transactionType) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Long> query = em.createQuery("SELECT sum(t.amount) FROM Daltontransaction t where t.transacttype = :transactionType", Long.class);
		query.setParameter("transactionType", transactionType);
		long totalNumberOfTransactions = 0;
		try {
			totalNumberOfTransactions = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return totalNumberOfTransactions;
	}
}
