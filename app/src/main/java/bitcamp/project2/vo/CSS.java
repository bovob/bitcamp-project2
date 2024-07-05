package bitcamp.project2.vo;

public class CSS {
    //ANSI SET
    public String dotCode = "\u25AE";
    public String redAnsi = "\033[31m";
    public String resetAnsi = "\033[0m";
    public String blueAnsi = "\033[94m";
    public String boldAnsi = "\033[1m";
    public String yellowAnsi = "\033[93m";
    public String line = "----------------------------------";
    public String longLine = "----------------------------------------------------------------------";

    public String boldRedAnsi    = (boldAnsi)+(redAnsi);
    public String boldBlueAnsi   = (boldAnsi)+(blueAnsi);
    public String boldYellowAnsi = (boldAnsi)+(yellowAnsi);
    public String boldLine       = (boldAnsi)+(line);
    public String boldLongLine       = (boldAnsi)+(longLine);

}
