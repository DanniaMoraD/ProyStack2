import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtTexto;
    private JButton btnVerificar;

    private JLabel label1;
    private JLabel label2;



    public boolean balanceado(String codigo) throws Exception {
        Pila1 p = new Pila1();

        for (int i = 0; i < codigo.length(); i++) {
            char simbolo = codigo.charAt(i);
            if (simbolo == '(' || simbolo == '[' || simbolo == '{'){
                p.insertar(simbolo);

            }
            else {
                if (simbolo == ')' || simbolo == ']' || simbolo == '}') {
                    if (simbolo == ')' && p.eliminar() != '(' || simbolo == ']' && p.eliminar() != '[' || simbolo == '}' && p.eliminar() != '{') {
                        return false;
                    }

                }
            }
        }

       //poner labels
        if(p.esVacia())
            return true;

        return false;

    }

    public int contarElementosApertura(String codigo) {
        int count = 0;
        for (int i = 0; i < codigo.length(); i++) {
            char caracter = codigo.charAt(i);
            if (caracter == '(' || caracter == '[' || caracter == '{') {
                count++;

            }
        }
        return count;
    }

    public int contarElementosCierre(String codigo) {
        int count = 0;
        for (int i = 0; i < codigo.length(); i++) {
            char caracter = codigo.charAt(i);
            if (caracter == ')' || caracter == ']' || caracter == '}') {
                count++;
            }
        }
        return count;
    }



    public Ventana() {

        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto= txtTexto.getText();
                int apertura = contarElementosApertura(texto);
                int cierre = contarElementosCierre(texto);
                try {
                    if(balanceado(texto)){
                        JOptionPane.showMessageDialog(null,"Codigo equilibrado");

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Codigo no equilibrado");

                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Falta apertura: "+ ex.getMessage());
                }
                label1.setText("Elementos de Apertura Ingresados: " + apertura);
                label2.setText("Elementos de Cierre Ingresados: " + cierre);


            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
