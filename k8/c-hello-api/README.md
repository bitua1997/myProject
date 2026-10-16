# c-hello-api

This project implements a simple API that returns "Hello World." It is built in C and can be deployed using Docker and Kubernetes.

## Project Structure

```
c-hello-api
├── src
│   ├── main.c        # Entry point of the application
│   ├── server.c      # Server implementation
│   └── server.h      # Header file for server functions
├── docker
│   └── Dockerfile     # Dockerfile for building the application image
├── k8s
│   ├── deployment.yaml # Kubernetes deployment configuration
│   └── service.yaml    # Kubernetes service configuration
├── Makefile           # Build instructions
└── README.md          # Project documentation
```

## Building the Application

To build the application, you can use the provided Makefile. Run the following command in the project root directory:

```
make
```

## Running the Application with Docker

To build the Docker image, navigate to the `docker` directory and run:

```
docker build -t c-hello-api .
```

To run the Docker container, use:

```
docker run -p 8080:8080 c-hello-api
```

You can then access the API at `http://localhost:8080`.

## Deploying the Application with Kubernetes

1. Ensure you have a Kubernetes cluster running.
2. Apply the deployment configuration:

```
kubectl apply -f k8s/deployment.yaml
```

3. Apply the service configuration:

```
kubectl apply -f k8s/service.yaml
```

4. To access the application, you may need to set up port forwarding or use a LoadBalancer service, depending on your Kubernetes setup.

## License

This project is licensed under the MIT License.