public class L714cherryPickUp {

    public static void main(String[] args) {
        int[][] a = {{0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}};
        System.out.println(cherryPickup(a));
    }

    private static int cherryPickup(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxP = grid[0][0];
        int s = 0, l = 0;//当前点位置
        while (s < grid.length && l < grid[0].length) {
            if (s == grid.length - 1 || grid[s + 1][l] == -1) {
                l++;
                continue;
            } else if (l == grid[0].length - 1 || grid[s][l + 1] == -1) {
                s++;
                continue;
            } else if (grid[s + 1][l] == -1 && grid[s][l + 1] == -1) {
                return -1;
            } else if (grid[s + 1][l] == 1) {
                grid[s + 1][l] = 0;
                maxP += 1;
                s++;
            } else if(grid[s ][l+1] == 1) {
                grid[s ][l+1] = 0;
                maxP+=1;
                l++;
            }
        }

        return maxP + cherryPickupAgin(grid);
    }

    private static int cherryPickupAgin(int[][] grid) {
        return 0;
    }
}
