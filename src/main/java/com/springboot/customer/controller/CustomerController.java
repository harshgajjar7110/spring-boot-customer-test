package com.springboot.customer.controller;

import com.springboot.customer.modal.Customer;
import com.springboot.customer.serviceimpl.CustomerServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

@Controller
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @PostConstruct
    private void faker() {
        //to produce fake data on startup
        String[] name = {"Jay", "ajay", "harsh", "vivek"};
        Long i = Long.valueOf(0);
        for (String firstname : name) {
            Customer person = new Customer(firstname, "Male", "dell@" + firstname + ".com", "777777777", "A/71", "colony" + i,
                    "Gujarat", "Gandhinagar", "382016", "india");
            i++;
            customerService.save(person);
        }
    }

    @GetMapping("/customer")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Customer> allCustomer = customerService.getAllCustomer();
        model.addAttribute("customers", allCustomer);
        return "List";
    }

    @GetMapping("customer/{id}")
    public String getCustomer(@PathVariable String id, Model model) throws NotFoundException {
        Customer customerById;
        customerById = customerService.getCustomerById(Long.valueOf(id));
        model.addAttribute("customer", customerById);
        return "index";
    }

    @PostMapping(path = {"customer", "customer/{id}"})
    public String postCustomer(@PathVariable(required = false) Integer id, @ModelAttribute Customer postCustomer) {

        if (Objects.nonNull(id)) {

            try {
                postCustomer.setId(Long.valueOf(id));
                customerService.updateCustomerId(postCustomer);
                return "redirect:/index";
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            customerService.save(postCustomer);
        }
        return "redirect:/index";

    }

}
