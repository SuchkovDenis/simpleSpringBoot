package com.geekbrains.students.repositories;

import com.geekbrains.students.entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Long> {

/*    @Modifying
    void DeleteById(Long id);



    @Transactional
    @Modifying
    @Query("update Student s set s.name = ?1, s.age = ?2 where s.id = ?3")
    void updateStudentById(String name, int age, Long id);

*/
}
