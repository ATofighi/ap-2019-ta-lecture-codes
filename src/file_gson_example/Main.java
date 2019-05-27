package file_gson_example;
import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Spaceship s1 = new Spaceship(4, 10);
        Spaceship s2 = new Spaceship(40, 20);
        s2.setBombs(100);
        System.out.println(s2.toString());
        System.out.println(gson.toJson(s1));
        Spaceship s3 = gson.fromJson(
                "{\"x\":88,\"y\":10,\"lastDagh\":0,\"bombs\":10}\n",
                Spaceship.class);
        System.out.println(s3);


        File f = new File("game.data");


        FileOutputStream fos = new FileOutputStream(f);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        PrintStream p = new PrintStream(bos);
        s3.save(p);
        p.flush();
        p.close();



        FileInputStream fis = new FileInputStream(f);
        Scanner s = new Scanner(fis);
        Spaceship s4 = Spaceship.load(s);
        System.out.println("s4 = " + s4);
        fis.close();
    }
}
