package com.attendance.controller;

import com.attendance.model.Attendance;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private List<Attendance> records = new ArrayList<>();

    @PostMapping
    public Attendance markAttendance(@RequestBody Attendance record) {
        records.add(record);
        return record;
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return records;
    }
}
