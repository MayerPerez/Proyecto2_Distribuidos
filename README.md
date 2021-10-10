# Proyecto2_Distribuidos
Topología anillo, manda token de un servidor a otro, recibe como argumentos el puerto que escucha y al que va a enviar. Ejemplo: "java UDPServer 4700 4710"

En este proyecto se hace uso de sockets UDP en Java. La clase servidor crea una instancia de la clase Token, que es una clase Serializable, para poder mandarla a otro servidor y cuando el otro servidor lo recibe imprime la información del token.
Primero se envia el token, despues se recibe y se imprime, espera 3 segundos y repite el proceso
