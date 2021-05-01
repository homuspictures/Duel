

import java.io.*;

public class CheckScore {
    private static String filePath;

    public static Score getScore(String file) {
        filePath = file;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            return (Score) objectInputStream.readObject();
        } catch (FileNotFoundException exception) {
            return new Score();
        } catch (IOException | ClassNotFoundException exception) {
            throw new RuntimeException("Cannot load", exception);
        }
    }

    public static void saveScore(Score score) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(score);
        } catch (IOException exception) {
            throw new RuntimeException("Cannot save", exception);
        }
    }
}
