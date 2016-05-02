package com.nyp.shopping.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name = "CUSTOMER_ORDER")

public class CustomerOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@Column(name = "ORDER_DATE")
	private Date orderPlacedDate;

	@Column(name = "PAYMENT_DATE")
	private Date orderPaidDate;

	@Column(name = "TOTAL_AMOUNT")
	private Double orderTotalAmount;

	@Column(name = "BILLING_AMOUNT")
	private Double billingAmount;

	@Column(name = "OTHER_DETAILS", length = 100)
	private String orderOtherDetails;

	// NOT_PAID, PART_PAID, FULL_PAID
	@Column(name = "PAYMENT_STATUS", length = 100)
	private String orderPaymentStatus;

	@Embedded
	private RecordInfo recordInfo;

	@OneToOne(fetch = FetchType.LAZY, mappedBy="customerOrder")
	private BillingAddress billingAddress;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="customerOrder")
	private Set<CustomerOrderStatus> customerOrderStatusList;

	/** CustomerOrder is considered as the owner side while Product is on OTHER side of ManyToMany relationship	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerOrder")
	private Set<CustomerOrderItem> customerOrderItemsList = new HashSet<CustomerOrderItem>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerOrder")
	private Set<CustomerOrderPayments> paymentList = new HashSet<CustomerOrderPayments>(0);

	public CustomerOrder() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderPlacedDate() {
		return this.orderPlacedDate;
	}

	public void setOrderPlacedDate(Date orderPlacedDate) {
		this.orderPlacedDate = orderPlacedDate;
	}

	public Date getOrderPaidDate() {
		return this.orderPaidDate;
	}

	public void setOrderPaidDate(Date orderPaidDate) {
		this.orderPaidDate = orderPaidDate;
	}

	public String getOrderOtherDetails() {
		return this.orderOtherDetails;
	}

	public void setOrderOtherDetails(String orderOtherDetails) {
		this.orderOtherDetails = orderOtherDetails;
	}

	public RecordInfo getRecordInfo() {
		return recordInfo;
	}

	public void setRecordInfo(RecordInfo recordInfo) {
		this.recordInfo = recordInfo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<CustomerOrderItem> getCustomerOrderItemsList() {
		return customerOrderItemsList;
	}

	public void setCustomerOrderItemsList(Set<CustomerOrderItem> customerOrderItemsList) {
		this.customerOrderItemsList = customerOrderItemsList;
	}

	public Set<CustomerOrderPayments> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(Set<CustomerOrderPayments> paymentList) {
		this.paymentList = paymentList;
	}

	public Set<CustomerOrderStatus> getCustomerOrderStatusList() {
		return customerOrderStatusList;
	}

	public void setCustomerOrderStatusList(
			Set<CustomerOrderStatus> customerOrderStatusList) {
		this.customerOrderStatusList = customerOrderStatusList;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Double getOrderTotalAmount() {
		return orderTotalAmount;
	}

	public void setOrderTotalAmount(Double orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}

	public Double getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(Double billingAmount) {
		this.billingAmount = billingAmount;
	}

}
