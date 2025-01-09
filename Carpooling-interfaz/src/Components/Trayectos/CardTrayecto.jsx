import React from 'react'

export default function CardTrayecto({trayecto}) {
  
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
            <button>Editar trayecto</button>
            <button>Eliminar trayecto</button>
      </div>
    </section>
  )
}
