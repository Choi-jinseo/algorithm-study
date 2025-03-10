#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

class Member {
public:
	int old;
	string name;
	int number;
};

bool mySort(Member a, Member b) {
	if (a.old == b.old) return a.number < b.number;
	else return a.old < b.old;
}

int main() {
	int n;
	int num = 1;
	cin >> n;
	Member* member = new Member[n];
	for (int i = 0; i < n; i++) {
		cin >> member[i].old >> member[i].name;
		member[i].number = num++;
	}
	sort(member, member + n, mySort);
	for (int i = 0; i < n; i++) {
		cout << member[i].old << " " << member[i].name << "\n";
	}
	return 0;
}