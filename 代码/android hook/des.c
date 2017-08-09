#include<stdio.h>
#include<stdlib.h>
#include<sys/wait.h>
#include<string.h>
#include<sys/types.h>
#include<unistd.h>
const int size=sizeof(char);
int main()  
{     
   int i;  
    for(i = 0;i < 10; ++i) {  
        printf("My counter: %d ", i);  
        sleep(2);  
    }  
    return 0;  
}  