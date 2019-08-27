package com.demoproject.controller.paymentManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

    @GetMapping(value = "/payment-list")
    public String payment(){
        return "payment-management/payment-lists";
    }
}
