package si.fri.rso.skupina1.narocila.models.converters;

import si.fri.rso.skupina1.narocila.lib.OrderItem;
import si.fri.rso.skupina1.narocila.models.entities.OrderItemEntity;

public class OrderItemConverter {
	public static OrderItem toDto(OrderItemEntity entity) {

		OrderItem dto = new OrderItem();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());

		return dto;
	}

	public static OrderItemEntity toEntity(OrderItem dto) {

		OrderItemEntity entity = new OrderItemEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());

		return entity;
	}
}
