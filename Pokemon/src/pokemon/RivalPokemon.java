package pokemon;

//���̹� ���ϸ� Ŭ����
public class RivalPokemon extends EnemyPokemon implements Runnable
{
	int growWaitTime = 1000;		// ���̹� ���ϸ��� ����ī��Ʈ 
	
	public RivalPokemon ()
	{
		
	}
	
	void displayRivalPokemon (RivalPokemon RivalPokemon)
	{
		System.out.printf("************************************************************\n");
		System.out.printf("���ϸ��� �ɷ�ġ\n\n");
		System.out.printf("����: %d\n", RivalPokemon.pokemonLevel);
		System.out.printf("HP: %d\n", RivalPokemon.pokemonStatus[0]);
		System.out.printf("���ݷ�: %d\n", RivalPokemon.pokemonStatus[1]);
		System.out.printf("����: %d\n", RivalPokemon.pokemonStatus[2]);
		System.out.printf("���ǵ�: %d\n\n", RivalPokemon.pokemonStatus[3]);
		System.out.printf("���ϸ��� ��ų\n\n");
		System.out.printf("1. %s\n����: %d, Ƚ��: %d, ���߷�: %d\n", 
				RivalPokemon.pokemonSkill.skillName[0], 
				RivalPokemon.pokemonSkill.skillDamage[0], 
				RivalPokemon.pokemonSkill.skillCount[0], 
				RivalPokemon.pokemonSkill.skillAccuracy[0]);
		System.out.printf("2. %s\n����: %d, Ƚ��: %d, ���߷�: %d\n", 
				RivalPokemon.pokemonSkill.skillName[1], 
				RivalPokemon.pokemonSkill.skillDamage[1], 
				RivalPokemon.pokemonSkill.skillCount[1], 
				RivalPokemon.pokemonSkill.skillAccuracy[1]);
		System.out.printf("3. %s\n����: %d, Ƚ��: %d, ���߷�: %d\n", 
				RivalPokemon.pokemonSkill.skillName[2], 
				RivalPokemon.pokemonSkill.skillDamage[2], 
				RivalPokemon.pokemonSkill.skillCount[2], 
				RivalPokemon.pokemonSkill.skillAccuracy[2]);
		System.out.printf("4. %s\n����: %d, Ƚ��: %d, ���߷�: %d\n", 
				RivalPokemon.pokemonSkill.skillName[3], 
				RivalPokemon.pokemonSkill.skillDamage[3], 
				RivalPokemon.pokemonSkill.skillCount[3], 
				RivalPokemon.pokemonSkill.skillAccuracy[3]);
		System.out.printf("************************************************************\n");
	}
		
	public void growRivalPokemon ()
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
		
		ShareData.rivalPokemon.pokemonSkill.currentSkillCount[0] = ShareData.rivalPokemon.pokemonSkill.skillCount[0];
		ShareData.rivalPokemon.pokemonSkill.currentSkillCount[1] = ShareData.rivalPokemon.pokemonSkill.skillCount[1];
		ShareData.rivalPokemon.pokemonSkill.currentSkillCount[2] = ShareData.rivalPokemon.pokemonSkill.skillCount[2];
		ShareData.rivalPokemon.pokemonSkill.currentSkillCount[3] = ShareData.rivalPokemon.pokemonSkill.skillCount[3];

	}
	
	// TODO: run�޼ҵ� �ȿ� ���̹� ���ϸ��� ���� �ֱ⸶�� �����ϴ� ����� �ֱ�
	public void run() 
	{
		//System.out.printf("\nRivalPokemon Thread Start\n");
		/*
		ReceiveData.ShareInt++;
		//System.out.printf("1 ReceiveShareData.IncreaseCount %b\n", ReceiveShareData.IncreaseCount);
		//System.out.printf("2 ReceiveShareData.ShareInt %d\n", ReceiveShareData.ShareInt);

		if (ReceiveData.IncreaseCount == true)
		{
			//ReceiveShareData.IncreaseCount = false;
			ReceiveData.RivalGrowUPCount++;
			System.out.printf("ReceiveShareData.RivalGrowUPCount %d\n", ReceiveData.RivalGrowUPCount);
		}
		*/
        
        //ReceiveData.Pokemon.PokemonLevel += 1;
        //ReceiveData.Pokemon.IncreasePokemonStatus(ReceiveData);
		
		ShareData.rivalPokemon.pokemonLevel = 1;
		
		// ���̹��� ���� 50�� �Ǹ� ������ ������.
		while (ShareData.rivalPokemon.pokemonLevel < 50)
		{
	        try 
	        {
	            Thread.sleep(growWaitTime);
	        }
	        catch(Exception e) 
	        {
	        	
	        }
	        
	        this.growRivalPokemon ();
		}

		//System.out.printf("\nRivalPokemon Thread End\n");
	}
}