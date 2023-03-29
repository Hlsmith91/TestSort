/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static testsort.QuickSort.iterativeQsort;

/**
 *
 * @author Heather
 */
public class TestSort {

    public static void main(String[] args) {
        
        ArrayList<Integer> array = new ArrayList<>();
        File file = new File("1KInts.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                int anInt = scan.nextInt();
                array.add(anInt);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Gets how long the sort took
            long nanoStartTime = System.nanoTime();
            long milliSecStart = System.currentTimeMillis();
            iterativeQsort(array);
            long nanoEndTime = System.nanoTime();
            long milliEndTime = System.currentTimeMillis();

        //System.out.println("Sorted array : " + array.toString());
        System.out.println("Sorted array : ");
        int psn = 0;
        while (psn < array.size()) {
            System.out.print(array.get(psn) + " ");
            psn++;
            if (psn % 25 == 0) {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("Nanoseconds: " + (nanoEndTime - nanoStartTime));
        System.out.println("Milliseconds: " + (milliEndTime - milliSecStart));

    }

}
