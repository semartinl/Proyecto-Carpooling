package incubadora.carpooling.Api;

import incubadora.carpooling.Models.Usuario;
import incubadora.carpooling.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import incubadora.carpooling.Entities.UserEntity;
import incubadora.carpooling.Mapper.UserMapper;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;


    private BCryptPasswordEncoder passwordEncoder;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<Usuario> usuarios = UserMapper.toModelList(userEntities);
        return ResponseEntity.ok(usuarios);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(user -> ResponseEntity.ok(UserMapper.toModel(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        UserEntity userEntity = UserMapper.toEntity(usuario);
        UserEntity savedUser = userRepository.save(userEntity);
        return new ResponseEntity<>(UserMapper.toModel(savedUser), HttpStatus.CREATED);
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Usuario> createUser(
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam String contraseña,
            @RequestParam String organizacion) {

        UserEntity userEntity = new UserEntity(nombre,email,contraseña,organizacion);
        if(userRepository.findByEmail(email).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        UserEntity savedUser = userRepository.save(userEntity);
        return new ResponseEntity<>(UserMapper.toModel(savedUser), HttpStatus.CREATED);
    }

    // Actualizar un usuario existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario usuario) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setNombre(usuario.getNombre());
                    existingUser.setEmail(usuario.getEmail());
                    existingUser.setPassword(usuario.getPassword());
                    existingUser.setOrganizacion(usuario.getOrganizacion());
                    UserEntity updatedUser = userRepository.save(existingUser);
                    return ResponseEntity.ok(UserMapper.toModel(updatedUser));
                }).orElse(ResponseEntity.notFound().build());
    }
    // Endpoint de login
    @PostMapping(value="/login", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        Optional<UserEntity> userEntityOptional;

        // Buscar por username
        if (username.contains("@")) {
            userEntityOptional = userRepository.findByEmail(username);  // Si contiene '@', buscar por email
        } else {
            userEntityOptional = userRepository.findByNombre(username); // Buscar por nombre de usuario
        }

        // Verificar si el usuario existe
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();

            // Comprobar que la contraseña es correcta
//            if (passwordEncoder.matches(password, userEntity.getPassword())) {
            if(userEntity.getPassword().equals(password)) {
                // Si la contraseña es correcta, iniciar sesión (Spring Security lo manejará automáticamente)
                return ResponseEntity.ok(UserMapper.toModel(userEntity));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

    @PutMapping(value = "/{id}", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Usuario> updateUser(
            @PathVariable Long id,
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam String contraseña,
            @RequestParam String organizacion) {

        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setNombre(nombre);
                    existingUser.setEmail(email);
                    existingUser.setPassword(contraseña);
                    existingUser.setOrganizacion(organizacion);
                    UserEntity updatedUser = userRepository.save(existingUser);
                    return ResponseEntity.ok(UserMapper.toModel(updatedUser));
                }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*// Buscar usuarios por organización
    @GetMapping("/organizacion/{organizacion}")
    public ResponseEntity<List<Usuario>> getUsersByOrganizacion(@PathVariable String organizacion) {
        List<UserEntity> userEntities = userRepository.findByOrganizacion(organizacion);
        List<Usuario> usuarios = UserMapper.toModelList(userEntities);
        return ResponseEntity.ok(usuarios);
    }*/

    // Insertar una lista de usuarios
    @PostMapping("/batch")
    public ResponseEntity<List<Usuario>> createUsersBatch(@RequestBody List<Usuario> usuarios) {
        List<UserEntity> userEntities = UserMapper.toEntityList(usuarios);
        List<UserEntity> savedUsers = userRepository.saveAll(userEntities);
        List<Usuario> savedUsuarios = UserMapper.toModelList(savedUsers);
        return new ResponseEntity<>(savedUsuarios, HttpStatus.CREATED);
    }

    // Eliminar una lista de usuarios por ID
    @DeleteMapping("/batch")
    public ResponseEntity<Void> deleteUsersBatch(@RequestBody List<Long> ids) {
        List<UserEntity> usersToDelete = userRepository.findAllById(ids);
        if (!usersToDelete.isEmpty()) {
            userRepository.deleteAll(usersToDelete);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar todos los usuarios
    @DeleteMapping
    public ResponseEntity<Void> deleteAllUsers() {
        userRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
