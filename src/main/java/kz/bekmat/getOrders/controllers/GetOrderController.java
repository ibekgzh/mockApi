package kz.bekmat.getOrders.controllers;


import kz.bekmat.getOrders.models.Order;
import kz.bekmat.getOrders.services.OrderService;
import kz.bekmat.getOrders.util.OrderErrorResponse;
import kz.bekmat.getOrders.util.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/get-orders")
public class GetOrderController {
    private final OrderService orderService;

    @Autowired
    public GetOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public List<Order> getClient(@RequestBody Order order) {
        return orderService.findByIin(order.getIin());
    }

    @ExceptionHandler
    private ResponseEntity<OrderErrorResponse> handleException(OrderNotFoundException e) {
        OrderErrorResponse response = new OrderErrorResponse(
                "iin - Нету зарегистрирванного физического лица с таким IIN",  LocalDateTime.now());
        System.out.println( LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
