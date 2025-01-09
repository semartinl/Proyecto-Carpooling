import React, { useState } from 'react'
import trayectosService from '../Controllers/TrayectoControllers'
import { useNavigate } from 'react-router-dom'

export default function CrearTrayecto() {
    // this.trayectoId = trayectoId;
    //     this.usuarioId = usuarioId;
    //     this.origen = origen;
    //     this.destino = destino;
    //     this.horaSalida = horaSalida;
    //     this.horaLlegada = horaLlegada;
    //     this.num_plazas_max = num_plazas_max;
const [from, setFrom] = useState('')
  const [to, setTo] = useState('')
  const [time, setTime] = useState('') //Hora de salida
  const [horaLlegada, setHoraLlegada] = useState("")
  const [numPlazas, setNumPlazas] = useState(4)
  const navigate = useNavigate()

  const handleCreateTrayecto = (event)=>{
    event.preventDefault()
    const formatteTime = time.replace("T", " ");
    const formattedHoraLlegada = horaLlegada.replace("T", " ")
    const newTrayecto = {
      trayectoId: Math.floor(Math.random() * 1000000),
      usuario_id: 1,
      origen: from,
      destino: to,
      hora_salida: formatteTime,
      hora_llegada: formattedHoraLlegada,
      num_plazas_max: numPlazas
      }
    // const newTrayecto = {
    //   trayectoId: Math.floor(Math.random() * 1000000),
    //   usuarioId: 1,
    //   origen: from,
    //   destino: to,
    //   hora_salida: time,
    //   hora_llegada: horaLlegada,
    //   num_plazas_max: numPlazas
    //   }
      console.log(newTrayecto)
      // const trayectoForm = URLSearchParams({from, to, time,})
      trayectosService.crearTrayecto(newTrayecto).then((response)=>{
        alert("Trayecto publicado con éxito")
        navigate("/user/config/misTrayectos")
        
      })

  }
  return (
    <form action="post" onSubmit={handleCreateTrayecto}>
    <label htmlFor="origen">Introduce el origen del trayecto: </label>
        <input type="text" name="origen" id="origen" onInput={(e)=> setFrom(e.target.value)}/>

        <label htmlFor="destino">Introduce el destino del trayecto: </label>
        <input type="text" name="destino" id="destino" onInput={(e)=> setTo(e.target.value)}/>

        <label htmlFor="hora">Introduce el día y hora de salida</label>
        <input type="datetime-local" name="hora" id="hora" onInput={(e)=> setTime(e.target.value)}/>

        <label htmlFor="horaLlegada">Introduce el día y hora de llegada</label>
        <input type="datetime-local" name="horaLlegada" id="horaLlegada" onInput={(e)=> setHoraLlegada(e.target.value)}/>

        <label htmlFor="numPlazas">Introduce el número de plazas disponibles</label>
        <input type="number" name="numPlazas" id="numPlazas" min={1} max={10} onInput={(e)=> setNumPlazas(e.target.value)}/>
        <button type="submit">Crear trayecto</button>
    
    </form>
  )
}
