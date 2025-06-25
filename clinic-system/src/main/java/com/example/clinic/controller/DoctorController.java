
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

    @GetMapping("/{userId}/{doctorId}/{date}/{token}")
    public ResponseEntity<?> getDoctorAvailability(
            @PathVariable Long userId,
            @PathVariable Long doctorId,
            @PathVariable String date,
            @PathVariable String token) {

        // Exemplo simples de validação do token (pode ser mais robusto com JWT etc.)
        if (!doctorService.validateToken(userId, token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        List<String> availability = doctorService.getAvailability(doctorId, date);

        return ResponseEntity.ok().body(Map.of(
            "doctorId", doctorId,
            "date", date,
            "availableTimes", availability
        ));
    }
}

