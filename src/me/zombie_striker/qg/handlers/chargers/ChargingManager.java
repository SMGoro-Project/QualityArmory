package me.zombie_striker.qg.handlers.chargers;

import java.util.HashMap;

public class ChargingManager {

	
	public static String BOLT = "BoltAction";
	public static String REVOLVER = ("Revolver");
	public static String PUMPACTION = ("PumpAction");
	public static String BREAKACTION = ("BreakAction");
	public static String RPG = ("SingleRPG");
	public static String MININUKELAUNCHER = ("MininukeLauncher");
	public static String HOMINGRPG = ("HomingRPG");
	public static String BURSTFIRE = ("BurstFire");
	public static String PUSHBACK = "PushBackCharger";

	public static HashMap<String, ChargingHandler> handlers = new HashMap<>();

	public static void add(ChargingHandler c) {
		handlers.put(c.getName(), c);
	}

	public static ChargingHandler getHandler(String name) {
		return handlers.get(name);
	}
}
