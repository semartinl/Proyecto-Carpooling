import axios from 'axios';
import { constComunes } from '../Config/constantesComunes';

// const API_URL = constComunes['URL-Reservas']; // Base URL para el microservicio de reservas
const API_URL = import.meta.env.VITE_RESERVAS_URL
const path = "reservas";

const reservasService = {
    // Obtener todas las reservas
    obtenerTodasReservas: async () => {
        const response = await axios.get(`${API_URL}${path}`, {
            headers: { 'Accept': 'application/json' }
        });
        return response.data;
    },
    obtenerReservaByUserIdAndTrayectoId: async (userId,trayecto) => {
        const response = await axios.get(`${API_URL}${path}`, {
            headers: { 'Accept': 'application/x-www-form-urlencoded' }
        });
        return response.data;
    },

    // Obtener una reserva por ID
    obtenerReservaPorId: async (id) => {
        const response = await axios.get(`${API_URL}${path}/${id}`, {
            headers: { 'Accept': 'application/json' }
        });
        return response.data;
    },

    // Crear una nueva reserva (form-urlencoded)
    crearReserva: async (reserva) => {
        const formData = new URLSearchParams();
        formData.append("userId", reserva.userId);
        formData.append("trayectoId", reserva.trayectoId);
        formData.append("paradaId", reserva.paradaId);

        const response = await axios.post(`${API_URL}${path}`, formData, {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        });
        return response.data;
    },

    // Actualizar una reserva existente (form-urlencoded)
    actualizarReserva: async (id, reserva) => {
        const formData = new URLSearchParams();
        formData.append("userId", reserva.userId);
        formData.append("trayectoId", reserva.trayectoId);
        formData.append("paradaId", reserva.paradaId);

        const response = await axios.put(`${API_URL}${path}/${id}`, formData, {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        });
        return response.data;
    },
     // Buscar reservas por trayectoId
    buscarReservasPorTrayectoId: async (trayectoId) => {
        const response = await axios.get(`${API_URL}${path}/trayecto/${trayectoId}`, {
            headers: { 'Accept': 'application/json' }
        });
        return response.data;
    },

    // Buscar reservas por userId
    buscarReservasPorUserId: async (userId) => {
        const response = await axios.get(`${API_URL}${path}/usuario/${userId}`, {
            headers: { 'Accept': 'application/json' }
        });
        return response.data;
    },

    // Eliminar una reserva por ID
    eliminarReserva: async (id) => {
        const response = await axios.delete(`${API_URL}${path}/${id}`);
        return response;
    },

    // Eliminar todas las reservas
    eliminarTodasReservas: async () => {
        const response = await axios.delete(`${API_URL}${path}`);
        return response;
    }
};

export default reservasService;
