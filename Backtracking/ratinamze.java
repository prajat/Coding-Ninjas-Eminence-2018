import java.util.*;
/**
 * ratinamze
 */
public class ratinamze {

    public static void main(String[] args) {

        int[][] maze = { { 1, 0, 1}, {  1, 1, 1 }, {  1, 1, 1 } };
        ratInAMaze(maze);
    }
    
    public static void ratInAMaze(int maze[][]) {

        int[][] solution = new int[maze.length][maze.length];
        mazehelp(maze, solution, 0, 0);

    }

    public static void mazehelp(int[][] maze, int[][] solution, int x, int y) {

        if (x == maze.length - 1 && y == maze.length - 1) {
            solution[x][y] = 1;
            printsolution(solution);
            solution[x][y] = 0;
            return;
        }
        if (x >= maze.length || x < 0 || y >= maze.length || y < 0 || maze[x][y] == 0 || solution[x][y] == 1) {
            return;

        }
        solution[x][y] = 1;
        mazehelp(maze, solution, x - 1, y);
        mazehelp(maze, solution, x + 1, y);
        mazehelp(maze, solution, x, y - 1);
        mazehelp(maze, solution, x, y + 1);
        solution[x][y] = 0;
    }

    public static void printsolution(int[][] solution) {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                System.out.print(solution[i][j]+" ");
            }
        }
        System.out.println();
        
    }
}