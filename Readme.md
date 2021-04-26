## Up & Running
### Prerequisites
The below dependencies should be installed on your machine before following the steps.

`maven, docker, docker compose`
### Steps
1. Clone the repo,
```
$ git clone https://github.com/amrHassanAbdallah/Socialaway.git
```
2. Move to where you downloaded it 
```
$ cd Socialaway
```
3. Generate the jar
```
$ mvn clean install
```
4. Run with docker compose
```
$ docker-compose build --no-cache
$ docker-compose up              
```


## Documentation
* Check endpoints [docs](https://documenter.getpostman.com/view/11908450/TzJydG1N)

* [Service Design](https://drive.google.com/file/d/1irPQZDBr94hWfKwRBu6G_QIDtS5haFnz/view?usp=sharing) 
