import axios from 'axios';
import { constComunes } from '../Config/constantesComunes';

// const API_URL = constComunes['URL-Usuarios'];
const API_URL = import.meta.env.VITE_USUARIOS_URL // example URL
const path = "usuarios";

const usersService = {

    // Obtener todos los usuarios
    obtenerTodosUsuarios: async () => {
        const response = await axios.get(`${API_URL}${path}`);
        return response.data;
    },

    // Obtener un usuario por ID
    obtenerUsuarioPorId: async (id) => {
        const response = await axios.get(`${API_URL}${path}/${id}`);
        return response.data;
    },

    // Crear un nuevo usuario (JSON)
    crearUsuario: async (usuario) => {
        const response = await axios.post(`${API_URL}${path}`, usuario, {
            headers: { 'Content-Type': 'application/json' }
        });
        return response.data;
    },

    // Crear un nuevo usuario (form-urlencoded)
    crearUsuarioForm: async (usuarioForm) => {
        const response = await axios.post(`${API_URL}${path}`, usuarioForm, {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        });
        return response.data;
    },

    // Actualizar un usuario existente (JSON)
    actualizarUsuario: async (id, usuario) => {
        const response = await axios.put(`${API_URL}${path}/${id}`, usuario, {
            headers: { 'Content-Type': 'application/json' }
        });
        return response.data;
    },

    // Actualizar un usuario existente (form-urlencoded)
    actualizarUsuarioForm: async (id, usuarioForm) => {
        const response = await axios.put(`${API_URL}${path}/${id}`, usuarioForm, {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        });
        return response.data;
    },

    // Eliminar un usuario
    eliminarUsuario: async (id) => {
        const response = await axios.delete(`${API_URL}${path}/${id}`);
        return response;
    },

    // Insertar una lista de usuarios
    crearUsuariosBatch: async (usuarios) => {
        const response = await axios.post(`${API_URL}${path}/batch`, usuarios, {
            headers: { 'Content-Type': 'application/json' }
        });
        return response.data;
    },

    // Eliminar una lista de usuarios por ID
    eliminarUsuariosBatch: async (ids) => {
        const response = await axios.delete(`${API_URL}${path}/batch`, {
            data: ids,
            headers: { 'Content-Type': 'application/json' }
        });
        return response;
    },

    // Buscar usuarios por trayecto (ID de trayecto)
    obtenerUsuariosPorTrayectoId: async (trayectoId) => {
        const response = await axios.get(`${API_URL}${path}/trayecto/${trayectoId}`);
        return response.data;
    },

    // Buscar usuarios por reserva (ID de reserva)
    obtenerUsuariosPorReservaId: async (reservaId) => {
        const response = await axios.get(`${API_URL}${path}/reserva/${reservaId}`);
        return response.data;
    },
    login: async (usuario) => {
        const params = new URLSearchParams();
        params.append('username', usuario.username);
        params.append('password', usuario.password);
        const response = await axios.post(`${API_URL}${path}/login`, params, {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            });
        return response.data;
        }
};

export default usersService;
