package com.packtpub.springmvc.chocolatestore.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "purchase")
@Configurable
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	private Boolean completed;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	@Column(name = "order_date")
	private Calendar orderDate;

	@Version
	@Column(name = "version")
	private Integer version;

	@ManyToOne
	@JoinColumn(name="ordered_by")
	private Customer orderedBy;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase", fetch = FetchType.EAGER)
	private List<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>();

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@PersistenceContext
	transient EntityManager entityManager;

	public static final EntityManager entityManager() {
		EntityManager em = new Purchase().entityManager;
		if (em == null)
			throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
		return em;
	}

	public Calendar getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getOrderedBy() {
		return this.orderedBy;
	}

	public void setOrderedBy(Customer orderedBy) {
		this.orderedBy = orderedBy;
	}

	public List<PurchaseItem> getPurchaseItems() {
		return this.purchaseItems;
	}

	public void setPurchaseItems(List<PurchaseItem> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}

	public Boolean getCompleted() {
		return this.completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String myString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Purchase [id=" + id + ", completed=" + completed
				+ ", orderDate=" + new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").format(orderDate.getTime()) + 
				", version=" + version
				+ ", orderedBy=" + orderedBy + "]");
		for (PurchaseItem item : purchaseItems) {
			buf.append(", ").append(item.myPurchaseItemString());
		}
		return buf.toString();
	}
}
