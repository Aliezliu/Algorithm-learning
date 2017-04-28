#include <bits/stdc++.h>

class Solution {
public:
	void replaceSpace(char *str, int length) {
        int numOfSpace = 0, originLength = 0;
        int i = 0;
        while(str[i] != '\0') {
            if (str[i] == ' ')
                numOfSpace++;
            i++;
        }   
        originLength = i;
        int newLength = originLength + (numOfSpace<<1);
        if(newLength > length)
            return;
        
        int index = newLength - originLength + i;
        
        while(i >= 0) {
            if (str[i] != ' ') 
                str[index--] = str[i];
            else {
                str[index--] = '0';
                str[index--] = '2';
                str[index--] = '%';
            }
            i--;
        }
    }
};