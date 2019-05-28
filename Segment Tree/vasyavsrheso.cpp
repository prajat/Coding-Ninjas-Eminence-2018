#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define pb push_back

class node{
public:
    int a, b;

    node(){

    }

    node(int a, int b){
        this->a = a;
        this->b = b;
    }
};

void buildTree(int *tree, node *input, int si, int ei, int id){
    if(si == ei){
        tree[id] = si;
        return;
    }

    int mid = (si+ei)/2;
    buildTree(tree, input, si, mid, 2*id);
    buildTree(tree, input, mid+1, ei, 2*id+1);

    if(input[tree[2*id]].a > input[tree[2*id+1]].a) tree[id] = tree[2*id];
    else if(input[tree[2*id]].a < input[tree[2*id+1]].a) tree[id] = tree[2*id+1];
    else{
        if(input[tree[2*id]].b < input[tree[2*id+1]].b) tree[id] = tree[2*id];
        else if(input[tree[2*id]].b > input[tree[2*id+1]].b) tree[id] = tree[2*id+1];
        else tree[id] = min(tree[2*id], tree[2*id+1]);
    }
}

int query(int *tree, node *input, int si, int ei, int id, int left, int right){
    if(si > right || ei < left) return left;

    if(si >= left && ei <= right) return tree[id];

    int mid = (si+ei)/2;
    int x = query(tree, input, si, mid, 2*id, left, right);
    int y = query(tree, input, mid+1, ei, 2*id+1, left, right);

    if(input[x].a > input[y].a) return x;
    else if(input[x].a < input[y].a) return y;
    else{
        if(input[x].b < input[y].b) return x;
        else if(input[x].b > input[y].b) return y;
        else return min(x, y);
    }
}

int main(){
    int n;
    cin >> n;

    node *input = new node[n];
    for(int i = 0; i < n; i++) cin >> input[i].a;
    for(int i = 0; i < n; i++) cin >> input[i].b;

    int *tree = new int[4*n];
    buildTree(tree, input, 0, n-1, 1);

    int q;
    cin >> q;
    int x, y;
    while(q--){
        cin >> x >> y;
        cout << query(tree, input, 0, n-1, 1, x-1, y-1)+1 << endl;
    }
}