import java.awt.*;
import javax.swing.*;
 
public class DrawPoints extends JPanel {

    private int width;
    private int height;
    private byte[] bitmap;

    public int byte2uint8(byte b) {
        if (b >= 0) return (int)b;
        return 256 + (int)b;
    }

    public void paintComponent(Graphics g) {
        /* Color color = new Color(R, G, B);
         * g.setColor(color);         // to set color temporarily
         * g.drawLine(x, x, x, x);  // to draw a dot
         */
        int cursor = 0;
        int x = 0;
        int y = 0;
        while (cursor < this.bitmap.length) {
            int R = byte2uint8( this.bitmap[cursor++] );
            int G = byte2uint8( this.bitmap[cursor++] );
            int B = byte2uint8( this.bitmap[cursor++] );
//          System.out.printf("%d %d %d\n", (int)R, (int)G, (int)B);
            Color color = new Color(R, G, B);
            g.setColor(color);
            if (x == width) {
                x = 0;
                y++;
            }
            g.drawLine(x, y, x, y);
            x++;
        }
    }

    DrawPoints(int width, int height, byte[] bitmap) {
        this.width = width;
        this.height = height;
        this.bitmap = new byte[bitmap.length];
        for (int i = 0; i < bitmap.length; i++)
            this.bitmap[i] = bitmap[i];
    }

}
