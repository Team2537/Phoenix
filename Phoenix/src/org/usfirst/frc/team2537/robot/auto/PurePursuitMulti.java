package org.usfirst.frc.team2537.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PurePursuitMulti extends CommandGroup {
	public PurePursuitMulti(Vector2d[] nodes, boolean nodesAreRelative, double followDistance, double speed){
		for(int i = 0; i < nodes.length; i++){
			Vector2d node = nodes[i];
			if(i > 0 && !nodesAreRelative){
				node = Vector2d.add(node, Vector2d.flip(nodes[i-1]));
			}
			addSequential(new PurePursuit(node, followDistance, speed, false));
		}
	}
}
