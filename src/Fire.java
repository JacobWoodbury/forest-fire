import java.util.*;
public class Fire {
    /**
     * Returns how long it takes for all vulnerable trees to be set on fire if a
     * match is lit at a given location.
     * 
     * The forest is represented via a rectangular 2d char array where t represents a tree
     * and . represents an empty space.
     * 
     * At time 0, the tree at location [matchR, matchC] is set on fire. At every subsequent
     * time step, any tree that is adjacent (up/down/left/right) to a burning tree is also
     * set on fire. 
     * 
     * 
     * EXAMPLE 
     * forest:
     * 
     * t..tttt.t
     * ..tt....t
     * ..ttttttt
     * tttt.....
     * 
     * matchR: 2
     * matchC: 6
     * 
     * Result: 8
     * 
     * Explanation:
     * At time 0, the tree at (2, 6) is set on fire. At time 1, its adjacent trees also catch on fire
     * At time 2, the trees adjacent to those catch as well. At time 8, the last tree to catch is at
     * (0,6). In this example, there is one tree that never burns, so it is not included in the time calculation.
     * 
     * 
     * @param forest a 2d array where t represents a tree and . represents the ground
     * @param matchR The row the match is lit at
     * @param matchC The column the match is lit at
     * @return the time at which the final tree to be incinerated starts burning
     */
    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?
        boolean[][] visited = new boolean[forest.length][forest[0].length];
        return timeToBurn(forest, matchR, matchC, 0, visited);
    }


    public static int timeToBurn(char[][] forest, int r, int c, int time, boolean[][] visited){
        
        Queue<int[]> trees = new LinkedList<>();
        trees.add(new int[] {r, c, time});
        visited[r][c] = true;
        int maxTime = 0;

        while(!trees.isEmpty()){
            int[] current = trees.poll();
            System.out.println(current[2]);
            int currentTime = current[2];
        
            maxTime = currentTime;
         for(int[] dir: directions){

            int[] point = {current[0]+dir[0], current[1] +dir[1], currentTime +1};
            
             if(point[0] >= 0 && point[0]<forest.length && 
             point[1] >=0 && point[1] <forest[0].length && 
             !visited[point[0]][point[1]] && 
             forest[point[0]][point[1]] == 't'){

                visited[point[0]][point[1]] = true;
                trees.add(point);
             }
            
        }
    }

        return maxTime ;
    }

    private static int[][] directions = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };


}