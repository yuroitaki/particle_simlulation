package simulation;

public class ParticleWallCollision extends Collision{
	
    private Wall wall;
    
    public ParticleWallCollision(Particle p, Wall w, double time) {
	super(time, new Particle[] { p });
	wall = w;
    }

    @Override 
    public void happen(ParticleEventHandler h) {
	int firstParticleIndex = 0;
	Particle p = particleArr[firstParticleIndex];
	p.collide(p,wall);      // update the particle's state
	h.reactTo(this);
    }
}
