package Dao;

import Entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse,Long> {

    /*
    findByID
    findAll
    save
    delete
     */
}
