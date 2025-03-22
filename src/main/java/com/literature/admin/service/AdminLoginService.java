package com.literature.admin.service;

import com.literature.admin.model.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminLoginService {
    String login(Admin admin);
}
