package pe.sommesommee.study.cp1.simplesearch;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SimpleSearch {

    /*
    단순탐색이란 말 그대로 연산 횟수는 주어진 연산 대상을  순서대로 모두 추축하는 과정
     */
    public static boolean simpleSearch(int[] param1, final int param2){

        //O(n)

        System.out.println(Arrays.toString(param1));
        boolean result = IntStream.of(param1).sequential().anyMatch(t -> t == param2);
        System.out.println(result);

        return result;

    }
}
