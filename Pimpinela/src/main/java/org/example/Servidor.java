package org.example;

import java.io.*;
import java.net.*;

/**
 * La clase Servidor espera conexiones de clientes y gestiona
 * un intercambio de mensajes basado en un diálogo predeterminado.
 * <p>
 * El servidor procesa mensajes del cliente y responde en consecuencia.
 * La conexión se cierra cuando se completa el diálogo esperado.
 * </p>
 */
public class Servidor {
    /**
     * Método principal que ejecuta el servidor.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Socket conexion = null;
        DataInputStream leer;
        DataOutputStream escribir;

        int PUERTO = 12345; // Puerto en el que el servidor escucha conexiones.

        try (ServerSocket servidorSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor iniciado. Esperando conexión...");
            conexion = servidorSocket.accept(); // Esperar conexión de un cliente.
            System.out.println("Cliente conectado.");

            leer = new DataInputStream(conexion.getInputStream());
            escribir = new DataOutputStream(conexion.getOutputStream());

            String mensaje;

            // Bucle de intercambio de mensajes con el cliente.
            while (true) {
                mensaje = leer.readUTF(); // Leer mensaje del cliente.
                System.out.println("Cliente: " + mensaje);

                // Responder según el flujo del diálogo.
                if ("¿Quién es?".equals(mensaje)) {
                    escribir.writeUTF("Soy yo");
                    mensaje = leer.readUTF();

                    if ("¿Qué vienes a buscar?".equals(mensaje)) {
                        escribir.writeUTF("A ti");
                        mensaje = leer.readUTF();

                        if ("Ya es tarde".equals(mensaje)) {
                            escribir.writeUTF("¿Por qué?");
                            mensaje = leer.readUTF();

                            if ("Porque ahora soy yo la que quiere estar sin ti".equals(mensaje)) {
                                escribir.writeUTF("Por eso vete, olvida mi nombre, mi cara, mi casa y pega la vuelta");
                                break;
                            } else {
                                escribir.writeUTF("Error");
                            }
                        } else {
                            escribir.writeUTF("Error");
                        }
                    } else {
                        escribir.writeUTF("Error");
                    }
                } else {
                    escribir.writeUTF("Error");
                }
            }

            System.out.println("Cerrando conexión...");
            conexion.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

