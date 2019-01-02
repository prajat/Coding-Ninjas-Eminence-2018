#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, m;
    cin >> n >> m;

    int **input = new int *[n];
    for (int i = 0; i < n; i++)
    {
        input[i] = new int[m];
        for (int j = 0; j < m; j++)
            cin >> input[i][j];
    }

    bool dp[n][n][m];

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            dp[i][i][j] = true;
        }
    }

    int i = 0, j = 0, col = 1;
    while (col < n)
    {
        j = col;
        i = 0;

        while (j < n)
        {
            for (int k = 0; k < m; k++)
            {
                dp[i][j][k] = dp[i][(i + j) / 2][k] && dp[((i + j) / 2) + 1][j][k] && (input[((i + j) / 2) + 1][k] >= input[(i + j) / 2][k]);
            }
            i++;
            j++;
        }
        col++;
    }

    int q;
    cin >> q;
    int x, y;
    while (q--)
    {
        cin >> x >> y;
        int k;
        for (k = 0; k < m; k++)
        {
            if (dp[x - 1][y - 1][k])
            {
                cout << "Yes" << endl;
                break;
            }
        }
        if (k == m)
            cout << "No" << endl;
    }
}