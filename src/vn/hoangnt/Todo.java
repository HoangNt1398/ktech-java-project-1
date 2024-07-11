package vn.hoangnt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
    private String title;
    private Date untilDate;
    private boolean done;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(Date untilDate) {
        this.untilDate = untilDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Todo(String title, Date untilDate){
        this.title = title;
        this.untilDate = untilDate;
        this.done = false;
    }

    public static Date parseDate(String date) throws IllegalArgumentException{
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(date);
        }catch (ParseException e) {
            throw new IllegalArgumentException("untilDate 다시 입력하세요!yyyy-MM-dd 체재 입력하세요!" );
        }
    }

    @Override
    public String toString() {
        return title + ";" + dateFormat.format(untilDate) + ";" + done;
    }

    public static Todo fromSting(String todoString) {
        String[] parts = todoString.split(";");
        if (parts.length != 3) throw new IllegalArgumentException("Invalid TODO format in file.");
        Todo todo = new Todo(parts[0], parseDate(parts[1]));
        todo.setDone(Boolean.parseBoolean(parts[2]));
        return todo;
    }
}
