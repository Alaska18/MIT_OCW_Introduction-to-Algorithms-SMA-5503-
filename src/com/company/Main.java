package com.company;
import com.sun.media.sound.JARSoundbankReader;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import sun.management.AgentConfigurationError;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//If the list A is sorted, the algorithm always returns true.
//• If the list A is not 90% sorted, the algorithm returns false with probability at least 2/3.
// We need to find the minimum number of Iterations to achieve the result with 2/3 probability that the list is not sorted.
// 2/3 is approx == 0.666
// The probability of landing on elements that provide true output is  1 - 2/n when k iterations are performed total is
// (1- 2/n)^k <= 1/3 <= 0.3333 (not more than 1/3)
// gives k >= log(3)*n/2; // at least n
// this means that is k is less than n then it will provide correct result but not with 2/3 probability.
// implementing the algorithm with k = 8 gives the result as



import java.util.*;

public class Main{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] papers = new int[10];
        for(int i = 0; i < 10; i++)
        {
            papers[i] = scanner.nextInt();
        }
        findProbability(papers);
    }
    private static void findProbability(int[] examPapers)
    {
        Random r = new Random();
        boolean ifSorted;

        int n = 0;
        while (n < 10) {
            int randomIndex = r.nextInt(8) + 1; // assuming size is 9
            ifSorted = (examPapers[randomIndex] >= examPapers[randomIndex - 1]) && (examPapers[randomIndex] <= examPapers[randomIndex + 1]);
            System.out.println("Trial: " + n + " " + (ifSorted));
            n++;
        }


    }



}