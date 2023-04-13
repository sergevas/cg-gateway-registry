FROM icr.io/appcafe/open-liberty:latest
# FROM icr.io/appcafe/open-liberty:kernel-slim-java17-openj9-ubi
# FROM icr.io/appcafe/open-liberty:beta-instanton

ARG VERSION=1.0
ARG REVISION=SNAPSHOT
ARG VERBOSE=true

COPY --chown=1001:0 src/main/liberty/config/ /config/

# RUN features.sh

COPY --chown=1001:0 target/*.war /config/apps/

RUN configure.sh