// by paimon
package cn.langya.util.impl.misc;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;

public class FileUtil {
    
    public static String readInputStream(final InputStream inputStream) {
        final StringBuilder stringBuilder = new StringBuilder();
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * Reads the image to a byte buffer that works with LWJGL.
     *
     * @author func16
     */
    public static ByteBuffer readImageToBuffer(BufferedImage bufferedImage) {
        int[] rgbArray = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * rgbArray.length);
        for (int rgb : rgbArray) {
            byteBuffer.putInt(rgb << 8 | rgb >> 24 & 255);
        }
        byteBuffer.flip();

        return byteBuffer;
    }
}
