package incubadora.carpoolingtrayectos.Entities;

import incubadora.carpoolingtrayectos.Models.Trayecto;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "Trayectos")

public class TrayectoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trayectoId;




    private Long usuarioId;


    private String origen;
    private String destino;
    private @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime horaSalida;

    private @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime horaLlegada;
    private int num_plazas_max;

    public TrayectoEntity() {

    }

    public TrayectoEntity(Long trayectoId, String origen, String destino, LocalDateTime horaSalida, LocalDateTime horaLlegada) {
        this.trayectoId = trayectoId;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.num_plazas_max = 4; //Por defecto, se establece a 4, que suele ser el número de plazas de un coche normal.
    }

    public TrayectoEntity(String origen, String destino, LocalDateTime horaSalida, LocalDateTime horaLlegada) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.num_plazas_max = 4; //Por defecto, se establece a 4, que suele ser el número de plazas de un coche normal.

    }

    public TrayectoEntity(String origen, String destino, LocalDateTime horaSalida, LocalDateTime horaLlegada, int num_plazas_max) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.num_plazas_max = num_plazas_max;
    }

    public TrayectoEntity(Long trayectoId, String origen, String destino, LocalDateTime horaSalida, LocalDateTime horaLlegada, int num_plazas_max) {
        this.trayectoId = trayectoId;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.num_plazas_max = num_plazas_max;
    }

    public TrayectoEntity(Long trayectoId,Long usuarioId, String origen, String destino, LocalDateTime horaSalida, LocalDateTime horaLlegada, int num_plazas_max) {
        this.trayectoId = trayectoId;
        this.usuarioId = usuarioId;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.num_plazas_max = num_plazas_max;
    }

    public Long getTrayectoId() {
        return trayectoId;
    }

    public void setTrayectoId(Long trayectoId) {
        this.trayectoId = trayectoId;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getNum_plazas_max() {
        return num_plazas_max;
    }

    public void setNum_plazas_max(int num_plazas_max) {
        this.num_plazas_max = num_plazas_max;
    }
}



