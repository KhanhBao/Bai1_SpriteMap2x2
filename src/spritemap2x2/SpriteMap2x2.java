/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spritemap2x2;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author JosPham
 */
public class SpriteMap2x2 {

    /**
     * @param args the command line arguments
     */
    public static void join(String inputPath, String outputPath, int col, int row) throws IOException {

        File directory = new File(inputPath);
        File[] pics = directory.listFiles();

        BufferedImage sprite = ImageIO.read(pics[0]);
        int width = sprite.getWidth()*col;
        int height = sprite.getHeight()*row;
        BufferedImage spritemap = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D graphics2d = spritemap.createGraphics();

        int x = 0;
        int y = 0;

        for (int i = 0; i < col; i++) {
            sprite = ImageIO.read(pics[i]);
            if (sprite != null) {
                graphics2d.drawImage(sprite, null, x, y);
                x += sprite.getWidth();
            }
        }
        y = sprite.getHeight();
        for (int i = col; i < row * col; i++) {
            sprite = ImageIO.read(pics[i]);
            if (sprite != null) {
                graphics2d.drawImage(sprite, null, x, y);
                x += sprite.getWidth();
            }
        }

        ImageIO.write(spritemap, "png", new File(outputPath));
    }

    public static void main(String[] args) throws IOException {
        Scanner scanIn = new Scanner(System.in);
        System.out.println("Input: ");
        String input = scanIn.nextLine();
        System.out.println("Output: ");
        String output = scanIn.nextLine();
        SpriteMap2x2.join(input, output, 2, 2);
    }

}
