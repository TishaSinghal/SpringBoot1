package com.sabpaisa.edistrict.eDistrictHimachal.controller;

import com.sabpaisa.edistrict.eDistrictHimachal.service.UserInfoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/edistrict")
public class EdistrictController {

	@Autowired
    private UserInfoService userInfoService;
    
    @GetMapping("/form")
    public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("inside form controller");
    	ModelAndView mv=new ModelAndView("form");
        return mv;
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("keyy") String keyy,
                             @RequestParam("hash") String hash,
                             @RequestParam("salt") String salt,
                             @RequestParam("txnid") String txnid,
                             @RequestParam("amount") String amount,
                             @RequestParam("productinfo") String productinfo,
                             @RequestParam("udf1") String udf1,
                             @RequestParam("udf2") String udf2,
                             @RequestParam("udf3") String udf3,
                             @RequestParam("udf4") String udf4,
                             @RequestParam("udf5") String udf5,
                             @RequestParam("udf6") String udf6,
                             @RequestParam("udf7") String udf7,
                             @RequestParam("udf8") String udf8,
                             @RequestParam("udf9") String udf9,
                             @RequestParam("udf10") String udf10,
                             Model model) {

       //String encryptedValue = String.join("|", keyy, txnid, amount, productinfo, name, email, udf1, udf2, udf3, udf4, udf5, udf6, udf7, udf8, udf9, udf10, salt);
        String encryptedValue = keyy + "|" + txnid + "|" + amount + "|" + productinfo + "|" + name + "|" + email + "|" + udf1 + "|" + udf2 + "|" + udf3 + "|" + udf4 + "|" + udf5+ "|" + udf6 + "|" + udf7+ "|" + udf8 + "|" + udf9 + "|" + udf10 + "|" + salt;
        
        boolean isHashValid = userInfoService.compareHash(hash, encryptedValue);

        if (isHashValid) {
        	 model.addAttribute("name", name);
             model.addAttribute("email", email);
             System.out.println("model added");
        	//userInfoService.saveUserInfo(name, email, keyy);
        	System.out.println("Database stored");
            return "show"; 
        } else {
            model.addAttribute("error", "Hash validation failed!");
            return "error"; 
        }
    }
}
