package DataBase;

public class StringFromDB {

    private int index;
    private String question;
    private String answer;
    private boolean yesNo;


    public StringFromDB(int i, String q, String a, boolean YN) {
        this.index = i;
        this.question = q;
        this.answer = a;
        this.yesNo = YN;
    }

    public boolean isYesNo() {
        return yesNo;
    }

    public void setYesNo(boolean yesNo) {
        this.yesNo = yesNo;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return index + " - " + question + '\'' + index + " - " + answer + '\'';
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
}
