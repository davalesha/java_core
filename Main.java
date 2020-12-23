package java_core.block1.task3_2_save;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {

        GameProgress progress1 = new GameProgress(94, 10, 2, 254.32);
        GameProgress progress2 = new GameProgress(50, 1, 3, 220.02);
        GameProgress progress3 = new GameProgress(80, 4, 1, 354.88);

        // путь к директории savegames
        String path = "C:\\Users\\svdav\\netology\\src\\java_core\\block1\\Games\\savegames";

        // пути к файлам
        String path1 = path + "\\save1.dat";
        String path2 = path + "\\save2.dat";
        String path3 = path + "\\save3.dat";

        // сохранение данных
        saveGame(path1, progress1);
        saveGame(path2, progress2);
        saveGame(path3, progress3);

        List<String> listFiles = new ArrayList<>();
        listFiles.add(path1);
        listFiles.add(path2);
        listFiles.add(path3);

        // путь к архиву
        String pathZip = path + "\\zip.zip";

        // архивирование файлов
        zipFiles(pathZip, listFiles);

        // удаление файлов
        deleteFile(path1);
        deleteFile(path2);
        deleteFile(path3);
    }

    private static void saveGame(String pathZip, GameProgress gameProgress) {
        // откроем выходной поток для записи в файл
        try (FileOutputStream fos = new FileOutputStream(pathZip);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // запишем экземпляр класса в файл
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void zipFiles(String pathZip, List<String> listFiles) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(pathZip))) {
            for (int i = 0; i < listFiles.size(); i++) {
                try (FileInputStream fis = new FileInputStream(listFiles.get(i))) {
                    ZipEntry entry = new ZipEntry("pack_save" + (i + 1) + ".dat");
                    zout.putNextEntry(entry);
                    // считываем содержимое файла в массив byte
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    // добавляем содержимое к архиву
                    zout.write(buffer);
                    // закрываем текущую запись для новой записи
                    zout.closeEntry();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Файл удален ");
            } else {
                System.out.println("Файл удалить не получилось ");
            }
        } else {
            System.out.println("Файл не найден ");
        }
    }
}
