/**************************************************
 
트레이너 클래스

**************************************************/

package pokemon;

import java.util.InputMismatchException;

public class Trainer 
{
	public static String trainerName = "";			// 트레이너 이름
	public static String currentOwnPokemon = "";	// 현재 보유 포켓몬
	public static int currentMoney = 2000;			// 현재 소지금
		
	/**************************************************
	 
	receiveName
	입력: 사용자로부터 입력받을 변수, 플레이어 이름인가 or 라이벌 이름인가
	출력: 트레이너 이름
	
	플레이어와 라이벌의 이름을 입력 받아서 저장한다.

	**************************************************/
	public static void receiveName (boolean isPlayer)
	{
		int receiveConfirm = -1;
		boolean correctName = false;	// 올바른 이름 입력을 판단하는 변수
		boolean nameConfirm = false;
		
		LoopName: while (correctName == false) // 올바른 이름을 입력 받으면 종료
		{
			if (isPlayer == true) // 플레이어 이름을 저장하는 것인가?
			{
				System.out.printf("************************************************************\n");
				System.out.printf("플레이어의 이름을 알려주세요.\n");
				System.out.printf("이름: ");
			}
			else // 라이벌의 이름을 저장
			{
				System.out.printf("************************************************************\n");
				System.out.printf("라이벌의 이름을 알려주세요.\n");
				System.out.printf("이름: ");
			}
			
			try
			{
				trainerName = ShareData.scanUserInput.next();
			}
			catch (InputMismatchException ErrorInput)
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
			}
			
			// 입력한 이름 확인 절차
			while (nameConfirm == false)
			{
				System.out.printf("이름이 %s가 맞습니까?   1. Yes    2. No\n", trainerName);
				System.out.printf("확인 선택: ");
				
				try
				{
					receiveConfirm = ShareData.scanUserInput.nextInt();
				}
				catch (InputMismatchException ErrorInput)
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
				}
				
				if ((receiveConfirm <= 0) && (receiveConfirm > 2))
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				else
				{
					// 이름 확인 완료
					if (receiveConfirm == 1)
					{
						nameConfirm = true;
						correctName = true;
					}
					else // 이름 재 입력
					{
						nameConfirm = false;
						correctName = false;
						continue LoopName;
					}
					
				}
			}
		}
	}
}

class Player extends Trainer
{
	public static Item item = new Item();
	public static int getFamiliarity = 0;		// 획득한 친민도 량
	public static boolean winToRival = false;	// 라이벌에게 이겼는가
	
	/**************************************************
	 
	displayTrainerInfo
	입력: 트레이너 이름, 소유 포켓몬, 소지금
	출력: 트레이너 정보를 콘솔에 표시
	
	현재 플레이어의 트레이너 정보를 출력한다.

	**************************************************/
	public static void displayTrainerInfo ()
	{
		System.out.printf("************************************************************\n");
		System.out.printf("현재 플레이어 정보\n");
		System.out.printf("트레이너 이름: %s\n", trainerName);
		System.out.printf("소유 포켓몬: %s\n", currentOwnPokemon);
		System.out.printf("소지금: %d\n", currentMoney);
		System.out.printf("************************************************************\n");
	}
	
	/**************************************************
	 
	displayItemInfo
	입력: 아이템 정보
	출력: 콘솔에 현재 가지고 있는 아이템 정보 표시
	
	현재 플레이어의 트레이너 아이템 정보를 출력한다.

	**************************************************/
	public static void displayItemInfo ()
	{
		
		System.out.printf("************************************************************\n");
		System.out.printf("현재 소지하고 있는 아이템 정보\n\n");
		System.out.printf("친밀도 아이템\n");
		
		for (int itemIdx = 0; itemIdx < 10; itemIdx++)
		{
			// 인벤에 소지수가 1개 이상인 것을 찾음
			if (item.familiarityAmount[itemIdx] > 0)
			{
				System.out.printf("%s   소지수: %d 친밀도 상승량: %d\n", 
						item.familiarityItemName[itemIdx], item.familiarityAmount[itemIdx], item.familiarityValue[itemIdx]);
			}
		}
		
		System.out.printf("회복 아이템\n");
		
		for (int itemIdx = 0; itemIdx < 10; itemIdx++)
		{
			// 인벤에 소지수가 1개 이상인 것을 찾음
			if (item.recoveryAmount[itemIdx] > 0)
			{
				if (item.recoveryItemName[itemIdx] == "만병통치약")
				{
					System.out.printf("%s   소지수: %d 회복량: %d + 상태이상 치료\n", 
							item.recoveryItemName[itemIdx], item.recoveryAmount[itemIdx], item.recoveryValue[itemIdx]);
				}
				else
				{
					System.out.printf("%s   소지수: %d 회복량: %d\n", 
							item.recoveryItemName[itemIdx], item.recoveryAmount[itemIdx], item.recoveryValue[itemIdx]);
				}
			}
		}
		
		System.out.printf("************************************************************\n");
	}
		
	/**************************************************
	 
	increaseFamiliarity
	입력: 유저가 선택한 번호, 아이템 정보
	출력: 증가하는 친밀도 양
	
	포켓몬의 친밀도를 올린다.

	**************************************************/
	public static int increaseFamiliarity ()
	{
		int receiveNumber = -1;				// 사용자가 입력하는 수치
		boolean correctNumber = false;		// 올바른 숫자 입력을 판단하는 변수
		boolean correctName = false;		// 올바른 이름 입력을 판단하는 변수
		String itemName = new String();		// 아이템 이름 입력받을 변수
		
		// 친밀도를 올릴 선택지를 고른다.
		while (correctNumber == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("친밀도를 어떻게 올릴까??\n");
			System.out.printf("1. 친밀도 아이템을 선물한다.\n2. 포켓몬과 같이 논다.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("내가 할 행동: ");
			
			try // 숫자를 입력 받는지 확인
			{
				receiveNumber = ShareData.scanUserInput.nextInt();
			}
			catch (InputMismatchException ErrorInput) // 숫자가 아닌 문자를 입력 한 경우 에러 메시지 출력
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 문자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((receiveNumber <= 0) || (receiveNumber >= 3))
			{
				System.out.printf("************************************************************\n");
				System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			else
			{
				// 선택 완료
				correctNumber = true;
			}
		}
		
		// 친밀도 아이템을 준다.
		if (receiveNumber == 1)
		{
			System.out.printf("\n내가 줄 수 있는 친밀도 아이템\n");
			for (int itemIdx = 0; itemIdx < 10; itemIdx++)
			{
				// 인벤에 소지수가 1개 이상인 것을 찾음
				if (Player.item.familiarityAmount[itemIdx] > 0)
				{
					System.out.printf("%d. %s   소지수: %d\n", (itemIdx + 1), Player.item.familiarityItemName[itemIdx], Player.item.familiarityAmount[itemIdx]);
				}
			}
			
			while (correctName == false) // 올바른 이름을 입력 받으면 종료
			{
				
				System.out.printf("\n건네줄 아이템 이름을 입력하세요.\n");
				System.out.printf("아이템 이름: ");
				try
				{
					itemName = ShareData.scanUserInput.next();
					for (int itemIdx = 0; itemIdx < 10; itemIdx++)
					{
						// 인벤에 소지수가 1개 이상인 것을 찾음
						correctName = itemName.equals(Player.item.familiarityItemName[itemIdx]);
						if (correctName == true)
						{
							System.out.printf("%s를 내 포켓몬에게 주었다.\n", Player.item.familiarityItemName[itemIdx]);
							System.out.printf("친밀도가 %d만큼 올랐다.\n", Player.item.familiarityValue[itemIdx]);
							Player.item.familiarityAmount[itemIdx]--;
							getFamiliarity = Player.item.familiarityValue[itemIdx];
							break;
						}
					}
				}
				catch (InputMismatchException ErrorInput)
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
				}

				if (correctName == false)
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
			}
		}
		else // 포켓몬과 같이 논다를 선택
		{
			System.out.printf("************************************************************\n");
			System.out.printf("포켓몬과 같이 신나게 놀았다.\n");
			System.out.printf("같이놀다보니 더 친해진 느낌이 든다.\n");
			System.out.printf("친밀도가 %d만큼 올랐다.\n", 20);
			System.out.printf("************************************************************\n");
			getFamiliarity = 20;
		}
		
		return getFamiliarity;
	}
}

class RivalTrainer extends Trainer
{
	/**************************************************
	 
	displayTrainerInfo
	입력: 라이벌 포켓몬 정보
	출력: 콘솔에 라이벌과 라이벌 포켓몬에 대한 정보 표시
	
	현재 라이벌 정보를 출력한다.

	**************************************************/
	public static void displayTrainerInfo ()
	{
		System.out.printf("************************************************************\n");
		System.out.printf("현재 라이벌 정보\n");
		System.out.printf("트레이너 이름: %s\n", trainerName);
		System.out.printf("소유 포켓몬: %s\n\n", ShareData.rivalPokemon.pokemonName);
		System.out.printf("라이벌 포켓몬 정보\n");
		System.out.printf("레벨: %d\n", ShareData.rivalPokemon.pokemonLevel);
		System.out.printf("HP: %d\n", ShareData.rivalPokemon.pokemonStatus[0]);
		System.out.printf("공격력: %d\n", ShareData.rivalPokemon.pokemonStatus[1]);
		System.out.printf("방어력: %d\n", ShareData.rivalPokemon.pokemonStatus[2]);
		System.out.printf("스피드: %d\n\n", ShareData.rivalPokemon.pokemonStatus[3]);
		System.out.printf("라이벌 포켓몬 스킬 정보\n");
		System.out.printf("1. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
				ShareData.rivalPokemon.pokemonSkill.skillName[0], 
				ShareData.rivalPokemon.pokemonSkill.skillDamage[0], 
				ShareData.rivalPokemon.pokemonSkill.currentSkillCount[0], ShareData.rivalPokemon.pokemonSkill.skillCount[0], 
				ShareData.rivalPokemon.pokemonSkill.skillAccuracy[0]);
		System.out.printf("2. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
				ShareData.rivalPokemon.pokemonSkill.skillName[1], 
				ShareData.rivalPokemon.pokemonSkill.skillDamage[1], 
				ShareData.rivalPokemon.pokemonSkill.currentSkillCount[1], ShareData.rivalPokemon.pokemonSkill.skillCount[1], 
				ShareData.rivalPokemon.pokemonSkill.skillAccuracy[1]);
		System.out.printf("3. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
				ShareData.rivalPokemon.pokemonSkill.skillName[2], 
				ShareData.rivalPokemon.pokemonSkill.skillDamage[2], 
				ShareData.rivalPokemon.pokemonSkill.currentSkillCount[2], ShareData.rivalPokemon.pokemonSkill.skillCount[2], 
				ShareData.rivalPokemon.pokemonSkill.skillAccuracy[2]);
		System.out.printf("4. %s\n위력: %d, 횟수: (%d / %d), 명중률: %d\n", 
				ShareData.rivalPokemon.pokemonSkill.skillName[3], 
				ShareData.rivalPokemon.pokemonSkill.skillDamage[3], 
				ShareData.rivalPokemon.pokemonSkill.currentSkillCount[3], ShareData.rivalPokemon.pokemonSkill.skillCount[3], 
				ShareData.rivalPokemon.pokemonSkill.skillAccuracy[3]);
		System.out.printf("************************************************************\n");
	}
}

//End of File
