FROM centos
MAINTAINER lzj
ADD root/apache-tomcat-8.5.11.tar.gz /root
ADD root/jdk-8u74-linux-x64.rpm /root
RUN rpm -ivh /root/jdk-8u74-linux-x64.rpm
ADD root/fpd.war /root/apache-tomcat-8.5.11/webapps
ENV JAVA_HOME /usr/java/jdk1.8.0_74
ENV PATH $JAVA_HOME/bin:$PATH
ENTRYPOINT /root/apache-tomcat-8.5.11/bin/startup.sh && tail -F /root/apache-tomcat-8.5.11/logs/catalina.out