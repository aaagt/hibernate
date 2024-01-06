## Запуск

```bash
./gradlew bootRun
```

Затем проверка по ссылке

- поиск по городу [http://localhost:8080/persons/by-city?city=Sochi](http://localhost:8080/persons/by-city?city=Sochi)
- поиск моложе чем
  возраст [http://localhost:8080/persons/younger-then?age=29](http://localhost:8080/persons/younger-then?age=29)
- поиск по имени и
  фамилии [http://localhost:8080/persons/by-fullname?name=Ivan&surname=Ivanov](http://localhost:8080/persons/by-fullname?name=Ivan&surname=Ivanov)
