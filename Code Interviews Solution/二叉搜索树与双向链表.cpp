/*
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};*/
#include <bits/stdc++.h>
class Solution {
public:
    TreeNode* Convert(TreeNode* pRootOfTree)
    {
        if(pRootOfTree == NULL)
            return NULL;
        stack<TreeNode*> st;
        st.push(pRootOfTree);
        TreeNode* tmp = pRootOfTree;
        TreeNode* tnp, *res = tmp;
        while(tmp->left != NULL) {
            tmp = tmp->left;
            st.push(tmp);
        }
        
        if(!st.empty()) {
            res = st.top();
        }
        
        while(!st.empty()) {
            tmp = st.top();
            st.pop();
            tnp = tmp->right;
            if(tnp != NULL) {
                st.push(tnp);
                while(tnp->left != NULL) {
                    tnp = tnp->left;
                    st.push(tnp);
                }
                tnp->left = tmp;
                tmp->right = tnp;
            } else {
                if(!st.empty()) {
                    tmp->right = st.top();
                    tmp->right->left = tmp;
                }
            }
        }
        return res;
    }
};