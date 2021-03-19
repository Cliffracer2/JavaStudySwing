/*

����� �ڹ� 4���� ����: Ŭ���� 2�� ����� �ּ� 1�� ����Ͽ� ���α׷� �����  
������ ����: ���ϸ� Ű���
����: �ڽ��� ������ ���ϸ��� Ű��� ���̹����� ��Ʋ���� �̱�� 
 
*/

package pokemon;

//import java.util.ArrayList;
import java.util.InputMismatchException;

public class PokemonMain 
{
	/**************************************************
	 
	���α׷��� �����ϴ� ���� �޼ҵ�

	**************************************************/
	public static void main(String[] args) 
	{
		// Ŭ������ ��üȭ ��Ŵ
		Pokemon pokemon = new Pokemon();							// ���ϸ� Ŭ����
		EnemyPokemon enemyPokemon = new EnemyPokemon();				// �� ���ϸ��� Ŭ����
		Item item = new Item();										// ������ Ŭ����
		Market market = new Market();								// ���� Ŭ����
		
		// Thread ����
		Thread playTimeThread = new Thread(new PlayTime());
		Thread rivalPokemonThread = new Thread(new RivalPokemon());
		Thread battleThread = new Thread(new Battle());
		Thread marketThread = new Thread(new Market());

		
		boolean completeGame = false; 	// ������ ������ �޼��ߴ°� ���ߴ°�
		int receiveNumber = -1;			// ����ڰ� �Է��ϴ� ����
		
		System.out.printf("************************************************************\n");
		System.out.printf("���ϸ� Ű���\n");
		System.out.printf("����: ���ϸ��� �ϳ� �����ؼ� �����Ѵ��� ���̹��� �����ؼ� �̰ܾ� �Ѵ�.\n");
		System.out.printf("************************************************************\n");
		System.out.printf("************************************************************\n");
		System.out.printf("���� ����\n");
		System.out.printf("������ �����ϸ� �÷��̾��� Ʈ���̳��� �̸��� �Է��ϰ� �˴ϴ�.\n");
		System.out.printf("�̸��� ���������� �ʽ��ϴ�. �ƹ����� �Է��ϼ���.\n");
		System.out.printf("�÷��̾��� �̸��� �Է��ϸ� ���̹��� �̸��� �Է��ϰ� �˴ϴ�.\n");
		System.out.printf("���̹� �̸����� �ƹ����� �Է��Ͻø� �˴ϴ�.\n");
		System.out.printf("�̸��� �Է������� ���ϸ��� �ϳ� �����ϰ� �˴ϴ�.\n");
		System.out.printf("���ϸ��� �ϳ� �����ϸ� ���̹��� �󼺿� ������ ���ϸ��� �������Ե˴ϴ�.\n");
		System.out.printf("���ϸ��� ������ �� ó�� ���ϸ��� �ɷ�ġ, Ʈ���̳��� ������ �����ݴϴ�.\n");
		System.out.printf("Ʈ���̳� �������� �̸��� ���� ���ϸ�, �������� ������ �� ���� ������ ����� ���ɴϴ�.\n");
		System.out.printf("������ ǥ�õ� �� ���������� ������ ���۵˴ϴ�. ���ϴ� �ൿ ��ȣ�� ������ �����ϼ���.\n");
		System.out.printf("���������δ� ���̹��� �ο��� �̱�� ���� �����Դϴ�.\n");
		System.out.printf("************************************************************\n");
		//System.out.printf("Play time thread create\n");
		playTimeThread.start();
		playTimeThread.setName("PlayTimeThread");
		ShareData.threadNames.add(playTimeThread.getName());
		ShareData.threads.add(playTimeThread);
		// �̸��� �Է� �޾� Ȯ���� ���������� ������ ����.
		// �÷��̾�, ���̹��� �̸��� �Է��Ѵ�.
		Player.receiveName (true);
		RivalTrainer.receiveName (false);
		// ���ϸ��� �����Ѵ�.
		Player.currentOwnPokemon = pokemon.selectPokemon ();
		ShareData.myPokemon.pokemonName = Player.currentOwnPokemon;
		// ������ ���ϸ� ������ �����Ѵ�.
		pokemon.setBasicMyPokemonStatus ();
		// ���ϸ��� ���� �� �ֿܼ� �÷��̾� Ʈ���̳��� ������ ǥ�����ش�.
		Player.item.initalizeItemList ();
		Player.displayTrainerInfo ();
		// �÷��̾��� ó�� ���� ������ ����
		Player.item.storeItem ("��������", 0, 5);
		Player.item.storeItem ("��ó��", 1, 5);
		//Player.Item.StoreItem ("������ġ��", 1, 5);
		// ������ ������ �ֿܼ� ���
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
		
		// ���ϸ��� ������ �� �����ϱ�
		// ������ Ŭ������ ������ ������ ����
		while (completeGame == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("Ʈ���̳� %s��(��) ������ �ұ�?\n", Player.trainerName);
			System.out.printf("1. ģ�е��� �ø���\n");
			System.out.printf("2. �߻����� ��Ʋ�ϱ�\n");
			System.out.printf("3. ���ϸ� ���ͷΰ���\n");
			System.out.printf("4. ������ ����\n");
			System.out.printf("5. ���̹��� ����ϱ�\n");
			System.out.printf("6. ���� �ڽ��� ������ Ȯ���Ѵ�.\n");
			System.out.printf("7. ���̹��� ������ Ȯ���Ѵ�.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("���� �� �� �Է�: ");
			try // ���ڸ� �Է� �޴��� Ȯ��
			{
				receiveNumber = ShareData.scanUserInput.nextInt();
			}
			catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((receiveNumber <= 0) || (receiveNumber >= 8))
			{
				// 100�� �Է��ϸ� ������ ��� ����
				if (receiveNumber != 100)
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
			}
			
			System.out.printf("************************************************************\n");
			System.out.printf("\n\n");
			
			switch (receiveNumber)
			{
				case 1: // 1. ģ�е��� �ø���
					System.out.printf("ģ�е��� �ø���� �ߴ�.\n");
					System.out.printf("ģ�е��� �ø��� ������ ���� ��ų�� ������ ������ Ȯ���� �����Ѵ�.\n");
					// ģ�е��� �ø��� �ൿ�� �Ѵ�.
					ShareData.myPokemon.familiarity = Player.increaseFamiliarity ();
					
					// ģ�е� �ִ�ġ�� �Ѿ�� �ִ�ġ�� ����
					if (ShareData.myPokemon.familiarity > 255)
					{
						// ģ�е� �ִ�ġ ����
						ShareData.myPokemon.familiarity = 255;
					}
					
					// �÷��̾ �ൿ�� ������ ���̹� ���ϸ��� ���� ī��Ʈ ����
					continue;
					
				case 2: // 2. �߻����� ��Ʋ�ϱ�
					System.out.printf("�߻����� ���ϸ� ��Ʋ�� �Ϸ� ����.\n");
					System.out.printf("�߻����� ������ �ϸ� �� ���ϸ��� �������� �������� �ϸ� ���ο� ��ų����� ��ȭ�� �� �� �ִ�.\n\n");
					// �� ���ϸ� ������ �������� �߻� ���ϸ� ������ ����
					enemyPokemon.appearWildPokemon (ShareData.enemyPokemon, ShareData.myPokemon.pokemonLevel);
					// ��Ʋ �����忡�� ��Ʋ����� �����ϱ� ����
					ShareData.enterBattleMenu = true;

					// ��Ʋ �߿��� ��Ʋ�� ���� ������ ����Ѵ�.
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
					// ���ϸ� ��Ʋ �޴����� ��Ʋ������ ����
					//Battle.PokemonBattleMenu (ShareData.MyPokemon, ShareData.EnemyPokemon);
					//MyPokemon = ShareData.MyPokemon;
					//EnemyPokemon = ShareData.EnemyPokemon;
					continue;
					
				case 3: // 3. ���ϸ� ���ͷΰ���
					System.out.printf("���ϸ� ���ͷΰ���.\n");
					System.out.printf("���ϸ� ���Ϳ����� �� ���ϸ��� ü�� ��ų Ƚ���� ȸ���� �� �ִ�.\n\n");
					// ���ϸ� ���ͷ� �̵��Ѵ�.
					ShareData.myPokemon.goToPokemonCenter ();
					continue;
					
				case 4: // 4. ������ ����
					System.out.printf("������ ����.\n");
					System.out.printf("���������� ģ�е� ������ ȸ�� �������� �����ϰų� �Ǹ� �� �� �ִ�.\n\n");
					// ������ ���� �޴��� ǥ���Ѵ�.
					market.marketMainMenu(item);
					// �÷��̾ �ൿ�� ������ ���̹� ���ϸ��� ���� ī��Ʈ ����
					continue;
					
				case 5: // 5. ���̹��� ����ϱ�
					//ShareData.MyPokemon = MyPokemon;
					//EnemyPokemon.BringRivalPokemon (ShareData.RivalPokemon);
					System.out.printf("���̹��� �����ϱ�� �ߴ�.\n");
					System.out.printf("�� �������� �̱�� ������ ���� �ȴ�.\n\n");
					// ���̹� ���ϸ��� ������ �� ���ϸ� ������ �����Ѵ�.
					enemyPokemon.bringRivalPokemon (ShareData.rivalPokemon, ShareData.enemyPokemon);
					// ���ϸ� ��Ʋ �޴����� ��Ʋ������ ����
					//Battle.PokemonBattleMenu (ShareData.MyPokemon, ShareData.EnemyPokemon);
					ShareData.enterBattleMenu = true;

					// ��Ʋ �߿��� ��Ʋ�� ���� ������ ����Ѵ�.
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
					
					// ���̹����� ��Ʋ���� �̱�� ������ ����ȴ�.
					if (Player.winToRival == true)
					{
						System.out.printf("���̹��� �������� �¸��ߴ�!\n");
						System.out.printf("�����մϴ�! ����� ������ Ŭ���� �ϼ̽��ϴ�.\n");
						ShareData.isGameOver = true;
						completeGame = true;
						
						//long CalculateMin;
						//long RemainSec;
						
						//ShareData.EndTime = System.currentTimeMillis();
						
						//CalculateMin = ((ShareData.EndTime - PlayTime.ReceiveData.StartTime) / 1000) / 60;
						//RemainSec = ((ShareData.EndTime - PlayTime.ReceiveData.StartTime) / 1000) % 60;
						
						//System.out.printf("�� �÷��� Ÿ��: %d �� %d�� \n", ShareData.CalculateMin, ShareData.RemainSec);
						break;
					}
					else
					{
						continue;
					}
			
				case 6:	// 6. �÷��̾� ������ Ȯ��.
					ShareData.showPlayTime = true;
					// �÷��� Ÿ���� ����Ҷ����� ���
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
					// Ʈ���̳� ������ �ֿܼ� ���
					Player.currentOwnPokemon = ShareData.myPokemon.pokemonName;
					Player.displayTrainerInfo();
					// �� ���ϸ� ������ �ֿܼ� ���
					ShareData.myPokemon.displayPokemonStatus();
					// �κ��丮 ������ �ֿܼ� ���
					Player.displayItemInfo ();
					
					
					
					continue;
					
				case 7:	// 7. ���̹��� ������ Ȯ���Ѵ�.
					//EnemyPokemon.BringRivalPokemon (ShareData.RivalPokemon);
					// ���̹� ������ �ֿܼ� ���
					RivalTrainer.displayTrainerInfo();
					continue;
					
				case 100:	// 100. ������ ���
					// �ڽ��� ���ϸ�� ���̹� ���ϸ��� ���� �ִ�ġ�� �ø���.
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
		
		// ���� ���α׷��� ����Ǳ����� �ٸ� �������� �����带 ���� �����Ҷ����� ���
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
