package com.projet_Docker.app_web.repository;

import com.projet_Docker.app_web.DTO.UserNameOnly;
import com.projet_Docker.app_web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Méthode de base fournie par JpaRepository
    Optional<User> findById(Long id);

    // Trouver par nom (dérivé du nom de méthode)
    List<User> findByNom(String nom);

    // Trouver par prénom (ignore la casse)
    List<User> findByPrenomIgnoreCase(String prenom);

    @Query(value = "SELECT * FROM user WHERE nom LIKE %:keyword% OR prenom LIKE %:keyword%",
            nativeQuery = true)
    List<User> searchByKeyword(@Param("keyword") String keyword);

    // Requête de projection corrigée :
    @Query("SELECT new com.projet_Docker.app_web.DTO.UserNameOnly(u.nom, u.prenom) FROM User u")
    List<UserNameOnly> findAllNames();
}
