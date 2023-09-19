package pe.sommesommee.study.cpt4.divideandconquer;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickSort {

    /*
    분할정복 전략이란 대표적인 재귀적 문제풀이 전략
    1.기본 단계를 설정 (기본 단계, 보통 배열 연산에서의 기본 단계는 배열 사이즈가 0이거나 1이 되는 경우)
    2.기본 단계가 될 때까지 나누거나 작게 만듬 (재귀 단계)
     */
    public static int[] quicksort(int[] param){

        //O(nlogn)

        //1. 기본 단계를 설정 한다.
        //1-1. 기본 단계는 배열의 사이즈가 2보다 작은 경우

        //3. 재귀 단계를 설정 한다.
        //3-1. pivot를 설정 한다.
        //3-2. pivot 기준 으로 큰 수의 배열과 작은 수의 배열을 설정 한다.
        //3-3. pivot 왼쪽에 작은 수의 배열을 두고 오른쪽에 큰 수의 배열을 둔다. 이때, 큰 수의 배열과 작은 수의 배열은 재귀 호출 한다.
        System.out.println(Arrays.toString(param));
        int[] result = recursiveQuickSort(param);
        System.out.println(Arrays.toString(result));

        return result;
    }

    private static int[] recursiveQuickSort(int[] param){
        //기본 단계
        if(param.length < 2){
            return param;
        }

        //재귀 단계
        final int pivot = param[0];

        int[] smallArr = recursiveQuickSort(Arrays.stream(param).skip(1).filter(t -> t < pivot).toArray());
        int[] bigArr = recursiveQuickSort(Arrays.stream(param).skip(1).filter(t -> t >= pivot).toArray());

        return IntStream.concat(IntStream.concat(IntStream.of(smallArr), IntStream.of(pivot)), IntStream.of(bigArr)).toArray();
    }
}
