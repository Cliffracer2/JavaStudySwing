

package pokemon;

public class FireSkill extends PokemonSkill
{
	/**************************************************
	
	setSkill
	�Է�: 
	���: ��ų ���� ����Ʈ ���� ��
	
	�ҼӼ� ��ų �̸� ����

	**************************************************/
	public void setSkill ()
	{
		this.skillNameList.add("�Ҳɼ���");		// 0
		this.skillNameList.add("�Ҳɾ���");		// 1
		this.skillNameList.add("ȭ�����");		// 2
		this.skillNameList.add("�Ҵ빮��");		// 3
		this.skillNameList.add("�÷������̺�");	// 4
		
		this.skillDamageList.add(40);			// 0
		this.skillDamageList.add(65);			// 1
		this.skillDamageList.add(90);			// 2
		this.skillDamageList.add(110);			// 3
		this.skillDamageList.add(120);			// 4
		
		this.skillCountList.add(25);			// 0
		this.skillCountList.add(15);			// 1
		this.skillCountList.add(15);			// 2
		this.skillCountList.add(5);				// 3
		this.skillCountList.add(15);			// 4

		this.skillAccuracyList.add(100);		// 0
		this.skillAccuracyList.add(95);			// 1
		this.skillAccuracyList.add(100);		// 2
		this.skillAccuracyList.add(85);			// 3
		this.skillAccuracyList.add(100);		// 4
	}
	
	/**************************************************
	
	setSkillName
	�Է�: ��ų ��ġ, ����Ʈ�� ��ų�� ��ġ ��
	���: ��ų �̸�
	
	�ҼӼ� ��ų �̸� ����

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
	
	�ҼӼ� ��ų ���� ����

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
	
	�ҼӼ� ��ų Ƚ�� ����

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
	
	�ҼӼ� ��ų ���߷� ����

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
	
	�ҼӼ� ��ų �Ӽ� ����

	**************************************************/
	void setSkillType (int[] skillType, int skillPosition)
	{
		// �ҼӼ����� ����
		skillType[skillPosition] = 1;
	}
}