/**************************************************
 
���ϸ� Ŭ����
���ϸ��� ������ ��� �ִ�.

**************************************************/

package pokemon;

import java.util.InputMismatchException;

public class Pokemon 
{
	PokemonSkill pokemonSkill = new PokemonSkill();
	
	// ���ϸ� ���� ����
	int currnetExp = 0;		// ���� ����ġ
	int levelUpExp = 0;		// �������� �ϱ����� ����ġ
	int pokemonLevel = 1;	// ���ϸ� ����
	int pokemonType = -1;	// ���ϸ� Ÿ��(�Ӽ�) ��
	String pokemonCondition = new String(); // ���ϸ� ����
	
	// ���ϸ� ������ ��� ����
	// �⺻ �ɷ�ġ ���� ����
	// 0. ü��  1. ���ݷ�  2. ����  3. ���ǵ�
	// 4. ���ϸ��� �Ӽ� ����  5. ���� ü��
	int[] pokemonStatus = new int[6];
	// ���ϸ� �̸�
	String pokemonName = new String();
	
	/**************************************************
	
	displayPokemonStatus
	�Է�: �� ���ϸ� ����
	���: �ָܼ޽���

	���� ���ϸ��� �ɷ�ġ�� �ֿܼ� ������ش�.

	**************************************************/
	public void displayPokemonStatus ()
	{
		System.out.printf("************************************************************\n");
		System.out.printf("���ϸ��� �ɷ�ġ\n\n");
		System.out.printf("����: %d\n", ShareData.myPokemon.pokemonLevel);
		System.out.printf("ģ�е�: %d\n", ShareData.myPokemon.familiarity);
		System.out.printf("HP: %d\n", ShareData.myPokemon.pokemonStatus[0]);
		System.out.printf("���ݷ�: %d\n", ShareData.myPokemon.pokemonStatus[1]);
		System.out.printf("����: %d\n", ShareData.myPokemon.pokemonStatus[2]);
		System.out.printf("���ǵ�: %d\n\n", ShareData.myPokemon.pokemonStatus[3]);
		System.out.printf("���ϸ��� ��ų\n\n");
		System.out.printf("1. %s\n����: %d, Ƚ��: %d, ���߷�: %d\n", 
				ShareData.myPokemon.pokemonSkill.skillName[0], 
				ShareData.myPokemon.pokemonSkill.skillDamage[0], 
				ShareData.myPokemon.pokemonSkill.skillCount[0], 
				ShareData.myPokemon.pokemonSkill.skillAccuracy[0]);
		System.out.printf("2. %s\n����: %d, Ƚ��: %d, ���߷�: %d\n", 
				ShareData.myPokemon.pokemonSkill.skillName[1], 
				ShareData.myPokemon.pokemonSkill.skillDamage[1], 
				ShareData.myPokemon.pokemonSkill.skillCount[1], 
				ShareData.myPokemon.pokemonSkill.skillAccuracy[1]);
		System.out.printf("3. %s\n����: %d, Ƚ��: %d, ���߷�: %d\n", 
				ShareData.myPokemon.pokemonSkill.skillName[2], 
				ShareData.myPokemon.pokemonSkill.skillDamage[2], 
				ShareData.myPokemon.pokemonSkill.skillCount[2], 
				ShareData.myPokemon.pokemonSkill.skillAccuracy[2]);
		System.out.printf("4. %s\n����: %d, Ƚ��: %d, ���߷�: %d\n", 
				ShareData.myPokemon.pokemonSkill.skillName[3], 
				ShareData.myPokemon.pokemonSkill.skillDamage[3], 
				ShareData.myPokemon.pokemonSkill.skillCount[3], 
				ShareData.myPokemon.pokemonSkill.skillAccuracy[3]);
		System.out.printf("************************************************************\n");
	}
	
	/**************************************************
	
	selectPokemon
	�Է�: ����ڷκ��� �Է¹��� ����
	���: ������ ���ϸ��� �̸�
	
	���ϸ��� �����Ѵ�.
	1. ���̸�.   2. �̻��ؾ�.   3. ���α�.

	**************************************************/
	public String selectPokemon ()
	{
		String selectPokemonName = new String();
		// ���ϸ��� �����Ѵ�.
		int receiveNumber = -1;					// ����ڰ� �Է��ϴ� ��ġ
		boolean correctNumber = false;			// �ùٸ� ���� �Է��� �Ǵ��ϴ� ����
		
		while (correctNumber == false)
		{
			// TODO: ������ �Է��� Ȯ�� �ް� ������ ������ ������ �����Ѵ�.
			System.out.printf("************************************************************\n");
			System.out.printf("���ϸ� �ϳ��� ���ʽÿ�.\n");
			System.out.printf("1. ���̸�          2. �̻��ؾ�          3. ���α�\n");
			System.out.printf("************************************************************\n");
			System.out.printf("���� ������ ���ϸ�: ");
			
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
			
			if ((receiveNumber <= 0) || (receiveNumber >= 4))
			{
				System.out.printf("************************************************************\n");
				System.out.println("�߸��� ���� �Է��Դϴ�.\n�ٽ� �Է� ���ּ���.\n");
				System.out.printf("************************************************************\n");
				continue;
			}
			else
			{
				// ���ϸ� ���� �Ϸ�
				correctNumber = true;
			}
		}
		
		switch (receiveNumber)
		{
			case 1: // ���̸�
				System.out.printf("************************************************************\n");
				System.out.printf("���̸��� �����߽��ϴ�.\n");
				System.out.printf("************************************************************\n");
				selectPokemonName = "���̸�";
				break;				
			case 2: // �̻��ؾ�
				System.out.printf("************************************************************\n");
				System.out.printf("�̻��ؾ��� �����߽��ϴ�.\n");
				System.out.printf("************************************************************\n");
				selectPokemonName = "�̻��ؾ�";
				break;		
			case 3: // ���α�
				System.out.printf("************************************************************\n");
				System.out.printf("���α⸦ �����߽��ϴ�.\n");
				System.out.printf("************************************************************\n");
				selectPokemonName = "���α�";
				break;
			default:
				break;
		}
		
		// ���ϸ� ����
		return selectPokemonName;
	}
		
	/**************************************************
	 
	setBasicMyPokemonStatus
	�Է�: �� ���ϸ� ����, �� ���ϸ� ����
	���: �� ���ϸ� ����, ���̹� ���ϸ� ����
	
	ó�� ���ϸ��� �����ϰ� �� ���ϸ��� ������ �����Ѵ�.

	**************************************************/
	public void setBasicMyPokemonStatus ()
	{
		Charmander myCharmander = new Charmander(); // ���̸�
		Bulbasaur myBulbasaur = new Bulbasaur();	// �̻��ؾ�
		Squirtle mySquirtle = new Squirtle();		// ���α�
		
		//MyPokemon.PokemonName = PokemonName;
		
		// ���ϸ� ���� �� �⺻ �� ����
		switch (ShareData.myPokemon.pokemonName)
		{
			case "���̸�":
				// ���̸��� �⺻ �ɷ�ġ ����
				myCharmander.setBasicPokemonStatus (true);
				// ���̸��� ���� �ɷ�ġ ���
				myCharmander.displayPokemonStatus ();
				// ���̹� ���α��� �⺻ �ɷ�ġ ����
				ShareData.rivalPokemon.pokemonName = "���α�";
				mySquirtle.setBasicPokemonStatus (false);
				break;
			case "�̻��ؾ�":
				// �̻��ؾ��� �⺻ �ɷ�ġ ����
				myBulbasaur.setBasicPokemonStatus (true);
				// �̻��ؾ��� ���� �ɷ�ġ ���
				myBulbasaur.displayPokemonStatus ();
				// ���̹� ���̸��� �⺻ �ɷ�ġ ����
				ShareData.rivalPokemon.pokemonName = "���̸�";
				myCharmander.setBasicPokemonStatus (false);
				break;
			case "���α�":
				// ���α��� �⺻ �ɷ�ġ ����
				mySquirtle.setBasicPokemonStatus (true);
				// ���α��� ���� �ɷ�ġ ���
				mySquirtle.displayPokemonStatus ();
				// �̻��ؾ��� �⺻ �ɷ�ġ ����
				ShareData.rivalPokemon.pokemonName = "�̻��ؾ�";
				myBulbasaur.setBasicPokemonStatus (false);
				break;
			default:
				break;
		}
		
		// ���� 1�� �ʿ� ����ġ��
		ShareData.myPokemon.levelUpExp = 10;
		// �����̻� ����
		ShareData.myPokemon.pokemonCondition = "����";
		ShareData.rivalPokemon.pokemonCondition = "����";
	}
	
	/**************************************************
	 
	increasePokemonStatus
	�Է�: �� ���ϸ��� ����, ������ ��� ������ ����ġ��
	���: �� ���ϸ��� ����
	
	�������� �ϸ� �ɷ�ġ�� ���������ְ� ��ų�� ������ ��ȭ ������ �Ǹ� ��ȭ�Ѵ�.

	**************************************************/
	public void increasePokemonStatus (int offsetExp)
	{
		FireElementPokemon fireElementPokemon = new FireElementPokemon();
		GrassElementPokemon grassElementPokemon = new GrassElementPokemon();
		WaterElementPokemon waterElementPokemon = new WaterElementPokemon();
		
		// ���̸�, �̻��ؾ�, ���α� Ŭ����
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		
		if ((ShareData.myPokemon.pokemonName == "���̸�") || 
				(ShareData.myPokemon.pokemonName == "���ڵ�") || 
				(ShareData.myPokemon.pokemonName == "���ڸ�"))
		{
			System.out.printf("************************************************************\n");
			System.out.printf("%s�� �ɷ�ġ ��� \n\n", ShareData.myPokemon.pokemonName);
			System.out.printf("����: %d -> %d\n", 
					(ShareData.myPokemon.pokemonLevel - 1), ShareData.myPokemon.pokemonLevel);
			System.out.printf("HP: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[0], 2, (ShareData.myPokemon.pokemonStatus[0] + 2));
			System.out.printf("���ݷ�: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[1], 2, (ShareData.myPokemon.pokemonStatus[1] + 2));
			System.out.printf("����: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[2], 1, (ShareData.myPokemon.pokemonStatus[2] + 1));
			System.out.printf("���ǵ�: %d + %d = %d\n\n", 
					ShareData.myPokemon.pokemonStatus[5], 2, (ShareData.myPokemon.pokemonStatus[3] + 2));
			System.out.printf("************************************************************\n");
			ShareData.myPokemon.pokemonStatus[0] += 2;
			ShareData.myPokemon.pokemonStatus[1] += 2;
			ShareData.myPokemon.pokemonStatus[2] += 1;
			ShareData.myPokemon.pokemonStatus[3] += 2;
			ShareData.myPokemon.pokemonStatus[5] += 2;
			// ������ �� ��ų�� ���������� �Ǹ� ���Ӽ� ��ų�� ������.
			ShareData.myPokemon.pokemonSkill.learnNewSkill (true);
			// ������ �� ��ų�� ���������� �Ǹ� �ҼӼ� ��ų�� ������.
			fireElementPokemon.learnNewSkill (true);
			// ���� ������ �Ǹ� ��ȭ�Ѵ�.
			charmander.evolutionPokemon(true);
		}
		else if ((ShareData.myPokemon.pokemonName == "�̻��ؾ�") || 
				(ShareData.myPokemon.pokemonName == "�̻���Ǯ") || 
				(ShareData.myPokemon.pokemonName == "�̻��ز�"))
		{
			System.out.printf("************************************************************\n");
			System.out.printf("%s�� �ɷ�ġ ��� \n\n", ShareData.myPokemon.pokemonName);
			System.out.printf("����: %d -> %d\n", 
					(ShareData.myPokemon.pokemonLevel - 1), ShareData.myPokemon.pokemonLevel);
			System.out.printf("HP: %d + %d = %d\n",
					ShareData.myPokemon.pokemonStatus[0], 3, (ShareData.myPokemon.pokemonStatus[0] + 3));
			System.out.printf("���ݷ�: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[1], 1, (ShareData.myPokemon.pokemonStatus[1] + 1));
			System.out.printf("����: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[2], 2, (ShareData.myPokemon.pokemonStatus[2] + 2));
			System.out.printf("���ǵ�: %d + %d = %d\n\n", 
					ShareData.myPokemon.pokemonStatus[5], 1, (ShareData.myPokemon.pokemonStatus[3] + 1));
			System.out.printf("************************************************************\n");
			ShareData.myPokemon.pokemonStatus[0] += 3;
			ShareData.myPokemon.pokemonStatus[1] += 1;
			ShareData.myPokemon.pokemonStatus[2] += 2;
			ShareData.myPokemon.pokemonStatus[3] += 1;
			ShareData.myPokemon.pokemonStatus[5] += 3;
			// ������ �� ��ų�� ���������� �Ǹ� ���Ӽ� ��ų�� ������.
			ShareData.myPokemon.pokemonSkill.learnNewSkill (true);
			// ������ �� ��ų�� ���������� �Ǹ� Ǯ�Ӽ� ��ų�� ������.
			grassElementPokemon.learnNewSkill (true);
			// ���� ������ �Ǹ� ��ȭ�Ѵ�.
			bulbasaur.evolutionPokemon(true);
		}
		else if ((ShareData.myPokemon.pokemonName == "���α�") || 
				(ShareData.myPokemon.pokemonName == "��Ϻα�") || 
				(ShareData.myPokemon.pokemonName == "�źϿ�"))
		{
			System.out.printf("************************************************************\n");
			System.out.printf("%s�� �ɷ�ġ ��� \n\n", ShareData.myPokemon.pokemonName);
			System.out.printf("����: %d -> %d\n", 
					(ShareData.myPokemon.pokemonLevel - 1), ShareData.myPokemon.pokemonLevel);
			System.out.printf("HP: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[0], 2, (ShareData.myPokemon.pokemonStatus[0] + 2));
			System.out.printf("���ݷ�: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[1], 1, (ShareData.myPokemon.pokemonStatus[1] + 1));
			System.out.printf("����: %d + %d = %d\n", 
					ShareData.myPokemon.pokemonStatus[2], 1, (ShareData.myPokemon.pokemonStatus[2] + 1));
			System.out.printf("���ǵ�: %d + %d = %d\n\n", 
					ShareData.myPokemon.pokemonStatus[5], 2, (ShareData.myPokemon.pokemonStatus[3] + 2));
			System.out.printf("************************************************************\n");
			ShareData.myPokemon.pokemonStatus[0] += 2;
			ShareData.myPokemon.pokemonStatus[1] += 1;
			ShareData.myPokemon.pokemonStatus[2] += 1;
			ShareData.myPokemon.pokemonStatus[3] += 2;
			ShareData.myPokemon.pokemonStatus[5] += 2;
			// ������ �� ��ų�� ���������� �Ǹ� ���Ӽ� ��ų�� ������.
			ShareData.myPokemon.pokemonSkill.learnNewSkill (true);
			// ������ �� ��ų�� ���������� �Ǹ� ���Ӽ� ��ų�� ������.
			waterElementPokemon.learnNewSkill (true);
			// ���� ������ �Ǹ� ��ȭ�Ѵ�.
			squirtle.evolutionPokemon(true);
		}
		else
		{
			// empty
		}
		
		ShareData.myPokemon.pokemonSkill.currentSkillCount[0] = ShareData.myPokemon.pokemonSkill.skillCount[0];
		ShareData.myPokemon.pokemonSkill.currentSkillCount[1] = ShareData.myPokemon.pokemonSkill.skillCount[1];
		ShareData.myPokemon.pokemonSkill.currentSkillCount[2] = ShareData.myPokemon.pokemonSkill.skillCount[2];
		ShareData.myPokemon.pokemonSkill.currentSkillCount[3] = ShareData.myPokemon.pokemonSkill.skillCount[3];
		
		// ������ �� ���� ����ġ�翡�� ������ ������ ����ġ���� ���鼭 ���� �ʿ� ����ġ�� ����Ѵ�.
		ShareData.myPokemon.levelUpExp = (10 * ShareData.myPokemon.pokemonLevel) + offsetExp;
		// ������ �� ���ϸ� �ɷ�ġ�� �ֿܼ� ����Ѵ�.
		ShareData.myPokemon.displayPokemonStatus ();
	}
	
	/**************************************************
	 
	increasePokemonStatus
	�Է�: ���̹� ���ϸ��� ����
	���: ���̹� ���ϸ��� ����
	
	�������� �ϸ� �ɷ�ġ�� ���������ְ� ��ų�� ������ ��ȭ ������ �Ǹ� ��ȭ�Ѵ�.

	**************************************************/
	public void increasePokemonStatus ()
	{
		FireElementPokemon fireElementPokemon = new FireElementPokemon();
		GrassElementPokemon grassElementPokemon = new GrassElementPokemon();
		WaterElementPokemon waterElementPokemon = new WaterElementPokemon();
		
		// ���̸�, �̻��ؾ�, ���α� Ŭ����
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		
		ShareData.rivalPokemon.pokemonLevel += 1;
		
		if ((ShareData.rivalPokemon.pokemonName == "���̸�") || 
				(ShareData.rivalPokemon.pokemonName == "���ڵ�") || 
				(ShareData.rivalPokemon.pokemonName == "���ڸ�"))
		{
			ShareData.rivalPokemon.pokemonStatus[0] += 2;
			ShareData.rivalPokemon.pokemonStatus[1] += 2;
			ShareData.rivalPokemon.pokemonStatus[2] += 1;
			ShareData.rivalPokemon.pokemonStatus[3] += 2;
			ShareData.rivalPokemon.pokemonStatus[5] += 2;
			// ������ �� ��ų�� ���������� �Ǹ� ���Ӽ� ��ų�� ������.
			ShareData.rivalPokemon.pokemonSkill.learnNewSkill (false);
			// ������ �� ��ų�� ���������� �Ǹ� �ҼӼ� ��ų�� ������.
			fireElementPokemon.learnNewSkill (false);
			// ���� ������ �Ǹ� ��ȭ�Ѵ�.
			charmander.evolutionPokemon(false);
		}
		else if ((ShareData.rivalPokemon.pokemonName == "�̻��ؾ�") || 
				(ShareData.rivalPokemon.pokemonName == "�̻���Ǯ") || 
				(ShareData.rivalPokemon.pokemonName == "�̻��ز�"))
		{
			ShareData.rivalPokemon.pokemonStatus[0] += 3;
			ShareData.rivalPokemon.pokemonStatus[1] += 1;
			ShareData.rivalPokemon.pokemonStatus[2] += 2;
			ShareData.rivalPokemon.pokemonStatus[3] += 1;
			ShareData.rivalPokemon.pokemonStatus[5] += 3;
			// ������ �� ��ų�� ���������� �Ǹ� ���Ӽ� ��ų�� ������.
			ShareData.rivalPokemon.pokemonSkill.learnNewSkill (false);
			// ������ �� ��ų�� ���������� �Ǹ� Ǯ�Ӽ� ��ų�� ������.
			grassElementPokemon.learnNewSkill (false);
			// ���� ������ �Ǹ� ��ȭ�Ѵ�.
			bulbasaur.evolutionPokemon(false);
		}
		else if ((ShareData.rivalPokemon.pokemonName == "���α�") || 
				(ShareData.rivalPokemon.pokemonName == "��Ϻα�") || 
				(ShareData.rivalPokemon.pokemonName == "�źϿ�"))
		{
			ShareData.rivalPokemon.pokemonStatus[0] += 2;
			ShareData.rivalPokemon.pokemonStatus[1] += 2;
			ShareData.rivalPokemon.pokemonStatus[2] += 1;
			ShareData.rivalPokemon.pokemonStatus[3] += 2;
			ShareData.rivalPokemon.pokemonStatus[5] += 2;
			// ������ �� ��ų�� ���������� �Ǹ� ���Ӽ� ��ų�� ������.
			ShareData.rivalPokemon.pokemonSkill.learnNewSkill (false);
			// ������ �� ��ų�� ���������� �Ǹ� ���Ӽ� ��ų�� ������.
			waterElementPokemon.learnNewSkill (false);
			// ���� ������ �Ǹ� ��ȭ�Ѵ�.
			squirtle.evolutionPokemon(false);
		}
		else
		{
			// empty
		}
		
		ShareData.pokemon.pokemonSkill.currentSkillCount[0] = ShareData.pokemon.pokemonSkill.skillCount[0];
		ShareData.pokemon.pokemonSkill.currentSkillCount[1] = ShareData.pokemon.pokemonSkill.skillCount[1];
		ShareData.pokemon.pokemonSkill.currentSkillCount[2] = ShareData.pokemon.pokemonSkill.skillCount[2];
		ShareData.pokemon.pokemonSkill.currentSkillCount[3] = ShareData.pokemon.pokemonSkill.skillCount[3];
	}
}

// End of File
