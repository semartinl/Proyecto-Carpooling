import { useContext, useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import UserContext from "../Context/UserContext"
import usersService from "../Controllers/UserController"

export default function LogIn() {
  const navigate = useNavigate()
  const [error, setError] = useState(null)
  const {user, setUser,isLoggedIn,setIsLoggedIn} = useContext(UserContext)
  // useEffect(()=>{
  //   const response = usersService.obtenerUsuarioPorId()
  //   console.log(response)
  // })
  const handleLogIn = (event)=>{
    event.preventDefault();

    var userLogIn = {
      "username": event.target.username.value,
      // "email": event.target.email.value,
      "password": event.target.password.value
    }
    console.log(userLogIn)
    usersService.login(userLogIn).then((response)=>{
      setUser(response)
			setError(null)
      alert("Login exitoso")
				setIsLoggedIn(true)
      window.localStorage.setItem("User",JSON.stringify(response))
      console.log(response)
      navigate("/app")
    }).catch((error)=>{
      if(error.status === 404){
        alert("Invalid username or password");
        setError("Invalid username or password")
      }
    })
  }
  return (
    <>
  <title>Medifli.com</title>
  <meta charSet="utf-8" />
  <link rel="icon" href="assets/Icons/medifli_M.png" />
  <link rel="stylesheet" href="./styles.css" />
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
  />
  <div className="parent-container">
    <div className="child-div">
      <img
        src="images/Icons/medifli_sin_fondo_2.png"
        title="Logo de Mediflí"
        height={150}
        alt="M de Mediflí"
      />
    </div>
    <div className="child-div">
      <fieldset className="loginContainer headerMedifli whiteLetters">
        <div>
          <h5>
            <b>Inicia sesión o crea una cuenta</b>
          </h5>
           {error? error:null}
          <form method="post" onSubmit={handleLogIn}>
            <label htmlFor="username"> Usuario </label>
            <input
              type="text"
              name="username"
              className="loginBox"
              autoComplete="on"
              size={46}
              placeholder="Indica tu username"
              required=""
              style={{ marginBottom: 10 }}
            />
            <label htmlFor="loginPwd"> Contraseña </label>
            <input
              type="password"
              name="password"
              className="loginBox"
              id="password"
              style={{ marginBottom: 18 }}
              size={46}
              placeholder="Indica tu contraseña"
              required=""
            />
            <input
              type="checkbox"
              className="passwordBox"
              
            />
            Mostrar contraseña
            <input
              type="submit"
              className="form-control whiteLetters hoverClass"
              id="loginButton"
              defaultValue="Iniciar sesión"
            />
          </form>
          <p className="small-font" style={{ textAlign: "center" }}>
            ${"{"}messages{"}"}
          </p>
          <form action="signUp_Medifli.html">
            <input
              type="submit"
              className="form-control whiteLetters hoverClass"
              id="signUpButton"
              defaultValue="Registrarme"
            />
          </form>
        </div>
        <div>
          <div className="center-text">
            <p className="small-font">o usar una de estas opciones</p>
          </div>
          <div id="fields">
            <form action="https://example.org">
              <div
                className="externalLoginButton"
                title="Inicia sesión con Facebook"
              >
                <input
                  type="image"
                  className="socialNetwork"
                  src="images/logos/facebook-logo.png"
                  alt="Facebook_logo"
                />
              </div>
            </form>
            <form action="https://example.org">
              <div
                className="externalLoginButton"
                title="Inicia sesión con Google"
              >
                <input
                
                  type="image"
                  className="socialNetwork"
                  src="images/logos/google-logo.png"
                  alt="Google_logo"
                />
              </div>
            </form>
            <form action="https://example.org">
              <div
                className="externalLoginButton"
                title="Inicia sesión con Apple"
              >
                <input
                  type="image"
                  className="socialNetwork"
                  src="assets/logos/apple-logo.png"
                  alt="Apple_logo"
                />
              </div>
            </form>
          </div>
          <div className="center-text">
            <p />
            <div className="top-borders margin-elements">
              <p />
              <p className="twelvePx">
                {" "}
                Al iniciar sesión o al crear una cuenta, aceptas nuestros
                Términos y condiciones y la Política de privacidad{" "}
              </p>
              <div>
                <p className="twelvePx" id="allRightsReserved">
                  Todos los derechos reservados
                </p>
                <span className="twelvePx">Copyright 2024 - Medifli.com</span>
              </div>
            </div>
          </div>
        </div>
      </fieldset>
    </div>
  </div>
</>
  )
}