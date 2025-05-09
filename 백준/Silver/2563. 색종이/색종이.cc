#include <iostream>
using namespace std;

int paper[100][100]{0};

void coloring(int x, int y)
{
    for (int i = x; i < x + 10; i++)
    {
        for (int j = y; j < y + 10; j++)
        {
            paper[i][j] = 1;
        }
    }
}

int main()
{
    int N, x, y;
    int count = 0;

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> x >> y;
        coloring(x, y);
    }
    for (int i = 0; i < 100; i++)
    {
        for (int j = 0; j < 100; j++)
        {
            count += paper[i][j];
        }
    }
    cout << count;
    return 0;
}