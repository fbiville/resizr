package com.github.fbiville.resizr.core;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;
import static javax.imageio.ImageIO.write;

//TODO: use Logger
public class Resizr {

    public void resize(String path, int width) throws IOException {
        System.out.println("About to resize: " + path);

        File picture = new File(path);
        BufferedImage resizedImage = Scalr.resize(read(picture), width);

        String original = picture.getAbsolutePath();
        String newPath = newPath(original);

        System.out.println("About to write to: " + newPath);
        write(resizedImage, format(original), new File(newPath));
    }

    private String format(String path) {
        return path.toLowerCase().substring(separatorPosition(path) + 1);
    }

    private String newPath(String original) {
        return original.substring(0, separatorPosition(original)) + "-resized." + format(original);
    }

    private int separatorPosition(String path) {
        return path.lastIndexOf('.');
    }
}
