#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    scanf("%d", &t);
    while (t--)
    {
        int r, c;
        scanf("%d%d", &r, &c);
        int a[r][c];
        for (int i = 0; i < r; ++i)
            for (int j = 0; j < c; ++j)
                scanf("%d", &a[i][j]);

        /*here we want that harry shouldnt die in the way,
      so we start from the destination and keep traversing 
      the path backwards, and calculating the minimum required
      power, if the power falls below or equal to zero, we
      reset the power. 
      Note that the reverse traversal means traversal along
      opposite direction of what is mentioned in the problem.
      */
        /*All 3 loops are reverse of what we do in 
      Minimum cost Path Problem*/
        a[r - 1][c - 1] = 1;
        for (int i = c - 2; i >= 0; --i)
        {
            a[r - 1][i] = a[r - 1][i + 1] - a[r - 1][i];
            if (a[r - 1][i] <= 0) //reset condition
                a[r - 1][i] = 1;
        }
        for (int i = r - 2; i >= 0; --i)
        {
            a[i][c - 1] = a[i + 1][c - 1] - a[i][c - 1];
            if (a[i][c - 1] <= 0)
                a[i][c - 1] = 1;
        }
        for (int i = r - 2; i >= 0; --i)
            for (int j = c - 2; j >= 0; --j)
            {
                a[i][j] = min(a[i + 1][j], a[i][j + 1]) - a[i][j];
                if (a[i][j] <= 0)
                    a[i][j] = 1;
            }
        printf("%d\n", a[0][0]);
    }
    return 0;
}