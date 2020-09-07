package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookstoreController {
	@GetMapping("/index")
	public String getBookstore(Model model) {
		model.addAttribute("model", model);
		return "index";
	}
}
