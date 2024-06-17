Spring JSON Merge Patch demo
================================================================================

Demonstration of updating and keeping fields using the JSON Merge Patch.


Requirements
--------------------------------------------------------------------------------

- Java 21


How to run
--------------------------------------------------------------------------------

```bash
./mvnw clean spring-boot:run
```


Demo
--------------------------------------------------------------------------------

Step 1: See the initial data.

```bash
curl -XGET "http://localhost:8080/users/1"
```

```json
{"id":1,"username":"alice","familyName":"Liddell","givenName":"Alice","age":7}
```

Step 2: Update age and delete familyName by JSON Patch Merge request.

```bash
curl -XPATCH -H"Content-type:application/merge-patch+json" http://localhost:8080/users/1 -d '{"age":17, "familyName":null}'
```

```json
{"id":1,"username":"alice","familyName":null,"givenName":"Alice","age":17}
```

Step 3: See the updated data.

```bash
curl -XGET "http://localhost:8080/users/1"
```

```json
{"id":1,"username":"alice","familyName":null,"givenName":"Alice","age":17}
```
