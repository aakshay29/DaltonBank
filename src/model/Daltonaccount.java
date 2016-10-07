package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DALTONACCOUNTS database table.
 * 
 */
@Entity
@Table(name="DALTONACCOUNTS")
@NamedQuery(name="Daltonaccount.findAll", query="SELECT d FROM Daltonaccount d")
public class Daltonaccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long accountid;

	private BigDecimal accountnumber;

	private BigDecimal accounttype;

	@Temporal(TemporalType.DATE)
	private Date dateclosed;

	@Temporal(TemporalType.DATE)
	private Date dateopened;

	//bi-directional many-to-one association to Daltoncustomer
	@ManyToOne
	@JoinColumn(name="CUSTOMERID")
	private Daltoncustomer daltoncustomer;

	//bi-directional many-to-one association to Daltontransaction
	@OneToMany(mappedBy="daltonaccount")
	private List<Daltontransaction> daltontransactions;

	public Daltonaccount() {
	}

	public long getAccountid() {
		return this.accountid;
	}

	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}

	public BigDecimal getAccountnumber() {
		return this.accountnumber;
	}

	public void setAccountnumber(BigDecimal accountnumber) {
		this.accountnumber = accountnumber;
	}

	public BigDecimal getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(BigDecimal accounttype) {
		this.accounttype = accounttype;
	}

	public Date getDateclosed() {
		return this.dateclosed;
	}

	public void setDateclosed(Date dateclosed) {
		this.dateclosed = dateclosed;
	}

	public Date getDateopened() {
		return this.dateopened;
	}

	public void setDateopened(Date dateopened) {
		this.dateopened = dateopened;
	}

	public Daltoncustomer getDaltoncustomer() {
		return this.daltoncustomer;
	}

	public void setDaltoncustomer(Daltoncustomer daltoncustomer) {
		this.daltoncustomer = daltoncustomer;
	}

	public List<Daltontransaction> getDaltontransactions() {
		return this.daltontransactions;
	}

	public void setDaltontransactions(List<Daltontransaction> daltontransactions) {
		this.daltontransactions = daltontransactions;
	}

	public Daltontransaction addDaltontransaction(Daltontransaction daltontransaction) {
		getDaltontransactions().add(daltontransaction);
		daltontransaction.setDaltonaccount(this);

		return daltontransaction;
	}

	public Daltontransaction removeDaltontransaction(Daltontransaction daltontransaction) {
		getDaltontransactions().remove(daltontransaction);
		daltontransaction.setDaltonaccount(null);

		return daltontransaction;
	}

}