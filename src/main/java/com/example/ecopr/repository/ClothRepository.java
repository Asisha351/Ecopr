package com.example.ecopr.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecopr.model.Cloth;
import java.util.Optional;

public interface ClothRepository extends JpaRepository<Cloth, Integer> {
    Optional<Cloth> findBycloth(String cloth);
}
