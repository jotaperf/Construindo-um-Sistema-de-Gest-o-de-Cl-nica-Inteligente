
package com.example.clinic.service;

import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    public String getAvailability(Long doctorId, String date) {
        return "Available times";
    }

    public String validateLogin(String email, String password) {
        return "Login valid";
    }
}
