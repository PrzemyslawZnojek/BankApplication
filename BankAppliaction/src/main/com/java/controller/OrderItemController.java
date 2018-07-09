package main.com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import main.com.java.service.OrderItemService;

@Controller
@RequestMapping("/user")
public class OrderItemController {
	
	//need to inject customerService
	@Autowired
	private OrderItemService orderItemService;
	
	@GetMapping("/makeTransfer")
	public String makeTransfer(Model theModel){
		
		//create model attribute to find
		OrderItem theOrderItem = new OrderItem();
		
		theModel.addAttribute("orderitem", theOrderItem);
		
		return "transfer-form";
	}
	
	@PostMapping("/saveTransfer")
	public String saveTransfer(@ModelAttribute("orderitem") OrderItem theOrderItem, @ModelAttribute("account") Account account,
			@RequestParam("accountNumberSender") String Send, @RequestParam("accountNumberReceiver") String Rec, @RequestParam("amount") long amount) {
		
		// save the customer using our service
		orderItemService.saveTransfer(theOrderItem, account, Send, Rec, amount);
		
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/panel")
	public String listCustomers(Model theModel) {
		
		// get customer from Service
		List<OrderItem> theOrderItems = orderItemService.getOrderItems();
		
		// add customer to the model
		theModel.addAttribute("orderItems", theOrderItems);
		
		return "indexUser";
	}

}
