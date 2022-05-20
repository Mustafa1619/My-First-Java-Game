/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointclickgame;

import java.security.PublicKey;

/**
 *
 * @author Gaming-3
 */
public class SceneChanger {
    
    GameManager gm;
    
    public SceneChanger(GameManager gm){
        
        this.gm = gm;  
    }
    
    public void showScene1(){
        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.fieldMusic1;
        gm.playMusic(gm.currentMusic);
        
        gm.ui.backgroundPanel[1].setVisible(true);
        gm.ui.backgroundPanel[2].setVisible(false);
        gm.ui.messageText.setText("Let's kill the monster and save the town.");
    }
    
    public void showScene2(){
        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.fieldMusic2;
        gm.playMusic(gm.currentMusic);
        
        gm.ui.backgroundPanel[1].setVisible(false);
        gm.ui.backgroundPanel[2].setVisible(true);
        gm.ui.backgroundPanel[3].setVisible(false);
        gm.ui.messageText.setText("");
    }
    
    public void showScene3(){
        if(gm.player.defeatWerewolf==false){
            gm.stopMusic(gm.currentMusic);
            gm.currentMusic = gm.fieldMusic3;
            gm.playMusic(gm.currentMusic);
        }
        
        
        gm.ui.backgroundPanel[2].setVisible(false);
        gm.ui.backgroundPanel[3].setVisible(true);
        
        gm.ui.messageText.setText("You entered the cave..");
    }
    
    public void showGameOverScreen(int currentBackgroundNum){
        
        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.gameOverSound;
        gm.playSoundEffect(gm.currentMusic);
        
        gm.ui.backgroundPanel[currentBackgroundNum].setVisible(false);
        gm.ui.titleLabel.setVisible(true);  
        gm.ui.titleLabel.setText("YOU DIED");
        gm.ui.restartButton.setVisible(true);
        gm.ui.restartButton.setText("Click here to restart");
    }
    
    public void restartGame(){
        
        gm.ui.titleLabel.setVisible(false);
        gm.ui.restartButton.setVisible(false);
        gm.player.setPlayerDefaultStatus();

    }
    
    public void showEndScreen(int currentBackgroundNum) {
		
        gm.ui.backgroundPanel[currentBackgroundNum].setVisible(false);
        gm.ui.titleLabel.setVisible(true);
        gm.ui.titleLabel.setText("Congratz!");
        gm.ui.messageText.setText("You have completed the game!");
    }
    
    
    
    
}
