import React, { useContext, useEffect, useState } from 'react'
import reservasService from '../../Controllers/ReservasController'
import ListCardReservas from '../../Components/Reservass/ListCardReservas'
import Loading from '../../Components/Loading'
import UserContext from '../../Context/UserContext'

export default function MisReservas() {
    const {user} = useContext(UserContext)
    const [listReservas, setListReservas] = useState([])
    const [loading, setLoading] = useState(true)


    useEffect(()=>{
        reservasService.obtenerTodasReservas().then((response)=>{
            console.log(response)
        })
        console.log(user)
        reservasService.buscarReservasPorUserId(user["usuario_id"]).then((response)=>{
            setListReservas(response)
        })
        // trayectosService.obtenerTodosTrayectos().then((response)=>{
        //     setListTrayectos(response)
        // })
        setLoading(false)
    }, [])
  return (
    <>
        {loading? <Loading /> : 
            <>
                <ListCardReservas listReservas={listReservas} />
            </>
        }
    </>
  )
}
