package main.com.java.controller;

import java.util.ArrayList;
import java.util.List;

import main.com.java.service.business.objectUtils.OrderItemFilter;
import main.com.java.service.domain.interfaces.AccountService;
import main.com.java.service.domain.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.com.java.entity.Account;
import main.com.java.entity.Customer;
import main.com.java.entity.OrderItem;
import main.com.java.service.domain.interfaces.OrderItemService;

@Controller
@RequestMapping("/user")
public class OrderItemController {

    private OrderItemService orderItemService;
    private UsersService usersService;
    private AccountService accountService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService, UsersService usersService, AccountService accountService) {
        this.orderItemService = orderItemService;
        this.usersService = usersService;
        this.accountService = accountService;
    }

    @GetMapping("/makeTransfer")
    public String makeTransfer(Model theModel) {

        OrderItem theOrderItem = new OrderItem();

        theModel.addAttribute("orderitem", theOrderItem);

        return "transfer-form";
    }

    @PostMapping("/saveTransfer")
    public String saveTransfer(@ModelAttribute("orderitem") OrderItem theOrderItem,
                               @ModelAttribute("account") Account account,
                               @RequestParam("accountNumberSender") String Send,
                               @RequestParam("accountNumberReceiver") String Rec,
                               @RequestParam("amount") long amount) {
        orderItemService.saveTransfer(theOrderItem, account, Send, Rec, amount);
        return "redirect:/user/panel";
    }

    @RequestMapping("/panel")
    public String listCustomers(Model theModel) {
        OrderItemFilter orderItemFilter = new OrderItemFilter(usersService, orderItemService, accountService);
        List<OrderItem> theOrderItems = orderItemFilter.getSenderOrderItem();
        theModel.addAttribute("orderItems", theOrderItems);
        return "indexUser";
    }


}
