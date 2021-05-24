package eci.ieti;

import eci.ieti.data.CustomerRepository;
import eci.ieti.data.ProductRepository;
import eci.ieti.data.TodoRepository;
import eci.ieti.data.UserRepository;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;

import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");


        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        
        customerRepository.findAll().stream().forEach(System.out::println);
        System.out.println();
        
        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));
        
        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");
        
        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 2)).stream()
        	.forEach(System.out::println);
   
        System.out.println();

        //IETI - LAB9
        //8. Add a findByResponsible method to the TodoRepository and verify it works. The method must support pagination

        System.out.println("Paginated search of Todo by criteria:");
        System.out.println("-------------------------------");

        todoRepository.save(new Todo("Do the homework",1,new Date("Jan 10 - 1860"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Do the exam",2,new Date("Jan 10 - 2010"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Play video games",3,new Date("Jan 20 - 2020"),"sofia@gmail.com","done"));
        todoRepository.save(new Todo("Sleep",4,new Date("Jan 10 - 2019"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Study",5,new Date("Jan 23 - 2018"),"natalia@gmail.com","pending"));
        todoRepository.save(new Todo("Buy clothes",6,new Date("Jan 10 - 2016"),"cristian@gmail.com","pending"));

        todoRepository.findByResponsible("camilo@gmail.com", PageRequest.of(0, 2)).stream()
                .forEach(System.out::println);

        System.out.println();

        // In the Application class create mocked data for 25 Todos and 10 different users (make sure the Todos have different dueDates and responsible)

        todoRepository.save(new Todo("Repair the cellphone",1,new Date("Jan 10 - 1860"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Do the german exam",2,new Date("Feb 10 - 2019"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Play new video games",3,new Date("Mar 20 - 2023"),"sofia@gmail.com","done"));
        todoRepository.save(new Todo("Sleep 8 hours",4,new Date("Apr 10 - 2025"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Study biology -------------------------------------------------------",8,new Date("Jan 23 - 2018"),"natalia@gmail.com","pending"));
        todoRepository.save(new Todo("Do the gardening -------------------------------------------------------",8,new Date("Feb 10 - 2022"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Do yoga -------------------------------------------------------",8,new Date("Jan 10 - 2010"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Do pottery",8,new Date("Jan 20 - 2020"),"sofia@gmail.com","done"));
        todoRepository.save(new Todo("Learn german ------------------------------------------------------- ",8,new Date("Dec 10 - 2021"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Ride a horse",8,new Date("Jan 23 - 2018"),"natalia@gmail.com","pending"));
        todoRepository.save(new Todo("Get a massage",8,new Date("Jan 10 - 1860"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Plant a tree -------------------------------------------------------",7,new Date("Jan 10 - 2010"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Feed the birds -------------------------------------------------------",3,new Date("Jan 20 - 2020"),"sofia@gmail.com","done"));
        todoRepository.save(new Todo("Go camping",4,new Date("Aug 10 - 2022"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Have a picnic",5,new Date("Feb 23 - 2018"),"natalia@gmail.com","pending"));
        todoRepository.save(new Todo("Go swimming",1,new Date("Mar 10 - 1860"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Go to the library",2,new Date("Jan 10 - 2010"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Repair the TV -------------------------------------------------------",6,new Date("Jan 20 - 2020"),"sofia@gmail.com","done"));
        todoRepository.save(new Todo("Go to the airport",4,new Date("Jan 10 - 2019"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Study math",5,new Date("Jan 23 - 2018"),"natalia@gmail.com","pending"));
        todoRepository.save(new Todo("Go shopping",1,new Date("Oct 10 - 2025"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Surf the Internet",6,new Date("Jan 10 - 2010"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Play an instrument",3,new Date("Nov 20 - 2022"),"sofia@gmail.com","done"));
        todoRepository.save(new Todo("Visit the grandmother",4,new Date("Jan 10 - 2019"),"camilo@gmail.com","pending"));
        todoRepository.save(new Todo("Go out with friends",6,new Date("Dec 23 - 2023"),"natalia@gmail.com","pending"));

        userRepository.save(new User(1,"Nicolas","nicolas@gmail.com"));
        userRepository.save(new User(1,"Maria","maria@gmail.com"));
        userRepository.save(new User(1,"Andres","andres@gmail.com"));
        userRepository.save(new User(1,"Jorge","jorge@gmail.com"));
        userRepository.save(new User(1,"Carlos","carlos@gmail.com"));
        userRepository.save(new User(1,"Lucas","lucas@gmail.com"));
        userRepository.save(new User(1,"Juan","juan@gmail.com"));
        userRepository.save(new User(1,"Daniel","daniel@gmail.com"));
        userRepository.save(new User(1,"Pedro","pedro@gmail.com"));
        userRepository.save(new User(1,"Luis","luis@gmail.com"));

        Query query1 = new Query();
        query1.addCriteria(Criteria.where("dueDate").lt(new Date()));
        List<Todo>todos1=mongoOperation.find(query1,Todo.class);
        System.out.println("---------Todos where the dueDate has expired-----------");
        System.out.println("With criteria query:");
        System.out.println(todos1);
        System.out.println("With todo Repository:");
        System.out.println(todoRepository.findByDueDateBefore(new Date()));

        System.out.println();
        System.out.println();


        Query query2 = new Query();
        query2.addCriteria(Criteria.where("responsible").is("camilo@gmail.com").and("priority").gte(5));
        List<Todo>todos2=mongoOperation.find(query2,Todo.class);
        System.out.println("---------Todos that are assigned to given user and have priority greater equal to 5-----------");
        System.out.println("With criteria query:");
        System.out.println(todos2);
        System.out.println("With todo Repository:");
        System.out.println(todoRepository.findByResponsibleEqualsAndPriorityIsGreaterThanEqual("camilo@gmail.com",5));


        System.out.println();
        System.out.println();

        Query query3 = new Query();
        query3.addCriteria(Criteria.where("description").regex("^.{30,}$"));
        List<Todo>todos3=mongoOperation.find(query3,Todo.class);
        System.out.println("---------Todos that contains a description with a length greater than 30 characters-----------");
        System.out.println("With criteria query:");
        System.out.println(todos3);
        System.out.println("With todo repository");
        System.out.println(todoRepository.findByDescriptionMatchesRegex("^.{30,}$"));










    }

}