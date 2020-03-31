package pl.skaler12.spring_mvc_jpa_security.domain.repository;


import pl.skaler12.spring_mvc_jpa_security.domain.Student;
import pl.skaler12.spring_mvc_jpa_security.utils.Ids;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryRepository implements StudentRepository{
    //tworze mape studentow
    Map<Integer, Student> students = new HashMap<>();

    public InMemoryRepository() {

    }

    @Override
    public Collection<Student>getAllStudents(){
        return students.values();
    }
    @Override
    public void createStudent(String imie, int wiek){
       Student newStudent = new Student(imie, wiek);
        newStudent.setId(Ids.generateNewId(students.keySet()));
        students.put(newStudent.getId(),newStudent);
    }
    @Override
    public void createStudent(Student student){
        student.setId(Ids.generateNewId(students.keySet()));
    students.put(student.getId(),student);
    }
    @Override
    public void deleteStudent(int id){
        students.remove(id);
    }
    @Override
    public void build(){
        createStudent("karol",22);
    }

    @Override
    public Student getStudentById(Integer id) {
        return students.get(id);
    }
}
