package Events; 

import pointclickgame.GameManager;




public class Event01 {
    
    GameManager gm;
    
    public Event01(GameManager gm){
        this.gm = gm;
    }
    public void lookCottage(){
        gm.ui.messageText.setText("This is your house.");
    }
    public void talkCottage(){
        gm.ui.messageText.setText("Who are you talking to?");
    }
    public void restCottage(){
        if(gm.player.defeatWerewolf==true) {
            gm.sceneChanger.showEndScreen(1);
	}		 
	else {
        
        if(gm.player.playerLife!=gm.player.playerMaxLife){
            
            gm.ui.messageText.setText("You rest at the house.\nYour LIFE has recovered.");    
            gm.player.playerLife++;
            gm.player.updatePlayerStatus();
        }
        else{
            gm.ui.messageText.setText("Your life is full.");
        }
        }
    }
    public void lookKnight(){
        gm.ui.messageText.setText("A knight is standing front of you.");
    }
    public void talkKnight(){
        if(gm.player.hasShield==0){
            gm.ui.messageText.setText("Knight: Hey! Don't go any further.\n(You should check the chest over there.)");
        }
        else{
            gm.ui.messageText.setText("Knight: Just leave me alone.");
        }
    }
    public void attackKnight(){
        
        if(gm.player.hasShield==0){
            
            if(gm.player.hasSword==0){
                
                if(gm.player.playerLife!=1){
                    
                    gm.ui.messageText.setText("Knight: Hey! Don't be stupid!\nKnight hits you back and your life decreases by 1.");
                    gm.player.playerLife--;
//                    gm.player.updatePlayerStatus();
                }
                else if(gm.player.playerLife==1){
                    
                    gm.ui.messageText.setText("Knight: You fool...");
                    gm.player.playerLife--;
                    gm.sceneChanger.showGameOverScreen(1);
                    
//                    gm.player.updatePlayerStatus();
                }
            }
            else if(gm.player.hasSword==1){
                
                gm.ui.messageText.setText("Knight: Aah...\nYou've defeated the knight and gotten his shield!");
                gm.player.hasShield = 1;
                gm.playSoundEffect(gm.popSound);
            }
            gm.player.updatePlayerStatus();
        }
        else{
            gm.ui.messageText.setText("Knight: Just leave me alone.");
        }
        
        
    }
    public void lookChest(){
        gm.ui.messageText.setText("A chest is on the ground.");
    }
    public void talkChest(){
        gm.ui.messageText.setText("You talk to the chest but it says nothing.");
    }
    public void openChest(){
        if(gm.player.hasSword==0){
            
            gm.ui.messageText.setText("You open the chest and find a sword!");
            gm.player.hasSword=1;
            gm.player.updatePlayerStatus();
            gm.playSoundEffect(gm.popSound);
        }
        else{
            
            gm.ui.messageText.setText("There is nothing inside..");
        }
            }    
}
