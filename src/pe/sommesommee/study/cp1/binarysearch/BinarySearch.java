package pe.sommesommee.study.cp1.binarysearch;

import java.util.Arrays;
import java.util.Optional;

public class BinarySearch {

    /*
    이진 탐색이란 주어진 연산 대상을  순서대로 모두 추축하는 과정
    이때 이진 탐색은 반드시 배열의 원소들이 정렬되어 있을 때에만 사용할 수 있음
     */

    public static boolean binarySearch(int[] param1, int param2){

        //O(logn)

        System.out.println(Arrays.toString(param1));
        boolean result = recursiveBinarySearch(param1, param2, 0, param1.length - 1);
        System.out.println(result);
        return  result;

    }

    public static boolean recursiveBinarySearch(final int[] param1, final int param2, final int startIdx, final int endIdx){

        //기본 단계 (가장 작은 크기로 나눴을 때, 그 값이 찾고자 하는 값과 일치하는지 확인)
        if(startIdx == endIdx){
            if(param1[startIdx] == param2){
                return true;
            }else{
                return false;
            }
        }

        //재귀 단계 (배열의 중간 임의로 설정하여 피봇으로 두고 배열 또는 초과 배열을 반환)
        final int pivotIdx = startIdx + (endIdx - startIdx) / 2;

        //pivot이 찾고자하는 값과 같은 경우
        if(param1[pivotIdx] == param2){
            return true;
        }

        if(param2 < param1[pivotIdx]){
            return recursiveBinarySearch(param1, param2, startIdx, pivotIdx - 1);
        }else{
            return recursiveBinarySearch(param1, param2, pivotIdx + 1 , endIdx);
        }

    }

}
