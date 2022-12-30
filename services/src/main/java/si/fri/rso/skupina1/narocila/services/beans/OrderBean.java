package si.fri.rso.skupina1.narocila.services.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;

import si.fri.rso.skupina1.narocila.lib.Order;
import si.fri.rso.skupina1.narocila.models.converters.OrderConverter;
import si.fri.rso.skupina1.narocila.models.entities.OrderEntity;

@RequestScoped
public class OrderBean {

	private Logger log = Logger.getLogger(OrderBean.class.getName());

	@Inject
	private EntityManager em;

	public List<Order> getOrders() {

		TypedQuery<OrderEntity> query = em.createNamedQuery(
				"OrderEntity.getAll", OrderEntity.class);

		List<OrderEntity> resultList = query.getResultList();

		return resultList.stream().map(OrderConverter::toDto).collect(Collectors.toList());

	}

	public List<Order> getOrderFilter(UriInfo uriInfo) {

		QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery()).defaultOffset(0)
				.build();

		return JPAUtils.queryEntities(em, OrderEntity.class, queryParameters).stream()
				.map(OrderConverter::toDto).collect(Collectors.toList());
	}

	public Order getOrder(Integer id) {

		OrderEntity orderEntity = em.find(OrderEntity.class, id);

		if (orderEntity == null) {
			throw new NotFoundException();
		}

		Order user = OrderConverter.toDto(orderEntity);

		return user;
	}

	public Order createOrder(Order order) {

		OrderEntity orderEntity = OrderConverter.toEntity(order);
		try {
			beginTx();
			em.persist(orderEntity);
			commitTx();
		} catch (Exception e) {
			rollbackTx();
		}

		if (orderEntity.getId() == null) {
			throw new RuntimeException("Entity was not persisted");
		}

		return OrderConverter.toDto(orderEntity);
	}

	public Order putOrder(Integer id, Order order) {

		OrderEntity c = em.find(OrderEntity.class, id);

		if (c == null) {
			return null;
		}

		OrderEntity updatedOrderEntity = OrderConverter.toEntity(order);

		try {
			beginTx();
			updatedOrderEntity.setId(c.getId());
			updatedOrderEntity = em.merge(updatedOrderEntity);
			commitTx();
		} catch (Exception e) {
			rollbackTx();
		}

		return OrderConverter.toDto(updatedOrderEntity);
	}

	public boolean deleteOrder(Integer id) {

		OrderEntity order = em.find(OrderEntity.class, id);

		if (order != null) {
			try {
				beginTx();
				em.remove(order);
				commitTx();
			} catch (Exception e) {
				rollbackTx();
			}
		} else {
			return false;
		}

		return true;
	}

	private void beginTx() {
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
	}

	private void commitTx() {
		if (em.getTransaction().isActive()) {
			em.getTransaction().commit();
		}
	}

	private void rollbackTx() {
		if (em.getTransaction().isActive()) {
			em.getTransaction().rollback();
		}
	}
}
