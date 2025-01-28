# Pimpinela

Se pide crear un Servidor y un Cliente, conectados entre sí mediante sockets.



El servidor pedirá un mensaje del cliente y siempre responderá con un "Error", excepto cuando el mensaje sea "¿Quién es?".



A lo que el servidor responderá "Soy yo". Si el cliente responde cualquier cosa volverá a mostrar "Error", excepto si recibe "¿Qué vienes a buscar?", en cuyo caso, el servidor responderá "A ti", esperando un nuevo mensaje que sea "Ya es tarde" (si es cualquier otro, responderá con un "Error").



Entonces, el servidor mostrará un "¿Por qué?" y el cliente enviará un "Porque ahora soy yo la que quiere estar sin ti", si recibe esto, el servidor mostrará el siguiente mensaje "Por eso vete, olvida mi nombre, mi cara, mi casa y pega la vuelta" y cortará la comunicación, en cualquier otro caso, mostrará "Error".

