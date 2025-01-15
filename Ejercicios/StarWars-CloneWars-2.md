# Star Wars: The Clone Wars

Hace mucho tiempo, en una galaxia muy, ¡muy
lejana [...] 

Una Galaxia dividida! Después de obtener
la victoria en la Batalla de Geonosis, el ejército de
droides del Conde Dooku ha tomado el control de las
principales rutas del hiperespacio, aislando a la
República de gran parte de su ejército de clones.
Con pocos clones disponibles, los generales Jedi no
pueden controlar el Borde Exterior conforme más y
más planetas se unen a los Separatistas de Dooku.

La república anda a la busca de un joven padawan
programador que ajuste el sistema de apuntado de
las naves X-wing T-65B para luchar contra el sistema
de droides voladores del Conde Dooku. Recuerda: Las
armas no ganan batallas. Tu mente, poderosa ella es. ¿Podrás ayudarles?

Para programar el sistema de escaneo y disparo de nuestra nave es importante conocer
nuestra Cuadrícula de acción. Dicha cuadrícula, se creará conociendo el número de
columnas de esta, que deberá ser siempre mayor o igual que 5 y menor o igual que 9.

A lo largo, de esta cuadrícula se dispondrán aleatoriamente un número de droides. Debemos
tener que cuenta lo siguiente. Un droide puede ser del tipo: SW348 los cuales aparecen un
20% y tienen un nivel de energía máximo de 50, un SW447, que aparecen un 40% de las
veces con un nivel de escudo de energía máximo de 100 y un SW421 los cuales aparecen un
20% con un escudo de energía que puede variar entre entre 100 y 150 aleatoriamente. Además, existe
el droide SW6969 que aparece un 20% de las veces y tiene un nivel de energía máximo de 200.

Debemos tener en cuenta que el número de droides es variable y se deberá conocer para
crear la simulación y debe ser siempre mayor o igual que 5 y menor o igual que 30.
Nuestro sistema, debe ir escaneando aleatoriamente nuestra cuadrícula. Si hay una nave
realiza un disparo y espera 100 milisegundos. Si hay una nave es capaz de dañarla y con
ello, bajará su nivel de energía 25 punto. A veces, el 15% de las veces podemos hacer un
disparo crítico y con ello dañamos al droide enemigo en 50 puntos de energía.

Pero tenemos en cuenta que que si el Droide es del tipo  Droide SW447, este tiene un escudo de defensa que delimita el efecto del ataque entre 5 y 10 puntos aleatoriamente. Si es el tipo Droide SW348, tiene la posibilidad de defenderse (el propio objeto) y con ello, el efecto del ataque sea el mínimo entre el ataque y su defensa (valor entre 9 y 12). Finalmente si es del tipo Droide SW421, tiene implementado un sistema de velocidad (entre 10 y 30) y con ello la posibilidad de esquivar el ataque y con ello no recibir daño el % de velocidad del droide. Finalmente, el droide SW6969 podrá actuar como el droide SW348 y SW421, pues al ser un diseño avanzando puede hacer las dos cosas, teniendo una velocidad máxima de 20 y escudo de defensa de 7. Pero en determinadas ocasiones puede explotar, (30% de veces), cosa que tenemos en cuenta que quizás en el futuro tenga el resto de droides.


El sistema de cuadrícula tiene un contador de droides destruidos, número de aciertos y de
disparos realizados. Obviamente un droide queda destruido cuando su energía es 0 y con
ello desaparece de nuestra cuadrícula de acción.

Cada 300 milisegundos los droides cambian de posición a una posición nueva
aleatoriamente.

Nuestro sistema terminará cuando haya pasado un tiempo máximo de ejecución,
indicado en la ejecución del simulador que puede ir entre 1 y 3 segundos o todos los droides
queden destruídos.

Cuando termine la simulación, deberá mostrar un informe de los resultados, indicando el
número de droides iniciales, el número de droides finales, la cantidad de disparos
realizados, la cantidad de droides muertos, el porcentaje de acierto. Se mostrará la lista
de droides que han aparecido en la simulación ordenada por energía desde el que tiene
mayor energía al que tiene menor energía restante.

El sistema de detección y protección de cuadrícula debe llamarse de la siguiente manera en
base a la línea de comandos:
> java -jar antidroides.jar <num_columnas> <num_droides> <tiempo>

Debemos tener en cuenta que si el sistema no se llama de esa manera o el número de
parámetro o valor de estos no coincide con las condiciones del enunciado se deberán pedir
manualmente una vez iniciado el sistema.

Además, debe estar perfectamente documentado y generar la documentación en formato HTML.


Las armas no ganan batallas. Tu mente, poderosa ella es.”
-- Yoda. Maestro DAM de la orden Jedi de Luke Skywalker