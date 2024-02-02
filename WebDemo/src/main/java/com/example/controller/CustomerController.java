package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Customer;
import com.example.helper.FileUploadHelper;
import com.example.service.CustomerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	FileUploadHelper fileuploadhelper;

	@GetMapping("/home")
	public ModelAndView findAllCustomers(@RequestParam("pageNumber") Optional<Integer> optional) {

		Page<Customer> page;
		if (optional.isPresent()) {
			int pageNumber = optional.get();
			page = customerService.findByPageNumber(pageNumber);
		} else {
			page = customerService.findAll();
		}

		int totalPages = page.getTotalPages();
		List<Integer> pageNumbers = new ArrayList<Integer>();

		for (int i = 1; i <= totalPages; i++) {
			pageNumbers.add(i);
		}
		ModelAndView mav = new ModelAndView();

		mav.addObject("pageNumbers", pageNumbers);
		mav.addObject("customers", page.getContent());
		mav.setViewName("customer-home");

		return mav;

	}

	@GetMapping("/home1/{pageNumber}")
	public ModelAndView findAllCustomersByPage(@PathVariable("pageNumber") int pageNumber) {

		Page<Customer> page = customerService.findByPageNumber(pageNumber);

		int totalPages = page.getTotalPages();
		List<Integer> pageNumbers = new ArrayList<Integer>();

		for (int i = 1; i <= totalPages; i++) {
			pageNumbers.add(i);
		}
		ModelAndView mav = new ModelAndView();

		mav.addObject("pageNumbers", pageNumbers);
		mav.addObject("customers", page.getContent());
		mav.setViewName("customer-home");

		return mav;

	}

	@GetMapping("/add-customer")
	public ModelAndView showCustomerForm() {

		Customer customer = new Customer();

		ModelAndView mav = new ModelAndView();

		mav.addObject("customer", customer);
		mav.setViewName("form");

		return mav;

	}

	@GetMapping("/update-customer")
	public ModelAndView updateCustomer(@RequestParam("id") int id) {

		ModelAndView mav = new ModelAndView();

		Customer customer = customerService.findById(id);

		mav.addObject("customer", customer);
		mav.setViewName("form");

		return mav;

	}

	@GetMapping("/delete-customer/{id}")
	public String deleteCustomerById(@PathVariable("id") int id) {

		System.out.println("delete hit====" + id);
		// Customer customer = customerService.findById(id);
		customerService.deleteFun(id);

		return "redirect:/customer/home";
	}

	@PostMapping("/submit-form")
	public ModelAndView submitForm(@Valid @ModelAttribute Customer customer, BindingResult result) {

		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {
			mav.addObject("customer", customer);
			mav.setViewName("customer-form");
			return mav;
		}

		MultipartFile file = customer.getFile();
		boolean uploadFile = fileuploadhelper.uploadFile(file);

		if (uploadFile) {
			String filename = file.getOriginalFilename();
			customer.setImagePath("/images/" + filename);
		}

		Customer save = customerService.SaveCutsomer(customer);

		mav.setViewName("redirect:/customer/home");
		return mav;
	}

	@GetMapping("/search-by-email")
	public ModelAndView searchByEmail(@RequestParam("searchEmail") String searchEmail) {

		List<Customer> customers = customerService.searchByEmail(searchEmail);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customers", customers);
		mav.setViewName("customer-home");

		return mav;

	}

	@GetMapping("/search-by-name")
	public ModelAndView searchByName(@RequestParam("searchName") String searchName) {

		List<Customer> customers = customerService.searchByName(searchName);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customers", customers);
		mav.setViewName("customer-home");

		return mav;

	}

}
