FROM icr.io/appcafe/open-liberty:latest

ARG VERSION=1.0
ARG REVISION=SNAPSHOT
ARG VERBOSE=true

COPY --chown=1001:0 src/main/liberty/config/ /config/

COPY --chown=1001:0 target/*.war /config/apps/

RUN configure.sh