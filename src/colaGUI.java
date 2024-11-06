import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class colaGUI {
    private JTextField textField1;
    private JTextArea txtResltado;
    private JButton encolarButton;
    private JButton desencolarButton;
    private JPanel pGeneral;
    public Cola c=new Cola();
    public int ContadorCliente = 0;
    public static int compararCliente;

    public colaGUI() {

        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res=textField1.getText();
                c.encolar(res, txtResltado );
                ContadorCliente++;
                if(ContadorCliente==compararCliente){
                    int respuesta = JOptionPane.showConfirmDialog(null,
                            "Ha agregado su numero de personas. Desea agregar mas?",
                            "",
                            JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        ContadorCliente=0;
                        compararCliente = Integer.parseInt(JOptionPane.showInputDialog("Cuantas personas va a atender?"));
                    } else {
                        encolarButton.setEnabled(false);
                    }
                }
                textField1.setText("");
            }
        });
        desencolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (c.estaVacia()) {
                    JOptionPane.showMessageDialog(null, "La cola esta vacia");
                } else {
                    while (!c.estaVacia()) {
                        JOptionPane.showMessageDialog(null, c.desencolar(txtResltado) + " ha sido desencolado/a");
                        }
                    int respuesta = JOptionPane.showConfirmDialog(null,
                            "No hay mas personas en la cola. Desea ingresar mas?",
                            "",
                            JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        encolarButton.setEnabled(true);
                        ContadorCliente=0;
                        compararCliente = Integer.parseInt(JOptionPane.showInputDialog("Cuantas personas va a atender?"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                        System.exit(0);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("colaGUI");
        frame.setContentPane(new colaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        compararCliente = Integer.parseInt(JOptionPane.showInputDialog("Cuantas personas va a atender?"));
    }
}
