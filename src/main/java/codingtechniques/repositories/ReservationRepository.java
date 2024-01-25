package codingtechniques.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import codingtechniques.model.Reservation;

@EnableJpaRepositories
@Repository
@Transactional

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    public Optional<Reservation> findByEmail(String email);

    public List<Reservation> findAllReservations();

    public void insert(Reservation reservation);

    public void update(Reservation reservation);

    public void delete(int id);

}
