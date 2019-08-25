package com.ttrzcinski;

import com.ttrzcinski.interfaces.Shop;
import com.ttrzcinski.utils.FileAssurer;
import com.ttrzcinski.utils.ConsoleOutput;
import com.ttrzcinski.utils.FileDigger;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class BrainShop extends ConsoleOutput implements Shop<Brain> {
    private final static String DEFAULT_REPO_PATH = "RepoOfMyBrains2";

    private Brain instance;
    private List<File> brainPool;

    public BrainShop() {
        out("Assuring brain repository.");
        this.assurePresenceOfRepo();
        out("Digging up the files from repository.");
        this.extractFile();
    }

    @Override
    public Brain createNew() {
        this.instance = new Brain();
        return this.instance;
    }

    @Override
    public Brain getCurrent() {
        return this.instance;
    }

    @Override
    public boolean saveCurrent() {
        // TODO DO THE OUTPUT TO FILE OR DB OR SERVICE
        return false;
    }

    @Override
    public Brain LoadTheNewest() {
        // TODO DO THE INPUT FROM FILE OR DB OR SERVICE

        String fileName = "brainZero.txt";

        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Brain loadFromRepo(String uniqueName) {
        //TODO DO THE INPUT FROM FILE OR DB OR SERVICE
        return null;
    }

    private void assureNotNullPool() {
        if (this.brainPool == null) {
            this.brainPool = new ArrayList<>();
        }
    }

    /**
     * Extracts all the files and catalogs from given path, if path is right.
     */
    private void extractFile() {
        // 
        File[] files = new FileDigger().digFile(DEFAULT_REPO_PATH);
        //
        this.assureNotNullPool();
        //
        this.brainPool.addAll(Arrays.asList(files));
    }

    private void assurePresenceOfRepo() {
        // Assures a file
        new FileAssurer().assurePresenceOfRepo(DEFAULT_REPO_PATH);
    }
}
