import React, { useContext, useEffect, useState } from 'react'
import UserContext from '../../Context/UserContext'
import usersService from '../../Controllers/UserController'
import { useNavigate } from 'react-router-dom'
import Loading from '../../Components/Loading'

export default function EditUser() {
    const {user,setUser} =useContext(UserContext)
    const [updatedUser, setUpdatedUser] = useState({})
    const [loading, setLoading] = useState(true)
    const navigate = useNavigate()
    const handleChange = (event) => {
        const { name, value } = event.target
        setUpdatedUser((prevValue) => {
            return {
                ...prevValue,
                [name]: value
                }
                })
    }
    const handleUpdate = (event) => {
        event.preventDefault()
        usersService.actualizarUsuario(updatedUser['usuario_id'],updatedUser).then(response =>{
            setUser(response)
            navigate("/user/config")
        })
        
        }
    useEffect(()=>{
        
        usersService.obtenerUsuarioPorId(user['usuario_id']).then(response =>{
            setUpdatedUser(response)
        })
        .finally(() => setLoading(false))

    },[])
  return (
    <div>
         {loading? <Loading/> : 
         <form action="" method="get" onSubmit={handleUpdate}>
            {/* <label htmlFor="username"> Username:</label>
            <input type="text" id="username" name="username" value={user.username} /> */}

            <label htmlFor="name">Name:</label>
            <input type="text" id="nombre" name="nombre" value={updatedUser.nombre} onInput={handleChange}/>

            <label htmlFor="email">Email:  </label>
            <input type="email" id="email" name="email" value={updatedUser.email} onInput={handleChange}/>

            <label htmlFor="password">Password:</label>
            <input type="password" id="password" name="password" value={updatedUser.password} onInput={handleChange}/>

            <button type="submit">Actualizar datos</button>
        </form>
        }
        
    </div>
  )
}
