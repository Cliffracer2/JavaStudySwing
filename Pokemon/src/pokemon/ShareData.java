package pokemon;

import java.util.ArrayList;
import java.util.Scanner;

// 스레드간의 데이터를 공유하기 위해 만든 클래스
public class ShareData 
{
	public static Scanner scanUserInput = new Scanner(System.in);	// Scanner 클래스
	public static Scanner battleInput = new Scanner(System.in);		// Scanner 클래스
	public static Pokemon pokemon = new Pokemon();
	public static Trainer trainer = new Trainer();
	public static Battle battle = new Battle();
	public static Player player = new Player();						// 플레이어 클래스
	public static MyPokemon myPokemon = new MyPokemon();
	public static EnemyPokemon enemyPokemon = new EnemyPokemon();
	public static RivalPokemon rivalPokemon = new RivalPokemon();		// 러이벌 포켓몬 클래스
	
	public static  ArrayList<Thread> threads = new ArrayList<Thread>();
	public static  ArrayList<String> threadNames = new ArrayList<String>();
	
	//public static int RivalGrowUPCount = 0;							// 라이벌 포켓몬의 성장카운트
	public static boolean isGameOver = false;
	
	public static long startTime;
	public static long endTime;
	
	public static boolean showPlayTime;
	
	public static boolean enterBattleMenu;
	
	// test variable
	public static int shareInt;
	public static boolean increaseCount; 
}
