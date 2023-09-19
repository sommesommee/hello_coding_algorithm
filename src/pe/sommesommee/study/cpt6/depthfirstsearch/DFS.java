package pe.sommesommee.study.cpt6.depthfirstsearch;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class DFS {
    /*
    너비 우선 탐색 이란 Depth-First-Search(DFS) 라고 칭한다.
    정점(Node) 와 간선(edge) 로 구성된 데이터 구조에서 시작 Node 로 부터 edge 로 이어진 Node 를 depth 기준으로 순차적으로 탐색하며 목적지까지 도달하는 전략이다.
    주로 간선상의 데이터(시간, 거리) 가 존재하지 않는 정점, 간선 관계에서 목적지 등 특정 데이터를 찾을 때 유용하다.

     */

    /*
    백준, 1260
    문제,
    그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
    단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
    정점 번호는 1번부터 N번까지이다.
    입력,
    첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
    다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
    어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
    입력으로 주어지는 간선은 양방향이다.
     */
    private static Queue<Integer> queue;
    public static void dfs(){
        //1.정점별 간선 정보를 인접 리스트(Adjcency List)로 저장한다.
        //ArrayList<ArrayList<Integer>> or 2차원배열
        //2.큐를 생성한다. (offer(), poll(), peek())
        //3.큐의 시작 점점과 간선으로 연결된 정점의 정보를 넣는다.

        int N = 4;
        int M = 5;
        int V = 1;
        String S =
                "1 2\n" +
                "1 3\n" +
                "1 4\n" +
                "2 4\n" +
                "4 1";

        queue = new LinkedList<>();
        List<Tuple> edge = new ArrayList<>();
        //큐에 동일한 값이 입력되지 않도록 입력된 값을 체크
        int[]queue_check = new int[N];

        String[] temp = S.split("\n");
        for(String str : temp){
            String[] str_edge = str.split(" ");
            edge.add(new Tuple(Integer.parseInt(str_edge[0]), Integer.parseInt(str_edge[1])));
        }

        queue.offer(V);

        while(queue.size() > 0){

            int node = queue.poll();
            //System.out.println("node=" + node);

            for(int i=0; i<edge.size(); i++){

                if(edge.get(i).getP1() == node){
                    //System.out.println("for... node=" + node + ", edge_node=" + edge.get(i).getP2());
                    if(queue_check[edge.get(i).getP2() - 1] == 0){
                        queue_check[edge.get(i).getP1() - 1] = 1;
                        queue.offer(edge.get(i).getP2());
                        System.out.println("node=" + node + ", edge_node=" + edge.get(i).getP2());
                    }
                }

            }

        }

    }

    public static class Tuple{
        private int p1;
        private int p2;
        public Tuple(int p1, int p2){
            this.p1 = p1;
            this.p2 = p2;
        }

        public int getP1(){
            return p1;
        }
        public int getP2(){
            return p2;
        }

        @Override
        public String toString(){
            return "p1=" + p1 + ", p2=" + p2;
        }
    }

}
