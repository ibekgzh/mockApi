package kz.bekmat.getOrders.services;

import kz.bekmat.getOrders.models.Order;
import kz.bekmat.getOrders.repositories.OrderRepository;
import kz.bekmat.getOrders.util.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findByIin(String iin) {
        Optional <List<Order>> listOrders = Optional.ofNullable(orderRepository.findByIin(iin));
        return listOrders.orElseThrow(OrderNotFoundException::new);

    }
}
