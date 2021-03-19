/**************************************************
 
������ Ŭ����

**************************************************/

package pokemon;

public class Item 
{
	// ģ�е� ������ ����
	String[] familiarityItemName = new String[10]; 	// ģ�е� ������ �̸�
	int[] familiarityValue = new int[10];			// ģ�е� ��·�
	int[] familiarityAmount = new int[10];			// ģ�е� ������ ������
	
	// ȸ�� ������ ����
	String[] recoveryItemName = new String[10];;	// ȸ�� ������ �̸�
	int[] recoveryValue = new int[10];				// ȸ����
	int[] recoveryAmount = new int[10];				// ȸ�� ������ ������
	
	/**************************************************
	 
	initalizeItemList
	������ ���� �ʱ�ȭ

	**************************************************/
	void initalizeItemList ()
	{
		familiarityItemName[0] = "��������";
		familiarityItemName[1] = "�ø�����";
		familiarityItemName[2] = "�ĺ񿭸�";
		familiarityItemName[3] = "�θſ���";
		familiarityItemName[4] = "�������";
		
		familiarityValue[0] = 4;
		familiarityValue[1] = 6;
		familiarityValue[2] = 8;
		familiarityValue[3] = 10;
		familiarityValue[4] = 15;
		
		familiarityAmount[0] = 0;
		familiarityAmount[1] = 0;
		familiarityAmount[2] = 0;
		familiarityAmount[3] = 0;
		familiarityAmount[4] = 0;
		
		recoveryItemName[0] = "��ó��";
		recoveryItemName[1] = "���� ��ó��";
		recoveryItemName[2] = "��� ��ó��";
		recoveryItemName[3] = "ȸ����";
		recoveryItemName[4] = "������ġ��";
		
		recoveryValue[0] = 20;
		recoveryValue[1] = 40;
		recoveryValue[2] = 60;
		recoveryValue[3] = 300;
		recoveryValue[4] = 20;
		
		recoveryAmount[0] = 0;
		recoveryAmount[1] = 0;
		recoveryAmount[2] = 0;
		recoveryAmount[3] = 0;
		recoveryAmount[4] = 0;
	}
	
	/**************************************************
	 
	storeItem
	�Է�: ������ �̸�, ������ Ÿ��, ������ ��
	���: ������ ������ ��
	
	Ʈ���̳��� �κ��丮�� �������� �����Ѵ�.
	������ Ÿ��
	0: ģ�е� ������
	1: ȸ�� ������

	**************************************************/
	public void storeItem (String itemName, int itemType, int amount)
	{
		switch (itemType)
		{
			case 0: // ģ�е� ������
				for (int itemIdx = 0; itemIdx < 10; itemIdx++)
				{
					// �κ��� ������ �̸��� ��ġ�ϴ� ��ġ�� ã��
					if (familiarityItemName[itemIdx] == itemName)
					{
						// �Է��� �縸ŭ ������ �� ����
						familiarityAmount[itemIdx] += amount;
					}
				}
				break;
			case 1: // ȸ�� ������
				for (int itemIdx = 0; itemIdx < 10; itemIdx++)
				{
					// �κ��� ������ �̸��� ��ġ�ϴ� ��ġ�� ã��
					if (recoveryItemName[itemIdx] == itemName)
					{
						// �Է��� �縸ŭ ������ �� ����
						recoveryAmount[itemIdx] += amount;
					}
				}
				break;
			default:
				break;
		}
	}
}
