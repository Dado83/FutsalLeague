package dp.futsal.service;


public class TeamForm {

    private int id;
    private String teamName;
    private String teamCity;
    private String kitColor;
    private String venue;
    private String gameTime;

    public TeamForm() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getKitColor() {
        return kitColor;
    }

    public void setKitColor(String kitColor) {
        this.kitColor = kitColor;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }

}
