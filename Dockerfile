

FROM java:8-jdk-alpine

COPY . /opt/app
WORKDIR /opt/app

RUN apk update \
    && apk add make gcc g++ python linux-headers paxctl libgcc libstdc++ gnupg bash git nodejs-lts \
    && rm -rf /var/cache/apk/*

RUN npm install \
    && node ./node_modules/bower/bin/bower install --allow-root \
    && node ./node_modules/gulp/bin/gulp.js install \
    && ./gradlew flywayMigrate -i

CMD ./gradlew bootRun
