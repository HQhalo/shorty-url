FROM amazoncorretto:25.0.1-al2023-headless
WORKDIR /app

COPY ./build/libs/*.jar ./
EXPOSE 8080
CMD java -Dspring.profiles.active=${spring_profile} -jar shortly-url.jar