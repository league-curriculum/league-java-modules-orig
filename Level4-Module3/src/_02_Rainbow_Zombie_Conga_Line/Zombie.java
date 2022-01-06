package _02_Rainbow_Zombie_Conga_Line;

public class Zombie {
    
    private ZombieHatColor hatColor;
    
    public Zombie (ZombieHatColor hatColor) {
        this.hatColor = hatColor;
    }
    
    public ZombieHatColor getZombieHatColor() {
        
        return hatColor;
    
    }
    
    @Override
    public String toString() {
        
        return hatColor + "-hatted zombie";
        
    }

}
