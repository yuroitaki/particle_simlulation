package simulation;

public class TwoParticleCollision extends Collision{
	
    public TwoParticleCollision(Particle p1, Particle p2, double time) {
	super(time, new Particle[] { p1, p2 });
    }

    @Override 
    public void happen(ParticleEventHandler h) {
	int 1stParticleIndex = 0;
	int 2ndParticleIndex = 1;
	Particle p1 = particleArr[1stParticleIndex];
	Particle p2 = particleArr[2ndParticleIndex];
	p1.collide(p1,p2);
	h.reactTo(this);
    }
}

