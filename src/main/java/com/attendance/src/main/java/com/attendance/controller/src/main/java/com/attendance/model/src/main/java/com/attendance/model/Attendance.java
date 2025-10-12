package com.attendance.model;

public class Attendance {
    private int employeeId;
    private String status;

    public Attendance() {}
    public Attendance(int employeeId, String status) {
        this.employeeId = employeeId;
        this.status = status;
    }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
