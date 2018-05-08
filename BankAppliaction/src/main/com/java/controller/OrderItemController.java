package main.com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.com.java.entity.OrderItem;
import main.com.java.service.OrderItemService;

@Controller
@RequestMapping("/customer")
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
	public String saveTransfer(@ModelAttribute("orderitem") OrderItem theOrderItem) {
		
		// save the customer using our service
		orderItemService.saveTransfer(theOrderItem);
		
		return "redirect:/customer/list";
	}

}
