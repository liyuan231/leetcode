package algorithm;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.Scanner;

public class Stats {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
//        readIntsBag();
//        readIntsQueues();
        readIntsStack();
    }

    private static void readIntsBag() {
        Bag<Double> numbers = new Bag<Double>();
        double num;
        while ((num = input.nextDouble()) != -1) {
            numbers.add(num);
        }
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / N;
        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (N - 1));
        System.out.printf("Mean:%.2f\n", mean);
        System.out.printf("Std dev:%.2f\n", std);
    }

    public static void readIntsQueues(){
        int num = -1;
        Queue<Integer> queue = new Queue<>();
        while ((num = input.nextInt())!=-1){
            queue.enqueue(num);
        }
        for(int i:queue){
            System.out.print(i+"->");
        }
    }
    public static void readIntsStack(){
        int num;
        Stack<Integer> stack = new Stack<>();
        while ((num=input.nextInt())!=-1){
            stack.push(num);
        }
        for(int i:stack){
            System.out.print(i+"->");
        }
    }
}
