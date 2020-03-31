package pl.skaler12.spring_mvc_jpa_security.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.skaler12.spring_mvc_jpa_security.components.TimeComponent;
import pl.skaler12.spring_mvc_jpa_security.domain.Student;
import pl.skaler12.spring_mvc_jpa_security.domain.University;
import pl.skaler12.spring_mvc_jpa_security.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentControler {

    @Autowired
    StudentService studentService;
    @Autowired
    TimeComponent timeComponent;

   @RequestMapping("/students")
   public String getStudents(Model model){
     List<Student> allStudents = studentService.getAllStudents();
     model.addAttribute("allStudents",allStudents);
     model.addAttribute("timeComponent",timeComponent);
     return "students";
   }
   @RequestMapping("/addStudent")
    public String createStudent(Model model){
     model.addAttribute("student", new Student());
       model.addAttribute("timeComponent",timeComponent);
     return "studentform";
   }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String saveKnight(@Valid Student student,  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "studentform";
        } else {
            studentService.saveStudent(student);
            return "redirect:/students";
        }
    }
    @RequestMapping(value = "/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id){
       studentService.deleteStudent(id);
        return "redirect:/students";
    }
    @RequestMapping("/student")
    public String getStudent(@RequestParam("id") Integer id, Model model) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        model.addAttribute("timecomponent", timeComponent);
        return "student";
    }
    @RequestMapping("/403")
    public String getError(Model model){
        return "403";
    }

}
