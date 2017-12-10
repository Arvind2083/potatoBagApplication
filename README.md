Prerequite to run this  application on the local machine 
1. JDK 1.8
2. Maven
3. GitHub
4. Postman(For testing)

Please follow these instructions to execute the program on the local machine :

1. Create a directory 
   mkdir potatoApp
2. Move to potatoApp
   cd potatoApp
3. Clone the code under this directory
   git clone https://github.com/Arvind2083/potatoBagApplication.git
4. Go inside the directory potatoBagApplication
   cd potatoBagApplication
5. Start the Spring-Boot application.The below command will take few minutes to download all the dependencies.
   mvn spring-boot:run
  
   Once you see Started PotatoBagApplication in <<>> seconds,it mean application is started on the localhost.
   
   TESTING OF THE APIs
   ===================
   
1. Go to the below url on browser or postman
    http://localhost:8080/
	
	Some Json text must be seen on the browser.It means application is running

2. Open the Postman to validate the API.

     Test cases :

	 P.S : There are 4 hardcorded Bag list exists in the application.These list can be used to test the GET request api without creating 
	       POST request.
	 
	 GET Request
	 ============
	 
    a) http://localhost:8080/
    
     Expected outcome :  3 Json object and HTTP status = 200 
	 
	b) http://localhost:8080/?count=1 
	
	 Expected outcome :  1 Json object and HTTP status = 200 
	 
	 
	 POST request
	 ============
	 
	 Select POST and set these parameters in the BODY
	 
	 key = potatoCount Value : Any value from 1 to 100
	 key = supplier  Value : Any name out of these "de coster" ,"Owel", "Patatas Ruben" ,"Yunnan Spices"
	 key = price  Value : Any value from 1 to 50
	 
	 P.S : Other 2 value for BagId will be randomly generated and creationDate will be the date and time creation.
	 
	 HAPPY FlOW : Post the all the values in the range (as mentioned above)
	 
     1. http://localhost:8080/
	 
	 key = potatoCount Value : 60
	 key = supplier  Value : "de coster" 
	 key = price  Value : 25
	 
	 This must create a new PotatoBag The HTTP status response code will be 201
	 
	 Now these will be 5 bags in the application.This can be tested with GET request :
	 
	 http://localhost:8080/?count=5
	 
	 Negative test Cases :
	 =====================
	 
	 POST :
	 =====
	 1. Out of Range potatoCount

	 key = potatoCount Value : 200                      (This is wrong)
	 key = supplier  Value : "de coster" 
	 key = price  Value : 25
	 
	 Expected Message : Errors [The count of Potatos in a bag must be between 1 and 100]
	 Expected HTTP status code : 406
	 
	 
	 2.  Invalid supplier
	 
	 key = potatoCount Value : 100                   
	 key = supplier  Value : "decoster" 
	 key = price  Value : 25
	 
	 Expected Message : Errors [Supplier Name is not correct.Valid supplier name from de coster,Owel,Patatas Ruben,Yunnan Spices]
	 Expected HTTP status code : 406
	 
	 
	 3. Out of range price
	 
	 key = potatoCount    Value : 100                   
	 key = supplier       Value : "de coster" 
	 key = price          Value : 60
	 
	
	 Expected Message : Errors [The Price of Potato Bag must be between 1 and 50]
	 Expected HTTP status code : 406
	 
	 4. Multiple errors invalid errors
	 
	 key = potatoCount    Value : 200                  
	 key = supplier       Value : "decoster" 
	 key = price          Value : 60

     Expected Message :Errors [The count of Potatos in a bag must be between 1 and 100, 
                               Supplier Name is not correct.Valid supplier name from de coster,Owel,Patatas Ruben,Yunnan Spices, 
                               The Price of Potato Bag must be between 1 and 50]
    Expected HTTP status code : 406					   
