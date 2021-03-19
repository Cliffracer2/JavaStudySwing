/*

팀노바 자바 4주차 과제: 클래스 2차 상속을 최소 1번 사용하여 프로그램 만들기  
진행할 과제: 포켓몬 키우기
목적: 자신이 선택한 포켓몬을 키우고 라이벌과의 배틀에서 이기기 
 
*/

package pokemon;

//import java.util.ArrayList;
import java.util.InputMismatchException;

public class PokemonMain 
{
	/**************************************************
	 
	프로그램을 실행하는 메인 메소드

	**************************************************/
	public static void main(String[] args) 
	{
		// 클래스를 객체화 시킴
		Pokemon pokemon = new Pokemon();							// 포켓몬 클래스
		EnemyPokemon enemyPokemon = new EnemyPokemon();				// 적 포켓몬의 클래스
		Item item = new Item();										// 아이템 클래스
		Market market = new Market();								// 상점 클래스
		
		// Thread 생성
		Thread playTimeThread = new Thread(new PlayTime());
		Thread rivalPokemonThread = new Thread(new RivalPokemon());
		Thread battleThread = new Thread(new Battle());
		Thread marketThread = new Thread(new Market());

		
		boolean completeGame = false; 	// 게임의 목적을 달성했는가 안했는가
		int receiveNumber = -1;			// 사용자가 입력하는 숫자
		
		System.out.printf("************************************************************\n");
		System.out.printf("포켓몬 키우기\n");
		System.out.printf("목적: 포켓몬을 하나 선택해서 육성한다음 라이벌과 전투해서 이겨야 한다.\n");
		System.out.printf("************************************************************\n");
		System.out.printf("************************************************************\n");
		System.out.printf("게임 설명\n");
		System.out.printf("게임을 시작하면 플레이어인 트레이너의 이름을 입력하게 됩니다.\n");
		System.out.printf("이름은 정해져있지 않습니다. 아무렇게 입력하세요.\n");
		System.out.printf("플레이어의 이름을 입력하면 라이벌의 이름을 입력하게 됩니다.\n");
		System.out.printf("라이벌 이름또한 아무렇게 입력하시면 됩니다.\n");
		System.out.printf("이름을 입력했으면 포켓몬을 하나 선택하게 됩니다.\n");
		System.out.printf("포켓몬을 하나 선택하면 라이벌이 상성에 유리한 포켓몬을 가져가게됩니다.\n");
		System.out.printf("포켓몬을 선택한 후 처음 포켓몬의 능력치, 트레이너의 정보를 보여줍니다.\n");
		System.out.printf("트레이너 정보에는 이름과 소유 포켓몬, 소지금이 나오고 그 다음 아이템 목록이 나옵니다.\n");
		System.out.printf("정보가 표시된 후 본격적으로 게임이 시작됩니다. 원하는 행동 번호를 눌러서 진행하세요.\n");
		System.out.printf("최종적으로는 라이벌과 싸워서 이기면 게임 종료입니다.\n");
		System.out.printf("************************************************************\n");
		//System.out.printf("Play time thread create\n");
		playTimeThread.start();
		playTimeThread.setName("PlayTimeThread");
		ShareData.threadNames.add(playTimeThread.getName());
		ShareData.threads.add(playTimeThread);
		// 이름을 입력 받아 확인이 끝날때까지 루프를 돈다.
		// 플레이어, 라이벌의 이름을 입력한다.
		Player.receiveName (true);
		RivalTrainer.receiveName (false);
		// 포켓몬을 선택한다.
		Player.currentOwnPokemon = pokemon.selectPokemon ();
		ShareData.myPokemon.pokemonName = Player.currentOwnPokemon;
		// 선택한 포켓몬 정보를 저장한다.
		pokemon.setBasicMyPokemonStatus ();
		// 포켓몬을 선택 후 콘솔에 플레이어 트레이너의 정보를 표시해준다.
		Player.item.initalizeItemList ();
		Player.displayTrainerInfo ();
		// 플레이어의 처음 소지 아이템 설정
		Player.item.storeItem ("유석열매", 0, 5);
		Player.item.storeItem ("상처약", 1, 5);
		//Player.Item.StoreItem ("만병통치약", 1, 5);
		// 아이템 정보를 콘솔에 출력
		Player.displayItemInfo ();
		
		//ShareData.Pokemon.PokemonName = RivalPokemon.PokemonName;
		//ShareData.Pokemon.PokemonStatus = RivalPokemon.PokemonStatus;
		
		//System.out.printf("Thread Create\n");
		rivalPokemonThread.start();
		rivalPokemonThread.setName("RivalPokemonThread");
		ShareData.threads.add(rivalPokemonThread);
		ShareData.threadNames.add(rivalPokemonThread.getName());
		battleThread.start();
		battleThread.setName("BattleThread");
		ShareData.threads.add(battleThread);
		ShareData.threadNames.add(battleThread.getName());
		marketThread.start();
		marketThread.setName("MarketThread");
		ShareData.threads.add(marketThread);
		ShareData.threadNames.add(marketThread.getName());
		
		// 포켓몬을 선택한 후 육성하기
		// 게임을 클리어할 때까지 루프를 돈다
		while (completeGame == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("트레이너 %s은(는) 무엇을 할까?\n", Player.trainerName);
			System.out.printf("1. 친밀도를 올리기\n");
			System.out.printf("2. 야생에서 배틀하기\n");
			System.out.printf("3. 포켓몬 센터로가기\n");
			System.out.printf("4. 상점에 가기\n");
			System.out.printf("5. 라이벌과 대결하기\n");
			System.out.printf("6. 현재 자신의 정보를 확인한다.\n");
			System.out.printf("7. 라이벌의 정보를 확인한다.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("내가 할 일 입력: ");
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
			
			if ((receiveNumber <= 0) || (receiveNumber >= 8))
			{
				// 100을 입력하면 개발자 모드 진입
				if (receiveNumber != 100)
				{
					System.out.printf("************************************************************\n");
					System.out.println("잘못된 숫자 입력입니다.\n다시 입력 해주세요.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
			}
			
			System.out.printf("************************************************************\n");
			System.out.printf("\n\n");
			
			switch (receiveNumber)
			{
				case 1: // 1. 친밀도를 올리기
					System.out.printf("친밀도를 올리기로 했다.\n");
					System.out.printf("친밀도를 올리면 명중이 낮은 스킬의 공격이 명중할 확률이 증가한다.\n");
					// 친밀도를 올리는 행동을 한다.
					ShareData.myPokemon.familiarity = Player.increaseFamiliarity ();
					
					// 친밀도 최대치를 넘어가면 최대치를 고정
					if (ShareData.myPokemon.familiarity > 255)
					{
						// 친밀도 최대치 고정
						ShareData.myPokemon.familiarity = 255;
					}
					
					// 플레이어가 행동할 때마다 라이벌 포켓몬의 성장 카운트 증가
					continue;
					
				case 2: // 2. 야생에서 배틀하기
					System.out.printf("야생으로 포켓몬 배틀을 하러 갔다.\n");
					System.out.printf("야생에서 레벨업 하면 내 포켓몬이 강해지고 레벨업을 하면 새로운 스킬습득과 진화를 할 수 있다.\n\n");
					// 내 포켓몬 정보를 기준으로 야생 포켓몬 정보를 얻어옴
					enemyPokemon.appearWildPokemon (ShareData.enemyPokemon, ShareData.myPokemon.pokemonLevel);
					// 배틀 스레드에서 배틀기능을 수행하기 시작
					ShareData.enterBattleMenu = true;

					// 배틀 중에는 배틀이 끝날 때까지 대기한다.
					while (ShareData.enterBattleMenu == true)
					{
				        try 
				        {
				            Thread.sleep(100);
				        }
				        catch(Exception e) 
				        {
				        	
				        }
					}
					//ShareData.MyPokemon = MyPokemon;
					//ShareData.EnemyPokemon = EnemyPokemon;
					// 포켓몬 배틀 메뉴에서 배틀과정을 진행
					//Battle.PokemonBattleMenu (ShareData.MyPokemon, ShareData.EnemyPokemon);
					//MyPokemon = ShareData.MyPokemon;
					//EnemyPokemon = ShareData.EnemyPokemon;
					continue;
					
				case 3: // 3. 포켓몬 센터로가기
					System.out.printf("포켓몬 센터로갔다.\n");
					System.out.printf("포켓몬 센터에서는 내 포켓몬의 체력 스킬 횟수를 회복할 수 있다.\n\n");
					// 포켓몬 센터로 이동한다.
					ShareData.myPokemon.goToPokemonCenter ();
					continue;
					
				case 4: // 4. 상점에 가기
					System.out.printf("상점에 갔다.\n");
					System.out.printf("상점에서는 친밀도 증가나 회복 아이템을 구입하거나 판매 할 수 있다.\n\n");
					// 상점의 메인 메뉴를 표시한다.
					market.marketMainMenu(item);
					// 플레이어가 행동할 때마다 라이벌 포켓몬의 성장 카운트 증가
					continue;
					
				case 5: // 5. 라이벌과 대결하기
					//ShareData.MyPokemon = MyPokemon;
					//EnemyPokemon.BringRivalPokemon (ShareData.RivalPokemon);
					System.out.printf("라이벌과 전투하기로 했다.\n");
					System.out.printf("이 전투에서 이기면 게임이 종료 된다.\n\n");
					// 라이벌 포켓몬의 정보를 적 포켓몬 정보에 저장한다.
					enemyPokemon.bringRivalPokemon (ShareData.rivalPokemon, ShareData.enemyPokemon);
					// 포켓몬 배틀 메뉴에서 배틀과정을 진행
					//Battle.PokemonBattleMenu (ShareData.MyPokemon, ShareData.EnemyPokemon);
					ShareData.enterBattleMenu = true;

					// 배틀 중에는 배틀이 끝날 때까지 대기한다.
					while (ShareData.enterBattleMenu == true)
					{
				        try 
				        {
				            Thread.sleep(100);
				        }
				        catch(Exception e) 
				        {
				        	
				        }
					}
					
					// 라이벌과의 배틀에서 이기면 게임이 종료된다.
					if (Player.winToRival == true)
					{
						System.out.printf("라이벌과 전투에서 승리했다!\n");
						System.out.printf("축하합니다! 당신은 게임을 클리어 하셨습니다.\n");
						ShareData.isGameOver = true;
						completeGame = true;
						
						//long CalculateMin;
						//long RemainSec;
						
						//ShareData.EndTime = System.currentTimeMillis();
						
						//CalculateMin = ((ShareData.EndTime - PlayTime.ReceiveData.StartTime) / 1000) / 60;
						//RemainSec = ((ShareData.EndTime - PlayTime.ReceiveData.StartTime) / 1000) % 60;
						
						//System.out.printf("총 플레이 타임: %d 분 %d초 \n", ShareData.CalculateMin, ShareData.RemainSec);
						break;
					}
					else
					{
						continue;
					}
			
				case 6:	// 6. 플레이어 정보를 확인.
					ShareData.showPlayTime = true;
					// 플레이 타임을 출력할때까지 대기
					while (ShareData.showPlayTime == true)
					{
				        try 
				        {
				            Thread.sleep(1);
				        }
				        catch(Exception e) 
				        {
				        	
				        }
					}
					// 트레이너 정보를 콘솔에 출력
					Player.currentOwnPokemon = ShareData.myPokemon.pokemonName;
					Player.displayTrainerInfo();
					// 내 포켓몬 정보를 콘솔에 출력
					ShareData.myPokemon.displayPokemonStatus();
					// 인벤토리 정보를 콘솔에 출력
					Player.displayItemInfo ();
					
					
					
					continue;
					
				case 7:	// 7. 라이벌의 정보를 확인한다.
					//EnemyPokemon.BringRivalPokemon (ShareData.RivalPokemon);
					// 라이벌 정보를 콘솔에 출력
					RivalTrainer.displayTrainerInfo();
					continue;
					
				case 100:	// 100. 개발자 모드
					// 자신의 포켓몬과 라이벌 포켓몬을 레벨 최대치로 올린다.
					for (int idx = 0; idx < 100; idx++)
					{
						//RivalPokemon.RivalGrowUPCount += 3;
						if (ShareData.myPokemon.pokemonLevel < 100)
						{
							ShareData.myPokemon.familiarity = 255;
							ShareData.myPokemon.pokemonLevel += 1;
							ShareData.myPokemon.increasePokemonStatus(0);
						}
					}
					
					continue;
				default:
					break;
			}
		}
		
		// 메인 프로그램이 종료되기전에 다른 실행중인 스레드를 먼저 종료할때까지 대기
        for(int idx=0; idx < ShareData.threads.size(); idx++) 
        {
            Thread threadsList = ShareData.threads.get(idx);
            try 
            {
            	threadsList.join();
            }
            catch(Exception e) 
            {
            	
            }
        }

        System.out.printf("FIN.\n");
		//ScanUserInput.close();
	}
}

//End of File
