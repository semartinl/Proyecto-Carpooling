call curl -X GET http://localhost:8080/trayectos -H "Accept: application/json"
call mvn clean package -DskipTests

call curl -X POST -i http://localhost:8080/trayectos -H "Content-Type: application/x-www-form-urlencoded"  -d "usuarioId=1&origen=Ciudad_A&destino=Ciudad_B&horaSalida=2024-10-31T08:30&horaLlegada=2024-10-31T12:45&num_plazas_max=5"
call curl -X POST -i http://localhost:8080/trayectos -H "Content-Type: application/x-www-form-urlencoded"  -d "trayectoId=3&usuarioId=1&origen=Ciudad_A&destino=Ciudad_B&horaSalida=2024-10-31T08:30&horaLlegada=2024-10-31T12:45&num_plazas_max=5"
curl -X POST -i http://localhost:8080/trayectos -H "Content-Type: application/x-www-form-urlencoded"  -d "trayectoId=3&usuarioId=1&origen=Plasencia&destino=Caceres&horaSalida=2024-10-31T08:30&horaLlegada=2024-10-31T12:45&num_plazas_max=5"

call curl -X PUT -i http://localhost:8080/trayectos/3 -H "Content-Type: application/x-www-form-urlencoded"  -d "trayectoId=3&usuarioId=1&origen=Modificado_A&destino=Modificado_B&horaSalida=2024-10-31T08:30&horaLlegada=2024-10-31T12:45&num_plazas_max=5"
call curl -X PUT -i http://localhost:8080/trayectos/3 -H "Content-Type: application/x-www-form-urlencoded"  -d "usuarioId=1&origen=Modificado_otravez&destino=Modificado_B&horaSalida=2024-10-31T08:30&horaLlegada=2024-10-31T12:45&num_plazas_max=5"

call curl -X DELETE http://localhost:8080/trayectos/2 -H "Accept: application/json"


#PRUEBAS REFERENTES A LAS PARADAS
call curl -X GET -i http://localhost:8080/paradas -H "Accept: application/json"
call curl -X GET -i http://localhost:8080/paradas/1 -H "Accept: application/json"
call curl -X POST -i  http://localhost:8080/paradas -H "Content-Type: application/x-www-form-urlencoded" -d "trayectoId=1&lugar=Plaza Central&orden=1"
call curl -X POST -i http://localhost:8080/paradas -H "Content-Type: application/x-www-form-urlencoded" -d "trayectoId=2&lugar=Plaza Central&orden=1"

call curl -X PUT -i http://localhost:8080/paradas/2 -H "Content-Type: application/x-www-form-urlencoded" -d "trayectoId=1&lugar=Modificado_A&orden=1"
call curl -X PUT -i http://localhost:8080/paradas/2 -H "Content-Type: application/x-www-form-urlencoded" -d "trayectoId=2&lugar=Plaza Central&orden=1"

call curl -X DELETE -i http://localhost:8080/paradas/1 -H "Accept: application/json"
