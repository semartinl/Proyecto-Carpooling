package incubadora.carpoolingtrayectos.Models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
@Validated
public class Trayecto {

    @JsonProperty("trayecto_id")
    private Long trayectoId;

    @JsonProperty("usuario_id")
    private Long usuarioId;

    @JsonProperty("origen")
    private String origen;

    @JsonProperty("destino")
    private String destino;

    @JsonProperty("hora_salida")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime horaSalida;

    @JsonProperty("hora_llegada")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime horaLlegada;

    @JsonProperty("num_plazas_max")
    private int num_plazas_max;

    public Trayecto() {
    }

    public Trayecto(Long trayectoId, Long usuarioId, String origen, String destino, LocalDateTime horaSalida, LocalDateTime horaLlegada, int num_plazas_max) {
        this.trayectoId = trayectoId;
        this.usuarioId = usuarioId;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.num_plazas_max = num_plazas_max;
    }

    public Trayecto(Long trayectoId, Long usuarioId, String origen, String destino, LocalDateTime horaSalida, LocalDateTime horaLlegada) {
        this.trayectoId = trayectoId;
        this.usuarioId = usuarioId;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.num_plazas_max = 4; //Numero medio de plazas de un coche
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getTrayectoId() {
        return trayectoId;
    }

    public void setTrayectoId(Long trayectoId) {
        this.trayectoId = trayectoId;
    }

    public int getNum_plazas_max() {
        return num_plazas_max;
    }

    public void setNum_plazas_max(int num_plazas_max) {
        this.num_plazas_max = num_plazas_max;
    }
}
