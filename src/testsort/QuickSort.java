/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author Heather
 */
public class QuickSort {

    public static void iterativeQsort(ArrayList<Integer> array) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        stack.push(array.size());
        
        
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) {
                continue;
            }
            
            int p = start + ((end - start) / 2);
            
            p = partition(array, p, start, end);
            
            stack.push(p + 1);
            stack.push(end);

            stack.push(start);
            stack.push(p);

        }
    }

   
    private static int partition(ArrayList<Integer> input, int p, int start, int end) {
        
        int l = start;
        int h = end - 2; 
        int piv = input.get(p); 
        Collections.swap(input, p, end - 1);
        while (l < h) {
            if (input.get(l) < piv) {
                l++;
            } else if (input.get(h) >= piv) {
                h--;
            } else {
                Collections.swap(input, l, h);
            }
        }
        int idx = h;
        if (input.get(h) < piv) {
            idx++;
        }
        Collections.swap(input, end - 1, idx);

        return idx;
    }

}
