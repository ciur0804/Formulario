
package formulario;

/**
 * IMPORT
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Ventanita extends JFrame implements ActionListener {
    
    //VARIABLES DE INSTANCIA 
    JTextField TNombreUsuario, TApellidoP, TApellidoM, TEscuela;
    JLabel LNombreUsuario, LApellidoP, LApellidoM, LEscuela, Bienvenida;
    JButton BotonGuardar;    
    /**
     * Creación del objeto perteneciente a la clase Validaciones.
     */
    Validaciones val = new Validaciones();
    
    //Constructor
    public Ventanita(){
        InicializarVentana();
        InicializarComponentes();
    }
    
    

    public void InicializarVentana(){
        setTitle("FORMULARIO");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setBackground(new Color(0,0,0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    /**
     * Método InicializarComponentes
     */
    public void InicializarComponentes(){
       
        //JTextField
        TNombreUsuario = new JTextField();
        TApellidoP = new JTextField();
        TApellidoM = new JTextField();
        TEscuela = new JTextField();
        //JLabel
        Bienvenida = new JLabel("BIENVENIDOS");
        LNombreUsuario = new JLabel("Introduce tu nombre: ");
        LApellidoP = new JLabel("Apellido paterno");
        LApellidoM = new JLabel("Apellido materno");
        LEscuela = new JLabel("Escuela");
        //Botones
        BotonGuardar = new JButton("GUARDAR");
        
        //Acomodamiento de las componentes en la ventana
        setLayout(new BorderLayout());
        add(Bienvenida, BorderLayout.NORTH);
        add(UbicacionCentro(), BorderLayout.CENTER);
        add(BotonGuardar, BorderLayout.SOUTH);
   
        //Agregamos ActionListener a los botones
        BotonGuardar.addActionListener(this);
        
        //Agregamos validaciones a los JTextField para que sólo acepten letras 
        val.SLetras(TNombreUsuario);
        val.SLetras(TApellidoP);
        val.SLetras(TApellidoM);
        val.SLetras(TEscuela);
        
    }
    
    private JPanel UbicacionCentro(){
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.add(LNombreUsuario);
        centro.add(TNombreUsuario);
        centro.add(LApellidoP);
        centro.add(TApellidoP);
        centro.add(LApellidoM);
        centro.add(TApellidoM);
        centro.add(LEscuela);
        centro.add(TEscuela);
        return centro;
    }  
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == BotonGuardar){
            /**
             * Creamos un objeto de la clase Conexion para poder llevar
             * a cabo una conexión a base de datos. 
             */
            Conexion ObjetoConexion = new Conexion();
            /**
             * Llevamos a cabo la conexión a base de datos con el método
             * getConexion()
             */
            ObjetoConexion.getConexion();
            /**
             * Se guardan los valores de los JTextField en variables. 
             */
            String Nombre = TNombreUsuario.getText();
            String APP = TApellidoP.getText();
            String APM = TApellidoM.getText();
            String Escuela = TEscuela.getText();
            
            /**
             * Enviamos dichos valores a la clase Conexion por medio del método
             * SubirDatos()
             */
            ObjetoConexion.SubirDatos(Nombre, APP, APM, Escuela);
            JOptionPane.showMessageDialog(null, "ALTA COMPLETADA");
        }
    }        
}