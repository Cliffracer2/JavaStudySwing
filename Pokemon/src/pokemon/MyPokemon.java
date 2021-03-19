/**************************************************
 
���� ���ϸ� Ŭ����

**************************************************/

package pokemon;

import java.util.InputMismatchException;

class MyPokemon extends Pokemon
{
	int familiarity = 0;	// ģ�е�
	
	/**************************************************
	 
	goToPokemonCenter
	�Է�: ������ �Է��ϴ� ��ġ
	���: ���ϸ� ����
	
	�߻� ���ϸ��� ������ �˷��ش�.
	�÷��̾��� ������ ���� �����ϴ� ���ϸ� ������ ������ �޶�����.

	**************************************************/
	void goToPokemonCenter ()
	{
		int receiveNumber = -1;			// ����ڰ� �Է��ϴ� ��ġ
		boolean correctNumber = false;	// �ùٸ� ���� �Է��� �Ǵ��ϴ� ����
		
		while (correctNumber == false)
		{
			System.out.printf("************************************************************\n");
			System.out.printf("%s�� ���ϸ� ���Ϳ� �Դ�.\n", pokemonName);
			System.out.printf("1. ȸ���Ѵ�.\n");
			System.out.printf("2. �׳� ������.\n");
			System.out.printf("************************************************************\n");
			System.out.printf("��ȣ ����: ");
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
			
			if (receiveNumber == 1)
			{
				System.out.printf("���ϸ� ���Ϳ��� ȸ���ϱ�� �ߴ�.\n\n");
				// ���ϸ��� ȸ���Ѵ�.
				// HP ȸ��
				pokemonStatus[5] = pokemonStatus[0];
				System.out.printf("%s�� HP: %d / %d\n", pokemonName, pokemonStatus[5], pokemonStatus[0]);
				// ��ų ���Ƚ�� ȸ��
				for (int skillIdx = 0; skillIdx < 4; skillIdx++)
				{
					pokemonSkill.currentSkillCount[skillIdx] = pokemonSkill.skillCount[skillIdx];
				}
				System.out.printf("1. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
						pokemonSkill.skillName[0], 
						pokemonSkill.skillDamage[0], 
						pokemonSkill.currentSkillCount[0], pokemonSkill.skillCount[0], 
						pokemonSkill.skillAccuracy[0]);
				System.out.printf("2. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
						pokemonSkill.skillName[1], 
						pokemonSkill.skillDamage[1], 
						pokemonSkill.currentSkillCount[1], pokemonSkill.skillCount[1], 
						pokemonSkill.skillAccuracy[1]);
				System.out.printf("3. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
						pokemonSkill.skillName[2], 
						pokemonSkill.skillDamage[2], 
						pokemonSkill.currentSkillCount[2], pokemonSkill.skillCount[2], 
						pokemonSkill.skillAccuracy[2]);
				System.out.printf("4. %s\n����: %d, Ƚ��: (%d / %d), ���߷�: %d\n", 
						pokemonSkill.skillName[3], 
						pokemonSkill.skillDamage[3], 
						pokemonSkill.currentSkillCount[3], pokemonSkill.skillCount[3], 
						pokemonSkill.skillAccuracy[3]);
				System.out.printf("************************************************************\n\n");
				System.out.printf("���ϸ��� �ǰ�������!\n\n");
				System.out.printf("************************************************************\n\n");
			}
			else
			{
				System.out.printf("�ƹ��͵� ���ϰ� �׳� ����.\n");
				System.out.printf("************************************************************\n");
			}
			
			correctNumber = true;
		}
	}
}