public class MyCounter {
	private int count = 0;
 	public synchronized void addTwo() {
 		this.count += 2;
 		// System.out.println("Value: " + count);
 		// retrieve counter, change counter, store counter
 	}
 	public synchronized void subtractTwo(){
 		this.count -= 2;
 		// System.out.println("Value: " + count);
 	}
 	public synchronized int countValue () {
 		return this.count;
 	}
}
