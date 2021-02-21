package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.entity.Exterior;
import ru.geekbrains.entity.Interior;

import java.util.Optional;

public interface  InteriorRepository extends JpaRepository<Interior, Long> {
    @Query("select i from  Interior as i  where i.id =:Id")
    Optional<Interior> findById(Long Id);

    @Query("select i from  Interior as i  where i.id =:Id")
    Interior findById2(Long Id);
}

