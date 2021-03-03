package concurrent.ch5;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author Chengliming
 * @create 2021-01-22 4:04 PM
 **/
public class Account {
    public static void resizeImage(String srcPath, String desPath, int scaleSize) {
        try {
            File srcFile = new File(srcPath);
            Image srcImg = ImageIO.read(srcFile);
            BufferedImage bi = null;
            try {
                bi = ImageIO.read(srcFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            float width = bi.getWidth(); // 像素
            float height = bi.getHeight(); // 像素
            float scale = width / scaleSize;
            BufferedImage buffImg = null;
            buffImg = new BufferedImage(scaleSize, (int) (height / scale), BufferedImage.TYPE_INT_RGB);
            //使用TYPE_INT_RGB修改的图片会变色
            buffImg.getGraphics().drawImage(
                    srcImg.getScaledInstance(scaleSize, (int) (height / scale), Image.SCALE_SMOOTH), 0,
                    0, null);

            ImageIO.write(buffImg, "JPEG", new File(desPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        resizeImage("/Users/chengliming/Downloads/1-1.jpg", "/Users/chengliming/Downloads/1-1-1.jpg", 300);
    }
}
