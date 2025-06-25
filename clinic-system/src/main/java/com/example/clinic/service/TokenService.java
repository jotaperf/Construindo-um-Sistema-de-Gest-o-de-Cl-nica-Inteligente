
package com.example.clinic.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String generateToken(String email) {
        return "JWT_TOKEN";
    }

    public String getSecretKey() {
        return "SECRET_KEY";
    }
}
