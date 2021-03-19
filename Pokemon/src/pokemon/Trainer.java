/**************************************************
 
Ʈ���̳� Ŭ����

**************************************************/

package pokemon;

import java.util.InputMismatchException;

public class Trainer 
{
	public static String trainerName = "";			// Ʈ���̳� �̸�
	public static String currentOwnPokemon = "";	// ���� ���� ���ϸ�
	public static int currentMoney = 2000;			// ���� ������
		
	/**************************************************
	 
	receiveName
	�Է�: ����ڷκ��� �Է¹��� ����, �÷��̾� �̸��ΰ� or ���̹� �̸��ΰ�
	���: Ʈ���̳� �̸�
	
	�÷��̾�� ���̹��� �̸��� �Է� �޾Ƽ� �����Ѵ�.

	**************************************************/
	public static void receiveName (boolean isPlayer)
	{
		int receiveConfirm = -1;
		boolean correctName = false;	// �ùٸ� �̸� �Է��� �Ǵ��ϴ� ����
		boolean nameConfirm = false;
		
		LoopName: while (correctName == false) // �ùٸ� �̸��� �Է� ������ ����
		{
			if (isPlayer == true) // �÷��̾� �̸��� �����ϴ� ���ΰ�?
			{
				System.out.printf("************************************************************\n");
				System.out.printf("�÷��̾��� �̸��� �˷��ּ���.\n");
				System.out.printf("�̸�: ");
			}
			else // ���̹��� �̸��� ����
			{
				System.out.printf("************************************************************\n");
				System.out.printf("���̹��� �̸��� �˷��ּ���.\n");
				System.out.printf("�̸�: ");
			}
			
			try
			{
				trainerName = ShareData.scanUserInput.next();
			}
			catch (InputMismatchException ErrorInput)
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
			}
			
			// �Է��� �̸� Ȯ�� ����
			while (nameConfirm == false)
			{
				System.out.printf("�̸��� %s�� �½��ϱ�?   1. Yes    2. No\n", trainerName);
				System.out.printf("Ȯ�� ����: ");
				
				try
				{
					receiveConfirm = ShareData.scanUserInput.nextInt();
				}
				catch (InputMismatchException ErrorInput)
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
				}
				
				if ((receiveConfirm <= 0) && (receiveConfirm > 2))
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
				else
				{
					// �̸� Ȯ�� �Ϸ�
					if (receiveConfirm == 1)
					{
						nameConfirm = true;
						correctName = true;
					}
					else // �̸� �� �Է�
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
	public static int getFamiliarity = 0;		// ȹ���� ģ�ε� ��
	public static boolean winToRival = false;	// ���̹����� �̰�°�
	
	/**************************************************
	 
	displayTrainerInfo
	�Է�: Ʈ���̳� �̸�, ���� ���ϸ�, ������
	���: Ʈ���̳� ������ �ֿܼ� ǥ��
	
	���� �÷��̾��� Ʈ���̳� ������ ����Ѵ�.

	**************************************************/
	public static void displayTrainerInfo ()
	{
		System.out.printf("************************************************************\n");
		System.out.printf("���� �÷��̾� ����\n");
		System.out.printf("Ʈ���̳� �̸�: %s\n", trainerName);
		System.out.printf("���� ���ϸ�: %s\n", currentOwnPokemon);
		System.out.printf("������: %d\n", currentMoney);
		System.out.printf("************************************************************\n");
	}
	
	/**************************************************
	 
	displayItemInfo
	�Է�: ������ ����
	���: �ֿܼ� ���� ������ �ִ� ������ ���� ǥ��
	
	���� �÷��̾��� Ʈ���̳� ������ ������ ����Ѵ�.

	**************************************************/
	public static void displayItemInfo ()
	{
		
		System.out.printf("************************************************************\n");
		System.out.printf("���� �����ϰ� �ִ� ������ ����\n\n");
		System.out.printf("ģ�е� ������\n");
		
		for (int itemIdx = 0; itemIdx < 10; itemIdx++)
		{
			// �κ��� �������� 1�� �̻��� ���� ã��
			if (item.familiarityAmount[itemIdx] > 0)
			{
				System.out.printf("%s   ������: %d ģ�е� ��·�: %d\n", 
						item.familiarityItemName[itemIdx], item.familiarityAmount[itemIdx], item.familiarityValue[itemIdx]);
			}
		}
		
		System.out.printf("ȸ�� ������\n");
		
		for (int itemIdx = 0; itemIdx < 10; itemIdx++)
		{
			// �κ��� �������� 1�� �̻��� ���� ã��
			if (item.recoveryAmount[itemIdx] > 0)
			{
				if (item.recoveryItemName[itemIdx] == "������ġ��")
				{
					System.out.printf("%s   ������: %d ȸ����: %d + �����̻� ġ��\n", 
							item.recoveryItemName[itemIdx], item.recoveryAmount[itemIdx], item.recoveryValue[itemIdx]);
				}
				else
				{
					System.out.printf("%s   ������: %d ȸ����: %d\n", 
							item.recoveryItemName[itemIdx], item.recoveryAmount[itemIdx], item.recoveryValue[itemIdx]);
				}
			}
		}
		
		System.out.printf("************************************************************\n");
	}
		
	/**************************************************
	 
	increaseFamiliarity
	�Է�: ������ ������ ��ȣ, ������ ����
	���: �����ϴ� ģ�е� ��
	
	���ϸ��� ģ�е��� �ø���.

	**************************************************/
	public static int increaseFamiliarity ()
	{
		int receiveNumber = -1;				// ����ڰ� �Է��ϴ� ��ġ
		boolean correctNumber = false;		// �ùٸ� ���� �Է��� �Ǵ��ϴ� ����
		boolean correctName = false;		// �ùٸ� �̸� �Է��� �Ǵ��ϴ� ����
		String itemName = new String();		// ������ �̸� �Է¹��� ����
		
		// ģ�е��� �ø� �������� ����.
		while (correctNumber == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("ģ�е��� ��� �ø���??\n");
			System.out.printf("1. ģ�е� �������� �����Ѵ�.\n2. ���ϸ�� ���� ���.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("���� �� �ൿ: ");
			
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
			
			if ((receiveNumber <= 0) || (receiveNumber >= 3))
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			else
			{
				// ���� �Ϸ�
				correctNumber = true;
			}
		}
		
		// ģ�е� �������� �ش�.
		if (receiveNumber == 1)
		{
			System.out.printf("\n���� �� �� �ִ� ģ�е� ������\n");
			for (int itemIdx = 0; itemIdx < 10; itemIdx++)
			{
				// �κ��� �������� 1�� �̻��� ���� ã��
				if (Player.item.familiarityAmount[itemIdx] > 0)
				{
					System.out.printf("%d. %s   ������: %d\n", (itemIdx + 1), Player.item.familiarityItemName[itemIdx], Player.item.familiarityAmount[itemIdx]);
				}
			}
			
			while (correctName == false) // �ùٸ� �̸��� �Է� ������ ����
			{
				
				System.out.printf("\n�ǳ��� ������ �̸��� �Է��ϼ���.\n");
				System.out.printf("������ �̸�: ");
				try
				{
					itemName = ShareData.scanUserInput.next();
					for (int itemIdx = 0; itemIdx < 10; itemIdx++)
					{
						// �κ��� �������� 1�� �̻��� ���� ã��
						correctName = itemName.equals(Player.item.familiarityItemName[itemIdx]);
						if (correctName == true)
						{
							System.out.printf("%s�� �� ���ϸ󿡰� �־���.\n", Player.item.familiarityItemName[itemIdx]);
							System.out.printf("ģ�е��� %d��ŭ �ö���.\n", Player.item.familiarityValue[itemIdx]);
							Player.item.familiarityAmount[itemIdx]--;
							getFamiliarity = Player.item.familiarityValue[itemIdx];
							break;
						}
					}
				}
				catch (InputMismatchException ErrorInput)
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
				}

				if (correctName == false)
				{
					System.out.printf("************************************************************\n");
					System.out.println("�߸��� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
					System.out.printf("************************************************************\n");
					continue;
				}
			}
		}
		else // ���ϸ�� ���� ��ٸ� ����
		{
			System.out.printf("************************************************************\n");
			System.out.printf("���ϸ�� ���� �ų��� ��Ҵ�.\n");
			System.out.printf("���̳�ٺ��� �� ģ���� ������ ���.\n");
			System.out.printf("ģ�е��� %d��ŭ �ö���.\n", 20);
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
	�Է�: ���̹� ���ϸ� ����
	���: �ֿܼ� ���̹��� ���̹� ���ϸ� ���� ���� ǥ��
	
	���� ���̹� ������ ����Ѵ�.

	**************************************************/
	public static void displayTrainerInfo ()
	{
		System.out.printf("************************************************************\n");
		System.out.printf("���� ���̹� ����\n");
		System.out.printf("Ʈ���̳� �̸�: %s\n", trainerName);
		System.out.printf("���� ���ϸ�: %s\n\n", ShareData.rivalPokemon.pokemonName);
		System.out.printf("���̹� ���ϸ� ����\n");
		System.out.printf("����: %d\n", ShareData.rivalPokemon.pokemonLevel);
		System.out.printf("HP: %d\n", ShareData.rivalPokemon.pokemonStatus[0]);
		System.out.printf("���ݷ�: %d\n", ShareData.rivalPokemon.pokemonStatus[1]);
		System.out.printf("����: %d\n", ShareData.rivalPokemon.pokemonStatus[2]);
		System.out.printf("���ǵ�: %d\n\n", ShareData.rivalPokemon.pokemonStatus[3]);
		System.out.printf("���̹� ���ϸ� ��ų ����\n");
		System.out.printf("1. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
				ShareData.rivalPokemon.pokemonSkill.skillName[0], 
				ShareData.rivalPokemon.pokemonSkill.skillDamage[0], 
				ShareData.rivalPokemon.pokemonSkill.currentSkillCount[0], ShareData.rivalPokemon.pokemonSkill.skillCount[0], 
				ShareData.rivalPokemon.pokemonSkill.skillAccuracy[0]);
		System.out.printf("2. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
				ShareData.rivalPokemon.pokemonSkill.skillName[1], 
				ShareData.rivalPokemon.pokemonSkill.skillDamage[1], 
				ShareData.rivalPokemon.pokemonSkill.currentSkillCount[1], ShareData.rivalPokemon.pokemonSkill.skillCount[1], 
				ShareData.rivalPokemon.pokemonSkill.skillAccuracy[1]);
		System.out.printf("3. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
				ShareData.rivalPokemon.pokemonSkill.skillName[2], 
				ShareData.rivalPokemon.pokemonSkill.skillDamage[2], 
				ShareData.rivalPokemon.pokemonSkill.currentSkillCount[2], ShareData.rivalPokemon.pokemonSkill.skillCount[2], 
				ShareData.rivalPokemon.pokemonSkill.skillAccuracy[2]);
		System.out.printf("4. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
				ShareData.rivalPokemon.pokemonSkill.skillName[3], 
				ShareData.rivalPokemon.pokemonSkill.skillDamage[3], 
				ShareData.rivalPokemon.pokemonSkill.currentSkillCount[3], ShareData.rivalPokemon.pokemonSkill.skillCount[3], 
				ShareData.rivalPokemon.pokemonSkill.skillAccuracy[3]);
		System.out.printf("************************************************************\n");
	}
}

//End of File
