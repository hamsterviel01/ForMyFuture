import java.util.*;

public class StacksAndQueues37 { 
	LinkedList<Dog> dogQueue = new LinkedList<Dog>();
	LinkedList<Cat> catQueue = new LinkedList<Cat>();

	public void enqueue(Dog animal){
	 	dogQueue.addFirst(animal);
	}

	public void enqueue(Cat animal){
		catQueue.addFirst(animal);
	}

	public Dog dequeueDog(){
		if (dogQueue.isEmpty()){
			return null;
		}
		return dogQueue.removeLast();
	}

	public Dog dequeueCat(){
		if (catQueue.isEmpty()){
			return null;
		}
		return dogQueue.removeLast();
	}

	public void dequeueAny(){
		if (dogQueue.isEmpty() && catQueue.isEmpty()){
			return;
		}

		if (dogQueue.isEmpty()){
			dequeueCat();
			return;
		}

		if (catQueue.isEmpty()){
			dequeueDog();
			return;
		}
		if (catQueue.peekLast().isOlder(dogQueue.peekLast())){
			dequeueCat();
		} else {
			dequeueDog();
		}
	}	

	public static void main(String[] args){
		
	}
}



class Dog extends Animal{
	public Dog(int date){
		super(date);
	}
}

class Cat extends Animal{
	public Cat(int date){
		super(date);
	}
}

class Animal {
	private int date;

	public Animal(int date){
		this.date = date;
	}

	public boolean isOlder(Animal animal){
		return this.date > animal.getDate();
	}

	public int getDate(){
		return date;
	}
}