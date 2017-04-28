class Solution
{
public:
    void push(int node) {
        stack1.push(node);
    }

    int pop() {
        if(!stack2.empty())
        {
            int a = stack2.top();
            stack2.pop();
            return a;
        } else {
            if(!stack1.empty())
            {
                while(!stack1.empty())
                {
                    stack2.push(stack1.top());
                    stack1.pop();
                }
                int a = stack2.top();
                stack2.pop();
                return a;
            }
            return stack2.top();
        }
    }

private:
    stack<int> stack1;
    stack<int> stack2;
};