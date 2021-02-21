package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.entity.Exterior;

import java.util.Optional;

public interface  ExteriorRepository extends JpaRepository<Exterior, Long> {

    @Query("select e from  Exterior as e  where e.id =:Id")
    Optional<Exterior> findById(Long Id);

    @Query("select e from  Exterior as e  where e.id =:Id")
    Exterior findById2(Long Id);
}

