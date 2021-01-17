package org.itstep.customlist;

public class Student {
    private static int count;

    private final int id;
    private final String name;
    private final int photoId;
    private final String group;

    public Student(String name, int photoId, String group) {
        this.id = ++count;
        this.name = name;
        this.photoId = photoId;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getGroup() {
        return group;
    }
}
