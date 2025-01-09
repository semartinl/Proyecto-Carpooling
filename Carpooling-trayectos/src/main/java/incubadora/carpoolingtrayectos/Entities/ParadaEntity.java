package incubadora.carpoolingtrayectos.Entities;

import incubadora.carpoolingtrayectos.Models.Parada;
import incubadora.carpoolingtrayectos.Models.Trayecto;
import jakarta.persistence.*;

@Entity
@Table(name = "Paradas")

public class ParadaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paradaId;
    private String lugar;
    private int orden;

    @ManyToOne
    @JoinColumn(name = "trayecto_id")
    private TrayectoEntity trayecto;

    public ParadaEntity(Long paradaId, String lugar, int orden, TrayectoEntity trayecto) {
        this.paradaId = paradaId;
        this.lugar = lugar;
        this.orden = orden;
        this.trayecto = trayecto;
    }

    public ParadaEntity(Long paradaId, TrayectoEntity trayecto, String lugar, int orden) {
        this.paradaId = paradaId;
        this.trayecto = trayecto;
        this.lugar = lugar;
        this.orden = orden;
    }

    public ParadaEntity() {

    }

    public Long getParadaId() {
        return paradaId;
    }

    public void setParadaId(Long paradaId) {
        this.paradaId = paradaId;
    }

    public TrayectoEntity getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(TrayectoEntity trayecto) {
        this.trayecto = trayecto;
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



