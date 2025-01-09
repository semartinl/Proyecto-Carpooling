package incubadora.carpoolingtrayectos.Api;

import incubadora.carpoolingtrayectos.Entities.ParadaEntity;
import incubadora.carpoolingtrayectos.Entities.TrayectoEntity;
import incubadora.carpoolingtrayectos.Mapper.ParadaMapper;
import incubadora.carpoolingtrayectos.Models.Parada;
import incubadora.carpoolingtrayectos.Repositories.ParadaRepository;
import incubadora.carpoolingtrayectos.Repositories.TrayectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paradas")
@CrossOrigin(origins = "http://localhost:5173")
public class ParadasController {

    @Autowired
    private ParadaRepository paradaRepository;
    @Autowired
    private TrayectoRepository trayectoRepository;
    // Constructor opcional si necesitas inicializaciones específicas
    public ParadasController() {}

    @PostMapping(
            consumes = { "application/json", "application/xml" },
            produces = { "application/json", "application/xml" }
    )
    public ResponseEntity<Void> crearParada(@RequestBody Parada paradaDto) {
        // Convertir Parada a ParadaEntity y guardar en la base de datos
        TrayectoEntity trayecto = trayectoRepository.findById(paradaDto.getTrayectoId()).orElse(null);
        if(trayecto == null) {
            return ResponseEntity.notFound().build();
        }
        ParadaEntity save = ParadaMapper.toEntity(paradaDto, trayecto);

        ParadaEntity savedEntity = paradaRepository.save(save);
        return ResponseEntity.ok().build();
    }

    @PostMapping(
            consumes = { "application/x-www-form-urlencoded" },
            produces = { "application/json", "application/xml" }
    )
    public ResponseEntity<Parada> crearParadaForm(@ModelAttribute Parada paradaDto) {
        // Convertir Parada a ParadaEntity y guardar en la base de datos
        TrayectoEntity trayecto = trayectoRepository.findById(paradaDto.getTrayectoId()).orElse(null);
        if(trayecto == null) {
            return ResponseEntity.notFound().build();
        }
        ParadaEntity save = ParadaMapper.toEntity(paradaDto, trayecto);

        ParadaEntity savedEntity = paradaRepository.save(save);
        return ResponseEntity.ok(ParadaMapper.toModel(savedEntity));

    }

    @GetMapping(
            path = "/{id}",
            produces = { "application/json", "application/xml" }
    )
    public ResponseEntity<Parada> obtenerParada(@PathVariable Long id) {
        ParadaEntity aux = paradaRepository.findById(id).orElse(null);
        if(aux == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ParadaMapper.toModel(aux));
    }

    @GetMapping(produces = { "application/json", "application/xml" })
    public ResponseEntity<List<Parada>> obtenerTodasParadas() {
        List<ParadaEntity> paradas = paradaRepository.findAll();

        return ResponseEntity.ok(ParadaMapper.toModelList(paradas));
    }

    @PutMapping(
            path = "/{id}",
            consumes = { "application/json", "application/xml" },
            produces = { "application/json", "application/xml" }
    )
    public ResponseEntity<Void> actualizarParada(@PathVariable Long id, @RequestBody Parada paradaDto) {
        ParadaEntity paradaEntity = paradaRepository.findById(id).orElse(null);
        if (paradaEntity == null) {
            return ResponseEntity.notFound().build();
        }
        // Convertir Parada a ParadaEntity y guardar en la base de datos
        TrayectoEntity trayecto = trayectoRepository.findById(paradaDto.getTrayectoId()).orElse(null);
        ParadaEntity save = ParadaMapper.toEntity(paradaDto, trayecto);

        ParadaEntity savedEntity = paradaRepository.save(save);
        return ResponseEntity.ok().build();
    }
    @PutMapping(
            path = "/{id}",
            consumes = { "application/x-www-form-urlencoded" },
            produces = { "application/json", "application/xml" }
    )
    public ResponseEntity<Void> actualizarParadaForm(@PathVariable Long id, @ModelAttribute Parada paradaDto) {
        ParadaEntity paradaEntity = paradaRepository.findById(id).orElse(null);
        if (paradaEntity == null || paradaEntity.getParadaId() != id) {
            return ResponseEntity.notFound().build();
        }
        // Convertir Parada a ParadaEntity y guardar en la base de datos
        TrayectoEntity trayecto = trayectoRepository.findById(paradaDto.getTrayectoId()).orElse(null);
        ParadaEntity save = ParadaMapper.toEntity(paradaDto, trayecto);
        save.setParadaId(id);
        ParadaEntity savedEntity = paradaRepository.save(save);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarParada(@PathVariable Long id) {
        if (paradaRepository.existsById(id)) {
            paradaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
