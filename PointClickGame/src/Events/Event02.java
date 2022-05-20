package Events;

import pointclickgame.GameManager;


public class Event02 {
    
    GameManager gm;
    
    public Event02(GameManager gm){
        
        this.gm= gm;
    }
    
    public void lookCave(){
        gm.ui.messageText.setText("It's a cave!");
    } 
    public void talkCave(){
        gm.ui.messageText.setText("You hear the echo of your voice.");
    }
    public void enterCave(){
        if(gm.player.hasLantern==0){
            gm.ui.messageText.setText("It's too dark to enter");    
        }
        else{
            gm.sceneChanger.showScene3();
        }
        
    }
    public void lookRoot(){
        gm.ui.messageText.setText("It's a big tree.");
    }
    public void talkRoot(){
        gm.ui.messageText.setText("They say plant grows well if you talk them but this tree doesn't need that.");
    }
    public void searchRoot(){
        if(gm.player.hasLantern==0){
            gm.ui.messageText.setText("You find a candle!");
            gm.player.hasLantern=1;
            gm.playSoundEffect(gm.popSound);
            gm.player.updatePlayerStatus();
        }
        else{
            gm.ui.messageText.setText("There's nothing in there");
        }
        
    }





}

