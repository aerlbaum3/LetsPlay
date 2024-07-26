public class PracticeMain {

	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(10);
		Organism org1 = new Organism(0,1,0);
		Organism org2 = new Organism(2,2,1);
		
    	cq.enQueue(org1);
		cq.enQueue(org2);
		
		
		System.out.println(cq.toString());
		cq.deQueue();
		System.out.println(cq.toString());
		cq.deQueue();
		System.out.println(cq.toString());
		cq.deQueue();


//		
//		System.out.println(cq);
		
		//System.out.println("(" + org.getRow() + "," + org.getCol()+") - " + org.getState());
		System.out.println("Hello");
	}
	
}
