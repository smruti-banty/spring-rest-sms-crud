package org.jt.finalsms.service;

import java.util.List;

import org.jt.finalsms.model.Student;
import org.jt.finalsms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(String id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public Student getStudentByRoll(int roll) {
        return studentRepository.findByRoll(roll).orElseThrow();
    }

    public Student updateStudent(String id, Student student) {
        if (!studentRepository.existsById(id))
            throw new RuntimeException("Student not found");

        student.setId(id);
        studentRepository.save(student);

        return student;
    }

    public Student deleteById(String id) {
        var student = getStudent(id);
        studentRepository.delete(student);
        return student;
    }
}
