package homework.homework.repository;

import homework.homework.model.Locality;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
@Repository
public class InMemoryStudentDAO {
    private final List<Locality> Localities = new ArrayList<>();
    public List<Locality> findAllStudent(){
        return Localities;
    }
    public Locality saveStudent(Locality locality) {
        Localities.add(locality);
        return locality;
    }

    public Locality findByEmail(String email) {
        return Localities.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Locality updateStudent(Locality locality) {
        var studentIndex = IntStream.range(0, Localities.size())
                .filter(index -> Localities.get(index).getEmail().equals(locality.getEmail()))
                .findFirst()
                .orElse(-1);
        if (studentIndex > -1) {
            Localities.set(studentIndex, locality);
            return locality;
        }
        return null;
    }

    public void deleteStudent(String email) {
        var student = findByEmail(email);
        if (student != null) {
            Localities.remove(student);
        }

    }
}
