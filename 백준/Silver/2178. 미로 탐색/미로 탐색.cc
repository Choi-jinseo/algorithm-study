#include <iostream>
#include <queue>
using namespace std;
// 미로의 최단거리 찾기 함수 "bfs()" 를 만들어 보자
int bfs(int N, int M, int **maze)
{
    // x,y 좌표를 저장하는 q
    queue<pair<int, int>> q;
    // 방문한 좌표를 기록하는 2차원 배열 visited
    int visited[101][101] = {0};
    // 방문한 좌표에 좌표까지 이동한 거리를 저장할 배열 distance
    int distance[101][101] = {0};

    visited[0][0] = 1;
    q.push(make_pair(0, 0));
    distance[0][0] = 1;
    // 사방탐색을 위한 동서남북 이동좌표 만들기
    int dir_x[4] = {1, -1, 0, 0};
    int dir_y[4] = {0, 0, -1, 1};
    while (!q.empty())
    {
        // 큐 맨 앞의 x,y 좌표를 꺼내고 제거
        // tip. 두 경로가 큐에 들어간 모습 상상하기
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int new_x = x + dir_x[i];
            int new_y = y + dir_y[i];
            if (0 <= new_x && new_x < N && 0 <= new_y && new_y < M &&
                !visited[new_x][new_y] && maze[new_x][new_y] == 1)
            {
                visited[new_x][new_y] = 1;
                q.push(make_pair(new_x, new_y));
                distance[new_x][new_y] = distance[x][y] + 1;
                if (new_x == N - 1 && new_y == M - 1)
                    return distance[new_x][new_y];
            }
        }
    }
}

int main()
{
    // 미로 크기 생성하기
    int N, M;
    cin >> N >> M;
    int **maze = new int *[N];
    for (int i = 0; i < N; i++)
    {
        maze[i] = new int[M];
    }
    // 미로 내용 생성하기
    string row;
    for (int i = 0; i < N; i++)
    {
        cin >> row;
        for (int j = 0; j < M; j++)
        {
            maze[i][j] = row[j] - '0';
        }
    }
    // 최단거리 구하기 함수 bfs 호출
    cout << bfs(N, M, maze);
    // 미로 삭제
    for (int i = 0; i < N; i++)
    {
        delete maze[i];
    }
    delete[] maze;
    return 0;
}