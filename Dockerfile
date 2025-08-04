# 빌드 스테이지
FROM gradle:7.6-jdk17 AS build
WORKDIR /home/app
COPY . .
RUN gradle build --no-daemon

# 런타임 스테이지
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /home/app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.datasource.url=jdbc:mysql://next-db.c74828wmikhx.ap-northeast-2.rds.amazonaws.com:3306/next?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8", "--spring.datasource.username=admin", "--spring.datasource.password=17Rwi[Cu*G[9*lGuXoWP)MFdyyVA"]
