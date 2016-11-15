package edu.bsuir.cinema.model;

/**
 * Created by Alesha on 01.10.2016.
 */
public class Picture {

    private int id;
    private String fileName;
    private String uploadedName;
    private int width;
    private int height;

    public Picture(){}

    public Picture(int id, String fileName, String uploadedName, int width, int height) {
        this.id = id;
        this.fileName = fileName;
        this.uploadedName = uploadedName;
        this.width = width;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadedName() {
        return this.uploadedName;
    }

    public void setUploadedName(String uploadedName) {
        this.uploadedName = uploadedName;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
