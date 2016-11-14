FROM tomcat:8-jre8
MAINTAINER "Legnesi <legnesi@gmail.com>"
ENV JPDA_ADDRESS=8000
ENV JPDA_TRANSPORT=dt_socket
ENV JDPA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n
ADD /conf/tomcat-users.xml /usr/local/tomcat/conf/
CMD ["catalina.sh", "jpda", "run"]
