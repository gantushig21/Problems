#include <iostream>

using namespace std;

const int limit = 710;
long long matrix[limit + 1][limit];
long long a[500001];

int t, x, y, q;

int main()
{
    cin >> q;
    for (int k = 0; k < q; k++)
    {
        cin >> t >> x >> y;
        if (t == 1)
        {
            a[x] += y;
            for (int i = 1; i <= limit; i++)
                matrix[i][x % i] += y;
        }
        else
        {
            if (x <= limit)
                cout << matrix[x][y] << endl;
            else
            {
                int sum = 0;
                for (int i = y; i <= 500000; i += x)
                    sum += a[i];
                cout << sum << endl;
            }
        }
    }

    return 0;
}