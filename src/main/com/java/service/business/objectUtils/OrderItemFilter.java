package main.com.java.service.business.objectUtils;

import main.com.java.entity.Account;
import main.com.java.entity.OrderItem;
import main.com.java.entity.Users;
import main.com.java.service.domain.interfaces.AccountService;
import main.com.java.service.domain.interfaces.OrderItemService;
import main.com.java.service.domain.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.*;

public class OrderItemFilter {

    private OrderItemService orderItemService;
    private AccountService accountService;

    @Autowired
    public OrderItemFilter(OrderItemService orderItemService, AccountService accountService) {
        this.orderItemService = orderItemService;
        this.accountService = accountService;
    }

    public List<OrderItem> getSenderOrderItem(){
        UserRecognizer userRecognizer = new UserRecognizer(accountService);
        return orderItemService.getOrderItemListSender(userRecognizer.getAccountNumber());
    }

    public List<OrderItem> getReceiverOrderItem(){
        UserRecognizer userRecognizer = new UserRecognizer(accountService);
        return orderItemService.getOrderItemListReceiver(userRecognizer.getAccountNumber());
    }

}
