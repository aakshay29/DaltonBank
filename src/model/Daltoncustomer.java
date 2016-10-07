package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DALTONCUSTOMERS database table.
 * 
 */
@Entity
@Table(name="DALTONCUSTOMERS")
@NamedQuery(name="Daltoncustomer.findAll", query="SELECT d FROM Daltoncustomer d")
public class Daltoncustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerid;

	private String address;

	private String city;

	private String name;

	@Column(name="\"STATE\"")
	private String state;

	private String zip;

	//bi-directional many-to-one association to Daltonaccount
	@OneToMany(mappedBy="daltoncustomer")
	private List<Daltonaccount> daltonaccounts;

	public Daltoncustomer() {
	}

	public long getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<Daltonaccount> getDaltonaccounts() {
		return this.daltonaccounts;
	}

	public void setDaltonaccounts(List<Daltonaccount> daltonaccounts) {
		this.daltonaccounts = daltonaccounts;
	}

	public Daltonaccount addDaltonaccount(Daltonaccount daltonaccount) {
		getDaltonaccounts().add(daltonaccount);
		daltonaccount.setDaltoncustomer(this);

		return daltonaccount;
	}

	public Daltonaccount removeDaltonaccount(Daltonaccount daltonaccount) {
		getDaltonaccounts().remove(daltonaccount);
		daltonaccount.setDaltoncustomer(null);

		return daltonaccount;
	}

}