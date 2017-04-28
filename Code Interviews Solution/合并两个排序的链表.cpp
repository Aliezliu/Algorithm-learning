/*
struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};*/
class Solution {
public:
    ListNode* Merge(ListNode* pHead1, ListNode* pHead2)
    {
        if(pHead1 == NULL)
            return pHead2;
        if(pHead2 == NULL)
            return pHead1;
        ListNode* MergeHead = NULL;
        ListNode* current = NULL;
        while(pHead1 != NULL && pHead2 != NULL)
        {
            if(pHead1->val < pHead2->val)
            {
                if(MergeHead == NULL)
               		 MergeHead = current = pHead1;
                else {
                    current->next = pHead1;
                    current = current->next;
                }
                pHead1 = pHead1->next;
            } else {
                if(MergeHead == NULL)
               		 MergeHead = current = pHead2;
                else {
                    current->next = pHead2;
                    current = current->next;
                }
                pHead2 = pHead2->next;
            }
        }
        if(pHead1 == NULL)
            current->next = pHead2;
        if(pHead2 == NULL)
            current->next = pHead1;
        return MergeHead;
    }
};




