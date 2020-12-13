package com.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Counter.exceptionMessage = "";
            Counter.count(scanner.nextLine());
            if (Counter.exceptionMessage.length() > 0) {
                throw new Exception(Counter.exceptionMessage, new Throwable());
            }
            System.out.println(Counter.result);
        }
    }
}
