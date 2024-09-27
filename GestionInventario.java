import java.util.Scanner;

public class GestionInventario {

    // Constantes para el tamaño máximo del inventario
    final int MAX_PRODUCTOS = 100;

    // Arrays para almacenar los productos
    String[] nombres = new String[MAX_PRODUCTOS];
    int[] cantidades = new int[MAX_PRODUCTOS];
    double[] precios = new double[MAX_PRODUCTOS];

    // Variable para llevar el control del número de productos en el inventario
    int numProductos = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionInventario gestion = new GestionInventario();
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión de Inventario ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Calcular Precio Total del Inventario");
            System.out.println("4. Generar Reporte del Inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    gestion.agregarProducto(sc);
                    break;
                case 2:          
                    gestion.mostrarInventario();
                    break;
                case 3:
                    gestion.calcularPrecioTotal();
                    break;
                case 4:
                    gestion.generarReporte();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    // Función para agregar productos al inventario
    public void agregarProducto(Scanner sc) {
        if (numProductos < MAX_PRODUCTOS) {
            System.out.print("Ingrese el nombre del producto: ");
            nombres[numProductos] = sc.next();

            System.out.print("Ingrese la cantidad del producto: ");
            cantidades[numProductos] = sc.nextInt();

            System.out.print("Ingrese el precio unitario del producto: ");
            precios[numProductos] = sc.nextDouble();

            numProductos++;
            System.out.println("Producto agregado correctamente.");
        } else {
            System.out.println("Inventario lleno, no se pueden agregar más productos.");
        }
    }

    // Función para mostrar el inventario
    public void mostrarInventario() {
        if (numProductos == 0) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("\n--- Inventario de Productos ---");

            for (int i = 0; i < numProductos; i++) {
                System.out.println("Nombre: " + nombres[i] + "   " + "Cantidad: " + cantidades[i] + "  " + "Precios: " + precios[i]);
            }
        }
    }

    // Función para calcular el precio total del inventario
    public void calcularPrecioTotal() {
        double precioTotal = 0;
        for (int i = 0; i < numProductos; i++) {
            precioTotal += cantidades[i] * precios[i];
        }
        System.out.println("El precio total del inventario es: " + precioTotal);
    }

    // Función para generar un reporte del inventario
    public void generarReporte() {
        if (numProductos == 0) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("\n--- Reporte de Inventario ---");
            for (int i = 0; i < numProductos; i++) {
                double totalProducto = cantidades[i] * precios[i];
                System.out.println("Nombre: " + nombres[i]);
                System.out.println("Cantidades: " + cantidades[i]);
                System.out.println("Precio: " + precios[i]);
                System.out.println("TotalProducto: " + totalProducto);
            }
        }
    }
}
