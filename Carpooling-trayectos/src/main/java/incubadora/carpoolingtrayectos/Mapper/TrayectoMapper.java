package incubadora.carpoolingtrayectos.Mapper;

import incubadora.carpoolingtrayectos.Entities.ParadaEntity;
import incubadora.carpoolingtrayectos.Entities.TrayectoEntity;
import incubadora.carpoolingtrayectos.Models.Trayecto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TrayectoMapper {

    // Convertir de TrayectoEntity a Trayecto
    public static Trayecto toModel(TrayectoEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Trayecto(
                entity.getTrayectoId(),
                entity.getUsuarioId(), // `usuarioId` es manejado por otra lógica, añadir si es necesario
                entity.getOrigen(),
                entity.getDestino(),
                entity.getHoraSalida(),
                entity.getHoraLlegada(),
                entity.getNum_plazas_max()
        );
    }

    // Convertir de Trayecto a TrayectoEntity
    public static TrayectoEntity toEntity(Trayecto model) {
        if (model == null) {
            return null;
        }

        return new TrayectoEntity(
                model.getTrayectoId(),
                model.getUsuarioId(),
                model.getOrigen(),
                model.getDestino(),
                model.getHoraSalida(),
                model.getHoraLlegada(),
                model.getNum_plazas_max()
        );
    }

    // Convertir lista de TrayectoEntity a lista de Trayecto
    public static List<Trayecto> toModelList(List<TrayectoEntity> entities) {
        return entities.stream()
                .map(TrayectoMapper::toModel)
                .collect(Collectors.toList());
    }

    // Convertir lista de Trayecto a lista de TrayectoEntity
    public static List<TrayectoEntity> toEntityList(List<Trayecto> models) {
        return models.stream()
                .map(TrayectoMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static LocalDateTime formattTime(String time, String format) {

        // Parseamos la entrada a un objeto LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(time);
        System.out.println(dateTime);
        // Definimos el formato de salida "yyyy-MM-dd HH:mm"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        // Formateamos el LocalDateTime al nuevo formato
        String formattedDate = dateTime.format(formatter);
        System.out.println(formattedDate);
        return LocalDateTime.parse(formattedDate, formatter);

    }
}

