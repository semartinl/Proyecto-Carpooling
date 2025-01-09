package incubadora.carpooling.Mapper;

import incubadora.carpooling.Entities.UserEntity;
import incubadora.carpooling.Models.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    // Convierte UserEntity a Usuario (modelo de la API)
    public static Usuario toModel(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(userEntity.getUsuarioId());
        usuario.setNombre(userEntity.getNombre());
        usuario.setPassword(userEntity.getPassword());
        usuario.setEmail(userEntity.getEmail());
        usuario.setOrganizacion(userEntity.getOrganizacion());
        return usuario;
    }

    // Convierte Usuario (modelo de la API) a UserEntity
    public static UserEntity toEntity(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsuarioId(usuario.getUsuarioId());
        userEntity.setPassword(usuario.getPassword());
        userEntity.setNombre(usuario.getNombre());
        userEntity.setEmail(usuario.getEmail());
        userEntity.setOrganizacion(usuario.getOrganizacion());
        return userEntity;
    }

    // Convierte una lista de UserEntity a una lista de Usuario
    public static List<Usuario> toModelList(List<UserEntity> userEntities) {
        if (userEntities == null) {
            return null;
        }
        return userEntities.stream()
                .map(UserMapper::toModel)
                .collect(Collectors.toList());
    }

    // Convierte una lista de Usuario a una lista de UserEntity
    public static List<UserEntity> toEntityList(List<Usuario> usuarios) {
        if (usuarios == null) {
            return null;
        }
        return usuarios.stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());
    }
}
