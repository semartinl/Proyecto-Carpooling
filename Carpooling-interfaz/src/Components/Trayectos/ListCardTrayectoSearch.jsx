import React from 'react'
import CardTrayectoSearch from './CardTrayectoSearch'

export default function ListCardTrayectoSearch({listTrayectos}) {
  return (
     <>
    {listTrayectos.length > 0 ? (
                    <>
                        {listTrayectos.map((trayecto) => (
                            <CardTrayectoSearch key={trayecto.trayecto_id} trayecto={trayecto}/>
                        ))}
                    </>
                ) : (
                    <p>No hay resultados.</p>
                )}
    </>
  )
}
