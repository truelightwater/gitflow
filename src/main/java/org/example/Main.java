package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String RESOURCE = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/bank-simple-data.csv";

    List<String> lines = null;

    public static void main(String[] args) throws IOException {

        Path path = Paths.get(RESOURCE);
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(100);
        Charset charset = Charset.forName("UTF-8");

        List<String> data2 = null;
        String data="";
        int byteCnt = 0;

        while (true) {
            byteCnt = fileChannel.read(buffer);
            if(byteCnt == -1) break;

            buffer.flip();
            data += charset.decode(buffer).toString();
            buffer.clear();
        }

        fileChannel.close();

        File file = new File("/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/bank-simple-data.csv");

        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> lines = Files.lines(file.toPath()).collect(Collectors.toList());
        System.out.println(lines.toString());
    }

//      line? 으로 읽는 것은 위에랑 크게 의미가 없는 것 같다.
//      File file = new File(RESOURCE + fileName);
//      lines = Files.lines(file.toPath()).collect(Collectors.toList());

//    FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);
//    ByteBuffer buffer = ByteBuffer.allocate(1024);
//    Charset charset = Charset.forName("UTF-8");
//
//    int byteCnt = 0;
//    String data = "";
//            while (true) {
//        byteCnt = fileChannel.read(buffer);
//        if(byteCnt == -1) break;
//
//        buffer.flip();
//        data = charset.decode(buffer).toString();
//        buffer.clear();
//    }
//
//            fileChannel.close();
//            System.out.println(data);

//        ByteBuffer buffer = null;
//        buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
//        Charset charset = Charset.defaultCharset();
//        String fileContent = charset.decode(buffer).toString();
//        BankTransaction bankTransaction = parser.parseFrom(fileContent);

}