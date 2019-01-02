#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define pb push_back

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string b1, b2;
        int l;
        cin >> b1 >> b2 >> l;

        int n = b1.length();
        int m = b2.length();

        int dp[n + 1][m + 1][l + 1];
        for (int i = 0; i <= n; i++)
        {
            dp[i][0][0] = 0;
            for (int k = 1; k <= l; k++)
                dp[i][0][k] = INT_MIN;
        }
        for (int j = 0; j <= m; j++)
        {
            dp[0][j][0] = 0;
            for (int k = 1; k <= l; k++)
                dp[0][j][k] = INT_MIN;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                dp[i][j][0] = 0;
                if (b1[i - 1] == b2[j - 1])
                {
                    for (int k = 1; k <= l; k++)
                    {
                        dp[i][j][k] = max(dp[i - 1][j - 1][k - 1] + b1[i - 1], max(dp[i - 1][j][k], dp[i][j - 1][k]));
                    }
                }
                else
                {
                    for (int k = 1; k <= l; k++)
                    {
                        dp[i][j][k] = max(dp[i - 1][j][k], dp[i][j - 1][k]);
                    }
                }
                // cout << i << " " << j << " " << dp[i][j][l-1] << " " << dp[i][j][l] << endl;
            }
            // cout << endl;
        }

        if (dp[n][m][l] < 0)
            cout << 0 << endl;
        else
            cout << dp[n][m][l] << endl;
    }
}