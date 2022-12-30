package si.fri.rso.skupina1.narocila.models.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
@NamedQueries(value = {
		@NamedQuery(name = "OrderEntity.getAll", query = "SELECT o FROM OrderEntity o")
})
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "clientId")
	private Integer clientId;

	@Column(name = "deliveryPersonId")
	private Integer deliveryPersonId;

	@Column(name = "address")
	private String address;

	@Column(name = "clientScore")
	private Integer clientScore;

	@Column(name = "deliveryScore")
	private Integer deliveryScore;

	@Column(name = "comment")
	private String comment;

	@Column(name = "status")
	private String status;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<OrderItemEntity> items;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderItemEntity> getItems() {
		return items;
	}

	public void setItems(List<OrderItemEntity> items) {
		this.items = items;
	}
}