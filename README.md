1. ¿Qué diferencia existe entre paralelismo y concurrencia?
El paralelismo ocurre cuando varias tareas se ejecutan al mismo tiempo con el fin de mejorar el rendimiento de múltiples hilos o procesadores, dividiendo un trabajo grande en partes más pequeñas para hacerlo más rápido.
La concurrencia, gestiona múltiples tareas que interactúan entre sí y comparten recursos cuando varios hilos trabajan sobre diferentes tareas o sobre un mismo recurso compartido, pero el sistema organiza su ejecución para que puedan avanzar casi al mismo tiempo.

2. ¿Qué problema ocurre cuando varios hilos acceden al mismo recurso?
Cuando varios hilos acceden al mismo recurso al mismo tiempo, puede producirse una sobrecarga o conflictos en el acceso a los datos. Esto ocurre porque cada hilo puede intentar leer o modificar el recurso simultáneamente sin un control adecuado. Lo cual pueden generarse errores, inconsistencias en la información o incluso pérdida de datos. Estos problemas pueden provocar resultados incorrectos o estados inesperados en el funcionamiento del programa.


3. ¿Qué es una condición de carrera (Race Condition)?
Una condición de carrera ocurre cuando dos o más hilos intentan leer o modificar el mismo recurso al mismo tiempo, y el resultado final depende del orden en que se ejecuten esos hilos. Esto genera que un programa producir resultados diferentes o incorrectos, porque los hilos "compiten" por acceder al recurso compartido.

4. ¿Por qué es importante sincronizar el acceso a recursos compartidos?
La sincronización es importante porque permite controlar qué hilo puede acceder a un recurso en un momento determinado.
De esta forma se evita que varios hilos modifiquen el recurso al mismo tiempo, lo que previene errores, inconsistencias y condiciones de carrera, garantizando que el programa funcione correctamente.



autor: diego fernando ibañez meneses 
