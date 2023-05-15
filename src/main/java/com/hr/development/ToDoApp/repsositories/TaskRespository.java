package com.hr.development.ToDoApp.repsositories;

import com.hr.development.ToDoApp.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRespository extends JpaRepository<Tasks,Integer> {
     List<Tasks> findByUserId(String userId);
}
