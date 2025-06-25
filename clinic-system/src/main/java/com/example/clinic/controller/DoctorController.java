
package com.example.clinic.controller;

import com.example.clinic.dto.DoctorAvailabilityDTO;
import com.example.clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/availability")
    public ResponseEntity<?> getAvailability(@RequestParam Long doctorId, @RequestParam String date) {
        return ResponseEntity.ok(doctorService.getAvailability(doctorId, date));
    }
}
