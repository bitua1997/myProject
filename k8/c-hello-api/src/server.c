#include <stdio.h>
#include "server.h"

void start_server() {
    printf("Content-Type: text/plain\n\n");
    printf("Hello World\n");
}

int main() {
    start_server();
    return 0;
}