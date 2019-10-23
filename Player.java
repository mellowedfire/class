/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gear5
 */
public class Player {
    private String name;
    private String team;
    private String atBats;
    private String hits;
    
  public Player() {
        this.name = "";
        this.team = "";
        this.atBats = "";
        this.hits = "";
        
    }
  
   public Player(String name, String team, String atBats, String hits) {
        this.name = name;
        this.team = team;
        this.atBats = atBats;
        this.hits = hits;
        
    }
    
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getatBats() {
        return atBats;
    }

    public void setatBats(String atBats) {
        this.atBats = atBats;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }



   
    
    
    
}

