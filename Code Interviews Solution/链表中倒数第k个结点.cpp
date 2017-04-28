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
    ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
    	if(pListHead == NULL)
            return NULL;
        int len = 0;
        ListNode* tmp = pListHead;
        while(tmp != NULL) {
            tmp = tmp->next;
            len++;
        }
        if(k > len || k == 0)
            return NULL;
        int index = 0;
        int pivot = len - k;
        tmp = pListHead;
        while(index != pivot) {
            tmp = tmp->next;
            index++;
        }
        return tmp;
    }
};