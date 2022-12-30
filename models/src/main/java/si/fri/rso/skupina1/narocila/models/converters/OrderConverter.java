package si.fri.rso.skupina1.narocila.models.converters;

import si.fri.rso.skupina1.narocila.lib.Order;
import si.fri.rso.skupina1.narocila.models.entities.OrderEntity;

import java.util.stream.Collectors;

public class OrderConverter {
	public static Order toDto(OrderEntity entity) {

		Order dto = new Order();
		dto.setId(entity.getId());
		dto.setClientId(entity.getClientId());
		dto.setDeliveryPersonId(entity.getDeliveryPersonId());
		dto.setAddress(entity.getAddress());
		dto.setClientScore(entity.getClientScore());
		dto.setDeliveryScore(entity.getDeliveryScore());
		dto.setComment(entity.getComment());
		dto.setStatus(entity.getStatus());
		dto.setItems(entity.getItems().stream().map(OrderItemConverter::toDto).collect(Collectors.toList()));

		return dto;
	}

	public static OrderEntity toEntity(Order dto) {

		OrderEntity entity = new OrderEntity();
		entity.setId(dto.getId());
		entity.setClientId(dto.getClientId());
		entity.setDeliveryPersonId(dto.getDeliveryPersonId());
		entity.setAddress(dto.getAddress());
		entity.setClientScore(dto.getClientScore());
		entity.setDeliveryScore(dto.getDeliveryScore());
		entity.setComment(dto.getComment());
		entity.setStatus(dto.getStatus());
		entity.setItems(dto.getItems().stream().map(OrderItemConverter::toEntity).collect(Collectors.toList()));

		return entity;
	}
}
