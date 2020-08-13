#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<unordered_map>
#include<map>
#include<string>
#include<cmath>
#include<algorithm>
#include<vector>
#include<unordered_set>
#include<set>
using namespace std;
const int N = 400;

vector<int>g[N];
int tin[N];
int tup[N];
bool used[N];
int timer = 0;
int dp[N][N];

void dfs1(int v, int p) {
	used[v] = true;
	tin[v] = tup[v] = timer++;
	for (auto u : g[v]) {
		if (u == p) continue;
		if (used[u]) {
			tup[v] = min(tup[v], tin[u]);
		}
		else {
			dfs1(u, v);
			tup[v] = min(tup[v], tup[u]);
		}
	}
}

void dfs2(int v, int start) {
	used[v] = true;
	for (auto u : g[v]) {
		if (!used[u]) {
			if (tup[u] >= tin[v]) {
				dp[start][u] = dp[start][v] + 1;
			}
			else {
				dp[start][u] = dp[start][v];
			}
			dfs2(u, start);
		}
	}
}

void print(int n, int start) {
    cout << "\t";
    for (int i = 0; i < n; i++)
        cout << "\t" << (i + 1);
    // cout << endl << "used";
    // for (int i = 0; i < n; i++)
    //     cout << "\t" << used[i];

    cout << endl << "tin ";
    for (int i = 0; i < n; i++)
        cout << "\t" << tin[i];

    cout << endl << "tup ";
    for (int i = 0; i < n; i++)
        cout << "\t" << tup[i];

    cout << endl << "dp  ";
    for (int i = 0; i < n; i++)
        cout << "\t" << dp[start][i];
    cout << endl << endl;
}

int main()
{
    #ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
    #endif
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;
		u--, v--;
		g[u].push_back(v);
		g[v].push_back(u);
	}
	for (int i = 0; i < n; i++) {
		fill(used, used + n, false);
		dfs1(i, -1);
		fill(used, used + n, false);
		dfs2(i, i);
        print(n, i);
	}
	int q;
	cin >> q;
	while (q--) {
		int a, b;
		cin >> a >> b;
		a--, b--;
		cout << max(0, dp[a][b] - 1) << endl;
	}
	return 0;
}
