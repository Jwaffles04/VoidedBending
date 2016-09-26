package air;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import main.BaseAbility;

public class AirAura extends BaseAbility {

	  private Player player;
	  private int t;

	  public AirAura(Player player) {
	    this.player = player;
	    add(this);
	  }

	  @Override
	  public boolean progress() {
	    if (player == null || !player.isOnline() || player.isDead() || t > 5 * 20) {
	      return false;
	    }
	    //circle effect
	    //thingie effect
	    for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
	      if (entity instanceof LivingEntity && !entity.equals(player)) {
	        // Pushes Entity. Doesn't do anything 
	        entity.setVelocity(null);
	      }
	    }
		return false;
	  }

	  @Override
	  public void stop() {
	    // we dont have a cooldown.
	  }

	}
