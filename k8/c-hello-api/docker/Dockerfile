FROM gcc:latest

WORKDIR /app

COPY src/ /app/src/
COPY Makefile /app/

RUN make

CMD ["./src/main"]