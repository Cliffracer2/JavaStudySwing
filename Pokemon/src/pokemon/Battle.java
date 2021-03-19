/**************************************************
 
��Ʋ Ŭ����

**************************************************/

package pokemon;

import java.util.InputMismatchException;
import java.util.Random;

public class Battle implements Runnable 
{
	int getExp = 0;			// ��Ʋ �¸��� ȹ���ϴ� ����ġ
	boolean isMyTurn;		// �÷��̾� ������ �Ǵ�
	int selectNumber;		// ��Ʋ �޴����� ������ ��ȣ
	
	public Battle ()
	{
		
	}
	
	/**************************************************
	
	pokemonBattleMenu
	�Է�: �� ���ϸ� ����, �� ���ϸ� ����
	���: �����ϸ� ����, �� ���ϸ� ����
	
	���ϸ� ��Ʋ �޴��� ǥ���ϰ� �����Ѵ�.
	1. �ο��.   2. ȸ���Ѵ�.   3. ��������.

	**************************************************/
	public void pokemonBattleMenu (MyPokemon myPokemon, EnemyPokemon enemyPokemon)
	{		
		int receiveNumber = -1;			// ���� ������ ��ȣ
		boolean isBattleOver = false;	// ��Ʋ ���Ῡ��
		
		// �÷��̾ �������� �ƴ��� �Ǵ�
		isMyTurn = this.checkPlayerFirstTurn (myPokemon.pokemonStatus[3], enemyPokemon.pokemonStatus[3]);
		
		// ��Ʋ�� ���������� �ݺ�
		while (isBattleOver == false)
		{
			// ���� ���ϸ�� ���� ���ϸ��� ������ ǥ��
			this.displayCurrentStatus (myPokemon, enemyPokemon);

			System.out.printf("************************************************************\n");
			System.out.printf("%s�� ������ �ұ�?\n", myPokemon.pokemonName);
			System.out.printf("1. �ο��.\n");
			System.out.printf("2. ȸ���Ѵ�.\n");
			System.out.printf("3. ��������.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("��ȣ ����: ");
			try // ���ڸ� �Է� �޴��� Ȯ��
			{
				receiveNumber = ShareData.battleInput.nextInt();
			}
			catch (InputMismatchException ErrorInput) // ���ڰ� �ƴ� ���ڸ� �Է� �� ��� ���� �޽��� ���
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			if ((receiveNumber <= 0) || (receiveNumber >= 4))
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			
			switch (receiveNumber)
			{
				case 1: // �ο��.
					// ���� ���� ����ó�� ���̱� ���� ����
					// ���� �ൿ �ϸ� ���� �ൿ�� ������ ������ �ൿ�Ѵ�.
					if (isMyTurn == true)
					{
						isBattleOver = this.pokemonBattle (myPokemon, enemyPokemon, isMyTurn);
						// ��Ʋ ���� ������ ����
						if (isBattleOver == true)
						{
							break;
						}
						else
						{
							isBattleOver = this.pokemonBattle (myPokemon, enemyPokemon, false);
							continue;
						}
					}
					else
					{
						isBattleOver = this.pokemonBattle (myPokemon, enemyPokemon, isMyTurn);
						// ��Ʋ ���� ������ ����
						if (isBattleOver == true)
						{
							break;
						}
						else
						{
							isBattleOver = this.pokemonBattle (myPokemon, enemyPokemon, true);
							continue;
						}
					}
				case 2:	// ȸ���Ѵ�.
					// �κ��� �ִ� �������� Ȯ���Ͽ� ����Ѵ�.
					this.recoveryPokemon(myPokemon);
					// ȸ���ϸ� ������ �����ϴ� �ൿ�� �Ѵ�.
					isBattleOver = this.pokemonBattle (myPokemon, enemyPokemon, false);
					continue;
				case 3:	// ��������.
					// ��Ʋ ����
					System.out.printf("������ �οﶧ�� �ƴѰ� ���� ��������.\n\n");
					System.out.printf("************************************************************\n");
					isBattleOver = true;
					break;
				default:
					break;
			}
		}
	}
	
	/**************************************************
	 
	pokemonBattle
	�Է�: �� ���ϸ� ����, �� ���ϸ� ����, �� ����
	���: �� ���ϸ� ����, �� ���ϸ� ����, �Ӽ���ġ ����, ��Ʋ ����
	
	���ϸ� ��Ʋ�� �����Ѵ�.
	������ �������� �����ϰ� ��ų�� ����Ͽ� ���濡�� ���ظ� ������.

	**************************************************/
	private boolean pokemonBattle (MyPokemon myPokemon, EnemyPokemon enemyPokemon, boolean myTurn)
	{
		// ���ϸ� Ŭ����
		Pokemon pokemon = new Pokemon();
		PokemonSkill pokemonSkill = new PokemonSkill();

		int useSkillNumber = -1; 	// ������ ��ų��ȣ
		int damageValue = -1;		// ���� ���ط�
		boolean battleOver = false;	// ��Ʋ ���Ῡ��
		boolean hitAttack = true;	// ���� ���߿���
		boolean canAttack = true;	// ���ϸ��� ������ �� �� �ִ� �����ΰ�
		
		// �÷��̾��� ��
		if (myTurn == true)
		{
			// �����̻� Ȯ�� 
			canAttack = this.checkAbnormalCondition (myPokemon, enemyPokemon, true);
			// ������ �� �� �ִ� ����
			if (canAttack == true)
			{
				System.out.printf("************************************************************\n");
				System.out.printf("�÷��̾� ����\n");
				// ��ų ���
				useSkillNumber = pokemonSkill.pokemonUsingSkill (myPokemon);
				// ���ط� ���
				damageValue = this.calculateRealDamage (myPokemon, enemyPokemon, useSkillNumber, true);
				// ���߿��� �Ǵ�
				hitAttack = this.checkHittingAttack (myPokemon.pokemonSkill.skillAccuracy[useSkillNumber], myPokemon.familiarity);
				
				if (hitAttack == true)
				{
					System.out.printf("���濡�� %d�� ���ظ� ������.\n", damageValue);
					System.out.printf("************************************************************\n\n");
					
					// ���Ӽ��� ������ �Ӽ������� �ϸ� �Ӽ��� �´� �����̻��� �ɾ����� �Ǵ��Ѵ�.
					this.checkAbnormalCondition(myPokemon, enemyPokemon, useSkillNumber, true);
					// ���� ü�� ���
					enemyPokemon.pokemonStatus[5] = enemyPokemon.pokemonStatus[5] - damageValue;
				}
				else
				{
					System.out.printf("������ ���߽�Ű�� ���ߴ�...\n");
					System.out.printf("************************************************************\n\n");
				}
				
				// ü���� 0���Ϸ� �������� ��Ʋ ����
				if (enemyPokemon.pokemonStatus[5] <= 0)
				{
					enemyPokemon.pokemonStatus[5] = 0;
					System.out.printf("%s��(��) ��������.\n\n", enemyPokemon.pokemonName);
					myPokemon.levelUpExp -= enemyPokemon.giveExp;
					
					// ������ ����ġ ����
					if (myPokemon.levelUpExp <= 0)
					{
						// �÷��̾�� ���� 100���� �����Ѵ�.
						if (myPokemon.pokemonLevel < 100)
						{
							myPokemon.pokemonLevel += 1;
							System.out.printf("������ �ö���!\n");
							System.out.printf("������ %d�� �Ǿ���!\n", myPokemon.pokemonLevel);
							pokemon.increasePokemonStatus(myPokemon.levelUpExp);
						}
						else
						{
							System.out.printf("����ġ %d��(��) �����.\n", enemyPokemon.giveExp);
							System.out.printf("���� ����ġ %d\n", myPokemon.levelUpExp);
						}
					}
					else
					{
						System.out.printf("����ġ %d��(��) �����.\n", enemyPokemon.giveExp);
						System.out.printf("���� ����ġ %d\n", myPokemon.levelUpExp);
					}
					
					// ��Ʋ�� �¸��ؼ� �������� ��´�.
					Player.currentMoney += 200;
					System.out.printf("������ %d��ŭ �����.\n", 200);
					System.out.printf("���� ������ %d\n", Player.currentMoney);
					
					// ��Ʋ �¸��� ģ�е� 5 ����
					myPokemon.familiarity += 5;
					battleOver = true;
					
					// �¸��� ���ϸ��� ���̹� ���ϸ�
					if (enemyPokemon.rivalPokemon == true)
					{
						Player.winToRival = true;
					}
				}
			}
			else // ���񶧹��� �ൿ�� ���� ���Ѵ�.
			{
				System.out.printf("���� ������ ������ �� ����!\n");
			}
		}
		else // ���� ��
		{
			// �����̻� Ȯ�� 
			canAttack = this.checkAbnormalCondition (myPokemon, enemyPokemon, false);
			// ������ �� �� �ִ� ����
			if (canAttack == true)
			{
				System.out.printf("************************************************************\n");
				System.out.printf("���� ����\n");
				// ��ų ���
				useSkillNumber = pokemonSkill.pokemonUsingSkill (enemyPokemon);
				// ���ط� ���
				damageValue = this.calculateRealDamage (myPokemon, enemyPokemon, useSkillNumber, false);
				// ���߿��� �Ǵ�
				hitAttack = this.checkHittingAttack (enemyPokemon.pokemonSkill.skillAccuracy[useSkillNumber], 0);
				
				if (hitAttack == true)
				{
					System.out.printf("��밡 %d�� ���ظ� �־���.\n", damageValue);
					System.out.printf("************************************************************\n\n");
					
					// ���Ӽ��� ������ �Ӽ������� �ϸ� �Ӽ��� �´� �����̻��� �ɾ����� �Ǵ��Ѵ�.
					this.checkAbnormalCondition(myPokemon, enemyPokemon, useSkillNumber, false);
					// ���� ü�� ���
					myPokemon.pokemonStatus[5] = myPokemon.pokemonStatus[5] - damageValue;
				}
				else
				{
					System.out.printf("����� ������ ���ߴ�! ���߾�! %s\n", myPokemon.pokemonName);
					System.out.printf("************************************************************\n\n");
				}
				
				// ü���� 0���Ϸ� �������� ��Ʋ ����
				if (myPokemon.pokemonStatus[5] <= 0)
				{
					myPokemon.pokemonStatus[5] = 0;
					System.out.printf("���� ���ϸ�%s��(��) ��������!!\n", myPokemon.pokemonName);
					System.out.printf("�� ���� ������ ����....\n");
					// ��Ʋ�� �й��ؼ� �������� �Ҵ´�.
					Player.currentMoney -= 100;
					System.out.printf("������ %d��ŭ �Ҿ���.\n", 100);
					System.out.printf("���� ������ %d\n", Player.currentMoney);
					
					// ��Ʋ �й�� ģ�е� 10����
					myPokemon.familiarity -= 10;
					
					// 0���� ���� ���̸� 0���� �ʱ�ȭ
					if (myPokemon.familiarity < 0)
					{
						myPokemon.familiarity = 0;
					}
					battleOver = true;
				}
			}
			else // ���񶧹��� �ൿ�� ���� ���Ѵ�.
			{
				System.out.printf("��밡 ���� ������ ������ �� ����!\n");
			}

		}
		
		return battleOver;
	}
		
	/**************************************************
	 
	displayCurrentStatus
	�Է�: ���� ���ϸ� ����, �� ���ϸ��� ����
	���: �ܼ� �޽���
	
	�ڽ��� ���ϸ�� �� ���ϸ��� ���� ���� ǥ��

	**************************************************/
	private void displayCurrentStatus (MyPokemon myPokemon, EnemyPokemon enemyPokemon)
	{
		System.out.printf("�� ���ϸ�\n");
		System.out.printf("Lv: %d    ����: %s\n", myPokemon.pokemonLevel, myPokemon.pokemonCondition);
		System.out.printf("%s HP: %d / %d \n\n", 
				myPokemon.pokemonName, 
				myPokemon.pokemonStatus[5], myPokemon.pokemonStatus[0]);
		
		if (enemyPokemon.rivalPokemon == true)
		{
			System.out.printf("���̹� ���ϸ�\n");
		}
		else
		{
			System.out.printf("�߻� ���ϸ�\n");
		}
		
		System.out.printf("Lv: %d    ����: %s\n", enemyPokemon.pokemonLevel, enemyPokemon.pokemonCondition);
		System.out.printf("%s HP: %d / %d \n\n", 
				enemyPokemon.pokemonName, 
				enemyPokemon.pokemonStatus[5], enemyPokemon.pokemonStatus[0]);
	}
		
	/**************************************************
	 
	calculateRealDamage
	�Է�: �� ���ϸ� ����, �� ���ϸ� ����, ����� ��ų ��ȣ, �÷��̾� �����ΰ�
	���: ���� ���ط�
	
	���ϸ� ���ݽ� ���� ���� ������� ����Ѵ�.
	���濡�� ���� ���ظ� ����Ͽ� �ش� ��ġ��ŭ ü���� ���� ��Ų��.

	**************************************************/
	private int calculateRealDamage (MyPokemon myPokemon, EnemyPokemon enemyPokemon, int skillNumber, boolean playerAttack)
	{	
		float applySynastry = -1;	// �� ���� ġ
		int calculateDamage = -1;	// ����� ����� ��
		boolean typeMatch;			// ���ϸ�� ��ų�� �Ӽ� ��ġ ����
		
		// ���� ���濡�� ���� ���ظ� ���
		if (playerAttack == true)
		{
			// ���ϸ��� �Ӽ��� ���ϸ� ��ų �Ӽ��� ��ġ
			if (myPokemon.pokemonStatus[4] == myPokemon.pokemonSkill.skillType[skillNumber])
			{
				typeMatch = true;
			}
			else
			{
				typeMatch = false;
			}
			
			// �⺻ ���ط� ���
			calculateDamage = (myPokemon.pokemonStatus[1] + 
					(myPokemon.pokemonSkill.skillDamage[skillNumber] / 10)) - (enemyPokemon.pokemonStatus[2] + 1);
			
			// Ÿ�� �󼺰���� ���ط� ����ġ�� ����ȴ�.
			applySynastry = this.applySynastryValue(myPokemon.pokemonSkill.skillType[skillNumber], enemyPokemon.pokemonStatus[4]);
			// ��ġ ����
			calculateDamage = (int)(calculateDamage * applySynastry);
		}
		else
		{
			// ���ϸ��� �Ӽ��� ���ϸ� ��ų �Ӽ��� ��ġ
			if (enemyPokemon.pokemonStatus[4] == enemyPokemon.pokemonSkill.skillType[skillNumber])
			{
				typeMatch = true;
			}
			else
			{
				typeMatch = false;
			}
			
			// �⺻ ���ط� ���
			calculateDamage = (enemyPokemon.pokemonStatus[1] + 
					(enemyPokemon.pokemonSkill.skillDamage[skillNumber] / 10)) - (myPokemon.pokemonStatus[2] + 1);
			
			// Ÿ�� �󼺰���� ���ط� ����ġ�� ����ȴ�.
			applySynastry = this.applySynastryValue(enemyPokemon.pokemonSkill.skillType[skillNumber], myPokemon.pokemonStatus[4]);
			// ��ġ ����
			calculateDamage = (int)(calculateDamage * applySynastry);
		}
		
		// ����� ������ ���Ƽ� ���ط��� -�� �Ȱ��, �ּ� ���ظ� �ֵ��� ����
		if (calculateDamage < 0)
		{
			calculateDamage = 1;
		}
		
		// ���ϸ� �Ӽ��� ��ų�� �Ӽ��� ������ ������ �����Ѵ�.
		if (typeMatch == true)
		{
			calculateDamage = (int)(calculateDamage * 1.5f);
		}
		
		return calculateDamage;
	}
	
	/**************************************************
	 
	applySynastryValue
	�Է�: ���� ��ų Ÿ��, ����� ���ϸ� Ÿ��
	���: ���ط� ����ġ
	
	Ÿ�� �󼺿� ���� ���ط��� ����ġ�� �����Ѵ�.

	**************************************************/
	private float applySynastryValue (int skillType, int pokemonType)
	{
		float applySynastry = -1;
		
		// �ڽ��� ���� �̱�� ����
		// �ڽ�: ��, ���: Ǯ
		if ((skillType == 1) && (pokemonType == 2))
		{
			applySynastry = 2;
		}
		// �ڽ�: Ǯ, ���: ��
		else if ((skillType == 2) && (pokemonType == 3))
		{
			applySynastry = 2;
		}
		// �ڽ�: ��, ���: ��
		else if ((skillType == 3) && (pokemonType == 1))
		{
			applySynastry = 2;
		}
		// �ڽ��� ���� ���� ����
		// �ڽ�: ��, ���: ��
		else if ((skillType == 1) && (pokemonType == 3))
		{
			applySynastry = 0.5f;
		}
		// �ڽ�: Ǯ, ���: ��
		else if ((skillType == 2) && (pokemonType == 1))
		{
			applySynastry = 0.5f;
		}
		// �ڽ�: ��, ���: Ǯ
		else if ((skillType == 3) && (pokemonType == 2))
		{
			applySynastry = 0.5f;
		}
		else
		{
			// �� ������
			applySynastry = 1;
		}
		
		return applySynastry;
	}
	
	/**************************************************
	 
	checkHittingAttack
	�Է�: ���߷�
	���: ���� ���� ��������
	
	���߷��� �Է¹޾Ƽ� ������ �����ߴ��� ���ߴ��� �Ǵ��Ѵ�.

	**************************************************/
	private boolean checkHittingAttack (int accuracy, int familiarity)
	{
		// �������ڸ� ��� ���� ���� Ŭ����
		Random random = new Random();
		int randomNumber = -1;		// ���� ����
		boolean hitAttack = true;	// ���� ���߿���

		// 0 ~ 99���� ���ڸ� �������� �����ؼ� ���߷� �� ���� �ȿ� ������ ���� ������ �ش�.
		randomNumber = random.nextInt(100);
		
		// ģ�е� ��ġ�� ���� ���߷� ���� ���� ���� �ȴ�.
		if ((familiarity > 0) && (familiarity <= 50))
		{
			accuracy += 1;
		}
		else if ((familiarity > 51) && (familiarity <= 100))
		{
			accuracy += 2;
		}
		else if ((familiarity > 101) && (familiarity <= 150))
		{
			accuracy += 5;
		}
		else if ((familiarity > 151) && (familiarity <= 200))
		{
			accuracy += 8;
		}
		else if ((familiarity > 201) && (familiarity <= 254))
		{
			accuracy += 10;
		}
		else if (familiarity == 255) // ģ�е� �ִ�ġ
		{
			accuracy += 20;
		}
		else
		{
			accuracy += 0;
		}
		
		// ���߷� 100�̻��� ������ ����
		if (accuracy >= 100)
		{
			hitAttack = true;
		}
		else
		{
			// �������� ���� ���ڰ� �� ũ�� ������ �������� ����
			// ex) 85 ���߷��̸� �������ڰ� 86~100�� ������ �������� �Ʒ� ���ڴ� ����
			if (randomNumber > accuracy)
			{
				hitAttack = false;
			}
			else
			{
				hitAttack = true;
			}
		}

		return hitAttack;
	}
	
	/**************************************************
	 
	checkPlayerFirstTurn
	�Է�: �� ���ϸ� ���ǵ�, �� ���ϸ� ���ǵ�
	���: �� ���ϸ��� �������� �� �ִ� or ����
	
	���ϸ��� Speed ��ġ�� ���Ͽ� ���� ���θ� �����Ѵ�.

	**************************************************/
	private boolean checkPlayerFirstTurn (int myPokemonSpeed, int enemyPokemonSpeed)
	{
		boolean playerFirstTurn; // �÷��̾� ��������
		
		// �÷��̾��� ���ϸ��� �� �ӵ��� �������
		if (myPokemonSpeed > enemyPokemonSpeed)
		{
			// �÷��̾� ����
			playerFirstTurn = true;
		}
		else
		{
			// �� ����
			playerFirstTurn = false;
		}
		
		return playerFirstTurn;
	}
	
	/**************************************************
	 
	checkAbnormalCondition
	�Է�: �� ���ϸ� ����, �� ���ϸ� ����, ����� ��ų ��ȣ, �÷��̾� �����ΰ�
	���: ���ϸ��� �����̻�
	
	���ϸ� ���ݽ� �Ӽ��� ���� ���� Ȯ���� �����̻��� �Ǵ�.

	**************************************************/
	private void checkAbnormalCondition (MyPokemon myPokemon, EnemyPokemon enemyPokemon, int skillNumber, boolean playerAttack)
	{
		FireElementPokemon fireElementPokemon = new FireElementPokemon();
		GrassElementPokemon grassElementPokemon = new GrassElementPokemon();
		WaterElementPokemon waterElementPokemon = new WaterElementPokemon();
		
		boolean abnormalCondition = false;
		int skilltype = 0;
		
		// �� ���ϸ��� ��ų Ÿ�� Ȯ��
		if (playerAttack == true)
		{
			skilltype = myPokemon.pokemonSkill.skillType[skillNumber];
		}
		else // �� ���ϸ��� ��ų Ÿ��
		{
			skilltype = enemyPokemon.pokemonSkill.skillType[skillNumber];
		}
		
		switch (skilltype)
		{
			case 1: // �ҼӼ� ��ų
				// �ҼӼ� �������� ȭ�� ���¸� ������� Ȯ��
				abnormalCondition = fireElementPokemon.makeBurnStatus ();
				
				// ȭ�� ���°� Ȯ��
				if (abnormalCondition == true)
				{
					// �÷��̾ ������ ���
					if (playerAttack == true)
					{
						System.out.printf("��뿡�� ȭ���� ������.\n");
						enemyPokemon.pokemonCondition = "ȭ��";
					}
					else
					{
						System.out.printf("ȭ���� �Ծ���!\n");
						myPokemon.pokemonCondition = "ȭ��";
					}
				}
				break;
			case 2: // Ǯ�Ӽ� ��ų
				// Ǯ�Ӽ� �������� ���� ���¸� ������� Ȯ��
				abnormalCondition = grassElementPokemon.makeParalysisStatus ();
				
				// ���� ���°� Ȯ��
				if (abnormalCondition == true)
				{
					// �÷��̾ ������ ���
					if (playerAttack == true)
					{
						System.out.printf("��뿡�� ���� �ɾ���.\n");
						enemyPokemon.pokemonCondition = "����";
					}
					else
					{
						System.out.printf("���� �ɷȴ�!\n");
						myPokemon.pokemonCondition = "����";
					}
				}
				break;
			case 3: // ���Ӽ� ��ų
				// ���Ӽ� �������� ���� ���¸� ������� Ȯ��
				abnormalCondition = waterElementPokemon.makeIceStatus ();
				
				// ���� ���°� Ȯ��
				if (abnormalCondition == true)
				{
					// �÷��̾ ������ ���
					if (playerAttack == true)
					{
						System.out.printf("��밡 �����.\n");
						enemyPokemon.pokemonCondition = "����";
					}
					else
					{
						System.out.printf("���� ���°� �Ǿ���!\n");
						myPokemon.pokemonCondition = "����";
					}
				}
				break;
			default:
				break;
		}
	}
	
	/**************************************************
	 
	checkAbnormalCondition
	�Է�: �� ���ϸ� ����, �� ���ϸ� ����, ����� ��ų ��ȣ, �÷��̾� �����ΰ�
	���: ���ϸ��� �����̻�
	
	���ϸ� ���ݽ� �Ӽ��� ���� ���� Ȯ���� �����̻��� �Ǵ�.

	**************************************************/
	private boolean checkAbnormalCondition (MyPokemon myPokemon, EnemyPokemon enemyPokemon, boolean playerAttack)
	{
		// �������ڸ� ��� ���� ���� Ŭ����
		Random random = new Random();
		int randomNumber = -1;		// ���� ����
		boolean canFight = true;	// ������¿��� ������ �� �ִ°�
		
		randomNumber = random.nextInt(100);
		
		if (playerAttack == true)
		{
			switch (myPokemon.pokemonCondition)
			{
				case "ȭ��":
					// ȭ�� �ɸ��� �� �ϸ��� ü���� 2 �����Ѵ�.
					myPokemon.pokemonStatus[5] -= 2;
					break;
				case "����":
					// ���� �ɸ��� 40% Ȯ���� �ൿ�� �� �� ����.
					if (randomNumber >= 40)
					{
						canFight = true;
					}
					else
					{
						canFight = false;
					}
					break;
				case "����":
					// ���ῡ �ɸ��� �� �ϸ��� ü���� 2 �����Ѵ�.
					myPokemon.pokemonStatus[5] -= 2;
					break;
				default:
					break;
			}
		}
		else
		{
			switch (enemyPokemon.pokemonCondition)
			{
				case "ȭ��":
					// ȭ�� �ɸ��� �� �ϸ��� ü���� 2 �����Ѵ�.
					enemyPokemon.pokemonStatus[5] -= 2;
					break;
				case "����":
					// ���� �ɸ��� 40% Ȯ���� �ൿ�� �� �� ����.
					if (randomNumber >= 40)
					{
						canFight = true;
					}
					else
					{
						canFight = false;
					}
					break;
				case "����":
					// ���ῡ �ɸ��� �� �ϸ��� ü���� 2 �����Ѵ�.
					enemyPokemon.pokemonStatus[5] -= 2;
					break;
				default:
					break;
			}
		}
		
		return canFight;
	}
	
	/**************************************************
	 
	recoveryPokemon
	�Է�: �� ���ϸ� ����
	���: ���ϸ��� ����
	
	��Ʋ�߿� ���ϸ��� ȸ���Ѵ�.

	**************************************************/
	private void recoveryPokemon (MyPokemon myPokemon)
	{
		boolean correctName = false;		// �ùٸ� �̸� �Է��� �Ǵ��ϴ� ����
		String itemName = new String();		// ������ �̸� �Է¹��� ����
		
		System.out.printf("\n���� ��� �� �� �ִ� ȸ�� ������\n");
		
		for (int itemIdx = 0; itemIdx < 10; itemIdx++)
		{
			// �κ��� �������� 1�� �̻��� ���� ã��
			if (Player.item.recoveryAmount[itemIdx] > 0)
			{
				System.out.printf("%s   ������: %d\n", Player.item.recoveryItemName[itemIdx], Player.item.recoveryAmount[itemIdx]);
			}
		}
		
		while (correctName == false) // �ùٸ� �̸��� �Է� ������ ����
		{
			
			System.out.printf("\n����� ȸ�� ������ �̸��� �Է��ϼ���.\n");
			System.out.printf("������ �̸�: ");
			try
			{
				itemName = ShareData.scanUserInput.next();
				
				for (int itemIdx = 0; itemIdx < 10; itemIdx++)
				{
					// �κ��� �������� 1�� �̻��� ���� ã��
					correctName = itemName.equals(Player.item.recoveryItemName[itemIdx]);
					if (correctName == true)
					{
						System.out.printf("%s�� �� ���ϸ󿡰� ����ߴ�.\n", Player.item.recoveryItemName[itemIdx]);
						System.out.printf("ü���� %d��ŭ �ö���.\n", Player.item.recoveryValue[itemIdx]);
						Player.item.recoveryAmount[itemIdx]--;
						// ������ ȸ���� ��ŭ ü���� ȸ��
						myPokemon.pokemonStatus[5] += Player.item.recoveryValue[itemIdx];
						// ü�� �ִ�ġ�� ������ �ִ�ġ�� ����
						if (myPokemon.pokemonStatus[5] > myPokemon.pokemonStatus[0])
						{
							myPokemon.pokemonStatus[5] = myPokemon.pokemonStatus[0];
						}
						// �����̻��� �ɷ��ִ� ���¿��� ������ġ���� ����ϸ� �����̻��� ġ���Ѵ�.
						if ((myPokemon.pokemonCondition != "����") && (Player.item.recoveryItemName[itemIdx] == "������ġ��"))
						{
							myPokemon.pokemonCondition = "����";
						}
						System.out.printf("************************************************************\n");
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
	
	/**************************************************
	 
	run
	��Ʋ �������� ����� �����ϴ� �޼ҵ�

	**************************************************/
	public void run() 
	{
		boolean isPlayer = false;
		
    	for (int idx = 0; idx < ShareData.threadNames.size(); idx++)
    	{
    		System.out.printf("thread %s\n", ShareData.threadNames.get(idx));
    		if (ShareData.threadNames.get(idx) == "BattleThread")
    		{
    			System.out.printf("Is My battle thread %s\n", ShareData.threadNames.get(idx));
    			isPlayer = true;
    		}
    	}
    	
    	// �÷��̾� ��Ʋ thread
		if (isPlayer == true)
		{
			System.out.printf("player thread\n");
		}
		else
		{
			System.out.printf("enemy thread\n");
		}
		
		// ������ ������ ������ ������� ��� �����Ѵ�. ������ Ŭ���� ������ �Ǹ� �����尡 ����ȴ�.
		while (ShareData.isGameOver == false)
		{
	        // ����ڰ� ��Ʋ�� �����ؼ� ��Ʋ �޴��� ���´�.
	        if (ShareData.enterBattleMenu == true)
	        {
	        	//ShareData.Threads.get(0)
	        	this.pokemonBattleMenu (ShareData.myPokemon, ShareData.enemyPokemon);
	        	ShareData.enterBattleMenu = false;
	        }
	        
	        // ������ ��ȭ�� �ν��ϱ� ���� ��� ������ �����.
	        try 
	        {
	            Thread.sleep(10);
	        }
	        catch (Exception e) 
	        {
	        	
	        }
		}
	}
}

//End of File
