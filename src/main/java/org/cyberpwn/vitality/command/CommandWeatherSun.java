package org.cyberpwn.vitality.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberpwn.vitality.feature.Feature;

public class CommandWeatherSun extends VitalCommand
{
	public CommandWeatherSun(Feature f)
	{
		super("vsun", f, "/sun [ticks]", "Set the world to sunny");
	}
	
	@Override
	public boolean onCommand(String[] arg, CommandSender sender)
	{
		if(arg.length == 0)
		{
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				
				try
				{
					p.getWorld().setStorm(false);
					f.getFeatureWeather().setWeatherTime(p.getWorld(), Integer.valueOf(12000 * 10));
					send(p, (p.getWorld().hasStorm() ? "Storms" : "Sun") + " in " + p.getWorld().getName() + " will continue for " + f.getFeatureWeather().getWeather(p.getWorld()) / 20 / 60 + " minutes.");
				}
				
				catch(Exception e)
				{
					
				}
			}
			
			else
			{
				send(sender, "Player only");
			}
		}
		
		else if(arg.length == 1)
		{
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				
				try
				{
					p.getWorld().setStorm(false);
					f.getFeatureWeather().setWeatherTime(p.getWorld(), Integer.valueOf(arg[0]));
					send(p, (p.getWorld().hasStorm() ? "Storms" : "Sun") + " in " + p.getWorld().getName() + " will continue for " + f.getFeatureWeather().getWeather(p.getWorld()) / 20 / 60 + " minutes.");
				}
				
				catch(Exception e)
				{
					sendInvalidArgument(sender, arg[0]);
				}
			}
			
			else
			{
				send(sender, "Player only");
			}
		}
		
		else
		{
			sendUsage(sender);
		}
		
		return true;
	}
}
