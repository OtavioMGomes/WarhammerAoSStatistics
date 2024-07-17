FROM postgres

ENV POSTGRES_USER docker
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB docker

ARG file1="Warhammer DB/DDL.sql"
ARG file2="Warhammer DB/DML.sql"

COPY ${file1} /docker-entrypoint-initdb.d/
COPY ${file2} /docker-entrypoint-initdb.d/