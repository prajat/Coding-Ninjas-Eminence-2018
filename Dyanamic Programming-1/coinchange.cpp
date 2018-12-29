
int Number_of_Changes_DP(int n, int k, int *den, int **output) // DP way
{
    if (n == 0)
        return 1;
    if (n < 1 || k == 0)
        return 0;

    if (output[n][k] != -1)
        return output[n][k];

    int first = Number_of_Changes_DP(n - den[k - 1], k, den, output);
    int second = Number_of_Changes_DP(n, k - 1, den, output);

    output[n][k] = first + second;
    return first + second;
}

int countWaysToMakeChange(int denominations[], int numDenominations, int value)
{

    int n = value;
    int k = numDenominations;
    int **output = new int *[n + 1]; //n+1 rows;

    for (int i = 0; i <= n; i++)
        output[i] = new int[k + 1]; //k+1 columns

    for (int i = 0; i <= n; i++)
        for (int j = 0; j <= k; j++)
            output[i][j] = -1;
    return Number_of_Changes_DP(value, numDenominations, denominations, output);
}
