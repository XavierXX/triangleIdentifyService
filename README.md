Documentation
-------------
RestFul service program for identifying triangle type;

Open API Spec
======
```json
info:
  description: RESTful service to identify triangle type.
  title: triangle service
  version: v1
  
host: localhost
schemes:
  - http
basePath: /  

paths:
  /triangle:
    get:
      sideA: numeric value of one side of a triangle
      sideB: numeric value of one side of a triangle
      sideC: numeric value of one side of a triangle
      requestBody:
        content:
          application/json:
            schema:
              type: object
              properties:
                sideA:
                  type: numeric
                sideB:
                  type: numeric
                sideC:
                  type: numeric                  
      responses:
        '200':
          description: OK
          schema:
            type: object
            properties:
                sideA:
                  type: numeric
                sideB:
                  type: numeric
                sideC:
                  type: numeric 
                triangleType:
                  type: string
        '400':
          description: bad request
```