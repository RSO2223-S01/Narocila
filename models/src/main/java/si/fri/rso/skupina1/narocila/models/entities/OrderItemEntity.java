package si.fri.rso.skupina1.narocila.models.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "OrderItems")
@NamedQueries(value = {
		@NamedQuery(name = "OrderItemEntity.getAll", query = "SELECT o FROM OrderItemEntity o")
})
public class OrderItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}