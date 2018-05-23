package org.blaec.HeadFirstJava.saving;

import java.io.*;
import java.net.URL;

public class GameSaverTest {
    private static final String FILE = "C:\\Users\\blaec\\Documents\\javaProjects\\HeadFirstJava\\src\\main\\java\\org\\blaec\\HeadFirstJava\\saving\\Game.ser";

    public static void main(String[] args) {
//        String filePath = new File("src/main/java/org.blaec.HeadFirstJava/saving/" + FILE).getAbsolutePath();
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[]{"spells", "invisibility"});

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILE));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILE));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("One's type: " + oneRestore.getType());
            System.out.println("Two's type: " + twoRestore.getType());
            System.out.println("Three's type: " + threeRestore.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static URL getPackageLocation() {
        return GameSaverTest.class.getResource(".");
    }
}
