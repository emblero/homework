package homework.homework.service.impl;

import homework.homework.model.Locality;
import homework.homework.repository.InMemoryStudentDAO;
import homework.homework.service.AttractionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class InMemoryStudentServiceImpl implements AttractionService {
    private final InMemoryStudentDAO repository;
    @Override
    public List<Locality> findAllStudent() {
        return repository.findAllStudent();
    }

    @Override
    public Locality saveStudent(Locality locality) {
        return repository.saveStudent(locality);
    }

    @Override
    public Locality findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Locality updateStudent(Locality locality) {
        return repository.updateStudent(locality);
    }

    @Override
    public void deleteStudent(String email) {
        repository.deleteStudent(email);
    }
}
