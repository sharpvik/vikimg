import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.ByteBuffer;

// Graphics
import java.awt.*;
import javax.swing.*;

public class VikImg {

    private int width;
    private int height;
    private byte[] bitmap;

    public void read(String filepath) throws Exception {
        byte[] bytes = Files.readAllBytes( Paths.get(filepath) );
        if (bytes.length < 8) {
            throw new Exception(
                "Input file seems to be incomplete or corrupt."
            );
        }

        byte[] widthBytes  = { bytes[0], bytes[1], bytes[2], bytes[3] };
        byte[] heightBytes = { bytes[4], bytes[5], bytes[6], bytes[7] };

        this.width  = ByteBuffer.wrap(widthBytes).getInt();
        this.height = ByteBuffer.wrap(heightBytes).getInt();

        if (bytes.length != 8 + 3 * this.width * this.height) {
            throw new Exception(
                "Input file seems to be corrupt. " +
                "Dimentions from metadata do not match actual size."
            );
        }

        this.bitmap = new byte[3 * this.width * this.height];
        int bitmapCursor = 0;
        int bytesCursor = 8;
        while (bytesCursor < bytes.length)
            this.bitmap[bitmapCursor++] = bytes[bytesCursor++];
    }

    public static void main(String[] args) throws Exception {
        String testFilePath = "../test/flower.vimg";
        VikImg img = new VikImg();
        img.read(testFilePath);
        System.out.println(img.width);
        System.out.println(img.height);

        JFrame frame = new JFrame("VikImg Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(img.width, img.height);
        frame.setLocationRelativeTo(null);

        DrawPoints panel = new DrawPoints(img.width, img.height, img.bitmap);
        frame.add(panel);

        frame.setVisible(true);
    }

}
