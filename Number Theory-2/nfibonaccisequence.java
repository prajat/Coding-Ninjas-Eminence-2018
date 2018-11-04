void multiply(signed long long A[2][2], signed long long M[2][2])
{
	A[0][0] %= 1000000007;
	A[0][1] %= 1000000007;
	A[1][0] %= 1000000007;
	A[1][1] %= 1000000007;

	M[0][0] %= 1000000007;
	M[0][1] %= 1000000007;
	M[1][0] %= 1000000007;
	M[1][1] %= 1000000007;

	signed long long first = (( A[0][0] * M[0][0] ) %1000000007  + ( A[0][1] * M[1][0] ) %1000000007)%1000000007; 	
	signed long long second = (( A[0][0] * M[0][1] ) %1000000007 + ( A[0][1] * M[1][1] ) %1000000007)%1000000007; 
	signed long long third = (( A[1][0] * M[0][0] ) %1000000007 +  ( A[1][1] * M[1][0] ) %1000000007)%1000000007; 
	signed long long fourth = (( A[1][0] * M[0][1] ) %1000000007 + ( A[1][1] * M[1][1] ) %1000000007)%1000000007; 

	A[0][0] = first%1000000007;
	A[0][1] = second%1000000007;
	A[1][0] = third%1000000007;
	A[1][1] = fourth%1000000007;
}

void power(signed long long A[2][2] , signed long long n)
{
	if(n <= 1)
		return;

	power(A,n/2);

	multiply(A,A);

	if(n%2 == 1) // if n is odd
	{
		signed long long M[2][2] =  { {1,1},{1,0} };
		multiply(A,M);
	}



}

signed long long fib(signed long long n)
{
	signed long long A[2][2] =  { {1,1},{1,0} };

	if(n == 0 )
		return 0;

	power(A,n-1);
	return (A[0][0]+1000000007)%1000000007;
}


signed long long fiboSum(signed long long m,signed long long n)
{
    
	signed long long first = fib(n+2);
	signed long long second = fib(m+1);
	return ( (first - second)+1000000007 )%1000000007;

}