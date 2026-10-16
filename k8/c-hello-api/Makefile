CC=gcc
CFLAGS=-I./src -Wall
SRC=src/main.c src/server.c
OBJ=$(SRC:.c=.o)
TARGET=hello-api

all: $(TARGET)

$(TARGET): $(OBJ)
	$(CC) -o $@ $^

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(OBJ) $(TARGET)