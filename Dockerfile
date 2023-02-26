FROM openjdk:11.0.16-slim
MAINTAINER wuhunyu<1632766060@qq.com>
ENV myHome "/home/code-gen-by-ddl"
RUN ["mkdir", "-p", "/home/code-gen-by-ddl"]
WORKDIR	$myHome
COPY ["./code-gen-by-ddl.jar", "/home/code-gen-by-ddl"]
EXPOSE 9000
CMD ["java", "-jar", "/home/code-gen-by-ddl/code-gen-by-ddl.jar"]