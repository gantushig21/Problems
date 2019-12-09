#include <bits/stdc++.h>

using namespace std;

const int N = 200200;
long long fenv[N];

void addFenv(int p, long long x)
{
    for (; p < N; p |= p + 1)
        fenv[p] += x;
}

long long getFenv(int r)
{
    long long res = 0;
    for (; r >= 0; r = (r & (r + 1)) - 1)
    {
        cout << r << " => ";
        res += fenv[r];
    }
    cout << res << "\n";
    return res;
}

int n;
long long a[N];

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
        addFenv(i + 1, i + 1);
    }

    for (int i = 0; i <= n; i++)
        cout << fenv[i] << " ";
    cout << "\n";

    for (int i = n - 1; i >= 0; i--)
    {
        int l = 0, r = n;
        while (r - l > 1)
        {
            int m = (l + r) / 2;
            cout << "(" << l << ", " << r << ") ";
            if (getFenv(m) <= a[i])
                l = m;
            else
                r = m;
        }
        cout << "\n";
        a[i] = r;
        addFenv(r, -r);
    }
    for (int i = 0; i < n; i++)
        printf("%lld ", a[i]);
    printf("\n");

    return 0;
}