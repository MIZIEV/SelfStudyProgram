package DataBase;

public class StringFromDB {

    private final int index;
    private final String question;
    private final String answer;
    private boolean yesNo;

    public StringFromDB(int i, String q, String a, boolean YN) {
        this.index = i;
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

    @Override
    public String toString() {
        return index + " - " + question + '\'' + index + " - " + answer + '\'' + yesNo;
    }
}