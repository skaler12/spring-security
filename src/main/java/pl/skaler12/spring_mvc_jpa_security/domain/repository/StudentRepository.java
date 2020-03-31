package pl.skaler12.spring_mvc_jpa_security.domain.repository;

import org.springframework.stereotype.Component;
import pl.skaler12.spring_mvc_jpa_security.domain.Student;

import java.util.Collection;

@Component
public interface StudentRepository  {

   public void createStudent(Student student);

   public void createStudent(String imie, int wiek);

   Collection <Student> getAllStudents();

   public void build();

   public void deleteStudent(int id);

   Student getStudentById(Integer id);
}
