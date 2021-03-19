/**************************************************
 
�ҼӼ� ���ϸ� Ŭ����

**************************************************/

package pokemon;

import java.util.Random;

//import java.util.InputMismatchException;

// �ҼӼ� ���ϸ�
// �ҼӼ� ���ϸ� Ŭ������ ���ϸ� Ŭ������ ����� ��û
class FireElementPokemon extends Pokemon
{
	// �ҼӼ� ��ų Ŭ����
	FireSkill fireSkill = new FireSkill();
	// �� �Ӽ� ���ϸ��� ȭ���� ���� �� �ִ�.
	boolean burnStatus = false;
	
	/**************************************************
	 
	makeBurnStatus
	�Է�: 0 ~ 99 ���� ���� ����
	���: ȭ�� ����
	
	�ҼӼ� ������ �ϸ� 20%�� Ȯ���� ȭ���� �ɸ���.

	**************************************************/
	boolean makeBurnStatus ()
	{
		// �������ڸ� ��� ���� ���� Ŭ����
		Random random = new Random();
		int randomNumber = -1;	// ���� ��ȣ�� ����
		
		// ���� ��ȣ�� �� ���� 20���� ������ ȭ�� ���°� �ȴ�.
		randomNumber = random.nextInt(100);
		
		if (randomNumber >= 20)
		{
			burnStatus = false;
		}
		else
		{
			burnStatus = true;
		}
		
		return burnStatus;
	}
	
	/**************************************************
	 
	LearnNewSkill
	�Է�: �� ���ϸ� ����
	���: ���ο� ��ų�� ���� �� ���ϸ� ����
	
	���� ������ �Ǹ�  ���ο� �ҼӼ� ��ų�� ������.

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
			case 10: // ���� 10
				// �Ҳɾ��ϸ� ������.
				if (isMyPokemon == true)
				{
					fireSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 1);
					fireSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 1);
					fireSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 1);
					fireSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 1);
					fireSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 1);
					fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 1);
					fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 1);
					fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 1);
					fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 0);
				}

				break;
			case 20: // ���� 20
				// ȭ����縦 ������.
				if (isMyPokemon == true)
				{
					fireSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 1, 2);
					fireSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 1, 2);
					fireSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 1, 2);
					fireSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 1, 2);
					fireSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 1);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[1]);
				}
				else
				{
					fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 1, 2);
					fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 1, 2);
					fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 1, 2);
					fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 1, 2);
					fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 1);
				}

				break;
			case 30: // ���� 30
				// �Ҵ빮�ڸ� ������.
				if (isMyPokemon == true)
				{
					fireSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 2, 3);
					fireSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 2, 3);
					fireSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 2, 3);
					fireSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 2, 3);
					fireSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 2);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[2]);
				}
				else
				{
					fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 3);
					fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 3);
					fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 3);
					fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 3);
					fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
				}

				break;
			case 40: // ���� 40
				// �÷������̺긦 ������.
				if (isMyPokemon == true)
				{
					fireSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 4);
					fireSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 4);
					fireSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 4);
					fireSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 4);
					fireSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 4);
					fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 4);
					fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 4);
					fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 4);
					fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
				}

				break;
			default:
				break;
		}
	}
}

//2�� ����� ���� �ҼӼ� ���ϸ��� ���̸�
//Charmander: ���̸��� ������
class Charmander extends FireElementPokemon
{
	/**************************************************
	 
	setBasicPokemonStatus
	�Է�: ������ ���� �� ���ϸ� ����
	���: ���̸� ������ ������ �� ���ϸ��� ����
	
	���̸��� �����ϰ� �ʱ� �ɷ�ġ�� �����Ѵ�.

	**************************************************/
	void setBasicPokemonStatus (boolean isMyPokemon)
	{
		if (isMyPokemon == true)
		{
			// ���� 1�� �⺻ �ɷ�ġ ����
			ShareData.myPokemon.pokemonStatus[0] = 10;		// HealthPoint
			ShareData.myPokemon.pokemonStatus[1] = 6;		// Attack
			ShareData.myPokemon.pokemonStatus[2] = 5;		// Defense
			ShareData.myPokemon.pokemonStatus[3] = 6;		// Speed
			
			ShareData.myPokemon.pokemonStatus[4] = 1; 		// ���ϸ� Ÿ��(�ҼӼ�)
			ShareData.myPokemon.pokemonStatus[5] = 10; 		// ���ϸ��� ���� ü��
			
			// ���̸��� ó�� ������ �ִ� ��ų ����
			// ��ų��
			ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 0, 1);
			fireSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillName[2] = "�̽���";
			ShareData.myPokemon.pokemonSkill.skillName[3] = "�̽���";
			
			// ��ų ����
			ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 0, 1);
			fireSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillDamage[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillDamage[3] = 0;
			
			// ��ų ���߷�
			ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 0, 0);
			fireSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillAccuracy[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillAccuracy[3] = 0;
			
			// ��ų Ƚ��
			ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 0, 0);
			fireSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillCount[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillCount[3] = 0;
			
			// ��ų �Ӽ�
			ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 0);
			fireSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 1);
			ShareData.myPokemon.pokemonSkill.skillType[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillType[3] = 0;
			
			// ��ų ��� Ƚ�� ����
			ShareData.myPokemon.pokemonSkill.currentSkillCount[0] = ShareData.myPokemon.pokemonSkill.skillCount[0];
			ShareData.myPokemon.pokemonSkill.currentSkillCount[1] = ShareData.myPokemon.pokemonSkill.skillCount[1];
			ShareData.myPokemon.pokemonSkill.currentSkillCount[2] = ShareData.myPokemon.pokemonSkill.skillCount[2];
			ShareData.myPokemon.pokemonSkill.currentSkillCount[3] = ShareData.myPokemon.pokemonSkill.skillCount[3];
		}
		else
		{
			// ���� 1�� �⺻ �ɷ�ġ ����
			ShareData.rivalPokemon.pokemonStatus[0] = 10;	// HealthPoint
			ShareData.rivalPokemon.pokemonStatus[1] = 6;		// Attack
			ShareData.rivalPokemon.pokemonStatus[2] = 5;		// Defense
			ShareData.rivalPokemon.pokemonStatus[3] = 6;		// Speed
			
			ShareData.rivalPokemon.pokemonStatus[4] = 1; 	// ���ϸ� Ÿ��(�ҼӼ�)
			ShareData.rivalPokemon.pokemonStatus[5] = 10; 	// ���ϸ��� ���� ü��
			
			// ���̸��� ó�� ������ �ִ� ��ų ����
			// ��ų��
			ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 0, 1);
			fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 1);
			fireSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 0);
			
			// ��ų ����
			ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 0, 1);
			fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 1);
			fireSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 0);
			
			// ��ų ���߷�
			ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 0, 1);
			fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 1);
			fireSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 0);
			
			// ��ų Ƚ��
			ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 0, 1);
			fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 1);
			fireSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 0);
			
			// ��ų �Ӽ�
			ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 0);
			fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 1);
			ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
			fireSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
			
			// ��ų ��� Ƚ�� ����
			ShareData.rivalPokemon.pokemonSkill.currentSkillCount[0] = ShareData.rivalPokemon.pokemonSkill.skillCount[0];
			ShareData.rivalPokemon.pokemonSkill.currentSkillCount[1] = ShareData.rivalPokemon.pokemonSkill.skillCount[1];
			ShareData.rivalPokemon.pokemonSkill.currentSkillCount[2] = ShareData.rivalPokemon.pokemonSkill.skillCount[2];
			ShareData.rivalPokemon.pokemonSkill.currentSkillCount[3] = ShareData.rivalPokemon.pokemonSkill.skillCount[3];
		}
	}
	
	/**************************************************
	 
	evolutionPokemon
	�Է�: �� ���ϸ��� ����
	���: �� ���ϸ��� ����
	
	���� ������ �޼��ϸ� ��ȭ�Ѵ�.
	���̸� -> ���ڵ� -> ���ڸ�

	**************************************************/
	void evolutionPokemon (boolean isMyPokemon)
	{
		int level = 0;
		
		if (isMyPokemon == true)
		{
			level = ShareData.myPokemon.pokemonLevel;
		}
		else
		{
			level = ShareData.pokemon.pokemonLevel;
		}
		
		switch (level)
		{
			case 16: // ������ 16�� �Ǹ� ���ڵ�� ��ȭ
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonName = "���ڵ�";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.myPokemon.pokemonStatus[0] += 10;	// HealthPoint
					ShareData.myPokemon.pokemonStatus[1] += 6;	// Attack
					ShareData.myPokemon.pokemonStatus[2] += 5;	// Defense
					ShareData.myPokemon.pokemonStatus[3] += 6;	// Speed

					ShareData.myPokemon.pokemonStatus[5] += 10; 	// ���ϸ��� ���� ü��
					
					System.out.printf("���̸��� ���ڵ�� ��ȭ�ߴ�.!!\n\n");
				}
				else
				{
					ShareData.rivalPokemon.pokemonName = "���ڵ�";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.rivalPokemon.pokemonStatus[0] += 10;		// HealthPoint
					ShareData.rivalPokemon.pokemonStatus[1] += 6;		// Attack
					ShareData.rivalPokemon.pokemonStatus[2] += 5;		// Defense
					ShareData.rivalPokemon.pokemonStatus[3] += 6;		// Speed

					ShareData.rivalPokemon.pokemonStatus[5] += 10; 		// ���ϸ��� ���� ü��
				}

				break;
			case 36: // ������ 36�� �Ǹ� ���ڸ����� ��ȭ
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonName = "���ڸ�";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.myPokemon.pokemonStatus[0] += 12;	// HealthPoint
					ShareData.myPokemon.pokemonStatus[1] += 10;	// Attack
					ShareData.myPokemon.pokemonStatus[2] += 8;	// Defense
					ShareData.myPokemon.pokemonStatus[3] += 8;	// Speed

					ShareData.myPokemon.pokemonStatus[5] += 12; 	// ���ϸ��� ���� ü��
					
					System.out.printf("���ڵ尡 ���ڸ����� ��ȭ�ߴ�.!!\n\n");
				}
				else
				{
					ShareData.rivalPokemon.pokemonName = "���ڸ�";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.rivalPokemon.pokemonStatus[0] += 12;		// HealthPoint
					ShareData.rivalPokemon.pokemonStatus[1] += 10;		// Attack
					ShareData.rivalPokemon.pokemonStatus[2] += 8;		// Defense
					ShareData.rivalPokemon.pokemonStatus[3] += 8;		// Speed

					ShareData.rivalPokemon.pokemonStatus[5] += 12; 		// ���ϸ��� ���� ü��
				}
				
				break;
			default:
				break;
		}
	}
}



//End of File
