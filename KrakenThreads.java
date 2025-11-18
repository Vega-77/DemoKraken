public class KrakenThreads{

	final static int ARRAY_SIZE = 1000;
	final static long COUNT_TO = 1000000;
	final static long COUNT_EACH = (int)(COUNT_TO/ARRAY_SIZE);

	public static void main(String[]args){
		FunThread[] threads = new FunThread[ARRAY_SIZE];
		for(int i=0; i<ARRAY_SIZE; i++){
			threads[i] = new FunThread(i+1, COUNT_EACH);
			threads[i].start();
		}
	}

	static class FunThread extends Thread{
		private long count;
		private long target;
		private int index;
		private long startTime;

		public FunThread(int i, long t){
			index = i;
			target = t;
		}

		public void run(){
			startTime = System.nanoTime();
			while(count!=target)
				count++;
			System.out.println("Thread "+index+" took "+(System.nanoTime()-startTime)+" nanoseconds to count to "+target);
		}
	}
}