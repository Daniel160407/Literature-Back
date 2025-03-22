package com.literature.admin.controller;

import com.literature.admin.model.Admin;
import com.literature.admin.service.AdminLoginService;
import com.literature.admin.service.exception.IncorrectEmailOrPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminpanel/authorisation")
@CrossOrigin(origins = "*")
public class AdminAuthorisationController {
    private final AdminLoginService adminLoginService;

    @Autowired
    public AdminAuthorisationController(AdminLoginService adminLoginService) {
        this.adminLoginService = adminLoginService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Admin admin) {
        try {
            return ResponseEntity.ok(adminLoginService.login(admin));
        } catch (IncorrectEmailOrPasswordException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
