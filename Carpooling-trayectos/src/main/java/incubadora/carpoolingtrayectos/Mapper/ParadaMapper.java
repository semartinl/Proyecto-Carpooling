package incubadora.carpoolingtrayectos.Mapper;

import incubadora.carpoolingtrayectos.Entities.ParadaEntity;
import incubadora.carpoolingtrayectos.Entities.TrayectoEntity;
import incubadora.carpoolingtrayectos.Models.Parada;

import java.util.List;
import java.util.stream.Collectors;

public class ParadaMapper {

    // Convertir de ParadaEntity a Parada
    public static Parada toModel(ParadaEntity entity) {
        if (entity == null) {
            return null;
        }

        Parada model = new Parada();
        model.setParadaId(entity.getParadaId());
        model.setTrayectoId(entity.getTrayecto() != null ? entity.getTrayecto().getTrayectoId() : null);
        model.setLugar(entity.getLugar());
        model.setOrden(entity.getOrden());

        return model;
    }

    // Convertir de Parada a ParadaEntity
    public static ParadaEntity toEntity(Parada model, TrayectoEntity trayectoEntity) {
        if (model == null) {
            return null;
        }

        ParadaEntity entity = new ParadaEntity();
        entity.setParadaId(model.getParadaId());
        entity.setLugar(model.getLugar());
        entity.setOrden(model.getOrden());
        entity.setTrayecto(trayectoEntity);  // Asignar el TrayectoEntity correspondiente

        return entity;
    }

    // Convertir lista de ParadaEntity a lista de Parada
    public static List<Parada> toModelList(List<ParadaEntity> entities) {
        return entities.stream()
                .map(ParadaMapper::toModel)
                .collect(Collectors.toList());
    }

    // Convertir lista de Parada a lista de ParadaEntity
    public static List<ParadaEntity> toEntityList(List<Parada> models, TrayectoEntity trayectoEntity) {
        return models.stream()
                .map(model -> toEntity(model, trayectoEntity))
                .collect(Collectors.toList());
    }
}

