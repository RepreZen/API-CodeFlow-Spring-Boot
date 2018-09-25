# API CodeFlow Spring Boot
Creating a Spring Boot app from an OpenAPI3 document with [SpringCodegen](https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator/src/main/java/org/openapitools/codegen/languages/SpringCodegen.java) using the [API CodeFlow approach](http://RZen.io/APICodeFlow).

In this demo, we will implement an API for a PetStore using the API CodeFlow approach:
1. **Design** your API in [OpenAPI](https://github.com/OAI/OpenAPI-Specification)
2. **Generate** stub code for Spring Boot (Java)
3. **Implement** the business logic

The API will allow to add a new pet, update an existing pet, list all pets, or view the pet for a given ID.

## To run the resulting implementation locally
1. Navigate to the Spring Boot directory: `cd 'Expanded Pet Store (v3)/implementation/springboot-petstore-demo/'`
2. `mvn spring-boot:run`

You can now access the PetStore API at this URI:  http://localhost:8080/api/pets/

<img width="287" alt="screen shot 2018-09-24 at 8 49 30 pm" src="https://user-images.githubusercontent.com/644582/45986765-81ea0080-c03b-11e8-8530-9036a3522e9f.png">

### POST to create a new pet
Use the POST method. 
Let's create Elya, the cat, using this curl command:
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

### GET to view all pets
Use the GET method. You can view the pets created in previous steps by opening this URL in a browser: `http://localhost:8080/api/pets`

### GET to view a particular pet
Use the GET method on `http://localhost:8080/api/pets/{petId}` where `petId` is the ID of a pet, e.g. `http://localhost:8080/api/pets/0`.

### PUT to update an existing pet
Let's change the name of Elya, the cat, to Ella. In our API, her `petID` is `0`:
```curl
curl --header "Content-Type: application/json" \
  --request PUT \
  --data '{"tag": "cat", "name": "Ella"}' \
  http://localhost:8080/api/pets/0
```

# Work in Progress
# How to create a working API for a PetStore in three easy steps. 

Note: Start with the `start` branch (`git checkout start`).  It's empty.
I am using GutHub pull requests for every step so it's easier to view all the changes. Feel free to checkout to the corresponding branch directly.

## Step 1: Design your API in OpenAPI
For simplicity, we use the already existing "Expanded Pet Store" example project.
Follow [Step 1: Design your API in OpenAPI](https://github.com/RepreZen/API-CodeFlow-Spring-Boot/pull/2)

## Step 2: Generate Spring Boot code
Add a new GenTarget for "Java Spring (Boot + MVC + CloudFeign) Server" and customize GenParameters in the `*.gen` file.
Follow [Step 2: Generate Spring Boot code](https://github.com/RepreZen/API-CodeFlow-Spring-Boot/pull/3)

## Step 3: Implement
Implement `PetsApiDelegate`. 

For simplicity, I am using a simple HashMap instead of a database.

Update pom.xml
The result of step 3 is on branch `step_2b`.

Now, you can run the API locally using `mvn spring-boot:run`. You can create a new pet and view it, you can also view all pets. 


## Step 4: Repeat
This first version of our API works, but it doesn't allow us to update an existing pet. Let's fix it by adding a PUT method for an individual pet. We will follow the Design-Generate-Implement pattern.
### Design
To do it, simply paste this code to your `petstore-expanded.yaml` file at the end of the `pets` pathItem:
```yaml

```
step_3a
### Generate code
Run "Generate Java Spring (Boot + MVC + CloudFeign) Server".
You can see also see the result by switching to `step_3b`

### Implement
We didn't have an implementation of the new PUT method yet. Fortunately, Java compiler will notify us about it. Let's add this implementation for `updatePet`:
```java

```	
Or, `git checkout step_3c`


