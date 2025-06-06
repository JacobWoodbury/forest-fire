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
        trees.add(new int[] {r, c, });

        while(!trees.isEmpty()){
            int[] current = trees.poll();
            if(visited[current[0]][current[1]]) continue;
            visited[current[0]][current[1]] = true;

            trees.addAll(setFire(forest, r, c, visited));
        }
        return time;
    }

    private static int[][] directions = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    public static Set<int[]> setFire(char[][] forest, int r, int c, boolean[][] visited){
        Set<int[]> burning = new HashSet<>();
        
        for(int[] dir: directions){

            int[] point = {r+dir[0], c+dir[1]};
            if(visited[point[0]][point[1]]){
                continue;
            }
            if((r+<0 || c<0 || r>= forest.length || c>= forest[0].length)){
                continue;
            }
            if(forest[r+dir[0]][dir[1]] == 't'){//we need to check bounds here ish
                burning.add(point);
            }
        }
        return burning;
    }



}