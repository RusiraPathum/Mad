package com.example.boadme;

public class Feedback {
    private  int id;
    private String customer_name,customer_email,customer_comment;
    private long started,finished;

    public Feedback(){

    }

    public Feedback(int id, String customer_name, String customer_email, String customer_comment,  long started, long finished) {
        this.id = id;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.customer_comment = customer_comment;
        this.started = started;
        this.finished = finished;
    }

    public Feedback( String customer_name, String customer_email, String customer_comment, long started, long finished) {
        this.customer_name= customer_name;
        this.customer_email = customer_email;
        this.customer_comment=customer_comment;
        this.started = started;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_comment() {
        return customer_comment;
    }

    public void setCustomer_comment(String customer_comment) {
        this.customer_comment = customer_comment;
    }


    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}


