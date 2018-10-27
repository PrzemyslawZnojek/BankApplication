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

    private UsersService usersService;
    private OrderItemService orderItemService;
    private AccountService accountService;

    @Autowired
    public OrderItemFilter(UsersService usersService, OrderItemService orderItemService, AccountService accountService) {
        this.usersService = usersService;
        this.orderItemService = orderItemService;
        this.accountService = accountService;
    }

    public List<OrderItem> getSenderOrderItem(){
        try{
            return orderItemService.getOrderItemListSender(getAccountNumber());
        }catch (Exception e){
            e.printStackTrace();
            return orderItemService.getOrderItems();
        }
    }

    public List<OrderItem> getReceiverOrderItem(){
        return orderItemService.getOrderItemListReceiver(getAccountNumber());
    }

    private String getAccountNumber(){
        Account account = accountService.getAccountByUsername(getAuthenticatedPrincipalUsername());
        return account.getAccountNumber();
    }

    private String getAuthenticatedPrincipalUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
