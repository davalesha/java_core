package java_core.block1.task3_3_download;

import java_core.block1.task3_2_save.GameProgress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {

        // путь к директории savegames
        String path = "C:\\Users\\svdav\\netology\\src\\java_core\\block1\\Games\\savegames";

        // путь к архиву
        String pathZip = path + "\\zip.zip";

        openZip(path, pathZip);

        // пути к файлам
        String path1 = path + "\\pack_save1.dat";
        String path2 = path + "\\pack_save2.dat";
        String path3 = path + "\\pack_save3.dat";

        GameProgress progress1 = openProgress(path1);
        GameProgress progress2 = openProgress(path2);
        GameProgress progress3 = openProgress(path3);

        System.out.println(progress1);
        System.out.println(progress2);
        System.out.println(progress3);
    }

    private static void openZip(String pathFolder, String pathZip) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(pathZip))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName(); // получим название файла
                // распаковка
                FileOutputStream fout = new FileOutputStream(pathFolder + "\\" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static GameProgress openProgress(String pathFile) {

        GameProgress gameProgress = null;
        // откроем входной поток для чтения файла
        try (FileInputStream fis = new FileInputStream(pathFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            // десериализуем объект и скастим его в класс
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return gameProgress;
    }
}
