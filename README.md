# Getting started

## Installation
- Install docker Desktop
	- Check installation
		```
		docker --version
		```
- Install vscode
	- Instal Extension "Dev Containers" 
		- ID: ms-vscode-remote.remote-containers
		- URL: https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers

## Startup
- Docker starten
- Vscode starten
	- File >> Open Folder... >> demoapp
	- Bottom left corner >> Button "><" >> Reopen in Container

# Open the Demo
## Start the server
Open a terminal
```
mvn spring-boot:run
```
Or navigate to src/main/java/de/demo/demoapp/DemoApplication.java and klick the "play" button.
## Vaadin Apps
- Demo1 (Vaadin view with minimum configuration)
	- URL: http://localhost:8080/demo1/simpleView
- Demo2 (Demo App with dynamic Menu, List, Dialog and Form with Validation)
	- URL: http://localhost:8080/demo2/HomeView
## REST-API 
- Swagger-UI (Swagger documentation wirh zero configuraten)
	- URL: http://localhost:8080/swagger-ui/index.html
- API (DEmo API with minimum configuration)
	- URL: http://localhost:8080/api/contacts
