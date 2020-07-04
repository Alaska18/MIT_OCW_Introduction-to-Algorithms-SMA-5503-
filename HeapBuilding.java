package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HeapBuilding {
    static class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }


    static public void main(String[] args) throws IOException {

        Main.FastScanner scanner = new Main.FastScanner();
        int n = scanner.nextInt();
        int[] array = new int[n + 1];
        array[0] = 0;
        for (int i = 1; i <= n; i++)
        {
            array[i] = scanner.nextInt();
        }
        for (int i = (n)/2; i >= 1; i--)
        {
            heapify(i, array);
        }
        for(int element : array)
        {
            System.out.print(element + " ");
        }

    }
    public static int getLeft(int index)
    {
        return 2*index;
    }
    public static int getRight(int index)
    {
        return 2*index + 1;
    }
    public static int getParent(int index)
    {
        return index/2;
    }
    public static void heapify(int index, int[] array)
    {
        if(2*index > array.length - 1)
        {
            return;
        }
        int leftChild = getLeft(index);
        int rightChild = getRight(index);
        int largest;
        if(leftChild < array.length && array[leftChild] > array[index])
        {
            largest = leftChild;
        }
        else
        {
            largest = index;
        }
        if(rightChild < array.length && array[rightChild] > array[largest])
        {
            largest = rightChild;
        }
        if(largest != index) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            heapify(largest, array);
        }
    }

}

