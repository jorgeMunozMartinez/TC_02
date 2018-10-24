# TC_02
OBJETIVO -- Allanar un terreno ---.
Sea un terreno T  de dimensiones CxF ([0..C-1] x [0..F-1]), en cuyas casillas puede haber una cantidad de arena no mayor que una cantidad MAX, y un pequeño tractor en una casilla (xr,yr) determinada. 

La acción asociada al tractor es la distribución de una cantidad de arena  S de su casilla entre las casillas adyacentes (norte, sur, este y oeste) y el desplazamiento a alguna de ellas. Cada acción que el tractor realiza tiene un costo energético equivalente a la cantidad mayor de arena que ha de trasladar entre dos casillas.

Supongamos que tenemos un terreno donde se ha distribuido de manera no uniforme una cantidad de arena   V = C*F*k, tal que k <= MAX y se ha situado al tractor en la casilla (xr,yr). ¿Cual es la secuencia de acciones que ha de realizar el tractor, con el mínimo gasto energético, para tener distribuida de manera uniforme toda la arena sobre el terreno y que todas las casillas tengan una cantidad igual de arena (k)?.
