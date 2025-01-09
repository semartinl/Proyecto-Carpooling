import axios from 'axios';
import { constComunes } from '../Config/constantesComunes';

// const API_URL = constComunes['URL-Trayectos'];
const API_URL = import.meta.env.VITE_TRAYECTOS_URL
const path = "trayectos";

const trayectosService = {
    crearTrayecto: async (trayecto) => {
        const response = await axios.post(`${API_URL}${path}`, trayecto, {
            headers: { 'Content-Type': 'application/json' },
        });
        return response;
    },
buscarTrayectos: async (origen, destino, horaSalida) => {
        const formData = new URLSearchParams();
        formData.append("origen", origen);
        formData.append("destino", destino);
        formData.append("hora_salida", horaSalida);

        const response = await axios.post(`${API_URL}${path}/buscar`, formData, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
                
            },
        });
        return response.data;
    },

    crearTrayectoForm: async (trayectoForm) => {
        const response = await axios.post(`${API_URL}${path}`, trayectoForm, {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded'},
        });
        return response;
    },

    obtenerTrayecto: async (id) => {
        const response = await axios.get(`${API_URL}${path}/${id}`);
        return response.data;
    },
    obtenerTrayectosByUserId: async (userId) => {
        const response = await axios.get(`${API_URL}${path}/user/${userId}`);
        return response.data;
    },

    obtenerTodosTrayectos: async () => {
        const response = await axios.get(`${API_URL}${path}`);
        return response.data;
    },

    actualizarTrayecto: async (id, trayecto) => {
        const response = await axios.put(`${API_URL}${path}/${id}`, trayecto, {
            headers: { 'Content-Type': 'application/json' },
        });
        return response;
    },

    modificarTrayectoForm: async (id, trayectoForm) => {
        const response = await axios.put(`${API_URL}${path}/${id}`, trayectoForm, {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
        });
        return response.data;
    },

    eliminarTrayecto: async (id) => {
        const response = await axios.delete(`${API_URL}${path}/${id}`);
        return response;
    }
};

export default trayectosService;
