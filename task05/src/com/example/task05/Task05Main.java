package com.example.task05;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task05Main
{
    public static void main(String[] args)
    {
        String pathToFile =  "/home/abracadabra.txt";

        try
        {
            String s = readFile(pathToFile);
            System.out.println(s);
        }

        catch (FileNotFoundException e)
        {
            throw new RuntimeException(String.format("file %s is not found", pathToFile));
        }

        catch (IOException e)
        {
            throw new RuntimeException(String.format("an error occurred while reading file: %s",pathToFile));
        }
    }

    public static String readFile(String pathToFile) throws IOException
    {
        FileReader fileReader = new FileReader(pathToFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null)
        {
            stringBuilder.append(currentLine);
            stringBuilder.append("\n");
        }
        bufferedReader.close();

        return stringBuilder.toString();
    }
}