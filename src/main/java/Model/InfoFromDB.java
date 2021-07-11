package Model;

public class InfoFromDB {

    private final int index;
    private final String question;
    private final String answer;
    private final String theme;
    private int yesNo;

    public InfoFromDB(int i, String t, String q, String a, int YN) {
        this.index = i;
        this.theme = t;
        this.question = q;
        this.answer = a;
        this.yesNo = YN;
    }

    public int getYesNo() {
        return yesNo;
    }

    public void setYesNo(int yesNo) {
        this.yesNo = yesNo;
    }

    public int getIndex() {
        return index;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return theme + " " + index + " - " + question+" YN - "+yesNo+"\n";
    }
}