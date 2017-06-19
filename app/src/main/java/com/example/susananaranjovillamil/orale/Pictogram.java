package com.example.susananaranjovillamil.orale;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

import java.util.UUID;

public class Pictogram {


    private String id, name, bodyPart, bodySubpart;
    private Integer imgid;



    public Pictogram (String bodyPart, String bodySubpart, String name, Integer imgid ){
        this.id= UUID.randomUUID().toString();
        this.bodyPart=bodyPart;
        this.bodySubpart=bodySubpart;
        this.name=name;
        this.imgid=imgid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getImgid() {
        return imgid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getBodySubpart() {
        return bodySubpart;
    }

    public void setBodySubpart(String bodySubpart) {
        this.bodySubpart = bodySubpart;
    }

}
