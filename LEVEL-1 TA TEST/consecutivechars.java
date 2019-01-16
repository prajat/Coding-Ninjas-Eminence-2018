import java.util.*;

public class solution {

    public static void LongestLetterChain(char[][] mat, char[] letters) {

        for (int i = 0; i < letters.length; i++) {

            char cc = letters[i];

            int ans = maxpath1(mat, cc);
            System.out.println(ans);
        }

    }

    public static int maxpath1(char[][] mat, char cc) {
        int max = 0;

        int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == cc) {

                    for (int x = 0; x < 8; x++) {
                        int length = maxpathutil(mat, i + row[x], j + col[x], cc);
                        max = Math.max(max, 1 + length);
                    }

                }
            }
        }
        return max;

    }

    public static boolean isValid(int x, int y, char[][] mat) {
        return (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length);
    }

    private static int maxpathutil(char[][] mat, int i, int j, char cc) {

        int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
        if (!isValid(i, j, mat) || cc + 1 != mat[i][j]) {
            return 0;
        }
        int maxlength = 0;

        for (int k = 0; k < 8; k++) {

            int len = maxpathutil(mat, i + row[k], j + col[k], mat[i][j]);

            maxlength = Math.max(maxlength, 1 + len);
        }

        return maxlength;

    }

}
