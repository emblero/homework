package homework.homework.controller;

import homework.homework.model.Locality;
import homework.homework.service.AttractionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private AttractionService service;
    @GetMapping
    public List<Locality> findAllStudent(){
        return service.findAllStudent();
    }
@PostMapping("save_student")
    public Locality saveStudent(@RequestBody Locality locality){
        return service.saveStudent(locality);
    }
@GetMapping("/{email}")
    public Locality findByEmail(@PathVariable String email){
        return service.findByEmail(email);
    }
@PutMapping("update_student")
    public Locality updateStudent(Locality locality){
        return service.updateStudent(locality);
    }
@DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email){
        service.deleteStudent(email);
    }
}
