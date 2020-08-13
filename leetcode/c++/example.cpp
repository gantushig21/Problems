#include <bits/stdc++.h>

using namespace std;

void passByValue(int x);
void passByReference(int *x);

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int betty = 13;
    int sandy = 13;

    passByReference(&sandy);

    cout << sandy << endl;
}

void passByValue(int x) {
    x = 99;
}

void passByReference(int *x) {
    int temp = *x;
    *x = 66;
}