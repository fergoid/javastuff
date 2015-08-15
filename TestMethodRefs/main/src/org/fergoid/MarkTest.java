package org.fergoid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MarkTest {
		 
	    /**
	     * @param args the command line arguments
	     */
	 
	     private static class Person {
	 
	            private final String name;
	            private final int age;
				protected  String gender = "male";
	 
	 
	            public Person(String name, int age) {
	                this.name = name;
	                this.age = age;
	 
	            }
	 
	            public String getName() {
	                return name;
	            }
	 
	            public int getAge() {
	                return age;
	            }

				public String getGender() {
					return gender;
				}
	 

	        }
         static class Boy extends Person {

         	public Boy(String name, int age) {
					super(name, age);
					gender = "male";
				}
         	
         }
         private static class Girl extends Person {

         	public Girl(String name, int age) {
					super(name, age);
					gender = "female";
				}

         	
         }
	     
	     
	    public static void main(String[] args) {
	        // TODO code application logic here
	        List<Person> persons = new ArrayList<Person>();
	            persons.add(new Boy("Albert", 80));
	            persons.add(new Boy("Ben", 15));
	            persons.add(new Girl("Charlote", 20));
	            persons.add(new Boy("Dean", 6));
	            persons.add(new Girl("Elaine", 17));
	 
	 
	            
	            List 
	            allAges = MarkTest.listAllAges(persons, Person::getAge, p -> p.getAge() < 18);
	            System.out.println("Printing out all ages \n"+allAges);

	            allAges = MarkTest.listAllAges(persons, Person::getAge, p -> true);
	            System.out.println("Printing out all ages \n"+allAges);
	            
	            List allNames = MarkTest.listAll(persons, Person::getName);
	            System.out.println("Printing out all names \n"+allNames);
	            
	            List allGenders = MarkTest.listAll(persons, Person::getGender);
	            System.out.println("Printing out all names \n"+allGenders);
	            

	    }
	 
	 
	    private static List<Integer> listAllAges(List<Person> person, Function<Person, Integer> f, Predicate<Person> p){
	        List<Integer> result = new ArrayList<Integer>();
	        person.stream().
	        	filter(p).
	        		forEach(x -> result.add(f.apply(x)));
	        return result;
	    }
	    
	    private static List<String> listAll(List<Person> person, Function<Person, String> f){
	        List<String> result = new ArrayList<String>();
	        person.forEach(x -> result.add(f.apply(x)));
	        return result;
	    }
	    
	}

