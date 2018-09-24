# API CodeFlow Spring Boot
Creating a Spring Boot app from an OpenAPI3 document with [SpringCodegen](https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator/src/main/java/org/openapitools/codegen/languages/SpringCodegen.java) using the [API CodeFlow approach](http://RZen.io/APICodeFlow).

In this demo, we will implement an API for a PetStore using the API CodeFlow approach:
1. Design your API in [OpenAPI](https://github.com/OAI/OpenAPI-Specification)
2. Generate stub code for Spring Boot (Java)
3. Implement the business logic
The resulting API will allow to add a new pet, update an existing pet, list all pets or a view the pet for a given ID.


## To run the resulting implementation locally:
1. `git checkout final`
2. Navigate to the Spring Boot directory: `cd 'Expanded Pet Store (v3)/implementation/springboot-petstore-demo/'`
3. `mvn spring-boot:run`
You can now access API at this URI:  http://localhost:8080/api/pets/

### To create a new pet:
Use the POST method. 
Let's create Elya, the cat using this curl command:
```curl
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"tag": "cat", "name": "Elya"}' \
  http://localhost:8080/api/pets
```
Let's also add Brody, the dog:
```curl
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"tag": "dog", "name": "Brody"}' \
  http://localhost:8080/api/pets
```

### To view all pets
Use the GET method. You can view the pets created in previous steps by opening this URL in a browser: `http://localhost:8080/api/pets`

### To view a particular pet
Use the GET method on `http://localhost:8080/api/pets/{petId}` where `petId` is the ID of a pet, e.g. `http://localhost:8080/api/pets/0`.

### To update an existing pet
Use the PUT method:
```curl
curl --header "Content-Type: application/json" \
  --request PUT \
  --data '{"tag": "cat", "name": "Ella"}' \
  http://localhost:8080/api/pets/0
```

# Work in Progress
# Instructions
Start with the master branch.  
## Step 1: Design your API in OpenAPI
For simplicity, we use the already existing "Expanded Pet Store" example project.
<TBD>

You can skip this step by switching to the branch "step_1a": `git checkout step_1a`.

## Step 2: Generate
Generate code
*	step_1b Add GenTarget for "Java Spring (Boot + MVC + CloudFeign) Server"
*	step_1c Modify output folder and packages in the *.gen file
*	step_2a Generate code

You can skip this step by switching to the branch "step_2a": `git checkout step_2a`.

## Step 3: Implement
*	step_2b Add implementation to the code

Now you can run the API locally as described above.


## Step 4: Repeat
*	step_3a Add a new method to the OAS document
*	step_3b Re-generate code
*	step_3c Add missing implementation


*	...
