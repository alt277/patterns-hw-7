package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Picture;

@Repository
public interface PictureRepository extends JpaRepository <Picture, Long> {
}
