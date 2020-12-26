FROM openjdk:11 as build
WORKDIR /build
RUN wget https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar -O BuildTools.jar
RUN java -jar BuildTools.jar --rev 1.16.4

FROM openjdk:11 as spigot
WORKDIR /server
COPY --from=build /build/Spigot/Spigot-Server/target/spigot-1.16.4-R0.1-SNAPSHOT.jar /server/spigot.jar
RUN echo "eula=true" > eula.txt
ENTRYPOINT ["java", "-jar", "spigot.jar"]