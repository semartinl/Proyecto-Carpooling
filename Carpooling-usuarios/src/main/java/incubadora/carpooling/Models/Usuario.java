package incubadora.carpooling.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuario {
    @JsonProperty("usuario_id")
    private Long usuarioId;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("password")
    private String password;
    @JsonProperty("email")
    private String email;
    @JsonProperty("organización")
    private String organizacion;

    public Usuario() {
    }

    public Usuario(Long usuarioId, String nombre, String password, String email, String organizacion) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.organizacion = organizacion;
    }

    public Usuario(String nombre, String password, String email) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }

    public Usuario(String nombre, String password, String email, String organizacion) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.organizacion = organizacion;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }
}
