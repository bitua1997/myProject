#include <stdio.h>
#include "server.h"

int main() {
    // Initialize the server
    init_server();

    // Start handling requests
    start_server();

    return 0;
}