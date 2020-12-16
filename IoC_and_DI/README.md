# Inversion of Control and Dependency Injection 

Before starting on coding, we need to know dependency injection. Spring boot is a framework to build java application in a Microservice way. Microservice is nothing but an extension of RESTful web services with the fundamental idea to break up code into small, distributed, and independent services for better scalability and management and spring boot helps us to achieve this. 

## Inversion of Control (IoC)

IoC is a principle in software engineering where the control of objects or portions of a program is transferred to a framework. It enables framework to take control of the flow of a program and make calls to our custom code. Few of the advantages are below, 

- Decoupling the execution of a task from its implementation 
- Easier to switch between different implementations
- Modularity 
- Easier to test a program by isolating a component or mocking its dependencies, allowing components to communicate through contracts. 
One way to achieve IoC is Dependency Injection. 

## Dependency Injection (DI)

```java
public class EmailService {
    private final ContactListService contactListService;
    
    public EmailService() {
        this.contactListService = new ContactListService();
    }
    
    sendEmail() {
        contactListService.getContacts().forEach(() -> contactListService::send);
    }
}
public class ContactListService {
    public ContactListService {
    
    }
    
    public List<Contacts> getContacts() {
        ...
        return ImmutableList.copyOf(...);
    }
    
    void send(Contact contact) {
        
    }

}
```
Suppose we have a class EmailService, and this class have to use another class ContactListService. ContactListService provides a list of contacts.  

The above piece of code works, but it is badly done. Since inside EmailService constructor, it is instantiating ContactListService.
- If we want to do unit testing, creating an instance of EmailService in the test will create an instance of the ContactListService. 
- If the ContactListService connects to a database for data, we are creating a real connection to the database.
- With the above way, we are creating a bunch of objects with the new keyword. If we have another service which uses the ContactListService as well, another instance of ContactListService is created as well. 
- If we have a bunch of classes, and usually in production application, we may have thousands of classes, creating instance like this is not ideal. 
- These bunch of objects is then stored in the heap, and we not necessarily know when these are clear by GC.
- These bunch of objects could actually be Singleton to resolve the issue.
- Writing code like this is very difficult to test since a real object is created and the object may have dependency such as Database connection etc.

Issue above can be mitigated through Dependency Injection, removing the **new** keyword.

```java
public class EmailService {
    private final ContactListService contactListService;

    @Inject
    public EmailService(ContactListService contactListService) {
        this.contactListService = contactListService; // new keyword is removed. With the annotation, this means that ContactListService will be injected into EmailService.
    }
    
    sendEmail() {
        contactListService.getContacts().forEach(() -> contactListService::send);
    }
}
// To tell Spring to instantiate this object so we can use it. This object is created as a singleton object. 
@Service
public class ContactListService {
    public ContactListService {
    
    }
    
    public List<Contacts> getContacts() {
        ...
        return ImmutableList.copyOf(...);
    }
    
    void send(Contact contact) {
        
    }

}
```
To inject dependency and removing the new keyword, framework such as Spring leave the creation of objects to the framework, and we can focus on writing code that we can easily test.    

To get ContactListService injected into the EmailService with Spring framework through annotation.  





https://www.youtube.com/watch?v=oqYRl06DNHQ