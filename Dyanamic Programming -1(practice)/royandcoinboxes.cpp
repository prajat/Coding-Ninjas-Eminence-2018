#include <bits/stdc++.h>
using namespace std;
#define MAX 1000001

int main()
{
    int n, m;
    cin >> n >> m;

    int *dp = new int[MAX];
    for (int i = 0; i < MAX; i++)
        dp[i] = 0;

    int l, r;
    for (int i = 0; i < m; i++)
    {
        cin >> l >> r;
        dp[r - 1]++;
        if (l > 1)
            dp[l - 2]--;
    }

    int *coin = new int[n];
    coin[n - 1] = dp[n - 1];
    for (int i = n - 2; i >= 0; i--)
    {
        coin[i] = dp[i] + coin[i + 1];
    }

    for (int i = 0; i < MAX; i++)
        dp[i] = 0;
    for (int i = 0; i < n; i++)
    {
        dp[coin[i]]++;
    }

    int *query = new int[MAX];
    query[MAX - 1] = dp[MAX - 1];
    for (int i = MAX - 2; i >= 0; i--)
    {
        query[i] = dp[i] + query[i + 1];
    }

    int q;
    cin >> q;
    int x;
    for (int i = 0; i < q; i++)
    {
        cin >> x;
        cout << query[x] << endl;
    }
}