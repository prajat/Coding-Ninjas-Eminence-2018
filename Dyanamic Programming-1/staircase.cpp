long Solve_Recursively(int n, long *arr)
{
    if (n == 0 || n == 1)
        return 1;
    if (n == 2)
        return 2;

    if (arr[n] != 0)
        return arr[n];

    long answer1 = Solve_Recursively(n - 1, arr);
    long answer2 = Solve_Recursively(n - 2, arr);
    long answer3 = Solve_Recursively(n - 3, arr);
    arr[n] = answer1 + answer2 + answer3;

    return answer1 + answer2 + answer3;
}

long staircase(int n)
{
    /*  Don't write main().
     *  Don't read input, it is passed as function argument.
     *  Return output and don't print it.
     *  Taking input and printing output is handled automatically.
     */
    long *arr = new long[n + 1];
    for (int i = 0; i <= n; i++)
        arr[i] = 0;

    return Solve_Recursively(n, arr);
}
