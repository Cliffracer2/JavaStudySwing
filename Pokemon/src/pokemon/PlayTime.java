package pokemon;

/**************************************************

PlayTime class

게임 플레이시간을 계산하여 출력한다.

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
		
		// 게임이 끝나기 전까지 스레드는 계속 동작한다. 게임이 클리어 조건이 되면 스레드가 종료된다.
		while (ShareData.isGameOver == false)
		{
	        try 
	        {
	            Thread.sleep(1);
	        }
	        catch(Exception e) 
	        {
	        	
	        }
	        
	        // 메인 메뉴에서 현재 플레이 시간을 확인할 경우
	        if (ShareData.showPlayTime == true)
	        {
	        	//  현재 플레이 시간을 표시하고 플래그를 초기화한다.
	    		ShareData.endTime = System.currentTimeMillis();
	    		
	    		calculateMin = ((ShareData.endTime - ShareData.startTime) / 1000) / 60;
	    		remainSec = ((ShareData.endTime - ShareData.startTime) / 1000) % 60;
	    		
	    		System.out.printf("현재 플레이 타임: %d분 %d초 \n", calculateMin, remainSec);
	    		ShareData.showPlayTime = false;
	        }
	        
			//System.out.printf("Test check ShareData.IsGameOver %b\n", ShareData.IsGameOver);
		}
		
		// 플레이 종료 시간 확인
		ShareData.endTime = System.currentTimeMillis();
		
		calculateMin = ((ShareData.endTime - ShareData.startTime) / 1000) / 60;
		remainSec = ((ShareData.endTime - ShareData.startTime) / 1000) % 60;
		
		System.out.printf("총 플레이 타임: %d분 %d초 \n", calculateMin, remainSec);
	}
}
