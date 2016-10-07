package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DALTONTRANSACTIONS database table.
 * 
 */
@Entity
@Table(name="DALTONTRANSACTIONS")
@NamedQuery(name="Daltontransaction.findAll", query="SELECT d FROM Daltontransaction d")
public class Daltontransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long transactionid;

	private long amount;

	@Temporal(TemporalType.DATE)
	private Date transactiondate;

	private BigDecimal transacttype;

	//bi-directional many-to-one association to Daltonaccount
	@ManyToOne
	@JoinColumn(name="ACCOUNTID")
	private Daltonaccount daltonaccount;

	public Daltontransaction() {
	}

	public long getTransactionid() {
		return this.transactionid;
	}

	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}

	public long getAmount() {
		return this.amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getTransactiondate() {
		return this.transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	public BigDecimal getTransacttype() {
		return this.transacttype;
	}

	public void setTransacttype(BigDecimal transacttype) {
		this.transacttype = transacttype;
	}

	public Daltonaccount getDaltonaccount() {
		return this.daltonaccount;
	}

	public void setDaltonaccount(Daltonaccount daltonaccount) {
		this.daltonaccount = daltonaccount;
	}

}