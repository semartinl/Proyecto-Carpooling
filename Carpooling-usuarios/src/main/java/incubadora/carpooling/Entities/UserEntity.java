package incubadora.carpooling.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    private String nombre;
    @Column(unique = true)
    private String email;
    private String password;

    /*@ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;*/
    private String Organizacion;

    public UserEntity() {

    }

    public UserEntity(String nombre, String email, String password, String organizacion) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.Organizacion = organizacion;
    }

    public UserEntity(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganizacion() {
        return Organizacion;
    }

    public void setOrganizacion(String organizacion) {
        Organizacion = organizacion;
    }
}



