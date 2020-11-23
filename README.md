# XXE demo with OWASP dependency check

## WARNING

This repo contains vulnerabilities. DO NOT DEPLOY ON PRODUCTION OR ANY PUBLICY ACCESSIBLE NETWORK.

https://github.com/jeremylong/DependencyCheck

## bootstrap

```shell script
mkdir -p ../OWASP-Dependency-Check/data
```

## run analyse

```shell script
docker-compose run owasp-dependency-check --scan /src/ --project xxe-demo --format ALL --out /reports
```

## !

cli don't check pom.xml : https://github.com/jeremylong/DependencyCheck/issues/2436