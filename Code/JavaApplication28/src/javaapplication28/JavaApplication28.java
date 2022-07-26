
package javaapplication28;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class JavaApplication28 {
static int numberOfFiles;
static ArrayList<String> str=new ArrayList<String>();
static File directoryPath=new File("E:\\University\\3-Third Year\\Operating Systems II\\Project\\Default Folder");
static String Longest;
static String Shortest;
static long numberOfWords;
static myFrame frame;

    public static void main(String[] args) {
        
        str.clear();
        Shortest="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Longest="";
        numberOfWords=0;
        numberOfFiles=0;
        int number_of_Threads = 5;
        Thread[] threads = new Thread[number_of_Threads];
        for (int t = 0; t < number_of_Threads; t++) {
            final int thread = t;
            threads[t] = new Thread() {
                @Override
                public void run() {
                    try {
 
                        File filesList[] = new File[100];
                        filesList = directoryPath.listFiles();
                        numberOfFiles=filesList.length;
                        final int filesPerThread = filesList.length / number_of_Threads;
                        final int remainingFiles = filesList.length % number_of_Threads;
                        runThread(filesList, number_of_Threads, thread, filesPerThread, remainingFiles);
                    } catch (FileNotFoundException ex) {
                    }
                }
            };
        }
        
        
        
        for (Thread t1 : threads) {
            t1.start(); // start processing all threads
        }
        for (Thread t2 : threads)
 
            try {
 
            t2.join(); // To wait until all thread complete its execution } catch (Interrupted Exception e) { }
 
        } catch (InterruptedException e) {}
        
        frame = new myFrame(numberOfFiles,str,Longest,Shortest,numberOfWords);
        
        
        
    }
 
    private static void runThread(File[] filesList, int numberOfThreads, int thread, int filesPerThread, int remainingFiles) throws FileNotFoundException {
 
        // Assigning files equally to each threads and assign remaining files to the last thread 
        List<File> inFiles = new ArrayList<>();
 
        for (int i = thread * filesPerThread; i < (thread + 1) * filesPerThread; i++) {
            inFiles.add(filesList[i]);
        }
 
        if (thread == numberOfThreads - 1 && remainingFiles > 0) {
            for (int j = filesList.length - remainingFiles; j < filesList.length; j++) {
                inFiles.add(filesList[j]);
            }
        }
 
        for (File file : inFiles) {
            int isCount = 0;
            int areCount = 0;
            int youCount = 0;
            int wordCount= 0;
            String longest = "";
            String shortest = "";
            isCount = getCount("is", file);
            areCount = getCount("are", file);
            youCount = getCount("you", file);
            wordCount= getCountWord(file);
            longest = getLongest(file);
            shortest = getShortest(file);
 
            /*System.out.println("Number Of \"Is\" in file " + file.getName() + " " + isCount);
            System.out.println("Number Of \"Are\" in file " + file.getName() + " " + areCount);
            System.out.println("Number Of \"You\" in file " + file.getName() + " " + amCount);
            System.out.println("Longest Word in file " + file.getName() + " " + longest);
            System.out.println("Shortest Word in file " + file.getName() + " " + shortest);*/
            
            str.add(file.getName());
            str.add(String.valueOf(wordCount));
            str.add(String.valueOf(isCount));
            str.add(String.valueOf(areCount));
            str.add(String.valueOf(youCount));
            str.add(longest);
            str.add(shortest);
            if(longest.length()>Longest.length())
                Longest=longest;
            if(shortest.length()<Shortest.length())
                Shortest=shortest;
            numberOfWords+=wordCount;
 
        }
                
    }
 
    private static int getCount(String word, File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        int count = 0;
        while (s.hasNext()) {
 
            if (s.next().equals(word)) {
                count++;
            }
        }
 
        return count;
    }
    private static int getCountWord(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        int count = 0;
        while (s.hasNext()) {
            s.next();
            count++; 
           
        }
 
        return count;
    }
 
    private static String getLongest(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        String longest = "";
        String current = "";
        while (s.hasNext()) {
            current = s.next();
            if (current.length() > longest.length()) {
                longest = current;
            }
        }
 
        return longest;
 
    }
 
    private static String getShortest(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        String shortest = s.next();
        String current = "";
        while (s.hasNext()) {
            current = s.next();
            if (current.length() < shortest.length()) {
                shortest = current;
            }
        }
 
        return shortest;
 
    }
 
    
}
