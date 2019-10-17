import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Writer {

    public static boolean write(String filepath, byte[] bytes) {
        File file = new File(filepath);
        try ( FileOutputStream fos = new FileOutputStream(file) ) {
            fos.write(bytes);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
