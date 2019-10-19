import java.awt.*;
import javax.swing.*;
 
public class DrawPoints extends JPanel {

    public byte[] bitmap;
    public int s;
    public int e;
 
    public void paintComponent(Graphics g) {
        g.drawLine(s, s, e, e);
        setForeground(Color.BLUE);
        g.drawLine(100, 100, 100, 200);
    }

    DrawPoints(int s, int e) {
        this.s = s;
        this.e = e;
    }

}
