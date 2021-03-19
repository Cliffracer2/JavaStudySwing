/**************************************************
 
�� ���ϸ� Ŭ����

**************************************************/

package pokemon;

import java.util.Random;

public class EnemyPokemon extends Pokemon
{	
	int giveExp; 					// �� ���ϸ��� ���� �ִ� ����ġ ��
	boolean rivalPokemon = false;	// �� ���ϸ��� ���̹� ���ϸ��ΰ�
	
	/**************************************************
	 
	appearWildPokemon
	�Է�: �� ���ϸ��� ����, ���� ���ϸ� ����
	���: �� �߻� ���ϸ��� ����
	
	�߻� ���ϸ��� ������ �˷��ش�.
	�÷��̾��� ������ ���� �����ϴ� ���ϸ� ������ ������ �޶�����.

	**************************************************/
	public void appearWildPokemon (EnemyPokemon enemyPokemon, int pokemonLevel)
	{
		// �� ���ϸ� Ŭ������ ��ӹ��� �߻� ���ϸ� Ŭ����
		WildPokemon wildPokemon = new WildPokemon();
		// �������ڸ� ��� ���� ���� Ŭ����
		Random random = new Random();
		int randomNumber = -1;	// ��ų ��ȣ ����
		
		// �� ���ϸ��� �������� �����ϱ� ���� ��ȣ ��
		randomNumber = random.nextInt(2);
		
		// �÷��̾� ���ϸ� ������ 1 ~ 10�̸� ����, ������ ����
		if (pokemonLevel <= 10)
		{
			// ���� ���� 0�� ������ ���� ����
			if (randomNumber == 0)
			{
				wildPokemon.getRattataInfo (enemyPokemon, pokemonLevel);
			}
			else // ���� ���� 1�̸� ���� ����
			{
				wildPokemon.getPidgeyInfo (enemyPokemon, pokemonLevel);
			}
		}
		// �÷��̾� ���ϸ� ������ 10 ~ 20�̸� �̺���, �Ŀ��� ����
		else if ((pokemonLevel >= 11) && (pokemonLevel <= 20))
		{
			// ���� ���� 0�� ������ �̺��� ����
			if (randomNumber == 0)
			{
				wildPokemon.getEeveeInfo (enemyPokemon, pokemonLevel);
			}
			else // ���� ���� 1�̸� �Ŀ��� ����
			{
				wildPokemon.getFarfetchInfo (enemyPokemon, pokemonLevel);
			}
		}
		// �÷��̾� ���ϸ� ������ 20 ~ 30�̸� ��Ű, ��Ʈ�� ����
		else if ((pokemonLevel >= 21) && (pokemonLevel <= 30))
		{
			// ���� ���� 0�� ������ ��Ű ����
			if (randomNumber == 0)
			{
				wildPokemon.getChanseyInfo (enemyPokemon, pokemonLevel);
			}
			else // ���� ���� 1�̸� ��Ʈ�� ����
			{
				wildPokemon.getRaticateInfo (enemyPokemon, pokemonLevel);
			}
		}
		// ���� 30�̻��̸� Ļī, �Ḹ�� ����
		else
		{
			// ���� ���� 0�� ������ Ļī ����
			if (randomNumber == 0)
			{
				wildPokemon.getSnorlaxInfo (enemyPokemon, pokemonLevel);
			}
			else // ���� ���� 1�̸� �Ḹ�� ����
			{
				wildPokemon.getKangaskhanInfo (enemyPokemon, pokemonLevel);
			}
		}
		
		System.out.printf("�߻��� %s��(��) ��Ÿ����!\n", enemyPokemon.pokemonName);
		
		// ���� ��ų Ƚ�� ����
		enemyPokemon.pokemonSkill.currentSkillCount[0] = enemyPokemon.pokemonSkill.skillCount[0];
		enemyPokemon.pokemonSkill.currentSkillCount[1] = enemyPokemon.pokemonSkill.skillCount[1];
		enemyPokemon.pokemonSkill.currentSkillCount[2] = enemyPokemon.pokemonSkill.skillCount[2];
		enemyPokemon.pokemonSkill.currentSkillCount[3] = enemyPokemon.pokemonSkill.skillCount[3];
		
		// �����̻� ����
		enemyPokemon.pokemonCondition = "����";
	}
	
	/**************************************************
	 
	bringRivalPokemon
	�Է�: ���̹� ���ϸ� ����, �� ���ϸ��� ����
	���: �� ���ϸ��� ������ ��� ���̹� ���ϸ� ����
	
	���̹� ���ϸ�� ��Ʋ�� �ϱ� ����
	���̹� ���ϸ��� ������ �����ͼ� �� ���ϸ� ������ �����Ѵ�.

	**************************************************/
	public void bringRivalPokemon (RivalPokemon rivalPokemon, EnemyPokemon enemyPokemon)
	{
		pokemonSkill.setSkill();
		
		enemyPokemon.rivalPokemon = true;
		enemyPokemon.pokemonLevel = rivalPokemon.pokemonLevel;
		enemyPokemon.pokemonName = rivalPokemon.pokemonName;
		enemyPokemon.pokemonCondition = rivalPokemon.pokemonCondition;
		
		enemyPokemon.pokemonStatus[0] = rivalPokemon.pokemonStatus[0];	// HealthPoint
		enemyPokemon.pokemonStatus[1] = rivalPokemon.pokemonStatus[1];	// Attack
		enemyPokemon.pokemonStatus[2] = rivalPokemon.pokemonStatus[2];	// Defense
		enemyPokemon.pokemonStatus[3] = rivalPokemon.pokemonStatus[3];	// Speed
		
		enemyPokemon.pokemonStatus[4] = rivalPokemon.pokemonStatus[4]; 	// ���ϸ� Ÿ��
		enemyPokemon.pokemonStatus[5] = rivalPokemon.pokemonStatus[5];	// ���� HP
		
		enemyPokemon.giveExp = 100 + (rivalPokemon.pokemonLevel * 2);
		
		
		
		// �Ḹ���� ��ų ����
		// 1. �ް�����ġ    2. ����   3. ������   4. �Ⱑ����Ʈ
		// ��ų��
		enemyPokemon.pokemonSkill.skillName[0] = rivalPokemon.pokemonSkill.skillName[0];
		enemyPokemon.pokemonSkill.skillName[1] = rivalPokemon.pokemonSkill.skillName[1];
		enemyPokemon.pokemonSkill.skillName[2] = rivalPokemon.pokemonSkill.skillName[2];
		enemyPokemon.pokemonSkill.skillName[3] = rivalPokemon.pokemonSkill.skillName[3];
		
		// ��ų ����
		enemyPokemon.pokemonSkill.skillDamage[0] = rivalPokemon.pokemonSkill.skillDamage[0];
		enemyPokemon.pokemonSkill.skillDamage[1] = rivalPokemon.pokemonSkill.skillDamage[1];
		enemyPokemon.pokemonSkill.skillDamage[2] = rivalPokemon.pokemonSkill.skillDamage[2];
		enemyPokemon.pokemonSkill.skillDamage[3] = rivalPokemon.pokemonSkill.skillDamage[3];
		
		// ��ų ���߷�
		enemyPokemon.pokemonSkill.skillAccuracy[0] = rivalPokemon.pokemonSkill.skillAccuracy[0];
		enemyPokemon.pokemonSkill.skillAccuracy[1] = rivalPokemon.pokemonSkill.skillAccuracy[1];
		enemyPokemon.pokemonSkill.skillAccuracy[2] = rivalPokemon.pokemonSkill.skillAccuracy[2];
		enemyPokemon.pokemonSkill.skillAccuracy[3] = rivalPokemon.pokemonSkill.skillAccuracy[3];
		
		// ��ų Ƚ��
		enemyPokemon.pokemonSkill.skillCount[0] = rivalPokemon.pokemonSkill.skillCount[0];
		enemyPokemon.pokemonSkill.skillCount[1] = rivalPokemon.pokemonSkill.skillCount[1];
		enemyPokemon.pokemonSkill.skillCount[2] = rivalPokemon.pokemonSkill.skillCount[2];
		enemyPokemon.pokemonSkill.skillCount[3] = rivalPokemon.pokemonSkill.skillCount[3];
		
		// ��ų �Ӽ�
		enemyPokemon.pokemonSkill.skillType[0] = rivalPokemon.pokemonSkill.skillType[0];
		enemyPokemon.pokemonSkill.skillType[1] = rivalPokemon.pokemonSkill.skillType[1];
		enemyPokemon.pokemonSkill.skillType[2] = rivalPokemon.pokemonSkill.skillType[2];
		enemyPokemon.pokemonSkill.skillType[3] = rivalPokemon.pokemonSkill.skillType[3];
	}
	
	/**************************************************
	 
	bringRivalPokemon
	�Է�: ���̹� ���ϸ� ����, �����忡�� ������ ���̹� ��� �ɷ�ġ
	���: �� ���ϸ��� ������ ��� ���̹� ���ϸ� ����
	
	���̹� ���ϸ�� ��Ʋ�� �ϱ� ����
	���̹� ���ϸ��� ������ �����ͼ� �� ���ϸ� ������ �����Ѵ�.

	**************************************************/
	public void bringRivalPokemon (RivalPokemon rivalPokemon)
	{
		pokemonSkill.setSkill();

		rivalPokemon.pokemonName = ShareData.pokemon.pokemonName;
		rivalPokemon.pokemonLevel = ShareData.pokemon.pokemonLevel;
		
		rivalPokemon.pokemonStatus[0] = ShareData.pokemon.pokemonStatus[0];	// HealthPoint
		rivalPokemon.pokemonStatus[1] = ShareData.pokemon.pokemonStatus[1];	// Attack
		rivalPokemon.pokemonStatus[2] = ShareData.pokemon.pokemonStatus[2];	// Defense
		rivalPokemon.pokemonStatus[3] = ShareData.pokemon.pokemonStatus[3];	// Speed
		
		rivalPokemon.pokemonStatus[4] = ShareData.pokemon.pokemonStatus[4]; 	// ���ϸ� Ÿ��
		rivalPokemon.pokemonStatus[5] = ShareData.pokemon.pokemonStatus[5];	// ���� HP
		
		rivalPokemon.giveExp = 100 + (ShareData.pokemon.pokemonLevel * 2);
		
		
		
		// �Ḹ���� ��ų ����
		// 1. �ް�����ġ    2. ����   3. ������   4. �Ⱑ����Ʈ
		// ��ų��
		rivalPokemon.pokemonSkill.skillName[0] = ShareData.pokemon.pokemonSkill.skillName[0];
		rivalPokemon.pokemonSkill.skillName[1] = ShareData.pokemon.pokemonSkill.skillName[1];
		rivalPokemon.pokemonSkill.skillName[2] = ShareData.pokemon.pokemonSkill.skillName[2];
		rivalPokemon.pokemonSkill.skillName[3] = ShareData.pokemon.pokemonSkill.skillName[3];
		
		// ��ų ����
		rivalPokemon.pokemonSkill.skillDamage[0] = ShareData.pokemon.pokemonSkill.skillDamage[0];
		rivalPokemon.pokemonSkill.skillDamage[1] = ShareData.pokemon.pokemonSkill.skillDamage[1];
		rivalPokemon.pokemonSkill.skillDamage[2] = ShareData.pokemon.pokemonSkill.skillDamage[2];
		rivalPokemon.pokemonSkill.skillDamage[3] = ShareData.pokemon.pokemonSkill.skillDamage[3];
		
		// ��ų ���߷�
		rivalPokemon.pokemonSkill.skillAccuracy[0] = ShareData.pokemon.pokemonSkill.skillAccuracy[0];
		rivalPokemon.pokemonSkill.skillAccuracy[1] = ShareData.pokemon.pokemonSkill.skillAccuracy[1];
		rivalPokemon.pokemonSkill.skillAccuracy[2] = ShareData.pokemon.pokemonSkill.skillAccuracy[2];
		rivalPokemon.pokemonSkill.skillAccuracy[3] = ShareData.pokemon.pokemonSkill.skillAccuracy[3];
		
		// ��ų Ƚ��
		rivalPokemon.pokemonSkill.skillCount[0] = ShareData.pokemon.pokemonSkill.skillCount[0];
		rivalPokemon.pokemonSkill.skillCount[1] = ShareData.pokemon.pokemonSkill.skillCount[1];
		rivalPokemon.pokemonSkill.skillCount[2] = ShareData.pokemon.pokemonSkill.skillCount[2];
		rivalPokemon.pokemonSkill.skillCount[3] = ShareData.pokemon.pokemonSkill.skillCount[3];
		
		rivalPokemon.pokemonSkill.currentSkillCount[0] = ShareData.pokemon.pokemonSkill.currentSkillCount[0];
		rivalPokemon.pokemonSkill.currentSkillCount[1] = ShareData.pokemon.pokemonSkill.currentSkillCount[1];
		rivalPokemon.pokemonSkill.currentSkillCount[2] = ShareData.pokemon.pokemonSkill.currentSkillCount[2];
		rivalPokemon.pokemonSkill.currentSkillCount[3] = ShareData.pokemon.pokemonSkill.currentSkillCount[3];
		
		// ��ų �Ӽ�
		rivalPokemon.pokemonSkill.skillType[0] = ShareData.pokemon.pokemonSkill.skillType[0];
		rivalPokemon.pokemonSkill.skillType[1] = ShareData.pokemon.pokemonSkill.skillType[1];
		rivalPokemon.pokemonSkill.skillType[2] = ShareData.pokemon.pokemonSkill.skillType[2];
		rivalPokemon.pokemonSkill.skillType[3] = ShareData.pokemon.pokemonSkill.skillType[3];
	}
	
}

//�߻� ���ϸ� Ŭ����
class WildPokemon extends EnemyPokemon
{
	// ���� ���� ��� ���� ���� ����
	Random randomLevel = new Random();
	int calculateLevel = 1;
	
	/**************************************************
	 
	getRattataInfo
	�Է�: �� ���ϸ� ����, �ڽ��� ���ϸ� ����
	���: ���� ������ ����� �� ���ϸ��� ����
	
	Rattata: ������ ������
	�߻��� ������ ������ ��´�.

	**************************************************/
	public void getRattataInfo (EnemyPokemon enemyPokemon, int level)
	{	
		pokemonSkill.setSkill();
		
		// �߻� ���ϸ��� ������ ���
		calculateLevel = randomLevel.nextInt(level) + 1;
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "����";
				
		// 1 ~ 5������ ����
		if (level == 1)
		{
			// ���� 1�� �⺻ �ɷ�ġ ����
			enemyPokemon.pokemonStatus[0] = 7;	// HealthPoint
			enemyPokemon.pokemonStatus[1] = 4;	// Attack
			enemyPokemon.pokemonStatus[2] = 3;	// Defense
			enemyPokemon.pokemonStatus[3] = 4;	// Speed
			
			enemyPokemon.pokemonStatus[4] = 0; 	// ���ϸ� Ÿ��(���Ӽ�)
			enemyPokemon.pokemonStatus[5] = 7; 	// ���ϸ��� ���� ü��
			
			enemyPokemon.giveExp = 6;
		}
		else
		{
			enemyPokemon.pokemonStatus[0] = 7 + calculateLevel;
			enemyPokemon.pokemonStatus[1] = 4 + calculateLevel;
			enemyPokemon.pokemonStatus[2] = 3 + calculateLevel;
			enemyPokemon.pokemonStatus[3] = 4 + calculateLevel;
			
			enemyPokemon.pokemonStatus[4] = 0; 	// ���ϸ� Ÿ��(���Ӽ�)
			enemyPokemon.pokemonStatus[5] = 7 + calculateLevel;
			
			enemyPokemon.giveExp = 6 + (calculateLevel * 2);
		}
		
		// ������ ��ų ����
		// ��ų��
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(1);
		
		// ��ų ����
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(1);
		
		// ��ų ���߷�
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(1);
		
		// ��ų Ƚ��
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(1);
		
		// ��ų �Ӽ�
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getPidgeyInfo
	�Է�: �� ���ϸ� ����, �ڽ��� ���ϸ� ����
	���: ���� ������ ����� �� ���ϸ��� ����
	
	Pidgey: ������ ������
	�߻��� ������ ������ ��´�.

	**************************************************/
	public void getPidgeyInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// �߻� ���ϸ��� ������ ���
		calculateLevel = randomLevel.nextInt(level) + 1;
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "����";
				
		// 1 ~ 5������ ����
		if (level == 1)
		{
			// ���� 1�� �⺻ �ɷ�ġ ����
			enemyPokemon.pokemonStatus[0] = 7;	// HealthPoint
			enemyPokemon.pokemonStatus[1] = 3;	// Attack
			enemyPokemon.pokemonStatus[2] = 2;	// Defense
			enemyPokemon.pokemonStatus[3] = 7;	// Speed
			
			enemyPokemon.pokemonStatus[4] = 0; 	// ���ϸ� Ÿ��(���Ӽ�)
			enemyPokemon.pokemonStatus[5] = 7; 	// ���ϸ��� ���� ü��
			
			enemyPokemon.giveExp = 5;
		}
		else
		{
			enemyPokemon.pokemonStatus[0] = 7 + calculateLevel;
			enemyPokemon.pokemonStatus[1] = 3 + calculateLevel;
			enemyPokemon.pokemonStatus[2] = 2 + calculateLevel;
			enemyPokemon.pokemonStatus[3] = 7 + calculateLevel;
			
			enemyPokemon.pokemonStatus[4] = 0; 	// ���ϸ� Ÿ��(���Ӽ�)
			enemyPokemon.pokemonStatus[5] = 7 + calculateLevel;
			
			enemyPokemon.giveExp = 5 + (calculateLevel * 2);
		}
		
		// ������ ��ų ����
		// ��ų��
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(1);
		
		// ��ų ����
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(1);
		
		// ��ų ���߷�
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(1);
		
		// ��ų Ƚ��
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(1);
		
		// ��ų �Ӽ�
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getEeveeInfo
	�Է�: �� ���ϸ� ����, �ڽ��� ���ϸ� ����
	���: �̺��� ������ ����� �� ���ϸ��� ����
	
	Eevee: �̺����� ������
	�߻��� �̺��� ������ ��´�.

	**************************************************/
	public void getEeveeInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// �߻� ���ϸ��� ������ ���
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// ���� �ּ�ġ ����
		if (calculateLevel < 10)
		{
			calculateLevel += 10;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "�̺���";
		
		enemyPokemon.pokemonStatus[0] = 10 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 7 + calculateLevel;		// Attack
		enemyPokemon.pokemonStatus[2] = 4 + calculateLevel;		// Defense
		enemyPokemon.pokemonStatus[3] = 7 + calculateLevel;		// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// ���ϸ� Ÿ��(���Ӽ�)
		enemyPokemon.pokemonStatus[5] = 10 + calculateLevel;	// ���ϸ��� ���� ü��
		
		enemyPokemon.giveExp = 7 + (calculateLevel * 2);
		
		// ������ ��ų ����
		// ��ų��
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(2);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(3);
		
		// ��ų ����
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(2);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(3);
		
		// ��ų ���߷�
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(2);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(3);
		
		// ��ų Ƚ��
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(2);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(3);
		
		// ��ų �Ӽ�
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getFarfetchInfo
	�Է�: �� ���ϸ� ����, �ڽ��� ���ϸ� ����
	���: �Ŀ��� ������ ����� �� ���ϸ��� ����
	
	Farfetch'd: �Ŀ����� ������
	�߻��� �Ŀ��� ������ ��´�.

	**************************************************/
	public void getFarfetchInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// �߻� ���ϸ��� ������ ���
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// ���� �ּ�ġ ����
		if (calculateLevel < 10)
		{
			calculateLevel += 10;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "�Ŀ���";
		
		enemyPokemon.pokemonStatus[0] = 12 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 8 + calculateLevel;		// Attack
		enemyPokemon.pokemonStatus[2] = 5 + calculateLevel;		// Defense
		enemyPokemon.pokemonStatus[3] = 8 + calculateLevel;		// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// ���ϸ� Ÿ��(���Ӽ�)
		enemyPokemon.pokemonStatus[5] = 12 + calculateLevel;	// ���ϸ��� ���� ü��
		
		enemyPokemon.giveExp = 8 + (calculateLevel * 2);
		
		// ������ ��ų ����
		// ��ų��
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(2);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(3);
		
		// ��ų ����
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(2);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(3);
		
		// ��ų ���߷�
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(2);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(3);
		
		// ��ų Ƚ��
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(2);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(3);
		
		// ��ų �Ӽ�
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getChanseyInfo
	�Է�: �� ���ϸ� ����, �ڽ��� ���ϸ� ����
	���: ��Ű ������ ����� �� ���ϸ��� ����
	
	Chansey: ��Ű�� ������
	�߻��� ��Ű ������ ��´�.

	**************************************************/
	public void getChanseyInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// �߻� ���ϸ��� ������ ���
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// ���� �ּ�ġ ����
		if (calculateLevel < 20)
		{
			calculateLevel += 20;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "��Ű";
		
		enemyPokemon.pokemonStatus[0] = 16 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 8 + calculateLevel;		// Attack
		enemyPokemon.pokemonStatus[2] = 10 + calculateLevel;	// Defense
		enemyPokemon.pokemonStatus[3] = 7 + calculateLevel;		// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// ���ϸ� Ÿ��(���Ӽ�)
		enemyPokemon.pokemonStatus[5] = 16 + calculateLevel;	// ���ϸ��� ���� ü��
		
		enemyPokemon.giveExp = 12 + (calculateLevel * 2);
		
		// ������ ��ų ����
		// ��ų��
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(2);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(3);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(4);
		
		// ��ų ����
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(2);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(3);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(4);
		
		// ��ų ���߷�
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(2);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(3);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(4);
		
		// ��ų Ƚ��
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(2);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(3);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(4);
		
		// ��ų �Ӽ�
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getRaticateInfo
	�Է�: �� ���ϸ� ����, �ڽ��� ���ϸ� ����
	���: ��Ʈ�� ������ ����� �� ���ϸ��� ����
	
	Raticate: ��Ʈ���� ������
	�߻��� ��Ʈ�� ������ ��´�.

	**************************************************/
	public void getRaticateInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// �߻� ���ϸ��� ������ ���
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// ���� �ּ�ġ ����
		if (calculateLevel < 20)
		{
			calculateLevel += 20;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "��Ʈ��";
		
		enemyPokemon.pokemonStatus[0] = 14 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 10 + calculateLevel;	// Attack
		enemyPokemon.pokemonStatus[2] = 7 + calculateLevel;		// Defense
		enemyPokemon.pokemonStatus[3] = 10 + calculateLevel;	// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// ���ϸ� Ÿ��(���Ӽ�)
		enemyPokemon.pokemonStatus[5] = 14 + calculateLevel;	// ���ϸ��� ���� ü��
		
		enemyPokemon.giveExp = 10 + (calculateLevel * 2);
		
		// ��Ʈ���� ��ų ����
		// ��ų��
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(1);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(2);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(3);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(4);
		
		// ��ų ����
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(1);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(2);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(3);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(4);
		
		// ��ų ���߷�
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(1);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(2);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(3);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(4);
		
		// ��ų Ƚ��
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(1);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(2);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(3);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(4);
		
		// ��ų �Ӽ�
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getSnorlaxInfo
	�Է�: �� ���ϸ� ����, �ڽ��� ���ϸ� ����
	���: �Ḹ�� ������ ����� �� ���ϸ��� ����
	
	Snorlax: �Ḹ���� ������
	�߻��� �Ḹ�� ������ ��´�.

	**************************************************/
	public void getSnorlaxInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// �߻� ���ϸ��� ������ ���
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// ���� �ּ�ġ ����
		if (calculateLevel < 30)
		{
			calculateLevel += 30;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "�Ḹ��";
		
		enemyPokemon.pokemonStatus[0] = 22 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 12 + calculateLevel;	// Attack
		enemyPokemon.pokemonStatus[2] = 20 + calculateLevel;	// Defense
		enemyPokemon.pokemonStatus[3] = 10 + calculateLevel;	// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// ���ϸ� Ÿ��(���Ӽ�)
		enemyPokemon.pokemonStatus[5] = 22 + calculateLevel;	// ���ϸ��� ���� ü��
		
		enemyPokemon.giveExp = 20 + (calculateLevel * 2);
		
		// �Ḹ���� ��ų ����
		// 1. �ް�����ġ    2. ����   3. ������   4. �Ⱑ����Ʈ
		// ��ų��
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(3);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(5);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(6);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(7);
		
		// ��ų ����
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(3);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(5);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(6);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(7);
		
		// ��ų ���߷�
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(3);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(5);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(6);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(7);
		
		// ��ų Ƚ��
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(3);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(5);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(6);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(7);
		
		// ��ų �Ӽ�
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
	
	/**************************************************
	 
	getKangaskhanInfo
	�Է�: �� ���ϸ� ����, �ڽ��� ���ϸ� ����
	���: Ļī ������ ����� �� ���ϸ��� ����
	
	Kangaskhan: Ļī�� ������
	�߻��� Ļī ������ ��´�.

	**************************************************/
	public void getKangaskhanInfo (EnemyPokemon enemyPokemon, int level)
	{
		pokemonSkill.setSkill();
		
		// �߻� ���ϸ��� ������ ���
		calculateLevel = randomLevel.nextInt(level) + 1;
		
		// ���� �ּ�ġ ����
		if (calculateLevel < 30)
		{
			calculateLevel += 30;
		}
		
		enemyPokemon.pokemonLevel = calculateLevel;
		enemyPokemon.pokemonName = "Ļī";
		
		enemyPokemon.pokemonStatus[0] = 20 + calculateLevel;	// HealthPoint
		enemyPokemon.pokemonStatus[1] = 15 + calculateLevel;	// Attack
		enemyPokemon.pokemonStatus[2] = 12 + calculateLevel;	// Defense
		enemyPokemon.pokemonStatus[3] = 15 + calculateLevel;	// Speed
		
		enemyPokemon.pokemonStatus[4] = 0; 	// ���ϸ� Ÿ��(���Ӽ�)
		enemyPokemon.pokemonStatus[5] = 20 + calculateLevel;	// ���ϸ��� ���� ü��
		
		enemyPokemon.giveExp = 15 + (calculateLevel * 2);
		
		// Ļī�� ��ų ����
		// 1. �����ġ��    2. ����   3. ����   4. ���ǻ�����Ŭ
		// ��ų��
		enemyPokemon.pokemonSkill.skillName[0] = pokemonSkill.skillNameList.get(0);
		enemyPokemon.pokemonSkill.skillName[1] = pokemonSkill.skillNameList.get(4);
		enemyPokemon.pokemonSkill.skillName[2] = pokemonSkill.skillNameList.get(5);
		enemyPokemon.pokemonSkill.skillName[3] = pokemonSkill.skillNameList.get(8);
		
		// ��ų ����
		enemyPokemon.pokemonSkill.skillDamage[0] = pokemonSkill.skillDamageList.get(0);
		enemyPokemon.pokemonSkill.skillDamage[1] = pokemonSkill.skillDamageList.get(4);
		enemyPokemon.pokemonSkill.skillDamage[2] = pokemonSkill.skillDamageList.get(5);
		enemyPokemon.pokemonSkill.skillDamage[3] = pokemonSkill.skillDamageList.get(8);
		
		// ��ų ���߷�
		enemyPokemon.pokemonSkill.skillAccuracy[0] = pokemonSkill.skillAccuracyList.get(0);
		enemyPokemon.pokemonSkill.skillAccuracy[1] = pokemonSkill.skillAccuracyList.get(4);
		enemyPokemon.pokemonSkill.skillAccuracy[2] = pokemonSkill.skillAccuracyList.get(5);
		enemyPokemon.pokemonSkill.skillAccuracy[3] = pokemonSkill.skillAccuracyList.get(8);
		
		// ��ų Ƚ��
		enemyPokemon.pokemonSkill.skillCount[0] = pokemonSkill.skillCountList.get(0);
		enemyPokemon.pokemonSkill.skillCount[1] = pokemonSkill.skillCountList.get(4);
		enemyPokemon.pokemonSkill.skillCount[2] = pokemonSkill.skillCountList.get(5);
		enemyPokemon.pokemonSkill.skillCount[3] = pokemonSkill.skillCountList.get(8);
		
		// ��ų �Ӽ�
		enemyPokemon.pokemonSkill.skillType[0] = 0;
		enemyPokemon.pokemonSkill.skillType[1] = 0;
		enemyPokemon.pokemonSkill.skillType[2] = 0;
		enemyPokemon.pokemonSkill.skillType[3] = 0;
	}
}

// End of File
