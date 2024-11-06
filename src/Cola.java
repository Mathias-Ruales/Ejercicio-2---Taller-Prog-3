import javax.swing.*;

public class Cola {
    public Cliente frente;

    public Cola(){
        frente = null;
    }
    public boolean estaVacia(){
        return frente == null;
    }

    public void encolar(String nombre, JTextArea textArea){
        Cliente nuevoCliente=new Cliente(nombre);
        if(estaVacia()) {
            nuevoCliente.siguente = frente;
            frente = nuevoCliente;
        } else {
            Cliente c = frente;

            while (c.siguente!=null){
                c=c.siguente;
            }
            c.siguente=nuevoCliente;
        }
        actualizarCola(textArea);
    }

public String desencolar (JTextArea textArea){
        if(estaVacia()){
            return "La cola esta vacia";
        } else {
         String cliente = frente.nombre;
         frente=frente.siguente;
         actualizarCola(textArea);
         return cliente;
        }
}
    public void mostrarCola (JTextArea textArea){
        if(estaVacia()){
            textArea.setText("");
        } else {
            StringBuilder cola = new StringBuilder();
            Cliente c = frente;
            while(c != null){
                cola.append(c.getNombre())
                        .append("\n");
                textArea.setText(frente.toString());
                c=c.siguente;
            }
            textArea.setText(cola.toString());
        }
    }
    public void actualizarCola (JTextArea textArea){
        mostrarCola(textArea);
    }
}
