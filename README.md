Before starting, I am a new user of Docker so I am opened to any remark or suggestion.

This example is just an illustration of how we can use a network created by docker-compose. 

The example expose a restful service, (deployed in a tomcat or wildfly container) which communicate with a mongodb conatiner. The restfull services is very simple and consist to create enterprises,  employees and associate an enployee to an enterprise. The root path of the service is http://HOST:8080/${build.final.name}/, where HOST is yur machine and ${build.final.name} is the name of the archive ( by default the root path will be http://HOST:8080/docker-rest-example/). See the code to get the urls of all the services. 


### Preriquires ###

	docker
	docker-compose
	Maven
	create a folder ~/mongo_store/db to store mongodb datas (normally docker will create this for you)


### How to use ###

These has been tested on a Linux distribution (Ubuntu 16 LTS)
### Tomcat users ###
	If you prefer tomcat, follow these steps:

	- Modifiy the file /docker-tomcat/.env and set the value of the environment variables TOMCAT_DEPLOYMENT_DIR and MOGO_DB_DATA
	- In the directory docker-rest-example/, run: mvn package -P tomcat (this will create the war archive)
	- In the directory docker-tomcat/, run docker-compose up (or docker-compose up -d in daemond mode); this will start a container with tomcat and mongodb. NB: tomcat will start in debug mode on port 8000.
	- Try the rests services.

### Wildfly users ###

If you prefer tomcat, follow these steps:

	- Modifiy the file /docker-wildfly/.env and set the value of the environment variables WILDFLY_DEPLOYMENT_DIR and MOGO_DB_DATA
	- In the directory docker-rest-example/, run: mvn package -P wildfly (this will create the war archive)
	- In the directory docker-wildfly/, run docker-compose up (or docker-compose up -d in daemond mode); this will start a container with wildfly and mongodb.
	- Try the rests services.
### NB ###
You can set your own path for the directories created for tomcat, mongodb or wildfly.

-------------------------------------------------------------
    Centered   Default           Right Left
     Header    Aligned         Aligned Aligned
   ----------- ------- --------------- -------------------------
      First    row                12.0 Example of a row that
                                       spans multiple lines.

     Second    row                 5.0 Here's another one. Note
                                       the blank line between
                                       rows.
   -------------------------------------------------------------
