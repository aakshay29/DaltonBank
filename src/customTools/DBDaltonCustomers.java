package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import UserData.DBUtil;
import model.Daltoncustomer;

public class DBDaltonCustomers {
	public static List<Daltoncustomer> getCustomerAccountBalance() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Daltoncustomer> query = em.createQuery("SELECT c FROM Daltoncustomer c", Daltoncustomer.class);
		List<Daltoncustomer> customer = null;
		try {
			customer = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return customer;
	}
	public static List<Daltoncustomer> getCustomerAccountBalance(int customerID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Daltoncustomer> query = em.createQuery("SELECT c FROM Daltoncustomer c where c.customerid = :customerID", Daltoncustomer.class);
		query.setParameter("customerID", customerID);
		List<Daltoncustomer> customer = null;
		try {
			customer = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return customer;
	}
}
