
public class AccountClient {

	public static void main(String[] args) {
		Account account = new Account(3000);
		TransactionThread t1=
				new TransactionThread(account,TransactionType.CREDIT,"Roger",2000);
		TransactionThread t2=
				new TransactionThread(account,TransactionType.CREDIT,"\tAmy",3500);
		TransactionThread t3=
				new TransactionThread(account,TransactionType.DEBIT,"\t\tCalvin",4000);
		
		t3.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();t2.join(); t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		System.out.println("Final balance :"+account.getBalance());
	}

}
