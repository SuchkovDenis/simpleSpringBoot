package com.geekbrains.students.servises;

import com.geekbrains.students.entities.Student;
import com.geekbrains.students.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Student get(Long id) {
        return studentsRepository.findById(id).get();
    }

    public List<Student> getAll() {
        return (List<Student>) studentsRepository.findAll();
    }

    public void delete(Long id) {
        studentsRepository.deleteById(id);
    }

    public void add(Student student) {
        studentsRepository.save(student);
    }
/*    public void delete(Long id) {
        studentsRepository.DeleteById(id);
    }
*/
    public void update(Student student) {
        studentsRepository.save(student);
    }

}
