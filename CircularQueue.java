// Java program for insertion and
	// deletion in Circular Queue
	 
	public class CircularQueue implements QueueInterface {
	 
	// Declaring the class variables.
	private int size, front, rear;
	 
	private Organism[] queue;
	 
	// Constructor
	CircularQueue(int len)
	{
	    this.size = 0;
	    this.front = 0;
	    this.rear = 0;
	    this.queue = new Organism[len];
	}
	 
	// Method to insert a new element in the queue.
	public void enQueue(Organism data)
	{ 	 	ensureCapacity();
	       
	        queue[rear] = data;
	        rear = (rear + 1) % queue.length;
	        size++;
	        }
	 
	// Function to dequeue an element
	// from the queue.
	public Organism deQueue()
	{
		if(isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		
	    Organism removed = queue[front];
	 
	    queue[front] = null;
	    front = (front + 1) % queue.length;
	    size--;
	    return removed;
	    
	}

	public boolean isEmpty() {
		return size == 0;
	}
	public void ensureCapacity() {
		if (size == queue.length) {
			Organism[] newQueue = new Organism[queue.length * 2];
			int index = 0;
			//copy elements to the new array with circular indexing
			for(int i = front; i < front + size; i++) {
				newQueue[index++]= newQueue[i % queue.length];
				}
			 front = 0;
			 rear = index;
			 queue = newQueue;
		}
	}
	public int getSize() {
		return this.size;
	}
	
	@Override
	 public String toString() {
	   StringBuilder stringBuilder = new StringBuilder();
	   stringBuilder.append("Contents of the queue: \n");

	 // Iterate from the head to the tail
	   for (int i = front; i != rear; i = (i + 1) % queue.length) {
	     if (queue[i] != null) {
	    	 Organism org = queue[i];
	   stringBuilder.append("(" + org.getRow() + "," + org.getCol()+") - " + org.getState());
	   stringBuilder.append("\n");
	   }
	  }

	  return stringBuilder.toString();
	 }
	}



	      
	 


	

	

	      
	 

