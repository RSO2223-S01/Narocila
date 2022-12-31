package si.fri.rso.skupina1.narocila.api.graphql;

import com.kumuluz.ee.graphql.annotations.GraphQLClass;
import com.kumuluz.ee.graphql.classes.Filter;
import com.kumuluz.ee.graphql.classes.Pagination;
import com.kumuluz.ee.graphql.classes.PaginationWrapper;
import com.kumuluz.ee.graphql.classes.Sort;
import com.kumuluz.ee.graphql.utils.GraphQLUtils;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import si.fri.rso.skupina1.narocila.lib.Order;
import si.fri.rso.skupina1.narocila.services.beans.OrderBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@GraphQLClass
@ApplicationScoped
public class OrderQueries {

    @Inject
    private OrderBean orderBean;

    @GraphQLQuery
    public PaginationWrapper<Order> allOrders(@GraphQLArgument(name = "pagination") Pagination pagination,
                                              @GraphQLArgument(name = "sort") Sort sort,
                                              @GraphQLArgument(name = "filter") Filter filter) {

        return GraphQLUtils.process(orderBean.getOrders(), pagination, sort, filter);
    }

    @GraphQLQuery
    public Order getOrder(@GraphQLArgument(name = "id") Integer id) {
        return orderBean.getOrder(id);
    }
}
