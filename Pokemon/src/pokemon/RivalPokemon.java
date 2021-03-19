package pokemon;

//라이벌 포켓몬 클래스
public class RivalPokemon extends EnemyPokemon implements Runnable
{
	int growWaitTime = 1000;		// 라이벌 포켓몬의 성장카운트 
	
	public RivalPokemon ()
	{
		
	}
	
	void displayRivalPokemon (RivalPokemon RivalPokemon)
	{
		System.out.printf("************************************************************\n");
		System.out.printf("포켓몬의 능력치\n\n");
		System.out.printf("레벨: %d\n", RivalPokemon.pokemonLevel);
		System.out.printf("HP: %d\n", RivalPokemon.pokemonStatus[0]);
		System.out.printf("공격력: %d\n", RivalPokemon.pokemonStatus[1]);
		System.out.printf("방어력: %d\n", RivalPokemon.pokemonStatus[2]);
		System.out.printf("스피드: %d\n\n", RivalPokemon.pokemonStatus[3]);
		System.out.printf("포켓몬의 스킬\n\n");
		System.out.printf("1. %s\n위력: %d, 횟수: %d, 명중률: %d\n", 
				RivalPokemon.pokemonSkill.skillName[0], 
				RivalPokemon.pokemonSkill.skillDamage[0], 
				RivalPokemon.pokemonSkill.skillCount[0], 
				RivalPokemon.pokemonSkill.skillAccuracy[0]);
		System.out.printf("2. %s\n위력: %d, 횟수: %d, 명중률: %d\n", 
				RivalPokemon.pokemonSkill.skillName[1], 
				RivalPokemon.pokemonSkill.skillDamage[1], 
				RivalPokemon.pokemonSkill.skillCount[1], 
				RivalPokemon.pokemonSkill.skillAccuracy[1]);
		System.out.printf("3. %s\n위력: %d, 횟수: %d, 명중률: %d\n", 
				RivalPokemon.pokemonSkill.skillName[2], 
				RivalPokemon.pokemonSkill.skillDamage[2], 
				RivalPokemon.pokemonSkill.skillCount[2], 
				RivalPokemon.pokemonSkill.skillAccuracy[2]);
		System.out.printf("4. %s\n위력: %d, 횟수: %d, 명중률: %d\n", 
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
		
		// 파이리, 이상해씨, 꼬부기 클래스
		Charmander charmander = new Charmander();
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		
		ShareData.rivalPokemon.pokemonLevel += 1;
		
		if ((ShareData.rivalPokemon.pokemonName == "파이리") || 
				(ShareData.rivalPokemon.pokemonName == "리자드") || 
				(ShareData.rivalPokemon.pokemonName == "리자몽"))
		{
			ShareData.rivalPokemon.pokemonStatus[0] += 2;
			ShareData.rivalPokemon.pokemonStatus[1] += 2;
			ShareData.rivalPokemon.pokemonStatus[2] += 1;
			ShareData.rivalPokemon.pokemonStatus[3] += 2;
			ShareData.rivalPokemon.pokemonStatus[5] += 2;
			// 레벨업 후 스킬을 익힐레벨이 되면 무속성 스킬을 익힌다.
			ShareData.rivalPokemon.pokemonSkill.learnNewSkill (false);
			// 레벨업 후 스킬을 익힐레벨이 되면 불속성 스킬을 익힌다.
			fireElementPokemon.learnNewSkill (false);
			// 일정 레벨이 되면 진화한다.
			charmander.evolutionPokemon(false);
		}
		else if ((ShareData.rivalPokemon.pokemonName == "이상해씨") || 
				(ShareData.rivalPokemon.pokemonName == "이상해풀") || 
				(ShareData.rivalPokemon.pokemonName == "이상해꽃"))
		{
			ShareData.rivalPokemon.pokemonStatus[0] += 3;
			ShareData.rivalPokemon.pokemonStatus[1] += 1;
			ShareData.rivalPokemon.pokemonStatus[2] += 2;
			ShareData.rivalPokemon.pokemonStatus[3] += 1;
			ShareData.rivalPokemon.pokemonStatus[5] += 3;
			// 레벨업 후 스킬을 익힐레벨이 되면 무속성 스킬을 익힌다.
			ShareData.rivalPokemon.pokemonSkill.learnNewSkill (false);
			// 레벨업 후 스킬을 익힐레벨이 되면 풀속성 스킬을 익힌다.
			grassElementPokemon.learnNewSkill (false);
			// 일정 레벨이 되면 진화한다.
			bulbasaur.evolutionPokemon(false);
		}
		else if ((ShareData.rivalPokemon.pokemonName == "꼬부기") || 
				(ShareData.rivalPokemon.pokemonName == "어니부기") || 
				(ShareData.rivalPokemon.pokemonName == "거북왕"))
		{
			ShareData.rivalPokemon.pokemonStatus[0] += 2;
			ShareData.rivalPokemon.pokemonStatus[1] += 2;
			ShareData.rivalPokemon.pokemonStatus[2] += 1;
			ShareData.rivalPokemon.pokemonStatus[3] += 2;
			ShareData.rivalPokemon.pokemonStatus[5] += 2;
			// 레벨업 후 스킬을 익힐레벨이 되면 무속성 스킬을 익힌다.
			ShareData.rivalPokemon.pokemonSkill.learnNewSkill (false);
			// 레벨업 후 스킬을 익힐레벨이 되면 물속성 스킬을 익힌다.
			waterElementPokemon.learnNewSkill (false);
			// 일정 레벨이 되면 진화한다.
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
	
	// TODO: run메소드 안에 라이벌 포켓몬이 일정 주기마다 성장하는 기능을 넣기
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
		
		// 라이벌이 레벨 50이 되면 성장이 끝난다.
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