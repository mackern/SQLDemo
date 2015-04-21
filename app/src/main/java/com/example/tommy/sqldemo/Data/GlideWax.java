package com.example.tommy.sqldemo.Data;

/**
 * Created by Tommy on 21/04/2015.
 */
public class GlideWax {
    private int _id;
    private String _producer;
    private String _name;
    private String _type;
    private String _comment;

    public GlideWax() {

    }
    public GlideWax(String Producer, String Name, String Type, String Comment) {
        this._producer = Producer;
        this._name = Name;
        this._type=Type;
        this._comment=Comment;
    }
    public void setID(int Id){
        this._id= Id;
    }
    public int getId(){
        return this._id;
    }
    public void setProducer(String Producer){ this._producer=Producer;}
    public String getProducer(){
        return this._producer;
    }
    public void setName(String Name){ this._name=Name;}
    public String getName(){
        return this._name;
    }
    public void setType(String Type){ this._type=Type;}
    public String getType() {
        return this._type;
    }
    public void setComment(String Comment){ this._comment=Comment;}
    public String getComment() {
        return this._comment;
    }
}
