import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class D20Frame extends JFrame {
    private final JLabel numeros = new JLabel("Elige",SwingConstants.CENTER);
    ActionListener actionListenerBotones = e -> {
        JButton botonPresionado = (JButton) e.getSource();
        String textoBoton = botonPresionado.getText();
        int numero;
        int numeroMaximo = 0;
        switch (textoBoton){
            case "coinflip":
                numeroMaximo = 2;
                break;
            case "d4":
                numeroMaximo = 4;
                break;
            case "d6":
                numeroMaximo = 6;
                break;
            case "d8":
                numeroMaximo = 8;
                break;
            case "d10":
                numeroMaximo = 10;
                break;
            case "d12":
                numeroMaximo = 12;
                break;
            case "d16":
                numeroMaximo = 16;
                break;
            case "d20":
                numeroMaximo = 20;
                break;
            case "d100":
                numeroMaximo = 100;
                break;
            default: break;
        }
        numero = generarNumero(numeroMaximo);
        if (textoBoton.contentEquals("coinflip")){
            if (numero == 1){
                numeros.setText("Cara");
                numeros.setForeground(Color.BLUE);
            }else {
                numeros.setText("Cruz");
                numeros.setForeground(Color.MAGENTA);
            }
        } else {
            numeros.setText(String.valueOf(numero));
            if (numero == 1){
                numeros.setForeground(Color.RED);
            } else if (numero == numeroMaximo) {
                numeros.setForeground(Color.GREEN);
            }else {
                numeros.setForeground(Color.BLACK);
            }
        }
    };

    public D20Frame() throws HeadlessException {
        this.setTitle("D20");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550,150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        ImageIcon icono = new ImageIcon("dado.png");
        this.setIconImage(icono.getImage());

        Font fuente = new Font(numeros.getFont().getName(),Font.PLAIN,40);
        numeros.setFont(fuente);
        this.add(numeros, BorderLayout.NORTH);

        JButton coinflip = new JButton("coinflip");
        coinflip.addActionListener(actionListenerBotones);
        JButton d4 = new JButton("d4");
        d4.addActionListener(actionListenerBotones);
        JButton d6 = new JButton("d6");
        d6.addActionListener(actionListenerBotones);
        JButton d8 = new JButton("d8");
        d8.addActionListener(actionListenerBotones);
        JButton d10 = new JButton("d10");
        d10.addActionListener(actionListenerBotones);
        JButton d12 = new JButton("d12");
        d12.addActionListener(actionListenerBotones);
        JButton d16 = new JButton("d16");
        d16.addActionListener(actionListenerBotones);
        JButton d20 = new JButton("d20");
        d20.addActionListener(actionListenerBotones);
        JButton d100 = new JButton("d100");
        d100.addActionListener(actionListenerBotones);


        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(coinflip);
        panelBotones.add(d4);
        panelBotones.add(d6);
        panelBotones.add(d8);
        panelBotones.add(d10);
        panelBotones.add(d12);
        panelBotones.add(d16);
        panelBotones.add(d20);
        panelBotones.add(d100);

        this.add(panelBotones,BorderLayout.CENTER);

        this.setVisible(true);
    }

    public static int generarNumero(int numero){
        Random random = new Random();
        return random.nextInt(numero)+1;
    }
}
