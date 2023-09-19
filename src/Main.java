import pe.sommesommee.study.cp1.binarysearch.BinarySearch;
import pe.sommesommee.study.cp1.simplesearch.SimpleSearch;
import pe.sommesommee.study.cpt2.selectedsort.SelectedSort;
import pe.sommesommee.study.cpt4.divideandconquer.QuickSort;
import pe.sommesommee.study.cpt6.depthfirstsearch.DFS;

public class Main {
    public static void main(String[] args) {

        int[] test1 = {1, 6, 2, 4, 6, 5, 7, 0, 10, 6, 4};
        int[] test2 = {1, 6, 2, 4, 6, 5, 7, 0, 10, 6, 4};

        System.out.println("SimpleSearch");
        SimpleSearch.simpleSearch(test2, 10);

        System.out.println("selectedSort");
        SelectedSort.SelectedSort(test1);

        System.out.println("quickSort");
        int[] qsortTest = QuickSort.quicksort(test2);

        System.out.println("binarySearch");
        BinarySearch.binarySearch(qsortTest, 2);

        System.out.println("Depth-First-Search");
        DFS.dfs();
    }

}