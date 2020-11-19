# XXE demo wi OWASp dependency check

## bootstrap

```shell script
mkdir -p ../OWASP-Dependency-Check/data
```

## run analyse

```shell script
docker-compose run owasp-dependency-check --scan /src/ --project xxe-demo --format ALL --out /reports
```