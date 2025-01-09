import React from 'react'
import CardTrayecto from './CardTrayecto'

export default function ListCardTrayectos({misTrayectos}) {

  return (
    <>
    {misTrayectos.length > 0 ? (
                    <>
                        {misTrayectos.map((trayecto) => (
                            <CardTrayecto key={trayecto.trayecto_id} trayecto={trayecto}/>
                        ))}
                    </>
                ) : (
                    <p>No hay resultados.</p>
                )}
    </>
    
  )
}
