FROM prodaptimages/maven339java8
ADD ./src /code/src
ADD ./pom.xml /code/pom.xml
WORKDIR /code
RUN mvn clean install
#ENV url jdbc:mysql://192.168.54.186/microdb?useSSL=false
#ENV username root
#ENV password password
#RUN set url jdbc:mysql://192.168.54.186/microdb?useSSL=false
#RUN set username root
#RUN set password password
ENTRYPOINT ["java","-jar","/code/target/prodapt-app.jar"]

