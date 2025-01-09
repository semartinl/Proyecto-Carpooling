import React from 'react'
import CardReserva from './CardReserva'

export default function ListCardReservas({listReservas}) {
  return (
    <>
    
    {listReservas.length > 0 ? (
                    <>
                        {listReservas.map((reserva) => (
                            <CardReserva key={reserva.reservaId} reserva={reserva}/>
                        ))}
                    </>
                ) : (
                    <p>No hay resultados.</p>
                )}
    </>
  )
}
