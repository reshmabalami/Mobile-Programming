package com.example.sending_data_to_remote_server;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    public static List<Student> getDummyStudents() {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("John Doe", "john.doe@example.com", "1234567890"));
        studentList.add(new Student("Jane Smith", "jane.smith@example.com", "9876543210"));
        studentList.add(new Student("Robert Johnson", "robert.johnson@example.com", "5555555555"));

        return studentList;
    }
}

