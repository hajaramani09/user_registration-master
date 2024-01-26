package codingtechniques.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import codingtechniques.model.Reservation;

@Repository
@Transactional
@RepositoryRestResource(exported = false)
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    public Optional<Reservation> findByEmail(String email);


  

}
