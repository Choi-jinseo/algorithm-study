#include <iostream>
using namespace std;

int main()
{
    long long nFac = 1, mFac = 1, m_nFac = 1;
    long long mCn = 1;
    int t, n, m;
    cin >> t;
    for (int T = 0; T < t; T++) {
        cin >> n >> m;
        // m!/m-n!*n!
        long long temp = n;
        long long count = 1;
        if (n > m - n) temp = m - n;
        for (int i = 0; i < temp; i++) {
            count = count * (m - i);
            count = count / (i + 1);
            //cout << "n - i : " << n - i << " i + 1 : " << i + 1;
        }
        cout << count << endl;
    }
    return 0;
}