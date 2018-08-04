package me.zombie_striker.qg.handlers.chargers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.zombie_striker.qg.Main;
import me.zombie_striker.qg.guns.Gun;
import me.zombie_striker.qg.guns.utils.WeaponSounds;

public class PumpactionCharger implements ChargingHandler {

	List<UUID> timeC = new ArrayList<>();
	List<UUID> timeR = new ArrayList<>();
public PumpactionCharger() {
	ChargingManager.add(this);
}
	@Override
	public boolean isCharging(Player player) {
		return timeC.contains(player.getUniqueId());
	}

	@Override
	public boolean shoot(Gun g, final Player player, ItemStack stack) {
		timeC.add(player.getUniqueId());

		new BukkitRunnable() {
			@Override
			public void run() {
				try {
					/*
					 * player.getWorld().playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 8,
					 * 1.4f); player.getWorld().playSound(player.getLocation(),
					 * Sound.BLOCK_SAND_BREAK, 8, 1.4f);
					 */
					player.getWorld().playSound(player.getLocation(), WeaponSounds.RELOAD_BULLET.getName(), 1, 1f);
				} catch (Error e) {
					try {
					player.getWorld().playSound(player.getLocation(), Sound.valueOf("CLICK"), 8, 1.4f);
					player.getWorld().playSound(player.getLocation(), Sound.valueOf("DIG_SAND"), 8, 1.4f);
					}catch(Error|Exception e43) {}
				}
			}
		}.runTaskLater(Main.getInstance(), 12);
		new BukkitRunnable() {
			@Override
			public void run() {
				try {
					player.getWorld().playSound(player.getLocation(), WeaponSounds.RELOAD_BOLT.getName(), 1,
							1f);/*
								 * player.getWorld().playSound(player.getLocation(), Sound.BLOCK_SAND_BREAK, 8,
								 * 1.4f); player.getWorld().playSound(player.getLocation(),
								 * Sound.BLOCK_LEVER_CLICK, 8, 1);
								 */
				} catch (Error e) {try {
					player.getWorld().playSound(player.getLocation(), Sound.valueOf("DIG_SAND"), 8, 1.4f);
					player.getWorld().playSound(player.getLocation(), Sound.valueOf("CLICK"), 8, 1);
				}catch(Error|Exception e43) {}

				}
			}
		}.runTaskLater(Main.getInstance(), 16);
		new BukkitRunnable() {
			@Override
			public void run() {
				timeC.remove(player.getUniqueId());
			}
		}.runTaskLater(Main.getInstance(), 20);
		return true;
	}


	@Override
	public String getName() {

		return ChargingManager.PUMPACTION;
	}

}
