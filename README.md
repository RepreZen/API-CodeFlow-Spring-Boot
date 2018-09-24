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

### POST to create a new pet
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
# Instructions: How to create a working API for a PetStore uin three easy steps
Start with the master branch.  It's empty.
## Step 1: Design your API in OpenAPI
For simplicity, we use the already existing "Expanded Pet Store" example project.
<TBD>

You can skip this step by switching to the branch "step_1a": `git checkout step_1a`.

## Step 2: Generate Spring Boot code
1. Add a new GenTarget for "Java Spring (Boot + MVC + CloudFeign) Server". The result should be similar to what you can find on branch step_1b.
2. Update pom.xml
Modify .gen file
step_1c Modify output folder and packages in the *.gen file
3. Generate Spring Boot code running the "Generate Java Spring (Boot + MVC + CloudFeign) Server" action from the toolbar. Notice that we have `*Delegate` among other generated artifacts. We will provide implementation of this interface in the next step. You can see the result of codegen in the branch `step_2a`.


## Step 3: Implement
Let's create the implementation of `Delegate`. For simplicity, I am using a simple HashMap instead of a database.

Update pom.xml
The result of step 3 is on branch `step_2b`.

Now, you can run the API locally using `mvn spring-boot:run`. You can create a new pet and view it, you can also view all pets. 


## Step 4: Repeat
This first version of our API works, but it doesn't allow us to update an existing pet. Let's fix it by adding a PUT method for an individual pet. We will follow the Design-Generate-Implement pattern.
### Design
To do it, simply paste this code to your ` ` file at the end of the `pets` pathItem:
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


