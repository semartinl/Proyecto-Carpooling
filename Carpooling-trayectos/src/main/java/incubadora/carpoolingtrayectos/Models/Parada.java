package incubadora.carpoolingtrayectos.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

@Validated
public class Parada {
    //Hola

    @JsonProperty("parada_id")
    private Long paradaId;

    @JsonProperty("trayecto_id")
    private Long trayectoId;

    @JsonProperty("lugar")
    private String lugar;

    @JsonProperty("orden")
    private int orden;

    public Parada() {
    }

    public Parada(Long paradaId, Long trayectoId, String lugar, int orden) {
        this.paradaId = paradaId;
        this.trayectoId = trayectoId;
        this.lugar = lugar;
        this.orden = orden;
    }

    public Long getParadaId() {
        return paradaId;
    }

    public void setParadaId(Long paradaId) {
        this.paradaId = paradaId;
    }

    public Long getTrayectoId() {
        return trayectoId;
    }

    public void setTrayectoId(Long trayectoId) {
        this.trayectoId = trayectoId;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}

