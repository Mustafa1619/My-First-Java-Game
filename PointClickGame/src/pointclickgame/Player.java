package pointclickgame;


public class Player {
    
    GameManager gm;
    
    public int playerMaxLife;
    public int playerLife;
    public int playerStrength = 3;
    public int playerEndurance = 1;
    public int playerAttack;
    public int playerDefense;

    public int hasSword;
    public int hasShield;
    public int hasLantern;
    public int weaponPower;
    public int shieldPower;
    
    public boolean defeatWerewolf = false;    
    
    
    
    public Player(GameManager gm){
        
        this.gm = gm;
        
        
    }
    
    public void setPlayerDefaultStatus(){
        
        playerMaxLife = 5;
        playerLife = 2;
        playerStrength = 3;
	playerEndurance = 1;
        hasSword = 0;
        hasShield = 0;
        hasLantern = 0;
        weaponPower=1;
        shieldPower=1;
        
        defeatWerewolf = false;
        
        updatePlayerStatus();
        
    }
        
    public void updatePlayerStatus(){
        
        int i = 1;
        while(i<6){
            
            gm.ui.lifeLabel[i].setVisible(false);
            i++;
        
        }
        
        int lifeCount = playerLife;
        while(lifeCount!=0){
            
            gm.ui.lifeLabel[lifeCount].setVisible(true);
            lifeCount--;
            
        }
        
        playerAttack = playerStrength + weaponPower;
	playerDefense = playerEndurance + shieldPower;
                
        //Check Items
        if(hasSword==0){
            gm.ui.swordLabel.setVisible(false);
        }
        else if(hasSword==1){
            gm.ui.swordLabel.setVisible(true);
        }
    
        if(hasShield==0){
            gm.ui.shieldLabel.setVisible(false);
        }
        else if(hasShield==1){
            gm.ui.shieldLabel.setVisible(true);
        }
        
        if(hasLantern==0){
            gm.ui.lanternLabel.setVisible(false);
        }
        else if(hasLantern==1){
            gm.ui.lanternLabel.setVisible(true);
        }
    }
    
}
