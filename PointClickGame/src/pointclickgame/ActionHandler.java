
package pointclickgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionHandler implements ActionListener{
    
    GameManager gm;
     
    public ActionHandler(GameManager gm){
        
        this.gm = gm;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();
        
        switch (yourChoice){
            //scene 1
            case "lookCottage": gm.ev1.lookCottage(); break;
            case "talkCottage": gm.ev1.talkCottage(); break;
            case "restCottage": gm.ev1.restCottage(); break;        
            case "lookKnight": gm.ev1.lookKnight(); break;        
            case "talkKnight": gm.ev1.talkKnight(); break;        
            case "attackKnight": gm.ev1.attackKnight(); break;
            case "lookChest": gm.ev1.lookChest(); break;        
            case "talkChest": gm.ev1.talkChest(); break;        
            case "openChest": gm.ev1.openChest(); break;        
            
            //scene 2
            case "lookCave": gm.ev2.lookCave(); break;
            case "talkCave": gm.ev2.talkCave(); break;
            case "enterCave": gm.ev2.enterCave(); break;
            case "lookRoot": gm.ev2.lookRoot(); break;
            case "talkRoot": gm.ev2.talkRoot(); break;
            case "searchRoot": gm.ev2.searchRoot(); break;
            
            //scene 3
            case "lookMonster": gm.ev3.lookMonster();break;
            case "talkMonster": gm.ev3.talkMonster();break;
            case "attackMonster": gm.ev3.attackMonster();break;

            //change scenes
            case "goScene1": gm.sceneChanger.showScene1(); break;
            case "goScene2": gm.sceneChanger.showScene2(); break;
            case "restart": gm.sceneChanger.restartGame(); gm.sceneChanger.showScene1(); break;
        
        }
    
    
    
    }
}