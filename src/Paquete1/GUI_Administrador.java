package Paquete1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.util.Queue;

public class GUI_Administrador extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tabla;
    private DefaultTableModel Apartados = new DefaultTableModel();
    int precio = 100;

    public GUI_Administrador(GUI_Clientes clientesGUI) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 877, 626);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        tabla = new JTable(Apartados) {
        	//Funcion para evitar que las celdas se editen mientras se ejeucta el programa
            public boolean isCellEditable(int fila, int column){  
                return false;  
            }
        };
        // Se agregan apartados a la tabla
        Apartados.addRow(new Object[]{"Ticket", "Nombre", "Cantidad", "Total a pagar ($)"});

        tabla.setBounds(58, 33, 347, 510);
        contentPane.add(tabla);
    }
    //Metodo para hacer conexxi�n en la tabla:
   	 public void actualizarTabla(Queue<Datos_Juego> cola) {
           // Limpiamos la tabla antes de actualizarla
           Apartados.setRowCount(1);

           // Iteramos sobre la cola y agregamos los datos
           for (Datos_Juego juego : cola) {
               int totalAPagar = juego.getcantidad() * precio; // Calcular el total a pagar
               Apartados.addRow(new Object[]{
                   juego.getTicket(),
                   juego.getnombre(),
                   juego.getcantidad(),
                   totalAPagar
               });
           }
    }
    }
