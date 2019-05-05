package com.realpacific.springboottodos;

import com.realpacific.springboottodos.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByUsername(String username);
}
