# Edde REST API :robot:

This project is designed to facilitate communication between Arduino and a Spring Boot backend application. The API enables Arduino devices to send and receive data efficiently while leveraging the power of artificial intelligence.

## Features

- **RESTful Architecture**
- **AI Integration**: This project uses [Ollama](https://ollama.com/) to integrate AI capabilities seamlessly. Ollama allows for easy deployment and management of machine learning models in your application. You can find more details on their [GitHub page](https://github.com/ollama/ollama).
- **PostgreSQL Database**
- **Secure Endpoints**

## How to Use Ollama

To get started with Ollama in your project, follow these steps:

1. **Installation**: First, ensure you have Ollama installed on your system. You can download it from the [Ollama website](https://ollama.com/).

2. **Setting Up Models**: Use the command to pull a machine learning model by replacing `<model-name>` with the specific model you want to use.
```bash
ollama pull <model-name>
``` 
3. **Running the Model**: Once you have the model, you can run it.
```bash
ollama run <model-name>
```
4. **Integration**: In your Spring Boot application, you can call the Ollama API to send data to the model and receive predictions or processed outputs. Use the appropriate endpoints to interact with your Arduino devices and utilize the AI capabilities.

5. **Documentation**: For more advanced usage and configuration options, refer to the [Ollama documentation](https://ollama.com/docs).

By using Ollama, you can enhance your Arduino and Spring Boot project with sophisticated AI features, making it more interactive and intelligent.
