#include <bits/stdc++.h>

#define long long long

using namespace std;

const int N = 400;
bool used[N];
int tin[N], tup[N], dp[N][N], timer = 0;

void dfs(int v, int p) {
    used[v] = true;
    tin[v] = tup[v] = timer++;
    for (int i = 0; i < graph[v].size(); i++) {
        int u = graph[v][i];
        if (u == p) 
            continue;
        if (used[u]) {

        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, m, u, v;
    cin >> n >> m;
    vector<int> graph[n];
    bool used[n];
    for (int i = 0; i < m; i++) {
        cin >> u >> v;
        u--; v--;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    for (int i = 0; i < n; i++) {
        fill(used, used + n, false);
        dfs(used, graph, 1, -1);
    }
}