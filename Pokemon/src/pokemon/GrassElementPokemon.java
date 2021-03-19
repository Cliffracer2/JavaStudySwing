/**************************************************
 
Ǯ�Ӽ� ���ϸ� Ŭ����

**************************************************/

package pokemon;

import java.util.Random;

//Ǯ�Ӽ� ���ϸ�
//Ǯ�Ӽ� ���ϸ� Ŭ������ ���ϸ� Ŭ������ ����� ��û
class GrassElementPokemon extends Pokemon
{
	// Ǯ�Ӽ� ��ų Ŭ����
	GlassSkill glassSkill = new GlassSkill();
	// Ǯ�Ӽ� ���ϸ��� ���� �� �� �ִ�.
	boolean paralysisStatus = false;
	
	/**************************************************
	 
	makeParalysisStatus
	�Է�: 0 ~ 99 ���� ���� ����
	���: ���� ����
	
	Ǯ�Ӽ� ������ �ϸ� 20%�� Ȯ���� ���� �ɸ���.

	**************************************************/
	boolean makeParalysisStatus ()
	{
		// �������ڸ� ��� ���� ���� Ŭ����
		Random random = new Random();
		int randomNumber = -1; // ���� ��ȣ�� ����
		
		// ���� ��ȣ�� �� ���� 20���� ������ ���� ���°� �ȴ�.
		randomNumber = random.nextInt(100);
		
		if (randomNumber >= 20)
		{
			paralysisStatus = false;
		}
		else
		{
			paralysisStatus = true;
		}
		
		return paralysisStatus;
	}
	
	/**************************************************
	 
	learnNewSkill
	�Է�: �� ���ϸ� ����
	���: ���ο� ��ų�� ���� �� ���ϸ� ����
	
	���� ������ �Ǹ�  ���ο� Ǯ�Ӽ� ��ų�� ������.

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
				// �ٳ������⸦ ������.
				if (isMyPokemon == true)
				{
					glassSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 2, 1);
					glassSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 2, 1);
					glassSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 2, 1);
					glassSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 2, 1);
					glassSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 2);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[2]);
				}
				else
				{
					glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 1);
					glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 1);
					glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 1);
					glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 1);
					glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
				}

				break;
			case 20: // ���� 20
				// ����ź�� ������.
				if (isMyPokemon == true)
				{
					glassSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 2);
					glassSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 2);
					glassSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 2);
					glassSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 2);
					glassSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 1, 2);
					glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 1, 2);
					glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 1, 2);
					glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 1, 2);
					glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 1);
				}

				break;
			case 30: // ���� 30
				// ���������� ������.
				if (isMyPokemon == true)
				{
					glassSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 2, 3);
					glassSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 2, 3);
					glassSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 2, 3);
					glassSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 2, 3);
					glassSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 2);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[2]);
				}
				else
				{
					glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 3);
					glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 3);
					glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 3);
					glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 3);
					glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
				}

				break;
			case 40: // ���� 40
				// �ֶ���� ������.
				if (isMyPokemon == true)
				{
					glassSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 3, 4);
					glassSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 3, 4);
					glassSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 3, 4);
					glassSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 3, 4);
					glassSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 3);
					System.out.printf("���ο� ��ų %s��(��) ������! \n\n", ShareData.myPokemon.pokemonSkill.skillName[3]);
				}
				else
				{
					glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 4);
					glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 4);
					glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 4);
					glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 4);
					glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
				}

				break;
			default:
				break;
		}
	}
}

//2�� ����� ���� Ǯ�Ӽ� ���ϸ��� �̻��ؾ�
//Bulbasaur: �̻��ؾ��� ������
class Bulbasaur extends GrassElementPokemon
{
	/**************************************************
	 
	setBasicPokemonStatus
	�Է�: ������ ���� �� ���ϸ� ����
	���: �̻��ؾ� ������ ������ �� ���ϸ��� ����
	
	�̻��ؾ��� �����ϰ� �ʱ� �ɷ�ġ�� �����Ѵ�.

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
			
			ShareData.myPokemon.pokemonStatus[4] = 2; 		// ���ϸ� Ÿ��(Ǯ�Ӽ�)
			ShareData.myPokemon.pokemonStatus[5] = 10; 		// ���ϸ��� ���� ü��
			
			// ���̸��� ó�� ������ �ִ� ��ų ����
			// ��ų��
			ShareData.myPokemon.pokemonSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 0, 1);
			glassSkill.setSkillName (ShareData.myPokemon.pokemonSkill.skillName, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillName[2] = "�̽���";
			ShareData.myPokemon.pokemonSkill.skillName[3] = "�̽���";
			
			// ��ų ����
			ShareData.myPokemon.pokemonSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 0, 1);
			glassSkill.setSkillDamage (ShareData.myPokemon.pokemonSkill.skillDamage, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillDamage[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillDamage[3] = 0;
			
			// ��ų ���߷�
			ShareData.myPokemon.pokemonSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 0, 0);
			glassSkill.setSkillAccuracy (ShareData.myPokemon.pokemonSkill.skillAccuracy, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillAccuracy[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillAccuracy[3] = 0;
			
			// ��ų Ƚ��
			ShareData.myPokemon.pokemonSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 0, 0);
			glassSkill.setSkillCount (ShareData.myPokemon.pokemonSkill.skillCount, 1, 0);
			ShareData.myPokemon.pokemonSkill.skillCount[2] = 0;
			ShareData.myPokemon.pokemonSkill.skillCount[3] = 0;
			
			// ��ų �Ӽ�
			ShareData.myPokemon.pokemonSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 0);
			glassSkill.setSkillType (ShareData.myPokemon.pokemonSkill.skillType, 1);
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
			
			ShareData.rivalPokemon.pokemonStatus[4] = 2; 	// ���ϸ� Ÿ��(Ǯ�Ӽ�)
			ShareData.rivalPokemon.pokemonStatus[5] = 10; 	// ���ϸ��� ���� ü��
			
			// ���̸��� ó�� ������ �ִ� ��ų ����
			// ��ų��
			ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 0, 1);
			glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 2, 1);
			glassSkill.setSkillName (ShareData.rivalPokemon.pokemonSkill.skillName, 3, 0);
			
			// ��ų ����
			ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 0, 1);
			glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 2, 1);
			glassSkill.setSkillDamage (ShareData.rivalPokemon.pokemonSkill.skillDamage, 3, 0);
			
			// ��ų ���߷�
			ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 0, 1);
			glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 2, 1);
			glassSkill.setSkillAccuracy (ShareData.rivalPokemon.pokemonSkill.skillAccuracy, 3, 0);
			
			// ��ų Ƚ��
			ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 0, 1);
			glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 1, 0);
			ShareData.rivalPokemon.pokemonSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 2, 1);
			glassSkill.setSkillCount (ShareData.rivalPokemon.pokemonSkill.skillCount, 3, 0);
			
			// ��ų �Ӽ�
			ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 0);
			glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 1);
			ShareData.rivalPokemon.pokemonSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 2);
			glassSkill.setSkillType (ShareData.rivalPokemon.pokemonSkill.skillType, 3);
			
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
	�̻��ؾ� -> �̻���Ǯ -> �̻��ز�

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
			case 16: // ������ 16�� �Ǹ� �̻���Ǯ�� ��ȭ
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonName = "�̻���Ǯ";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.myPokemon.pokemonStatus[0] += 11;	// HealthPoint
					ShareData.myPokemon.pokemonStatus[1] += 5;	// Attack
					ShareData.myPokemon.pokemonStatus[2] += 6;	// Defense
					ShareData.myPokemon.pokemonStatus[3] += 5;	// Speed

					ShareData.myPokemon.pokemonStatus[5] += 11; 	// ���ϸ��� ���� ü��
					
					System.out.printf("�̻��ؾ��� �̻���Ǯ�� ��ȭ�ߴ�.!!\n\n");
				}
				else
				{
					ShareData.rivalPokemon.pokemonName = "�̻���Ǯ";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.rivalPokemon.pokemonStatus[0] += 11;	// HealthPoint
					ShareData.rivalPokemon.pokemonStatus[1] += 5;		// Attack
					ShareData.rivalPokemon.pokemonStatus[2] += 6;		// Defense
					ShareData.rivalPokemon.pokemonStatus[3] += 5;		// Speed

					ShareData.rivalPokemon.pokemonStatus[5] += 12; 	// ���ϸ��� ���� ü��
				}

				break;
			case 36: // ������ 36�� �Ǹ� �̻��ز����� ��ȭ
				if (isMyPokemon == true)
				{
					ShareData.myPokemon.pokemonName = "�̻��ز�";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.myPokemon.pokemonStatus[0] += 15;	// HealthPoint
					ShareData.myPokemon.pokemonStatus[1] += 7;	// Attack
					ShareData.myPokemon.pokemonStatus[2] += 10;	// Defense
					ShareData.myPokemon.pokemonStatus[3] += 6;	// Speed

					ShareData.myPokemon.pokemonStatus[5] += 15; 	// ���ϸ��� ���� ü��
					
					System.out.printf("�̻���Ǯ�� �̻��ز����� ��ȭ�ߴ�.!!\n\n");
				}
				else
				{
					ShareData.rivalPokemon.pokemonName = "�̻��ز�";
					// ��ȭ�� ���� �⺻ �ɷ�ġ ���
					ShareData.rivalPokemon.pokemonStatus[0] += 15;	// HealthPoint
					ShareData.rivalPokemon.pokemonStatus[1] += 7;		// Attack
					ShareData.rivalPokemon.pokemonStatus[2] += 10;	// Defense
					ShareData.rivalPokemon.pokemonStatus[3] += 6;		// Speed

					ShareData.rivalPokemon.pokemonStatus[5] += 15; 	// ���ϸ��� ���� ü��
				}

				break;
			default:
				break;
		}
	}
}

//End of File
