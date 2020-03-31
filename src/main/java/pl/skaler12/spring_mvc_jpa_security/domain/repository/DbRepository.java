package pl.skaler12.spring_mvc_jpa_security.domain.repository;

import pl.skaler12.spring_mvc_jpa_security.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

    public class DbRepository implements StudentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Student>getAllStudents(){
       return em.createQuery("select c from Student c", Student.class).getResultList();
    }
    @Override
    @Transactional
    public void createStudent(String imie, int wiek){
        Student student =new Student(imie,wiek);
        em.persist(student);
    }
    @Override
    @Transactional
    public void createStudent(Student student){
        em.persist(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        em.remove(id);
    }

    @Override
    public void build(){

    }
    @Override
    public Student getStudentById(Integer id) {
        return em.find(Student.class, id);
    }
}
