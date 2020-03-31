package pl.skaler12.spring_mvc_jpa_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;
import pl.skaler12.spring_mvc_jpa_security.domain.Student;
import pl.skaler12.spring_mvc_jpa_security.domain.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentRepository.getAllStudents());
    }

    public void saveStudent(Student student) {
        studentRepository.createStudent(student);
    }
    public void deleteStudent(int id){
        studentRepository.deleteStudent(id);
    }

    public Student getStudent(Integer id) {
        return studentRepository.getStudentById(id);
    }
}
