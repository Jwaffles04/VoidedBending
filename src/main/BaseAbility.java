package main;

import io.netty.util.internal.ConcurrentSet;

public abstract class BaseAbility {

	  private static final ConcurrentSet<BaseAbility> allInstances = new ConcurrentSet<BaseAbility>();

	  protected void add(BaseAbility ability) {
	    allInstances.add(ability);
	  }

	  protected abstract boolean progress();

	  protected abstract void stop();

	  public static void progressAll() {
	    for (BaseAbility ability : allInstances) {
	      if (!ability.progress()) {
	        ability.stop();
	        allInstances.remove(ability);
	      }
	    }
	  }

	  public static void removeAll() {
	    for (BaseAbility ability : allInstances) {
	      ability.stop();
	    }
	    allInstances.clear();
	  }

	}
	 
