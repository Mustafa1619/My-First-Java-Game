package pointclickgame;

import Events.Event01;
import Events.Event02;
import Events.Event03;
import java.net.URL;


public class GameManager {
    
    ActionHandler actionHandler = new ActionHandler(this);
    
    public UI ui= new UI(this);
    public Player player = new Player(this);
    public SceneChanger sceneChanger = new SceneChanger(this);
    
    public Event01 ev1 = new Event01(this);
    public Event02 ev2 = new Event02(this);
    public Event03 ev3 = new Event03(this);
    
    public BattleManager bm = new BattleManager(this);
    
    Music music = new Music();
    SoundEffect soundEffect = new SoundEffect();
    
    //sound
    public URL fieldMusic1 = getClass().getClassLoader().getResource("audio//roots-main-theme.wav");
    public URL fieldMusic2 = getClass().getClassLoader().getResource("audio//lobby-theme-nighttime.wav");
    public URL fieldMusic3 = getClass().getClassLoader().getResource("audio//darkness-march-alexandr-zhelanov.wav");
    public URL popSound = getClass().getClassLoader().getResource("audio//pop.wav");
    public URL gameOverSound = getClass().getClassLoader().getResource("audio//game-over.wav");
    public URL currentMusic;
    
    public static void main(String[] args) {
    
        new GameManager();
    }

    public GameManager(){
        currentMusic = fieldMusic1;
        playMusic(currentMusic);
        
        player.setPlayerDefaultStatus();
        sceneChanger.showScene1();
    }
    
    public void playSoundEffect(URL url){
        
        soundEffect.setFile(url);
        soundEffect.play(url);
    }
    
    public void playMusic(URL url){
        
        music.setFile(url);
        music.play(url);
        music.loop(url);
    }
    
    public void stopMusic(URL url){
        
        music.stop(url);
    }
}
