package com.pb.kopejkin.hw9;


import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class FileNumbers {

    private static final Logger logger = Logger.getLogger(FileNumbers.class.getName());
    Path path = Paths.get("src/com/pb/kopejkin/hw9/numbers.txt");

    public void createNumbersFile(){
        logger.info("->> Start createNumbersFile...");

        Random random = new Random();
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            int count =0;
            for(int i=1; i<100; i++){
                count++;
                writer.write(random.nextInt(100)+" ");
                if(count==10){
                    count=0;
                    writer.newLine();
                }
            }
            logger.info("- Write in file "+path.toAbsolutePath()+
                    " successfully!");
        } catch (Exception e){
            logger.severe("!!!Failed to write in file..\nDescription: "+
                    e.getMessage());
        }
    }

    public void createOddNumbersFile() {
        logger.info("->> Start createOddNumbersFile...");

        Path pathOdd = Paths.get("src/com/pb/kopejkin/hw9/odd-numbers.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(pathOdd)) {
            List<String> arrInt = Files.readAllLines(path);

            for (String s : arrInt) {
                System.out.println(s);
                String[] array = s.split(" ");

                for (String value : array) {
                    int integer = Integer.parseInt(value);
                    if(integer % 2 == 0) {
                        integer = 0;
                    }
                    writer.write(integer + " ");
                }
                writer.newLine();
            }
            logger.info("- Read from "+path.toAbsolutePath()+" and write to "+
                    pathOdd.toAbsolutePath()+" successfully done!");
        } catch (Exception e){
            logger.severe("!!!Failed write in file : "+
                    pathOdd.toAbsolutePath()+"\nDescription: "+e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {

        FileNumbers fileNumbers = new FileNumbers();

        fileNumbers.createNumbersFile();
        fileNumbers.createOddNumbersFile();


    }
}
