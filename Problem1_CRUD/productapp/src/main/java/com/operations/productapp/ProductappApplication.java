package com.operations.productapp;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.operations.productapp.dao.UserRepository;
import com.operations.productapp.entities.User;

@SpringBootApplication
public class ProductappApplication {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		ApplicationContext context=SpringApplication.run(ProductappApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);
		int rep;
		do {
		
		System.out.println("Select operation you want to perform");
		System.out.println("1.CREATE\n2.READ\n3.DELETE\n4.UPDATE");
		int c=s.nextInt();
		switch(c)
		{
		case 1:
		   System.out.println("Enter name:");
		   String na=s.next();
		   System.out.println("Enter Age:");
		   int ag=s.nextInt();
		   System.out.println("Enter city:");
		   String ci=s.next();
		   User user1=new User();
		   user1.setName(na);
		   user1.setCity(ci);
		   user1.setAge(ag);
		   userRepository.save(user1);
		   break;
		
		case 2:
			Iterable<User> itr=userRepository.findAll();
			Iterator<User> iterator=itr.iterator();
			while(iterator.hasNext())
			{
				User user=iterator.next();
				System.out.println(user);
			}
		    break;
		
		case 3:
			System.out.println("Enter Id to be deleted");
			int id1=s.nextInt();
			userRepository.deleteById(id1);
			System.out.println("Deleted");
			break;
			
		case 4:
			System.out.println("Enter Id to be updated");
			int id2=s.nextInt();
			Optional<User> optional=userRepository.findById(id2);
	        User user2=optional.get();
	        System.out.println("Enter updated city:");
	        String cit=s.next();
            user2.setCity(cit);
            userRepository.save(user2);
            System.out.println("Updated");
            break;
			
		}
		System.out.println("press 1 , if want to perform more operations");
		rep=s.nextInt();
		}while(rep==1);
	}

}
