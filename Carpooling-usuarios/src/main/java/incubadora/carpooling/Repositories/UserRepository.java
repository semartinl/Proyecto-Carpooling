package incubadora.carpooling.Repositories;


import incubadora.carpooling.Entities.UserEntity;
import incubadora.carpooling.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);


    Optional<UserEntity> findByNombre(String nombre);

    /*List<UserEntity> findByOrganizacion(String organizacion);*/
}
