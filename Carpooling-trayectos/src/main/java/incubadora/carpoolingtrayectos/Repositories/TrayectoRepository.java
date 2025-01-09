package incubadora.carpoolingtrayectos.Repositories;


import incubadora.carpoolingtrayectos.Entities.TrayectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TrayectoRepository extends JpaRepository<TrayectoEntity, Long> {
    List<TrayectoEntity> findByOrigenAndDestinoAndHoraSalida(String origen, String destino, LocalDateTime horaSalida);

    List<TrayectoEntity> findByOrigen(String origen);

    List<TrayectoEntity> findByDestino(String destino);

    List<TrayectoEntity> findByHoraSalidaBetween(LocalDateTime start, LocalDateTime end);

    List<TrayectoEntity> findByUsuarioId(Long id);
}

