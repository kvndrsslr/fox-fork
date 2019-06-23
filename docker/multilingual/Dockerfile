FROM maven:3.6.1-jdk-8

MAINTAINER R. Speck <speck@informatik.uni-leipzig.de>

# install all we need
RUN apt-get update && apt-get -y install \
    git \
    wget \
    graphviz \
    tar \
    unzip \
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

COPY ./run.sh /usr/bin/FOX/run.sh
RUN chmod +x /usr/bin/FOX/run.sh

RUN ./scripts/downloadAgdistis.sh 
RUN ./scripts/downloadSpotlight.sh

# FOX port
EXPOSE 4444

# build app
RUN mvn clean compile -Dmaven.test.skip=true

# run app
CMD ["/usr/bin/FOX/run.sh"]
