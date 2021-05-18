package test;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author li zhipeng
 * @date 2021/5/14
 * @Description:
 */
class ImageTest {

    @Test
    void test() {
        try {
/*            BufferedImage image = ImageIO.read(new File(""));
            assertNotNull(image);*/
            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream(""));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}