import React from 'react'
import reservasService from '../../Controllers/ReservasController'
import { useNavigate } from 'react-router-dom'

export default function CardTrayectoReserva({idReserva,trayecto}) {
  const navigate = useNavigate()
  const handleReserva = (event)=>{
    event.preventDefault()
    reservasService.eliminarReserva(idReserva).then((response)=>{
        console.log(response)
        navigate('/user/config/misReservas')
    })

  }

  return (
    
    <section className='card-container' key={trayecto.trayecto_id}>
   <div>
      <p>Trayecto: {trayecto.origen} → {trayecto.destino}</p>
      <p>Numero de plazas: {trayecto.num_plazas_max}</p>  
   </div>
   <div>
      Salida: {trayecto.hora_salida} 
   </div>
   <div>
        <button onClick={handleReserva}>Eliminar reserva</button>
   </div>
    </section>
  )
}