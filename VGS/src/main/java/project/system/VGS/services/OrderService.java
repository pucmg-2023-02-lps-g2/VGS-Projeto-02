package project.system.VGS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.system.VGS.models.Order;
import project.system.VGS.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order addOrder(Order user) {
        return orderRepository.save(user);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    public Order findOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order findOrderByCpf(String id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }
}
