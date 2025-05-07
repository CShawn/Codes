
class Solution {
    struct State {
        int x;
        int y;
        int dis;
        State(int x, int y, int dis) : x(x), y(y), dis(dis) {};
        bool operator < (const State &state) const {
            return dis > state.dis;
        }
    };
public:
    const int inf = 0x3f3f3f3f;
    // Dijkstra
    int minTimeToReach(vector<vector<int>>& moveTime) {
        int n = moveTime.size(), m = moveTime[0].size();
        int directions[4][2] = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        vector<vector<int>> distance(n, vector<int>(m, inf));
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        distance[0][0] = 0;
        priority_queue<State> queue;
        queue.push(State(0, 0, 0));
        while (queue.size()) {
            State s = queue.top();
            queue.pop();
            if (visited[s.x][s.y]) {
                continue;
            }
            visited[s.x][s.y] = true;
            for (int i = 0; i < 4; i++) {
                int x = s.x + directions[i][0];
                int y = s.y + directions[i][1];
                if (x < 0 || y < 0 || x >= n || y >= m) {
                    continue;
                }
                int dis = max(distance[s.x][s.y], moveTime[x][y]) + 1;
                if (distance[x][y] <= dis) {
                    continue;
                }
                distance[x][y] = dis;
                queue.push(State(x, y, dis));
            }
        }
        return distance[n - 1][m - 1];
    }
};