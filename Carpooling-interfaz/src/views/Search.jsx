import React, { useEffect, useState } from 'react'
import { useLocation } from 'react-router-dom'
import trayectosService from '../Controllers/TrayectoControllers'

export default function Search() {
    const [trayectos,setTrayectos] = useState([])
    const [listFavorites, setListFavorites] = useState([])
    

    
    // const {search} = useLocation()
    // const query = new URLSearchParams(search)
    
    // useEffect(()=>{
    //     trayectosService.buscarTrayectos(query)
        
    // },[search])
    useEffect(()=>{
      trayectosService.obtenerTodosTrayectos().then((response)=>{
        setTrayectos(response)
        console.log(response)
      })
    },[])
  return (
    <>
        <h1>BUSCADOR</h1>
    </>
  )
  
}
