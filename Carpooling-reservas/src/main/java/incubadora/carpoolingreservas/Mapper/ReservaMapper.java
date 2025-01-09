package incubadora.carpoolingreservas.Mapper;

import incubadora.carpoolingreservas.Entities.ReservaEntity;
import incubadora.carpoolingreservas.Model.Reserva;

import java.util.List;
import java.util.stream.Collectors;

public class ReservaMapper {

    public static Reserva toModel(ReservaEntity entity) {
        return new Reserva(
                entity.getReservaId(),
                entity.getUserId(),
                entity.getTrayectoId(),
                entity.getParadaId()
        );
    }

    public static ReservaEntity toEntity(Reserva model) {
        return new ReservaEntity(
                model.getReservaId(),
                model.getUserId(),
                model.getTrayectoId(),
                model.getParadaId()
        );
    }

    public static List<Reserva> toModelList(List<ReservaEntity> entities) {
        return entities.stream().map(ReservaMapper::toModel).collect(Collectors.toList());
    }

    public static List<ReservaEntity> toEntityList(List<Reserva> models) {
        return models.stream().map(ReservaMapper::toEntity).collect(Collectors.toList());
    }
}

