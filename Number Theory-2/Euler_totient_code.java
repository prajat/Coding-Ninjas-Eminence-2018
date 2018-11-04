


void EulerPhi(int n) // need to calculate Euler Totient of all numbers upto n
{
	int *phi = new int[n+1];

	for(int i=1;i<=n;i++)
		phi[i] = i;

	for(int i=2;i<=n;i++)
	{
		if(phi[i] == i) // imples i is a prime number
		{
			for(int j = 2*i;j<=n; j+=i )
				phi[j] = ( phi[j] * (i-1) ) / i;

			phi[i] = i-1;
		}
	}

	for(int i=1;i<=n;i++)
		cout << "Phi[" << i << "] is " << phi[i] << endl;
}


int main()
{	
	int n;
	cout << "Enter the number till which you want to calculate all Euler Totient Values : ";

	cin >> n;
	EulerPhi(n);


	return 0 ; 

}