package incubadora.carpoolingreservas.API;

import incubadora.carpoolingreservas.Entities.ReservaEntity;
import incubadora.carpoolingreservas.Model.Reserva;
import incubadora.carpoolingreservas.Repositories.ReservaRepository;
import incubadora.carpoolingreservas.Mapper.ReservaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    // Obtener todas las reservas
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<ReservaEntity> reservaEntities = reservaRepository.findAll();
        List<Reserva> reservas = ReservaMapper.toModelList(reservaEntities);
        return ResponseEntity.ok(reservas);
    }

    // Obtener reservas por trayectoId
    @GetMapping(value = "/trayecto/{trayectoId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Reserva>> getReservasByTrayectoId(@PathVariable Long trayectoId) {
        List<ReservaEntity> reservaEntities = reservaRepository.findByTrayectoId(trayectoId);
        List<Reserva> reservas = ReservaMapper.toModelList(reservaEntities);
        return ResponseEntity.ok(reservas);
    }

    // Obtener reservas por userId
    @GetMapping(value = "/usuario/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Reserva>> getReservasByUserId(@PathVariable Long userId) {
        List<ReservaEntity> reservaEntities = reservaRepository.findByUserId(userId);
        List<Reserva> reservas = ReservaMapper.toModelList(reservaEntities);
        return ResponseEntity.ok(reservas);
    }

    // Obtener una reserva por ID
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
        Optional<ReservaEntity> reservaEntity = reservaRepository.findById(id);
        return reservaEntity.map(reserva -> ResponseEntity.ok(ReservaMapper.toModel(reserva)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva reserva (acepta JSON, XML y form-urlencoded)
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Reserva> createReserva(
            @RequestParam(required = false) Long reservaId,
            @RequestParam Long userId,
            @RequestParam Long trayectoId,
            @RequestParam Long paradaId) {

        ReservaEntity reservaEntity = new ReservaEntity(userId, trayectoId, paradaId);
        ReservaEntity savedReserva = reservaRepository.save(reservaEntity);
        return new ResponseEntity<>(ReservaMapper.toModel(savedReserva), HttpStatus.CREATED);
    }

    @GetMapping (consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Reserva> getReservaByUserIdAndTrayectoId(

            @RequestParam Long userId,
            @RequestParam Long trayectoId
            ) {

        ReservaEntity reservaEntity = reservaRepository.findByUserIdAndTrayectoId(userId, trayectoId);

        return new ResponseEntity<>(ReservaMapper.toModel(reservaEntity), HttpStatus.OK);
    }

    // Actualizar una reserva existente (acepta JSON, XML y form-urlencoded)
    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Reserva> updateReserva(
            @PathVariable Long id,
            @RequestParam Long userId,
            @RequestParam Long trayectoId,
            @RequestParam Long paradaId) {

        return reservaRepository.findById(id)
                .map(existingReserva -> {
                    existingReserva.setUserId(userId);
                    existingReserva.setTrayectoId(trayectoId);
                    existingReserva.setParadaId(paradaId);
                    ReservaEntity updatedReserva = reservaRepository.save(existingReserva);
                    return ResponseEntity.ok(ReservaMapper.toModel(updatedReserva));
                }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar una reserva por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar todas las reservas
    @DeleteMapping
    public ResponseEntity<Void> deleteAllReservas() {
        reservaRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}

