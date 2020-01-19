#include <iostream>

using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;

    if (a + b > c) {
        if (a + c > b) {
            if (b + c > a) {
                cout << "YES" << endl;
            } else cout << "NO" << endl;
        } else cout << "NO" << endl;
    } else cout << "NO" << endl;
}