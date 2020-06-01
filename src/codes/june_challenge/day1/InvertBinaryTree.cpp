// Definition for a binary tree node.
#include<bits/stdc++.h>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

//bfs approach to invert binary tree

class Solution
{
public:
    TreeNode *invertTree(TreeNode *root)
    {
        if (!root)
            return nullptr;
        TreeNode *newroot = root;
        queue<TreeNode *> q;
        q.push(root);
        while (!q.empty())
        {
            TreeNode *parent = q.front();
            q.pop();
            swap(parent->left, parent->right);
            if (parent->left)
                q.push(parent->left);
            if (parent->right)
                q.push(parent->right);
        }
        return root;
    }
};