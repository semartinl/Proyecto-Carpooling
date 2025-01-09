package incubadora.carpoolingtrayectos.Api;

import incubadora.carpoolingtrayectos.Entities.TrayectoEntity;
import incubadora.carpoolingtrayectos.Mapper.TrayectoMapper;
import incubadora.carpoolingtrayectos.Models.Trayecto;
import incubadora.carpoolingtrayectos.Repositories.TrayectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/trayectos")
@CrossOrigin(origins = "http://localhost:5173")
public class TrayectosController {

    @Autowired
    private TrayectoRepository trayectoRepository;

    public TrayectosController() {}

    @PostMapping(consumes = { "application/json", "application/xml" })
    public ResponseEntity<String> crearTrayecto(@RequestBody Trayecto trayecto) {
        trayectoRepository.save(TrayectoMapper.toEntity(trayecto));
        return ResponseEntity.ok("Creado trayecto " + trayecto.getTrayectoId());
    }

    @PostMapping(consumes = { "application/x-www-form-urlencoded" })
    public ResponseEntity<Trayecto> crearTrayectoForm(@ModelAttribute Trayecto trayecto) {
        trayectoRepository.save(TrayectoMapper.toEntity(trayecto));
        return ResponseEntity.ok(trayecto);
    }

    @GetMapping(path = "/{id}"/*, produces = { "application/json", "application/xml" }*/)
    public ResponseEntity<Trayecto> obtenerTrayecto(@PathVariable Long id) {

        try {
            Trayecto trayecto = TrayectoMapper.toModel(trayectoRepository.findById(id).get());
            System.out.println(trayecto.getHoraSalida());
            return ResponseEntity.ok(trayecto);
        }catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }


    }

    @GetMapping(path = "/user/{id}"/*, produces = { "application/json", "application/xml" }*/)
    public ResponseEntity<List<Trayecto>> obtenerTrayectoByUserId(@PathVariable Long id) {

        try {
            List<Trayecto> trayecto = TrayectoMapper.toModelList(trayectoRepository.findByUsuarioId(id));
            return ResponseEntity.ok(trayecto);
        }catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }


    }

    @PostMapping(path = "/buscar", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<List<Trayecto>> buscarTrayectos(
            @RequestParam("origen") String origen,
            @RequestParam("destino") String destino,
            @RequestParam("hora_salida") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime horaSalida) {

//        List<TrayectoEntity> resultados = trayectoRepository.findAll().stream()
//                .filter(trayecto -> trayecto.getOrigen().equalsIgnoreCase(origen))
//                .filter(trayecto -> trayecto.getDestino().equalsIgnoreCase(destino))
////                .filter(trayecto -> trayecto.getHoraSalida().equals(horaSalida))
//                .toList();
        
        LocalDateTime formattedTime = TrayectoMapper.formattTime(horaSalida.toString(),"yyyy-MM-dd HH:mm");

        List<TrayectoEntity> resultados = trayectoRepository.findByOrigenAndDestinoAndHoraSalida(origen, destino, formattedTime);



        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(TrayectoMapper.toModelList(resultados));
    }

    /*@GetMapping(produces = { "application/json", "application/xml" })*/
    @GetMapping
    public ResponseEntity<List<Trayecto>> obtenerTodosTrayectos() {
        List<Trayecto> trayectos = TrayectoMapper.toModelList(trayectoRepository.findAll());
        return ResponseEntity.ok(trayectos);
    }

    @PutMapping(path = "/{id}", consumes = { "application/json", "application/xml" })
    public ResponseEntity<String> actualizarTrayecto(@PathVariable Long id, @RequestBody Trayecto trayecto) {
        TrayectoEntity aux = trayectoRepository.findById(id).orElse(null);
        if(aux == null) {
            return ResponseEntity.notFound().build();
        }
        trayectoRepository.save(TrayectoMapper.toEntity(trayecto));
        return ResponseEntity.ok("Trayecto actualizado");
    }

    @PutMapping(path = "/{id}", consumes = { "application/x-www-form-urlencoded" })
    public ResponseEntity<Trayecto> modificarTrayectoForm(@PathVariable Long id,@ModelAttribute Trayecto trayecto) { //AQUI SE ES OBLIGATORIO PONER EN EL FORM PARAM EL ID DEL TRAYECTO

        TrayectoEntity aux = trayectoRepository.findById(id).orElse(null);
        if(aux == null) {
            return ResponseEntity.notFound().build();
        }
        trayectoRepository.save(TrayectoMapper.toEntity(trayecto));
        return ResponseEntity.ok(trayecto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTrayecto(@PathVariable Long id) {
        trayectoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
