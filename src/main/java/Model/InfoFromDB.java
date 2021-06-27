package Model;

public class InfoFromDB {

    private final int index;
    private final String question;
    private final String answer;
    private final String theme;
    private boolean yesNo;

    public InfoFromDB(int i, String t, String q, String a, boolean YN) {
        this.index = i;
        this.theme = t;
        this.question = q;
        this.answer = a;
        this.yesNo = YN;
    }

    public boolean getYesNo() {
        return yesNo;
    }

    public void setYesNo(boolean yesNo) {
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
        return theme + " " + index + " - " + question+"\n";
    }
}