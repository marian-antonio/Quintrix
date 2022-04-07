package com.quintrix.jfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportFile {

  public static void main(String[] args) throws FileNotFoundException {
    String filePath = "..\\quintrix-java\\src\\test\\testInputFile.txt";
    File file = new File(filePath);
    System.out.println("File exists: " + file.exists() + "\n\nFile Contents:");

    Scanner scan = new Scanner(file);
    while (scan.hasNextLine()) {
      System.out.println(scan.nextLine());
    }
    scan.close();
  }

}
