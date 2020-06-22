package com.company;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.Random;
import java.util.Scanner;

public class Unimodal {

    public static void main(String[] a)
    {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] a1 = new int[s];
        for(int i = 0; i < s; i++)
        {
            a1[i] = sc.nextInt();
        }
        int result = findUniModal(a1, 0, s - 1);
        int result2 = findUniModalNaive(a1, 0, s - 1);
        if(result == -1 || result2 == -1)
            System.out.println("Not Found!");
        else if(result == result2)
        {
            System.out.println("Found at " + "Index : " + result);
        }
        else
            System.out.println("Error!");

        // Stress test
        /*Random r = new Random();
         while(true)
         {
             int n = r.nextInt(100);
             int[] array = new int[n];
             for(int j = 0; j < n; j++)
             {
                 array[j] = r.nextInt();
             }
             int r1 = findUniModal(array, 0, n - 1);
             int r2 = findUniModalNaive(array, 0, n - 1);
             if(r1 != r2)
             {
                 System.out.println("error");
             }
             else
                 System.out.println("okay!");
         }*/
    }
    private static int findUniModal(int[] array, int startIndex, int endIndex)
    {

        int m = (startIndex + endIndex)/2;  // running time - O(nlogn)
        if(m == 0) return array[0];   //only happen in the case of 1 or 2 elements in the array.
        if((m + 1 <= endIndex)&&(startIndex <= endIndex)&&(m > 0)) {
            if ((array[m] >= array[m - 1]) && (array[m] >= array[m + 1])) {
                return m;
            } else if ((array[m] >= array[m - 1]) && (array[m] <= array[m + 1]))
                return findUniModal(array, m + 1 , endIndex);
            else if ((array[m] <= array[m - 1]) && (array[m] >= array[m + 1]))
                return findUniModal(array, startIndex, m);
        }
        return -1;
    }
    private static int findUniModalNaive(int[] array, int startIndex, int endIndex)
    { if(endIndex <= 1) return array[0];    // running time - O(n)
        int result;
        for(int i = 1; i <= (endIndex - 1); i++)
        {
            if((array[i] >= array[i + 1])&&(array[i] >= array[i - 1]))
            {
                return i;
            }
        }
        return -1;
    }
}