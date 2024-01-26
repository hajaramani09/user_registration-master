package codingtechniques.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import codingtechniques.model.Responsable;

@Transactional
@RepositoryRestResource(exported = false)
public interface ResponsableRepositories extends JpaRepository<Responsable, Integer> {

    public Optional<Responsable> findByEmail(String email);


    
}
