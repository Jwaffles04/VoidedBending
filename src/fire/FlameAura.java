package fire;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import main.BaseAbility;

public class FlameAura extends BaseAbility {

	  private Player player;
	  private int t;

	  public FlameAura(Player player) {
	    this.player = player;
	    add(this);
	  }

	  @Override
	  public boolean progress() {
	    if (player == null || !player.isOnline() || player.isDead() || t > 5 * 20) {
	      return false;
	    }
	    // play effect.
	    for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
	      if (entity instanceof LivingEntity && !entity.equals(player)) {
	        // damage entity, or set them on fire for example.
	        entity.setFireTicks(5);
	      }
	    }
		return false;
	  }

	  @Override
	  public void stop() {
	    // we dont have a cooldown.
	  }

	}
