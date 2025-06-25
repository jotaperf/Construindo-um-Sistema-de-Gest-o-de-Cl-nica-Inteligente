
package com.example.clinic.service;

import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    public String bookAppointment(Long doctorId, String dateTime) {
        return "Appointment booked";
    }

    public String getAppointments(Long doctorId, String date) {
        return "Appointments for date";
    }
}
