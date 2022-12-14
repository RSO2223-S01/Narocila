package si.fri.rso.skupina1.narocila.lib;

import java.util.List;

public class Order {

	private Integer id;
	private Integer clientId;
	private Integer deliveryPersonId;
	private Integer providerId;
	private String address;
	private Integer clientScore;
	private Integer deliveryScore;
	private String comment;
	private String commentEN;
	private String status;
	private List<OrderItem> items;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getDeliveryPersonId() {
		return deliveryPersonId;
	}

	public void setDeliveryPersonId(Integer deliveryPersonId) {
		this.deliveryPersonId = deliveryPersonId;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setClientScore(Integer clientScore) {
		this.clientScore = clientScore;
	}

	public Integer getClientScore() {
		return clientScore;
	}

	public Integer getDeliveryScore() {
		return deliveryScore;
	}

	public void setDeliveryScore(Integer deliveryScore) {
		this.deliveryScore = deliveryScore;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentEN() {
		return commentEN;
	}

	public void setCommentEN(String commentEN) {
		this.commentEN = commentEN;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
}