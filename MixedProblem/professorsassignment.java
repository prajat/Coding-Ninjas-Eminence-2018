import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        int mod=1000000007;

        //int inv = 0.5 % mod;
       long i=1;
        long sum=0;
      	long t=500000004;
 
      	while(i<=n){
      	    long temp;
          	long x=n/i;
          	long j=n/x;
          	long y=(((((x)%mod)*((x+1)%mod))%mod)*t)%mod;
 
      	   temp=(((((j-i+1)%mod)*((i+j)%mod))%mod)*t)%mod;
 
          	sum=((sum+(temp*y)%mod))%mod;
 
          	i=j+1;
        }
      	
      System.out.println(sum);
    }

}