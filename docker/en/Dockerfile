FROM maven:3.6.1-jdk-8

MAINTAINER R. Speck <speck@informatik.uni-leipzig.de>

# install all we need
RUN apt-get update && apt-get -y install \
    wget \
    unzip \
    tar \
    git \
    graphviz \
    && rm -rf /var/lib/apt/lists/*

# folder setup
RUN mkdir -p /usr/bin/FOX
WORKDIR /usr/bin/FOX

# environment setup
ENV MAVEN_OPTS "-Xmx20G -Dlog4j.configuration=file:/usr/bin/FOX/data/fox/log4j.properties -Dmaven.repo.local=/usr/bin/FOX/m2repository"

ENV DEBIAN_FRONTEND noninteractive

# get app 
RUN cd /usr/bin/FOX 
RUN git clone --branch master https://github.com/AKSW/FOX .

#setup app
RUN cp ./fox.properties-dist ./fox.properties

COPY org.aksw.fox.tools.ToolsGenerator.xml ./data/fox/cfg/

COPY downloadAgdistis.sh   ./
COPY downloadSpotlight.sh   ./
COPY build ./
COPY downloads ./
RUN rm ScriptBuild.sh ScriptRun.sh
COPY ScriptRun.sh ./
COPY ScriptRunSpotlight.sh ./
RUN chmod +x ./downloads
RUN chmod +x ./build
RUN chmod +x ./ScriptRun.sh
RUN chmod +x ./ScriptRunSpotlight.sh

RUN ./downloads
RUN rm ./build ./ScriptRun.sh
COPY build ./
COPY ScriptRun.sh ./
RUN ./build2

# FOX port
EXPOSE 4444

# run app
CMD ["./ScriptRun.sh"] 

