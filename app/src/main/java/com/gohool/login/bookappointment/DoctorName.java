package com.gohool.login.bookappointment;

class DoctorName {
    private String name;
    private int img;
    private String speciality;

    public DoctorName(String name, int img, String speciality) {
        this.name = name;
        this.img = img;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
