package customTools;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import UserData.DBUtil;

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
}
