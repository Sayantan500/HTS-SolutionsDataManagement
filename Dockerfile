ARG java_repo_name=eclipse-temurin
ARG image_tag_jdk=17-jdk-focal
ARG image_tag_jre=17-jre-focal

# Stage 1 of build --> building the project and creating jar file
FROM $java_repo_name:$image_tag_jdk AS app_jar_builder
WORKDIR /app/
COPY src/ ./src/
COPY pom.xml ./
COPY .mvn/ ./'.mvn'/
COPY mvnw ./
RUN ["./mvnw","clean","install","spring-boot:repackage"]


#Stage 2 of build --> copying the jar file from previous stage and building the final image
FROM $java_repo_name:$image_tag_jre
WORKDIR /app/
COPY --from=app_jar_builder /app/target/HTS_Solutions_Management_System.jar ./
EXPOSE 8082
ENTRYPOINT ["java","-jar","HTS_Solutions_Management_System.jar"]