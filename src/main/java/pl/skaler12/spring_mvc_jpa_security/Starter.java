package pl.skaler12.spring_mvc_jpa_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.skaler12.spring_mvc_jpa_security.domain.Student;
import pl.skaler12.spring_mvc_jpa_security.domain.repository.StudentRepository;
import pl.skaler12.spring_mvc_jpa_security.service.StudentService;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {
    @Value("${opis.tak:czesc}")
    String siemanko;

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... strings) throws Exception { System.out.println("Witaj świecie!");

        Student student2 = new Student();
        student2.setImie("Kamil");
        student2.setWiek(20);

        studentRepository.createStudent(student2);

        Student student1 = new Student();
        student1.setImie("Wojtek");
        student1.setWiek(40);


        studentRepository.createStudent(student1);

        System.out.println(siemanko);

    }

}
