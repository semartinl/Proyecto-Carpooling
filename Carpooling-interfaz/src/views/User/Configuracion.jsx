import { useEffect, useState } from "react";
import React from "react";

import { Link, NavLink,Route, useMatch } from 'react-router-dom';

import { Routes } from "react-router-dom";


import './../../css/style-perfil-usuario.css';

export function Configuracion() {
    
    
    return (
        <main>
            <h1 className="titulo-configuracion">CONFIGURACIÓN DE LA CUENTA</h1>
            <div className="contenedor-perfil">
                <section className="card-perfil">
                    <h2>Información del perfil</h2>
                    <p>Actualiza tus datos personales.</p>
                    <NavLink to="/">Editar perfil</NavLink>
                </section>
                
                {/* <section className="card-perfil">
                    <h2>Tus alojamientos favoritos</h2>
                    <p>Revisa todos tus alojamientos favoritos</p>
                    <NavLink to="favorites">Ver mis alojamientos favoritos</NavLink>
                </section>
                
                <section className="card-perfil">
                    <h2>Mis propiedades registradas</h2>
                    <p>Gestiona, actualiza y revisa toda la información acerca de tus apartamentos favoritos</p>
                    <NavLink to="mis-alojamientos">Gestionar mis alojamientos</NavLink>
                </section> */}
                
                <section className="card-perfil">
                    <h2>Mis trayectos</h2>
                    <p>Recuerda y revisa tus trayectos publicacados</p>
                    <NavLink to="/user/config/misTrayectos">Ver mis trayectos</NavLink>
                </section>
                
                <section className="card-perfil">
                    <h2>Mis reservas</h2>
                    <p>Mira todas tus reservas de trayectos</p>
                    <NavLink to="/user/config/misReservas">Ver mis reservas de trayectos</NavLink>
                </section>
            </div>

        </main>
    );
}
