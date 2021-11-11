package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

@Slf4j
public class NIO2AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Path path = Paths.get("test");
        Path path1 = Paths.get(new URI("file:///home/tuhlc/Downloads/demo/test"));
        Path path2 = FileSystems.getDefault().getPath("test");
        File file = new File("test");
        Path path3 = file.toPath();
        log.info("URI {} {} {} {}", path.toUri(), path1.toUri(), path2.toUri(), path3.toUri());
        Path path4 = Paths.get("/par1/par2/file.csv");
        Path path5 = Paths.get("par2/file.csv");
        info(path4);
        info(path5);

        Path path6 = Paths.get("E:\\habitat");
        Path path7 = Paths.get("E:\\sanctuary\\raven");
        System.out.println(path6.relativize(path7));
        System.out.println(path7.relativize(path6));

        final Path path8 = Paths.get("/turkey/food");
        final Path path9 = Paths.get("/tiger/cage");
        System.out.println(path8.resolve(path9));

        final Path path10 = Paths.get("/cats/../panther");
        final Path path11 = Paths.get("food");
        System.out.println(path10.resolve(path11));
        System.out.println(path10.normalize());
        System.out.println(Paths.get(".").toRealPath());
        Files.exists(path4);
        Files.isSameFile(path, path2);
        //Files.createDirectories(path1);
        //Files.createDirectory(path1);
        //Files.copy(path, path2);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            bufferedReader.lines().forEach(line -> log.info("Read {}", line));
        } catch (IOException e) {

        }

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
             bufferedWriter.write("Hello every one\n");
             bufferedWriter.write("Hello every one\n");
             bufferedWriter.write("Hello every one\n");
        }

        try {
            List<String> content = Files.readAllLines(path);
            log.info("Content {}", content.stream().reduce(String::concat));
        } catch (IOException e) {

        }

        UserPrincipal u = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("tuhlc");
        Files.setOwner(path, u);
        log.info("{}", u);

        BasicFileAttributes data = Files.readAttributes(path, BasicFileAttributes.class);
        BasicFileAttributeView attributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);

    }


    void info(Path path) {
        log.info("Path {}", path);
        log.info("File name {}", path.getFileName());
        log.info("Root {}", path.getRoot());
        log.info("Is absolute {}", path.isAbsolute());
        Path curParent = path;

        while ((curParent = curParent.getParent()) != null) {
            log.info("Parent {}", curParent);
        }
    }
}
