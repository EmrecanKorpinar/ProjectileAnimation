import javax.swing.*;
import java.awt.*;

public class ProjectileMotionAnimation extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 1000;

    private double initialAngle; // İlk açı (derece cinsinden)
    private double initialVelocity; // İlk hız (metre/saniye cinsinden)
    private double initialX; // İlk x konumu
    private double initialY; // İlk y konumu

    private double time = 0; // Geçen süre

    public ProjectileMotionAnimation(double initialAngle, double initialVelocity, double initialX, double initialY) {
        this.initialAngle = Math.toRadians(initialAngle); // Dereceyi radyana çevirir
        this.initialVelocity = initialVelocity;
        this.initialX = initialX;
        this.initialY = initialY;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int x = (int) (initialX + initialVelocity * Math.cos(initialAngle) * time); // X konumu hesaplanır
        int y = (int) (initialY - (initialVelocity * Math.sin(initialAngle) * time - (0.5 * 9.8 * time * time))); // Y konumu hesaplanır

        g2d.setColor(Color.RED);
        g2d.fillOval(x, y, 50, 50); // Top çizdirilir

        time += 0.01; // Zamanı günceller

        if (y < HEIGHT) {
            repaint(); // Yeni çizim için bileşeni yeniden boyar
        } else {
            double totalTime =Math.abs(2 * initialVelocity * Math.sin(initialAngle) / 9.8) ; // Topun düşüş süresi hesaplanır
            System.out.println("Top zemine " + totalTime + " saniyede düşer.");
        }
    }


}