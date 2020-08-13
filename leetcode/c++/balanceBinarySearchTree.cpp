#include<bits/stdc++.h>

using namespace std;

struct TreeNode {
    int value;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int x): value(x), left(nullptr), right(nullptr) {}
};

void dfs(TreeNode* node) {
    if (node == nullptr)
        return;

    dfs(node->left);
    cout << node->value << endl;
    dfs(node->right);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    TreeNode* root = new TreeNode(5);
    root->left = new TreeNode(3);
    root->right = new TreeNode(10);
    root->left->left = new TreeNode(1);
    root->left->right = new TreeNode(4); 

    dfs(root);

    return 0;
}