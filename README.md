# Contract-as-Code Demo: OpenAPI3 -> Spring Boot
Demo for OpenAPI3 to Spring Boot generator

To run the code locally
1. `git checkout final`
2. Navigate to the Spring Boot directory: `cd 'Expanded Pet Store (v3)/implementation/springboot-petstore-demo/'`
3. `mvn spring-boot:run`
4. Access API at this URI:  http://localhost:8080/api/pets/

To learn more about the Contract-as-Code approach, watch our presentation: [API Contract-As-Code: Rapid Development with OpenAPI](https://www.slideshare.net/TedEpstein/api-contractascode-rapid-development-with-openapi)


# Work in Progress
## Step 1: Describe
Describe your RESTful API
*	step_1a Create "Expanded Pet Store" Project
*	step_1b Add GenTarget for "Java Spring (Boot + MVC + CloudFeign) Server"
*	step_1c Modify output folder and packages in the *.gen file

## Step 2: Generate
Generate code and add customizations
*	step_2a Generate code
*	step_2b Add implementation to the code

Now you can run the API locally as described above.

## Step 3: Iterate
*	step_3a Add a new method to the OAS document
*	step_3b Re-generate code
*	step_3c Add missing implementation


*	...
