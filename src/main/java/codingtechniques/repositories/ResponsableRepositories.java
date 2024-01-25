package codingtechniques.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import codingtechniques.model.Responsable;

@Repository
@Transactional
@EnableJpaRepositories
public interface ResponsableRepositories extends JpaRepository<Responsable, Integer> {

    public Optional<Responsable> findByEmail(String email);
}
