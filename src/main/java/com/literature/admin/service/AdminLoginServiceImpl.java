package com.literature.admin.service;

import com.literature.admin.model.Admin;
import com.literature.admin.service.exception.IncorrectEmailOrPasswordException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
    @Value("${ADMIN_EMAIL}")
    private String adminEmail;
    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;
    @Value("${ADMIN_KEY}")
    private String adminKey;

    @Override
    public String login(Admin admin) {
        if (admin.getEmail().equals(adminEmail) && admin.getPassword().equals(adminPassword)) {
            return adminKey;
        }
        throw new IncorrectEmailOrPasswordException();
    }
}
