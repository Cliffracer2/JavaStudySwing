/**************************************************
 
아이템 클래스

**************************************************/

package pokemon;

public class Item 
{
	// 친밀도 아이템 관련
	String[] familiarityItemName = new String[10]; 	// 친밀도 아이템 이름
	int[] familiarityValue = new int[10];			// 친밀도 상승량
	int[] familiarityAmount = new int[10];			// 친밀도 아이템 소지수
	
	// 회복 아이템 관련
	String[] recoveryItemName = new String[10];;	// 회복 아이템 이름
	int[] recoveryValue = new int[10];				// 회복량
	int[] recoveryAmount = new int[10];				// 회복 아이템 소지수
	
	/**************************************************
	 
	initalizeItemList
	아이템 정보 초기화

	**************************************************/
	void initalizeItemList ()
	{
		familiarityItemName[0] = "유석열매";
		familiarityItemName[1] = "시마열매";
		familiarityItemName[2] = "파비열매";
		familiarityItemName[3] = "로매열매";
		familiarityItemName[4] = "토망열매";
		
		familiarityValue[0] = 4;
		familiarityValue[1] = 6;
		familiarityValue[2] = 8;
		familiarityValue[3] = 10;
		familiarityValue[4] = 15;
		
		familiarityAmount[0] = 0;
		familiarityAmount[1] = 0;
		familiarityAmount[2] = 0;
		familiarityAmount[3] = 0;
		familiarityAmount[4] = 0;
		
		recoveryItemName[0] = "상처약";
		recoveryItemName[1] = "좋은 상처약";
		recoveryItemName[2] = "고급 상처약";
		recoveryItemName[3] = "회복약";
		recoveryItemName[4] = "만병통치약";
		
		recoveryValue[0] = 20;
		recoveryValue[1] = 40;
		recoveryValue[2] = 60;
		recoveryValue[3] = 300;
		recoveryValue[4] = 20;
		
		recoveryAmount[0] = 0;
		recoveryAmount[1] = 0;
		recoveryAmount[2] = 0;
		recoveryAmount[3] = 0;
		recoveryAmount[4] = 0;
	}
	
	/**************************************************
	 
	storeItem
	입력: 아이템 이름, 아이템 타임, 아이템 양
	출력: 저장한 아이템 수
	
	트레이너의 인벤토리에 아이템을 저장한다.
	아이템 타입
	0: 친밀도 아이템
	1: 회복 아이템

	**************************************************/
	public void storeItem (String itemName, int itemType, int amount)
	{
		switch (itemType)
		{
			case 0: // 친밀도 아이템
				for (int itemIdx = 0; itemIdx < 10; itemIdx++)
				{
					// 인벤에 아이템 이름이 일치하는 위치를 찾음
					if (familiarityItemName[itemIdx] == itemName)
					{
						// 입력한 양만큼 아이템 수 증가
						familiarityAmount[itemIdx] += amount;
					}
				}
				break;
			case 1: // 회복 아이템
				for (int itemIdx = 0; itemIdx < 10; itemIdx++)
				{
					// 인벤에 아이템 이름이 일치하는 위치를 찾음
					if (recoveryItemName[itemIdx] == itemName)
					{
						// 입력한 양만큼 아이템 수 증가
						recoveryAmount[itemIdx] += amount;
					}
				}
				break;
			default:
				break;
		}
	}
}
