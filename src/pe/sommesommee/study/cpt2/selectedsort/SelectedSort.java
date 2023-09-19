package pe.sommesommee.study.cpt2.selectedsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelectedSort {

    /*
    선택 정렬이란 배열의 가장 큰 값을 배열에 맨 앞으로 위치시키며 순차적으로 정렬하는 과정
     */


    public static int[] SelectedSort(int[] param){

        //O(n^2)

        System.out.println(Arrays.toString(param));
        int[] result = new int[param.length];
        List<Integer> list = IntStream.of(param).boxed().collect(Collectors.toList());
        recursiveSelectedSort(list, result, param.length - 1);
        System.out.println(Arrays.toString(result));

        return result;

    }

    private static int[] recursiveSelectedSort(List<Integer> param, int[] result, int headIdx){
        //기본 단계
        if(headIdx < 0){
            return result;
        }

        //재귀 단계
        //가장 큰 값을 찾은 후 그 값을 제외
        int maxNum = 0;
        int maxNumIdx = 0;
        for(int i=0; i<param.size(); i++){
            if(maxNum < param.get(i)){
                maxNum = param.get(i);
                maxNumIdx = i;
            }
        }

        param.remove(maxNumIdx);
        result[headIdx] = maxNum;


        return recursiveSelectedSort(param, result, headIdx - 1);
    }
}
