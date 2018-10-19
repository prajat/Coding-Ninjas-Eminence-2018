#include<bits/stdc++.h>
#include<vector>
#include<algorithm>
using namespace std;
 
int* lowest_primed( int n ){
  int* arr = new int[n+1] ;
 
  for( int i=0 ; i<= n ; i++ ){
    arr[i] = 0 ;
  }
 
  for( int i=2 ; i <= n ; i++ ){
    if( arr[i] == 0 ){
      arr[i] = i ;
 
      for( int j=2*i ; j<= n ; j+=i ){
        if( arr[j] == 0 ){
          arr[j] = i ;
 
        }
      }
    }
  }
 
  return arr ;
 
}
 
void strange_order( int* p , int n ){
 
  int *arr = lowest_primed( n ) ;
  bool marked[n] ={0} ;
  vector<int>  v1 ;
 
  for( int i=n-1 ; i>=0 ; i-- ){
    vector<int> v ;
    if( marked[i] == 0 ){
      v.push_back(p[i]) ;
      marked[i] = 1 ;
      int x = p[i] ;
 
      int lpd = arr[x] ;
      while( x != 1 ){
        for( int j=i-lpd ; j>= 1 ; j-=lpd ){
          if( marked[j] == 0 ){
          	v.push_back(p[j]) ;
          	marked[j] = 1 ;
          }
        }
 
 
        while( x%lpd == 0 ){
          x = x/lpd ;
        }
        lpd = arr[x] ; 
 
      }
 
    }
 
    sort( v.begin() , v.end() , greater<int>()) ;
 
    for( int i=0 ; i< v.size() ; i++){
      v1.push_back(v[i]) ;
    }
 
  }
 
  for( int i=0 ; i< v1.size() ; i++ ){
    cout<<v1[i]<<" " ;
  }
 
}
 
 
 
int main() {
 
 
    int n ;
  cin>> n ;
 
  int *p = new int[n] ;
  for( int i=0 ; i< n ; i++ ){
    p[i] = i+1 ;
  }
 
  strange_order( p , n ) ;
	// Write your code here
}