package Dao;

import Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<AppUser,Long> {

    /*
    findByID
    findAll
    save
    delete
     */

    @Query("select u from AppUser u where u.idUser = :id")
    public AppUser donnerUserSelonLeNom(@Param(value = "id") Long id);

    @Query("select u from AppUser u")
    public List<AppUser> donnerTousLesUser();

    @Query("select u from AppUser u where u.age > :age")
    public List<AppUser> donnerTousLesUserSelonLage(@Param(value = "age") int age);

    public AppUser findByNom(String nom);


}
