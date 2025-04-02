#!/bin/bash

PASSWORD='clingdance61@A'
execute(){
    echo "$PASSWORD" | sudo -S sudo docker compose up -d
    echo "$PASSWORD" | sudo -S ls 2> /dev/null
    echo "$PASSWORD" | sudo -S sudo apt install openjdk-21-jdk-headless
    echo "$PASSWORD" | sudo -S sudo apt install openjdk-21-jdk
    export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
    export PATH=$JAVA_HOME/bin:$PATH
    javac -version
    echo "$PASSWORD" | sudo -S bash -c "source '$HOME/.sdkman/bin/sdkman-init.sh' && \
     sdk install gradle && gradle --version && gradle -q javaToolchains && sleep 60 && \
     gradle clean test --refresh-dependencies && sleep 60"
    echo "$PASSWORD" | sudo -S sudo docker compose down
}

execute