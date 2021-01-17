FROM openjdk:8-jdk-alpine
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENV JAVA_OPTS="-Dspring.profiles.active=prod"
#ENTRYPOINT ["java", "-cp","app:app/lib/*","org.anz.wholesale.WholesaleAccountsApplication"] #WORKING
#ENTRYPOINT ["java","-Dspring.profiles.active=dev", "-cp","app:app/lib/*","org.anz.wholesale.WholesaleAccountsApplication"] #WORKING
#ENTRYPOINT ["java",$JAVA_OPTS, "-cp","app:app/lib/*","org.anz.wholesale.WholesaleAccountsApplication"] #NOTWORKING
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -cp app:app/lib/*:conf org.anz.wholesale.WholesaleAccountsApplication"]