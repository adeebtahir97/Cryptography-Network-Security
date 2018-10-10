#include<bits/stdc++.h>
#include<conio.h>
using namespace std;
int main(){
	double p,q;
	double a,b;
	cout<<"Enter p(prime) & q(generator)->";
	cin>>p>>q;
	cout<<"Enter Alice's personal key A->"; cin>>a;
	cout<<"Enter Bob's personal key B->"; cin>>b;
	double astar,bstar;
	astar = fmod(pow(q,a),p);
	bstar = fmod(pow(q,b),p);
	cout<<" Alice's Public Key(A*) using (q^a mod p)-> "<<astar<<endl;
	cout<<" Bob's Public key(B*) using (q^b mod p)-> "<<bstar<<endl;

	cout<<" Decryption Key(X) computed by Alice(B*^a mod p) ->"<<fmod(pow(bstar,a),p)<<endl;
	cout<<" Decryption Key(Y) computed by Bob(A*^b mod p) ->"<<fmod(pow(astar,b),p)<<endl;

	cout<<" Diffie-Helman Key Exchange Successfully Performed! "<<endl;
	getch();
}