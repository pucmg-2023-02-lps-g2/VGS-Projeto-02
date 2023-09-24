package project.system.VGS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.system.VGS.models.Order;
import project.system.VGS.services.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String order(Order order, Model model) {
        model.addAttribute("orderList", orderService.findAllOrders());
        return "orderManagement";
    }

    @PostMapping("/order")
    public String addOrder(@ModelAttribute Order order, Model model) {
        orderService.addOrder(order);
        model.addAttribute("orderList", orderService.findAllOrders());
        return "orderManagement";
    }

    @PostMapping("/order/delete")
    public String deleteOrder(@RequestParam("idDelete") String idDelete, Order order, Model model) {
        orderService.deleteOrder(idDelete);
        model.addAttribute("orderList", orderService.findAllOrders());
        return "orderManagement";
    }
}


