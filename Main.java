package java_core.block1.task3_1_install;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
В папке Games создайте несколько директорий: src, res, savegames, temp.
        В каталоге src создайте две директории: main, test.
        В подкаталоге main создайте два файла: Main.java, Utils.java.
        В каталог res создайте три директории: drawables, vectors, icons.
        В директории temp создайте файл temp.txt.
*/
public class Main {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        File dir = new File("C:\\Users\\svdav\\netology\\src\\java_core\\block1\\Games");

        File srcFolder = new File(dir, "src");
        String text = srcFolder.mkdir() ? "Директория src создана" : "Ошибка при создании директории src";
        stringBuilder.append(text + "\n");

        File srcMain = new File(srcFolder, "main");
        text = srcMain.mkdir() ? "Директория src/main создана" : "Ошибка при создании директории src/main";
        stringBuilder.append(text + "\n");

        File mainFile = new File(srcMain, "Main.java");
        try {
            text = mainFile.createNewFile() ? "Файл Main.java создан" : "Файл Main.java уже создан";
        } catch (IOException ex) {
            text = "Ошибка при создании файла Main.java: " + ex.getMessage();
        }
        stringBuilder.append(text + "\n");

        File utilsFile = new File(srcMain, "Utils.java");
        try {
            text = utilsFile.createNewFile() ? "Файл Utils.java создан" : "Файл Utils.java уже создан";
        } catch (IOException ex) {
            text = "Ошибка при создании файла Utils.java: " + ex.getMessage();
        }
        stringBuilder.append(text + "\n");

        File srcTest = new File(srcFolder, "test");
        text = srcTest.mkdir() ? "Директория src/test создана" : "Ошибка при создании директории src/test";
        stringBuilder.append(text + "\n");

        File resFolder = new File(dir, "res");
        text = resFolder.mkdir() ? "Директория res создана" : "Ошибка при создании директории res";
        stringBuilder.append(text + "\n");

        File resDrawables = new File(resFolder, "drawables");
        text = resDrawables.mkdir() ? "Директория res/drawables создана" : "Ошибка при создании директории res/drawables";
        stringBuilder.append(text + "\n");

        File resVectors = new File(resFolder, "vectors");
        text = resVectors.mkdir() ? "Директория res/vectors создана" : "Ошибка при создании директории res/vectors";
        stringBuilder.append(text + "\n");

        File resIcons = new File(resFolder, "icons");
        text = resIcons.mkdir() ? "Директория res/icons создана" : "Ошибка при создании директории res/icons";
        stringBuilder.append(text + "\n");

        File saveGamesFolder = new File(dir, "savegames");
        text = saveGamesFolder.mkdir() ? "Директория savegames создана" : "Ошибка при создании директории savegames";
        stringBuilder.append(text + "\n");

        File tempFolder = new File(dir, "temp");
        text = tempFolder.mkdir() ? "Директория temp создана" : "Ошибка при создании директории temp";
        stringBuilder.append(text + "\n");

        File tempFile = new File(tempFolder, "temp.txt");
        try {
            text = tempFile.createNewFile() ? "Файл temp.txt создан" : "Файл temp.txt уже создан";
        } catch (IOException ex) {
            text = "Ошибка при создании файла temp.txt: " + ex.getMessage();
        }
        stringBuilder.append(text + "\n");

        // запись файла
        try (FileWriter writer = new FileWriter(tempFile, false)) {
            writer.write(stringBuilder.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

 }
