/**************************************************
 
���Ӽ� ���ϸ� Ŭ����

**************************************************/

package pokemon;

import java.util.Random;

//���Ӽ� ���ϸ�
//���Ӽ� ���ϸ� Ŭ������ ���ϸ� Ŭ������ ����� ��û
class WaterElementPokemon extends Pokemon
{
	// ���Ӽ� ��ų Ŭ����
	WaterSkill waterSkill = new WaterSkill();
	// �� �Ӽ� ���ϸ��� ������ �� �� �ִ�.
	boolean iceStatus = false;
	
	/**************************************************
	 
	makeIceStatus
	�Է�: 0 ~ 99 ���� ���� ����
	���: ���� ����
	
	���Ӽ� ������ �ϸ� 20%�� Ȯ���� ������ �ɸ���.

	**************************************************/
	boolean makeIceStatus ()
	{
		// �������ڸ� ��� ���� ���� Ŭ����
		Random random = new Random();
		int randomNumber = -1; // ���� ��ȣ�� ����
		
		// ���� ��ȣ�� �� ���� 20���� ������ ���� ���°� �ȴ�.
		randomNumber = random.nextInt(100);
		
		if (randomNumber >= 20)
		{
			iceStatus = false;
		}
		else
		{
			iceStatus = true;
		}
		
		return iceStatus;
	}
	
	/**************************************************
	 
	learnNewSkill
	�Է�: �� ���ϸ� ����
	���: ���ο� ��ų�� ���� �� ���ϸ� ����
	
	���� ������ �Ǹ�  ���ο� ���Ӽ� ��ų�� ������.

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
				// �����ĵ��� ������.
				if (isMyPokemon == true)
				{
					waterSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 2, 1);
					waterSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 2, 1);
					waterSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 2, 1);
					waterSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 2, 1);
					waterSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 2);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[2]);
				}
				else
				{
					waterSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 1);
					waterSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 1);
					waterSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 1);
					waterSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 1);
					waterSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
				}

				break;
			case 20: // ���� 20
				// ����������� ������.
				if (isMyPokemon == true)
				{
					waterSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 2);
					waterSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 2);
					waterSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 2);
					waterSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 2);
					waterSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					waterSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 2);
					waterSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 2);
					waterSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 2);
					waterSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 2);
					waterSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
				}

				break;
			case 30: // ���� 30
				// �ĵ�Ÿ�⸦ ������.
				if (isMyPokemon == true)
				{
					waterSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 2, 3);
					waterSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 2, 3);
					waterSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 2, 3);
					waterSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 2, 3);
					waterSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 2);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[2]);
				}
				else
				{
					waterSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 3);
					waterSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 3);
					waterSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 3);
					waterSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 3);
					waterSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
				}

				break;
			case 40: // ���� 40
				// ���̵�������� ������.
				if (isMyPokemon == true)
				{
					waterSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 4);
					waterSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 4);
					waterSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 4);
					waterSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 4);
					waterSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					waterSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 4);
					waterSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 4);
					waterSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 4);
					waterSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 4);
					waterSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
				}

				break;
			default:
				break;
		}
	}
}

//2�� ����� ���� ���Ӽ� ���ϸ��� ���α�
//Squirtle: ���α��� ������
class Squirtle extends WaterElementPokemon
{
	/**************************************************
	 
	setBasicPokemonStatus
	�Է�: ������ ���� �� ���ϸ� ����
	���: ���α� ������ ������ �� ���ϸ��� ����
	
	���α⸦ �����ϰ� �ʱ� �ɷ�ġ�� �����Ѵ�.

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
			
			ShareData.myPokemon.pokemonStatus[4] = 3; 		// ���ϸ� Ÿ��(���Ӽ�)
			ShareData.myPokemon.pokemonStatus[5] = 10; 		// ���ϸ��� ���� ü��
			
			// ���̸��� ó�� ������ �ִ� ��ų ����
			// ��ų��
			ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 0, 1);
			waterSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillName[2] = "�̽���";
			ShareData.myPokemon.pokemonSkill.skillName[3] = "�̽���";
			
			// ��ų ����
			ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 0, 1);
			waterSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillDamage[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillDamage[3] = 0;
			
			// ��ų ���߷�
			ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 0, 0);
			waterSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillAccuracy[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillAccuracy[3] = 0;
			
			// ��ų Ƚ��
			ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 0, 0);
			waterSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillCount[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillCount[3] = 0;
			
			// ��ų �Ӽ�
			ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 0);
			waterSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 1);
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
			
			ShareData.rivalPokemon.pokemonStatus[4] = 3; 	// ���ϸ� Ÿ��(���Ӽ�)
			ShareData.rivalPokemon.pokemonStatus[5] = 10; 	// ���ϸ��� ���� ü��
			
			// ���̸��� ó�� ������ �ִ� ��ų ����
			// ��ų��
			ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 0, 1);
			waterSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 1);
			waterSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 0);
			
			// ��ų ����
			ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 0, 1);
			waterSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 1);
			waterSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 0);
			
			// ��ų ���߷�
			ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 0, 1);
			waterSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 1);
			waterSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 0);
			
			// ��ų Ƚ��
			ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 0, 1);
			waterSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 1);
			waterSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 0);
			
			// ��ų �Ӽ�
			ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 0);
			waterSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 1);
			ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
			waterSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
			
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
	���α� -> ��Ϻα� -> �źϿ�

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
			level = ShareData.rivalPokemon.pokemonLevel;
		}
		
		switch (level)
		{
			case 16: // ������ 16�� �Ǹ� ��Ϻα�� ��ȭ
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonName = "��Ϻα�";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.myPokemon.pokemonStatus[0] += 10;	// HealthPoint
					ShareData.myPokemon.pokemonStatus[1] += 6;	// Attack
					ShareData.myPokemon.pokemonStatus[2] += 5;	// Defense
					ShareData.myPokemon.pokemonStatus[3] += 6;	// Speed

					ShareData.myPokemon.pokemonStatus[5] += 10; 	// ���ϸ��� ���� ü��
					
					System.out.printf("���αⰡ ��Ϻα�� ��ȭ�ߴ�.!!\n\n");
				}
				else
				{
					ShareData.rivalPokemon.pokemonName = "��Ϻα�";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.rivalPokemon.pokemonStatus[0] += 10;	// HealthPoint
					ShareData.rivalPokemon.pokemonStatus[1] += 6;	// Attack
					ShareData.rivalPokemon.pokemonStatus[2] += 5;	// Defense
					ShareData.rivalPokemon.pokemonStatus[3] += 6;	// Speed

					ShareData.rivalPokemon.pokemonStatus[5] += 10; 	// ���ϸ��� ���� ü��
				}

				break;
			case 36: // ������ 36�� �Ǹ� �źϿ����� ��ȭ
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonName = "�źϿ�";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.myPokemon.pokemonStatus[0] += 12;	// HealthPoint
					ShareData.myPokemon.pokemonStatus[1] += 8;	// Attack
					ShareData.myPokemon.pokemonStatus[2] += 8;	// Defense
					ShareData.myPokemon.pokemonStatus[3] += 10;	// Speed

					ShareData.myPokemon.pokemonStatus[5] += 12; 	// ���ϸ��� ���� ü��
					
					System.out.printf("��ϺαⰡ �źϿ����� ��ȭ�ߴ�.!!\n\n");
				}
				else
				{
					ShareData.rivalPokemon.pokemonName = "�źϿ�";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.rivalPokemon.pokemonStatus[0] += 12;	// HealthPoint
					ShareData.rivalPokemon.pokemonStatus[1] += 8;	// Attack
					ShareData.rivalPokemon.pokemonStatus[2] += 8;	// Defense
					ShareData.rivalPokemon.pokemonStatus[3] += 10;	// Speed

					ShareData.rivalPokemon.pokemonStatus[5] += 12; 	// ���ϸ��� ���� ü��
				}

				break;
			default:
				break;
		}
	}
}

//End of File
