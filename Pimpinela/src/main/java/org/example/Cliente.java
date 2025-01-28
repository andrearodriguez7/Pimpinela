package org.example;

import java.io.*;
import java.net.*;

/**
 * La clase Cliente se conecta a un servidor utilizando sockets y permite
 * el intercambio de mensajes entre cliente y servidor.
 * <p>
 * El cliente envía mensajes al servidor y procesa las respuestas recibidas.
 * La conexión se cierra si el servidor envía un mensaje con la frase
 * "Por eso vete".
 * </p>
 */
public class Cliente {
    /**
     * Método principal que ejecuta el cliente.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            // Flujo para leer datos enviados por el servidor.
            DataInputStream leer = new DataInputStream(socket.getInputStream());
            // Flujo para enviar datos al servidor.
            DataOutputStream escribir = new DataOutputStream(socket.getOutputStream());
            // Lectura de la entrada desde la consola.
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

            String mensaje, respuesta;

            // Bucle principal de comunicación.
            while (true) {
                System.out.print("Escribe un mensaje: ");
                mensaje = consola.readLine();
                escribir.writeUTF(mensaje); // Enviar mensaje al servidor.

                respuesta = leer.readUTF(); // Leer respuesta del servidor.
                System.out.println("Servidor: " + respuesta);

                // Salir si el servidor envía la frase de cierre.
                if (respuesta.contains("Por eso vete")) {
                    break;
                }
            }

            System.out.println("Conexión cerrada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



