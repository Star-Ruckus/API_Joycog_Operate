#!/bin/bash
DEPLOY_PATH=/home/ubuntu/emotiv/server/
APPLICATION_JAR_NAME=Joycog-Operate-0.0.1-SNAPSHOT.jar
APPLICATION_JAR=$DEPLOY_PATH$APPLICATION_JAR_NAME
echo "> 현재 실행중인 애플리케이션 pid 확인"
CURRENT_PID=$(pgrep -f $APPLICATION_JAR_NAME)
if [ -z "$CURRENT_PID" ]
then
  echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다..."
else
  echo "> kill -9 $CURRENT_PID"
  kill -9 "$CURRENT_PID"
  sleep 5
fi
#export SPRING_PROFILES_ACTIVE=prod
echo "> $APPLICATION_JAR 배포 "
nohup /usr/lib/jvm/java-17-openjdk-amd64/bin/java -jar /home/ubuntu/emotiv/server/Joycog-Operate-0.0.1-SNAPSHOT.jar >/dev/null 2>&1 &