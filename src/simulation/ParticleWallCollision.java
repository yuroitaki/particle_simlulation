package simulation;

public class ParticleWallCollision extends Collision{
	
    private Wall wall;
    
    public ParticleWallCollision(Particle p, Wall w, double time) {
	super(time, new Particle[] { p });
	wall = w;
    }

    @Override 
    public void happen(ParticleEventHandler h) {
	int 1stParticleIndex = 0;
	Particle p = particleArr[1stParticleIndex];
	p.collide(p,wall);
	h.reactTo(this);
    }
}
