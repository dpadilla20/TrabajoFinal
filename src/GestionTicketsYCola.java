import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class GestionTicketsYCola {
    private Queue<Integer> colaPacientes = new LinkedList<>();
    private int numeroTicket = 1;
    private final int tiempoAtencionPorPaciente = 5; // tiempo promedio en minutos

    public void asignarTicket() {
        colaPacientes.add(numeroTicket);
        System.out.println("-----------------------------------");
        System.out.println("Ticket asignado: " + numeroTicket);
        System.out.println("-----------------------------------");
        numeroTicket++;
    }

    public void atenderPaciente() {
        if (colaPacientes.isEmpty()) { // isEmpty para verificar si esta vacio o no
            System.out.println("-----------------------------------");
            System.out.println("No hay pacientes en espera.");
            System.out.println("-----------------------------------");
        } else {
            int ticketAtendido = colaPacientes.poll(); // Saca al primer paciente de la cola
            System.out.println("-----------------------------------");
            System.out.println("Atendiendo al paciente con ticket: " + ticketAtendido);
            System.out.println("-----------------------------------");            
        }
    }
    public void mostrarEstadoCola() {
        if (colaPacientes.isEmpty()) {
            System.out.println("-----------------------------------");
            System.out.println("No hay pacientes en espera.");
            System.out.println("-----------------------------------");
        } else {
            int pacientesEnEspera = colaPacientes.size();
            int tiempoEstimado = pacientesEnEspera * tiempoAtencionPorPaciente;
            System.out.println("-----------------------------------");
            System.out.println("Pacientes en espera: " + pacientesEnEspera);
            System.out.println("Tiempo estimado de espera: " + tiempoEstimado + " minutos");
            System.out.println("Próximo ticket a atender: " + colaPacientes.peek());
            System.out.println("-----------------------------------");
        }

    }
    public static void main(String[] args) {
        GestionTicketsYCola sistemaGestion = new GestionTicketsYCola();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSistema de Gestión de Tickets");
            System.out.println("1. Asignar Ticket");
            System.out.println("2. Atender Paciente");
            System.out.println("3. Mostrar Estado de la Cola");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();  //

                switch (opcion) {
                    case 1:
                        sistemaGestion.asignarTicket();
                        break;
                    case 2:
                        sistemaGestion.atenderPaciente();
                        break;
                    case 3:
                        sistemaGestion.mostrarEstadoCola();
                        break;
                    case 4:
                        continuar = false;
                        System.out.println("Saliendo del sistema.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
    }
}