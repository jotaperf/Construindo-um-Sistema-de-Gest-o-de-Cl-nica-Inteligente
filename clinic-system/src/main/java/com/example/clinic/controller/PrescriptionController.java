
package com.example.clinic.controller;

import com.example.clinic.dto.PrescriptionDTO;
import com.example.clinic.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<?> savePrescription(@RequestBody PrescriptionDTO dto) {
        return ResponseEntity.ok(prescriptionService.save(dto));
    }
}
