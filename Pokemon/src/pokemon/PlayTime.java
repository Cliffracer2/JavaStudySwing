package pokemon;

/**************************************************

PlayTime class

���� �÷��̽ð��� ����Ͽ� ����Ѵ�.

**************************************************/
public class PlayTime implements Runnable 
{
	long calculateMin;
	long remainSec;
	
	public PlayTime ()
	{
		
	}
	
	public void run() 
	{	
		//System.out.printf("\nRun Play time\n");
		
		ShareData.startTime = System.currentTimeMillis();
		
		// ������ ������ ������ ������� ��� �����Ѵ�. ������ Ŭ���� ������ �Ǹ� �����尡 ����ȴ�.
		while (ShareData.isGameOver == false)
		{
	        try 
	        {
	            Thread.sleep(1);
	        }
	        catch(Exception e) 
	        {
	        	
	        }
	        
	        // ���� �޴����� ���� �÷��� �ð��� Ȯ���� ���
	        if (ShareData.showPlayTime == true)
	        {
	        	//  ���� �÷��� �ð��� ǥ���ϰ� �÷��׸� �ʱ�ȭ�Ѵ�.
	    		ShareData.endTime = System.currentTimeMillis();
	    		
	    		calculateMin = ((ShareData.endTime - ShareData.startTime) / 1000) / 60;
	    		remainSec = ((ShareData.endTime - ShareData.startTime) / 1000) % 60;
	    		
	    		System.out.printf("���� �÷��� Ÿ��: %d�� %d�� \n", calculateMin, remainSec);
	    		ShareData.showPlayTime = false;
	        }
	        
			//System.out.printf("Test check ShareData.IsGameOver %b\n", ShareData.IsGameOver);
		}
		
		// �÷��� ���� �ð� Ȯ��
		ShareData.endTime = System.currentTimeMillis();
		
		calculateMin = ((ShareData.endTime - ShareData.startTime) / 1000) / 60;
		remainSec = ((ShareData.endTime - ShareData.startTime) / 1000) % 60;
		
		System.out.printf("�� �÷��� Ÿ��: %d�� %d�� \n", calculateMin, remainSec);
	}
}
