package main;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AbilityManager extends BukkitRunnable {

	  public AbilityManager(Plugin plugin) {
		runTaskTimer(plugin, 0, 1);
	  }

	  @Override
	  public void run() {
	    BaseAbility.progressAll();
	  }

	  @Override
	  public void cancel() {
	    super.cancel();
	    BaseAbility.removeAll();
	  }

	}
