/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Camnang {
    private int id;
    private int day;
    private String month;
    private String title;
    private String scriptShort;
    private String scriptFull;
    private String image;

    public Camnang() {
    }

    public Camnang(int id, int day, String month, String title, String scriptShort, String scriptFull, String image) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.title = title;
        this.scriptShort = scriptShort;
        this.scriptFull = scriptFull;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


 

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

  

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScriptShort() {
        return scriptShort;
    }

    public void setScriptShort(String scriptShort) {
        this.scriptShort = scriptShort;
    }

    public String getScriptFull() {
        return scriptFull;
    }

    public void setScriptFull(String scriptFull) {
        this.scriptFull = scriptFull;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Camnang{" + "id=" + id + ", day=" + day + ", month=" + month + ", title=" + title + ", scriptShort=" + scriptShort + ", scriptFull=" + scriptFull + ", image=" + image + '}';
    }


            
            
}
