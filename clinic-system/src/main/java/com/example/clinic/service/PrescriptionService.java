
package com.example.clinic.service;

import com.example.clinic.dto.PrescriptionDTO;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {

    public String save(PrescriptionDTO dto) {
        return "Prescription saved";
    }
}
