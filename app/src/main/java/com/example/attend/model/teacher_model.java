package com.example.attend.model;

public class teacher_model {
    String teacher_name , teacher_qualification , department , year , email , password , phone ;

    public teacher_model(String teacher_name, String teacher_qualification, String department, String year, String email, String password, String phone) {

        this.teacher_name = teacher_name;
        this.teacher_qualification = teacher_qualification;
        this.department = department;
        this.year = year;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_qualification() {
        return teacher_qualification;
    }

    public void setTeacher_qualification(String teacher_qualification) {
        this.teacher_qualification = teacher_qualification;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
