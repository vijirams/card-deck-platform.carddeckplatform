package carddeckplatform.game;

import war.War;
import logic.client.Game;

public class GameStatus {
	public static boolean isServer;
	public static String hostIp;
	public static String localIp;
	public static String username;
	public static int hostPort = 9997;
	public static Game game = new War();
	//public static int localPort = 9998;
}
