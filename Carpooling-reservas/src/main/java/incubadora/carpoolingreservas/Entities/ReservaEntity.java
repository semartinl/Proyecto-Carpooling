package incubadora.carpoolingreservas.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Reserva")
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservaId;
    private Long userId;
    private Long trayectoId;
    private Long paradaId;

    public ReservaEntity() {
    }

    public ReservaEntity(Long reservaId, Long userId, Long trayectoId, Long paradaId) {
        this.reservaId = reservaId;
        this.userId = userId;
        this.trayectoId = trayectoId;
        this.paradaId = paradaId;
    }

    public ReservaEntity(Long userId, Long trayectoId, Long paradaId) {
        this.userId = userId;
        this.trayectoId = trayectoId;
        this.paradaId = paradaId;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTrayectoId() {
        return trayectoId;
    }

    public void setTrayectoId(Long trayectoId) {
        this.trayectoId = trayectoId;
    }

    public Long getParadaId() {
        return paradaId;
    }

    public void setParadaId(Long paradaId) {
        this.paradaId = paradaId;
    }
}
