import javax.swing.*;

import java.awt.*;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;

public class Main {
    public static void main(String[] args) {
        double initialAngle = Double.parseDouble(JOptionPane.showInputDialog("İlk açıyı girin (derece): "));
        double initialVelocity = Double.parseDouble(JOptionPane.showInputDialog("İlk hızı girin (m/s): "));
        double initialX = (WIDTH - 20)/2; // İlk x konumu (ekranın ortasında)
        double initialY = HEIGHT - 50; // İlk y konumu (ekranın en altında)

        ProjectileMotionAnimation animation = new ProjectileMotionAnimation(initialAngle, initialVelocity, initialX, initialY);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Serbest Atış Hareketi");
            frame.setSize(WIDTH, HEIGHT);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(animation);
            frame.setVisible(true);
        });
    }
}