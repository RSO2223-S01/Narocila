package si.fri.rso.skupina1.narocila.api.v1.resources;

import com.kumuluz.ee.logs.cdi.Log;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Counted;

import si.fri.rso.skupina1.narocila.lib.Order;
import si.fri.rso.skupina1.narocila.services.beans.OrderBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;

@Log
@ApplicationScoped
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

	private Logger log = Logger.getLogger(OrderResource.class.getName());

	@Inject
	private OrderBean orderBean;

	@Context
	protected UriInfo uriInfo;

	@Counted(name = "getOrders_total")
	@Metered(name = "getOrders_rate")
	@Operation(description = "Get all orders.", summary = "Get orders")
	@APIResponses({
			@APIResponse(responseCode = "200", description = "List of orders", content = @Content(schema = @Schema(implementation = Order.class, type = SchemaType.ARRAY)), headers = {
					@Header(name = "X-Total-Count", description = "Number of objects in list") }) })
	@GET
	public Response getOrders() {

		List<Order> orders = orderBean.getOrderFilter(uriInfo);

		return Response.status(Response.Status.OK).entity(orders).build();
	}

	@Counted(name = "getOrder_total")
	@Metered(name = "getOrder_rate")
	@Operation(description = "Get order.", summary = "Get order")
	@APIResponses({
			@APIResponse(responseCode = "200", description = "Order", content = @Content(schema = @Schema(implementation = Order.class))) })
	@GET
	@Path("/{orderId}")
	public Response getOrder(
			@Parameter(description = "Order ID.", required = true) @PathParam("orderId") Integer orderId) {

		Order order = orderBean.getOrder(orderId);

		if (order == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.status(Response.Status.OK).entity(order).build();
	}

	@Counted(name = "createOrder_total")
	@Metered(name = "createOrder_rate")
	@Operation(description = "Add order.", summary = "Add order")
	@APIResponses({
			@APIResponse(responseCode = "201", description = "Order successfully added."),
			@APIResponse(responseCode = "405", description = "Validation error.")
	})
	@POST
	public Response createOrder(
			@RequestBody(description = "DTO object with order data.", required = true, content = @Content(schema = @Schema(implementation = Order.class))) Order order) {

		if (order.getClientId() == null || order.getAddress() == null || order.getItems() == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			order = orderBean.createOrder(order);
		}

		return Response.status(Response.Status.CONFLICT).entity(order).build();

	}

	@Counted(name = "putOrder_total")
	@Metered(name = "putOrder_rate")
	@Operation(description = "Update data for an order.", summary = "Update order")
	@APIResponses({
			@APIResponse(responseCode = "200", description = "Order successfully updated.")
	})
	@PUT
	@Path("{orderId}")
	public Response putOrder(
			@Parameter(description = "Order ID.", required = true) @PathParam("orderId") Integer orderId,
			@RequestBody(description = "DTO object with order data.", required = true, content = @Content(schema = @Schema(implementation = Order.class))) Order order) {

		order = orderBean.putOrder(orderId, order);

		if (order == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.status(Response.Status.NOT_MODIFIED).build();
	}

	@Counted(name = "deleteOrder_total")
	@Metered(name = "deleteOrder_rate")
	@Operation(description = "Delete order.", summary = "Delete order")
	@APIResponses({
			@APIResponse(responseCode = "200", description = "Order successfully deleted."),
			@APIResponse(responseCode = "404", description = "Not found.")
	})
	@DELETE
	@Path("{orderId}")
	public Response deleteOrder(
			@Parameter(description = "Order ID.", required = true) @PathParam("orderId") Integer orderId) {

		boolean deleted = orderBean.deleteOrder(orderId);

		if (deleted) {
			return Response.status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
