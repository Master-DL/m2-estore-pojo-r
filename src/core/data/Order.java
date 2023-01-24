package core.data;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import core.data.interfaces.IItemList;
import core.data.interfaces.ISeller;
import core.service.OrderService;
import estorePojo.exceptions.UnknownItemException;

public class Order implements IItemList {

	private Account clientAccount;
	private String deliveryAddress;
	private ISeller store;
	public Date deliveryDate;
	private int deliveryDelay;
	private Map<Product,Integer> orderContent;

	private Integer orderId;

	public Order(Account clientAccount, String deliveryAddress, ISeller store, Date deliveryDate, int deliveryDelay) {
		this.clientAccount = clientAccount;
		this.deliveryAddress = deliveryAddress;
		this.store = store;
		this.deliveryDate = deliveryDate;
		this.deliveryDelay = deliveryDelay;
		this.orderContent = new HashMap<>();
	}

	public Map<Product, Integer> getOrderContent() {
		return orderContent;
	}

	public Account getClientAccount() {
		return clientAccount;
	}

	public void setClientAccount(Account clientAccount) {
		this.clientAccount = clientAccount;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public ISeller getStore() {
		return store;
	}

	public void setStore(ISeller store) {
		this.store = store;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getDeliveryDelay() {
		return deliveryDelay;
	}

	public void setDeliveryDelay(int deliveryDelay) {
		this.deliveryDelay = deliveryDelay;
	}

	@Override
	public Map<Product, Integer> getContent() {
		return orderContent;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setContent(Map<Product, Integer> content) {
		this.orderContent = content;
	}
}
