package Dao;

import Entity.CarteAcces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarteAccesRepository extends JpaRepository<CarteAcces,Long> {
    /*@Query("select c from CarteAcces c join c.user ")
    public List<CarteAcces> getAdresseList();
    */
}
