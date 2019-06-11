package Synchronization;

public class App_synchronize {

	private int count=0;
	public synchronized void  increament() {
		count++;
	}
	
	public static void main(String[] args) {
		App_synchronize app_synchronize=new App_synchronize();
		app_synchronize.doWork();

	}
	public void doWork() {
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					increament();
				}
				
			}
		});
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					increament();
				}
				
			}
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count "+count);
	}

}
