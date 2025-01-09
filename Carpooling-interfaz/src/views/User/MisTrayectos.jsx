import React, { useContext, useEffect, useState } from 'react'
import UserContext from '../../Context/UserContext'
import trayectosService from '../../Controllers/TrayectoControllers'
import ListCardTrayectos from '../../Components/Trayectos/ListCardTrayectos'

export default function MisTrayectos() {
    const {user} = useContext(UserContext)
    const [listTrayectos, setListTrayectos] = useState([])
    const [loading, setLoading] = useState(true)

    useEffect(()=>{
        trayectosService.obtenerTrayectosByUserId(1).then((response)=>{
             setListTrayectos(response)

            console.log(response)
        })
        // trayectosService.obtenerTodosTrayectos().then((response)=>{
        //     setListTrayectos(response)
        // })
    }, [])
  return (
    <>
        <h1>MisTrayectos</h1>

        <main>
            <div>
                <ListCardTrayectos misTrayectos={listTrayectos}/>
            </div>
        </main>

    </>
    


  )
}
