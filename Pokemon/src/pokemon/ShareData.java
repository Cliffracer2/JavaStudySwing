package pokemon;

import java.util.ArrayList;
import java.util.Scanner;

// �����尣�� �����͸� �����ϱ� ���� ���� Ŭ����
public class ShareData 
{
	public static Scanner scanUserInput = new Scanner(System.in);	// Scanner Ŭ����
	public static Scanner battleInput = new Scanner(System.in);		// Scanner Ŭ����
	public static Pokemon pokemon = new Pokemon();
	public static Trainer trainer = new Trainer();
	public static Battle battle = new Battle();
	public static Player player = new Player();						// �÷��̾� Ŭ����
	public static MyPokemon myPokemon = new MyPokemon();
	public static EnemyPokemon enemyPokemon = new EnemyPokemon();
	public static RivalPokemon rivalPokemon = new RivalPokemon();		// ���̹� ���ϸ� Ŭ����
	
	public static  ArrayList<Thread> threads = new ArrayList<Thread>();
	public static  ArrayList<String> threadNames = new ArrayList<String>();
	
	//public static int RivalGrowUPCount = 0;							// ���̹� ���ϸ��� ����ī��Ʈ
	public static boolean isGameOver = false;
	
	public static long startTime;
	public static long endTime;
	
	public static boolean showPlayTime;
	
	public static boolean enterBattleMenu;
	
	// test variable
	public static int shareInt;
	public static boolean increaseCount; 
}
