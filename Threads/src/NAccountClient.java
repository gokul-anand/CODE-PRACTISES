
public class NAccountClient {

	public static void main(String[] args) {
		NAccount account = new NAccount(3000);
		NTransactionThread t1=
				new NTransactionThread(account,TransactionType.CREDIT,"Roger",2000);
		NTransactionThread t2=
				new NTransactionThread(account,TransactionType.CREDIT,"\tAmy",3500);
		NTransactionThread t3=
				new NTransactionThread(account,TransactionType.DEBIT,"\t\tCalvin",4000);
		
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
