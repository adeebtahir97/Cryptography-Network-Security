#include<iostream>
#include<vector>

using namespace std;


/*-----------------------------------------------------*/

/*string encrypt(string, int): A function which takes
in plain text and key and returns encrypted text using
Caesar Cipher*/

string encrypt(string plainText, int key)
{
	string cipherText = "";
	for(int i = 0; i < plainText.length(); i++)
	{
		cipherText += ((plainText[i] - 'a' + key) % 26 + 'a');
	}
	return cipherText;
}


/*-----------------------------------------------------*/

/*string decrypt(string, int): A function which takes
in plain text and key and returns encrypted text using
Caesar Cipher*/

string decrypt(string cipherText, int key)
{
	string plainText = "";
	for(int i = 0; i < cipherText.length(); i++)
	{
		plainText += ((cipherText[i] - 'a' - key + 26) % 26 + 'a');
	}
	return plainText;
}


/*-----------------------------------------------------*/

int main()
{
	string plainText, cipherText;
	int choice, key;
	while(1)
	{
		cout << "\n\t\t CAESAR CIPHER \n\n\t 1. Encryption \n\t 2.Decryption \n\t Your choice: ";
		cin >> choice;
		switch(choice)
		{
			case 1:
				cout << "\n\t Enter PlainText: "; 
				cin >> plainText;
				cout << "\n\t Enter key: ";
				cin >> key;
				cout << "\n\t Cipher Text: " << encrypt(plainText, key);
				break;
			case 2:
				cout << "\n\t Enter CipherText: ";
				cin >> cipherText;
				cout << "\n\t Enter key: ";
				cin >> key;
				cout << "\n\t Plain Text: " << decrypt(cipherText, key);
				break;
			default:
				return 0;
		}
	}
	return 0;
}