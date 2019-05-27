package game;

import sun.misc.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;

public class FileClassLoader extends ClassLoader {

    public FileClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class loadClass(String name, File file) {
        byte[] classData = new byte[0];
        try {
            classData = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(name,
                classData, 0, classData.length);

    }

}
