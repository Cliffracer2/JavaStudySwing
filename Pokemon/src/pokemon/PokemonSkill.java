/**************************************************
 
���ϸ� ��ų Ŭ����

**************************************************/

package pokemon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

public class PokemonSkill 
{
	List<String> skillNameList = new ArrayList<String>();		// ��ų �� ����Ʈ
	ArrayList<Integer> skillDamageList = new ArrayList<>();		// ��ų ���� ����Ʈ
	ArrayList<Integer> skillCountList = new ArrayList<>();		// ��ų Ƚ�� ����Ʈ
	ArrayList<Integer> skillAccuracyList = new ArrayList<>();	// ��ų ���߷� ����Ʈ
	
	// ���ϸ��� ��ų 4���� ������ �ڸ�
	// ��ų 1 ~ 4�� �̸�
	String[] skillName = new String[4];
	// ��ų 1 ~ 4�� ���� ����
	int[] skillDamage = new int[4];
	// ��ų 1 ~ 4�� ���߷� ����
	int[] skillAccuracy = new int[4];
	// ��ų 1 ~ 4�� ����� �� �ִ� Ƚ�� ����
	int[] skillCount = new int[4];
	// ��ų 1 ~ 4�� ���� ����� �� �ִ� Ƚ�� ����
	int[] currentSkillCount = new int[4];
	// ��ų �Ӽ� ������ �����Ѵ�.
	// 0: ���Ӽ�, 1: �ҼӼ�, 2: Ǯ�Ӽ�, 3: ���Ӽ�
	int[] skillType = new int[4];
		
	// ������ ���Ӽ� ��ų(���ϸ��� �������� ���� �� �ִ�) ����
	public void setSkill ()
	{
		skillNameList.add("�����ġ��");		// 0
		skillNameList.add("������");			// 1
		skillNameList.add("��ӽ���");			// 2
		skillNameList.add("�ް�����ġ");		// 3
		skillNameList.add("����");			// 4
		skillNameList.add("����");			// 5
		skillNameList.add("������");			// 6
		skillNameList.add("�Ⱑ����Ʈ");		// 7
		skillNameList.add("���ǻ�����Ŭ");		// 8

		skillDamageList.add(40);			// 0
		skillDamageList.add(40);			// 1
		skillDamageList.add(50);			// 2
		skillDamageList.add(80);			// 3
		skillDamageList.add(90);			// 4
		skillDamageList.add(80);			// 5
		skillDamageList.add(85);			// 6
		skillDamageList.add(150);			// 7
		skillDamageList.add(120);			// 8
		
		skillCountList.add(35);				// 0
		skillCountList.add(35);				// 1
		skillCountList.add(40);				// 2
		skillCountList.add(20);				// 3
		skillCountList.add(20);				// 4
		skillCountList.add(15);				// 5
		skillCountList.add(15);				// 6
		skillCountList.add(5);				// 7
		skillCountList.add(15);				// 8
		
		skillAccuracyList.add(100);			// 0
		skillAccuracyList.add(100);			// 1
		skillAccuracyList.add(100);			// 2
		skillAccuracyList.add(85);			// 3
		skillAccuracyList.add(85);			// 4
		skillAccuracyList.add(100);			// 5
		skillAccuracyList.add(100);			// 6
		skillAccuracyList.add(90);			// 7
		skillAccuracyList.add(100);			// 8
	}
	
	/**************************************************
	
	setSkillName
	�Է�: ��ų ��ġ, ����Ʈ�� ��ų�� ��ġ ��
	���: ��ų �̸�
	
	���Ӽ� ��ų �̸� ����

	**************************************************/
	void setSkillName (String[] skillName, int skillPosition, int skillIndex)
	{	
		// ���ϸ��� ��ų ������ �ҷ��´�.
		setSkill();
		
		// SkillPosition �ڸ���  SkillIndex���� ��ų�� ������.
		skillName[skillPosition] = skillNameList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillDamage
	�Է�: ��ų ��ġ, ����Ʈ�� ��ų�� ��ġ ��
	���: ��ų ����
	
	���Ӽ� ��ų ���� ����

	**************************************************/
	void setSkillDamage (int[] skillDamage, int skillPosition, int skillIndex)
	{
		// ���ϸ��� ��ų ������ �ҷ��´�.
		setSkill();
		
		// SkillPosition �ڸ���  SkillIndex���� ��ų�� ������.
		skillDamage[skillPosition] = skillDamageList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillCount
	�Է�: ��ų ��ġ, ����Ʈ�� ��ų�� ��ġ ��
	���: ��ų Ƚ��
	
	���Ӽ� ��ų Ƚ�� ����

	**************************************************/
	void setSkillCount (int[] skillCount, int skillPosition, int skillIndex)
	{
		// ���ϸ��� ��ų ������ �ҷ��´�.
		setSkill();
		
		// SkillPosition �ڸ���  SkillIndex���� ��ų�� ������.
		skillCount[skillPosition] = skillCountList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillAccuracy
	�Է�: ��ų ��ġ, ����Ʈ�� ��ų�� ��ġ ��
	���: ��ų Ƚ��
	
	���Ӽ� ��ų ���߷� ����

	**************************************************/
	void setSkillAccuracy (int[] skillAccuracy, int skillPosition, int skillIndex)
	{
		// ���ϸ��� ��ų ������ �ҷ��´�.
		setSkill();
		
		// SkillPosition �ڸ���  SkillIndex���� ��ų�� ������.
		skillAccuracy[skillPosition] = skillAccuracyList.get(skillIndex);
	}
	
	/**************************************************
	
	setSkillType
	�Է�: ��ų ��ġ
	���: ��ų �Ӽ�
	
	���Ӽ� ��ų �Ӽ� ����

	**************************************************/
	void setSkillType (int[] skillType, int skillPosition)
	{
		// ���Ӽ����� ����
		skillType[skillPosition] = 0;
	}
	
	/**************************************************
	
	pokemonUsingSkill
	�Է�: ����ڷκ��� �Է¹��� ����, �� ���ϸ� ����
	���: �÷��̾ ����� ��ų ��ȣ
	
	�÷��̾� ���ϸ��� ��ų ���
	1 ~ 4���� ��ų�� �ϳ��� �Է��Ͽ� ����ϰ� �Է��� ��ȣ ���� �����Ѵ�.

	**************************************************/
	public int pokemonUsingSkill (MyPokemon myPokemon)
	{
		// ������ ����� ��ų ����
		int receiveNumber = -1;				// ����ڰ� �Է��ϴ� ������ ��ġ
		boolean correctNumber = false;		// �ùٸ� ���� �Է��� �Ǵ��ϴ� ����
		
		// �´� ���ڸ� �Է��� ������ �ݺ�
		while (correctNumber == false)
		{
			// 4���� ��ų�� ��ų��, ����, (���� Ƚ�� / �ִ� Ƚ��) ������ ���
			System.out.printf("************************************************************\n");
			System.out.printf("��ų�� ���� �ϼ���.\n");
			System.out.printf("1. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
					myPokemon.pokemonSkill.skillName[0], 
					myPokemon.pokemonSkill.skillDamage[0], 
					myPokemon.pokemonSkill.currentSkillCount[0], myPokemon.pokemonSkill.skillCount[0], 
					myPokemon.pokemonSkill.skillAccuracy[0]);
			System.out.printf("2. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
					myPokemon.pokemonSkill.skillName[1], 
					myPokemon.pokemonSkill.skillDamage[1], 
					myPokemon.pokemonSkill.currentSkillCount[1], myPokemon.pokemonSkill.skillCount[1], 
					myPokemon.pokemonSkill.skillAccuracy[1]);
			System.out.printf("3. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
					myPokemon.pokemonSkill.skillName[2], 
					myPokemon.pokemonSkill.skillDamage[2], 
					myPokemon.pokemonSkill.currentSkillCount[2], myPokemon.pokemonSkill.skillCount[2], 
					myPokemon.pokemonSkill.skillAccuracy[2]);
			System.out.printf("4. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
					myPokemon.pokemonSkill.skillName[3], 
					myPokemon.pokemonSkill.skillDamage[3], 
					myPokemon.pokemonSkill.currentSkillCount[3], myPokemon.pokemonSkill.skillCount[3], 
					myPokemon.pokemonSkill.skillAccuracy[3]);
			System.out.printf("************************************************************\n");
			System.out.printf("���� ������ ��ų��ȣ: ");
			
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
			
			if ((receiveNumber <= 0) || (receiveNumber >= 5))
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			else
			{
				// ����� ��ų�� Ƚ���� 0�̸�
				if (myPokemon.pokemonSkill.currentSkillCount[receiveNumber - 1] == 0)
				{
					System.out.printf("\n\n");
					System.out.printf("�� ����� ���̻� ������� ����! �ٸ� ��ų�� �����!\n");
					continue;
				}
				else
				{
					// ���ڸ� �°� �Է���
					correctNumber = true;
				}
			}
		}
		
		// ��ų ���� �޽��� ���
		System.out.printf("\n\n");
		
		switch (receiveNumber)
		{
			case 1: // 1��° ��ų ���
				System.out.printf("%s! %s!\n", 
						myPokemon.pokemonName, myPokemon.pokemonSkill.skillName[0]);
				break;
			case 2: // 2��° ��ų ���
				System.out.printf("%s! %s!\n", 
						myPokemon.pokemonName, myPokemon.pokemonSkill.skillName[1]);
				break;
			case 3: // 3��° ��ų ���
				System.out.printf("%s! %s!\n", 
						myPokemon.pokemonName, myPokemon.pokemonSkill.skillName[2]);
				break;
			case 4: // 4��° ��ų ���
				System.out.printf("%s! %s!\n", 
						myPokemon.pokemonName, myPokemon.pokemonSkill.skillName[3]);
				break;
			default:
				break;
		}
		
		// ��ų�� ����ϰ��� ��ų ī��Ʈ�� 1 ���� ��Ų��.
		if (myPokemon.pokemonSkill.currentSkillCount[receiveNumber - 1] > 0)
		{
			myPokemon.pokemonSkill.currentSkillCount[receiveNumber - 1]--;
		}
		
		// �迭�� ������ ��ġ�� ���߱� ���� 1�� ���ҽ�Ŵ
		return (receiveNumber - 1);
	}
	
	/**************************************************
	
	pokemonUsingSkill
	�Է�: �� ���ϸ� ����
	���: ���� ����ϴ� ��ų ��ȣ
	
	�� ���ϸ��� ��ų ���
	1 ~ 4���� ��ų�� �ϳ��� �Է��Ͽ� ����ϰ� �Է��� ��ȣ ���� �����Ѵ�.

	**************************************************/
	public int pokemonUsingSkill (EnemyPokemon enemyPokemon)
	{
		// �������ڸ� ��� ���� ���� Ŭ����
		Random randomSkillUse = new Random();
		int useSkillNumber = -1;	// ��ų ��ȣ ����
		
		// �� ���ϸ��� �������� ���� ��ų ��ȣ�� �Է� �޾� ��ų�� ����Ѵ�.
		useSkillNumber = randomSkillUse.nextInt(4) + 1;
		
		// ��ų ���� �޽��� ���
		System.out.printf("\n\n");
		
		switch (useSkillNumber)
		{
			case 1: // 1��° ��ų ���
				System.out.printf("%s�� %s!\n", 
						enemyPokemon.pokemonName, enemyPokemon.pokemonSkill.skillName[0]);
				break;
			case 2: // 2��° ��ų ���
				System.out.printf("%s�� %s!\n", 
						enemyPokemon.pokemonName, enemyPokemon.pokemonSkill.skillName[1]);
				break;
			case 3: // 3��° ��ų ���
				System.out.printf("%s�� %s!\n", 
						enemyPokemon.pokemonName, enemyPokemon.pokemonSkill.skillName[2]);
				break;
			case 4: // 4��° ��ų ���
				System.out.printf("%s�� %s!\n", 
						enemyPokemon.pokemonName, enemyPokemon.pokemonSkill.skillName[3]);
				break;
			default:
				break;
		}
		
		// ��ų�� ����ϰ��� ��ų ī��Ʈ�� 1 ���� ��Ų��.
		if (enemyPokemon.pokemonSkill.currentSkillCount[useSkillNumber - 1] > 0)
		{
			enemyPokemon.pokemonSkill.currentSkillCount[useSkillNumber - 1]--;
		}
		
		// �迭�� ������ ��ġ�� ���߱� ���� 1�� ���ҽ�Ŵ
		return (useSkillNumber - 1);
	}
	
	/**************************************************
	 
	learnNewSkill
	�Է�: �� ���ϸ� ����
	���: ���ο� ��ų�� ���� �� ���ϸ� ����
	
	���� ������ �Ǹ� ���ο� ���Ӽ� ��ų�� ������.

	**************************************************/
	void learnNewSkill (boolean isMyPokemon)
	{
		int level = 0;
		
		if (isMyPokemon == true)
		{
			level = ShareData.myPokemon.pokemonLevel;
		}
		else
		{
			level = ShareData.rivalPokemon.pokemonLevel;
		}
		
		switch (level)
		{
			case 5: // ���� 5
				// ��ӽ����� ������.
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 2, 2);
					ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 2, 2);
					ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 2, 2);
					ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 2, 2);
					ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 2);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[2]);
				}
				else
				{
					ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 2);
					ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 2);
					ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 2);
					ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 2);
					ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
				}

				break;
			case 15: // ���� 15
				// �ް�����ġ�� ������.
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 3);
					ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 3);
					ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 3);
					ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 3);
					ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 3);
					ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 3);
					ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 3);
					ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 3);
					ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
				}

				break;
			case 25: // ���� 25
				// ������ ������.
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 0, 4);
					ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 0, 4);
					ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 0, 4);
					ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 0, 4);
					ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 0);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[0]);
				}
				else
				{
					ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 0, 4);
					ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 0, 4);
					ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 0, 4);
					ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 0);
				}

				break;
			case 35: // ���� 35
				// ������ ������.
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 1, 5);
					ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 1, 5);
					ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 1, 5);
					ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 1, 5);
					ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 1);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[1]);
				}
				else
				{
					ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 1, 5);
					ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 1, 5);
					ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 1, 5);
					ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 1, 5);
					ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 0);
				}

				break;
			default:
				break;
		}
	}
}

//End of File
