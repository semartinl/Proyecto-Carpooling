import React, { useEffect, useState } from 'react'
import trayectosService from '../../Controllers/TrayectoControllers'
import CardTrayectoReserva from '../Trayectos/CardTrayectoReserva'
import Loading from '../Loading'

export default function CardReserva({reserva}) {
    const [trayecto, setTrayecto] = useState(null)
    const [loading, setLoading] = useState(true)

    useEffect(()=>{
        trayectosService.obtenerTrayecto(reserva.trayectoId).then((response)=>{
            setTrayecto(response)
            setLoading(false)
        })
    },[reserva.trayectoId])
  return (
    <>
     {loading? <Loading /> : 
         <CardTrayectoReserva idReserva={reserva.reservaId} trayecto={trayecto}/>
}
    </>
  )
}
