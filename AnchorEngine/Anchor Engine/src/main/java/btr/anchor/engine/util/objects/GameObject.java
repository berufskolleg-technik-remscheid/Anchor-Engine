package btr.anchor.engine.util.objects;

import btr.anchor.engine.util.math.vector.Vector2D;
import btr.anchor.engine.util.position.Position2D;

public abstract class GameObject implements Movable {

	Position2D position;
	Vector2D direction;
	int mass;

	@Override
	public void move(Position position) {
		
	}
	
	
}