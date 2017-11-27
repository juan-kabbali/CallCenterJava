CALL CENTER
===================

Consideraciones de diseño
-------------------------
Se diseñó una arquitectura para dar solución a un caso hipotético, en donde existen 3 tipos de empleados los cuales están agrupados por:

 - Operador
 - Supervisor
 - Director

Adicionalmente, entran llamadas las cuales deben ser atendidas por los empleados que estén disponibles teniendo como prioridad los operadores, supervisores y directores respectivamente.

Debe existir una clase llamada Dispatcher que se encarga de orquestar las llamadas y los empleados. Al interior de esta clase, debe haber una llamada dispachCall para realizar dicha orquestación.

Las llamadas tienen una duración entre 5 y 10 segundos.

Se crean dos test unitarios en donde se procesan 10 y 20 llamadas respectivamente con el fin de validar la concurrencia. 

----------
Diagrama de clases
-------------
Para dar solución a este problema se diseña la siguiente arquitectura: 

![Callcenter UML ](https://lh3.googleusercontent.com/-hpYWl3BHIn4/WhudQn76ktI/AAAAAAAAAGU/48l6Dv2uldMTjWHYbNbJ-RAUtvpIPwtSgCLcBGAs/s0/UML.PNG "Callcenter_uml.PNG")


Extras
-------------------
Qué pasa cuando hay una llamada y no hay un empleado libre

> **Solución:** Se creo una lista de llamadas en espera. 
> Cuando no hay empleados disponibles para atender una llamada, se almacena en la lista hasta que un empleado este libre. 
> [Ver test unitario de 20 llamadas.](https://github.com/juan-kabbali/CallCenterJava/blob/master/src/test/java/com/almundo/callcenter/NoAvailableEmployeesTest.java)

Agregar documentación del código

> [Ver el javaDoc](https://github.com/juan-kabbali/CallCenterJava/tree/master/target/site/apidocs)

Iniciar el proyecto
-------------------
```
$ git clone https://github.com/juan-kabbali/CallCenterJava.git
$ mvn clean install
```






