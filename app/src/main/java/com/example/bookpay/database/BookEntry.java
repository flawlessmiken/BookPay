package com.example.bookpay.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by Flawless on 11/12/2018.
 */
@Entity(tableName = "studentBook")
public class BookEntry {
    @PrimaryKey(autoGenerate = true)
    private  int id;
    private String mStudentName;
    private String mStudentRegNo;
    private boolean isMme540;
    private boolean isMme552;
    private boolean isMme545;
    private boolean isMme582;
    private boolean isItDefense;

    @Ignore
    public BookEntry(String studentName,String studentRegNo, boolean Mme540, boolean Mme552, boolean Mme545, boolean Mme582, boolean ItDefense){
        this.mStudentName = studentName;
        this.mStudentRegNo = studentRegNo;
        this.isMme540 = Mme540;
        this.isMme552 = Mme552;
        this.isMme545= Mme545;
        this.isMme582 = Mme582;
        this.isItDefense = ItDefense;

    }

    public BookEntry(int id, String studentName,String studentRegNo, boolean Mme540, boolean Mme552, boolean Mme545, boolean Mme582,  boolean ItDefense){
        this.id = id;
        this.mStudentName = studentName;
        this.mStudentRegNo = studentRegNo;
        this.isMme540 = Mme540;
        this.isMme552 = Mme552;
        this.isMme545= Mme545;
        this.isMme582 = Mme582;
        this.isItDefense = ItDefense;
    }

    public BookEntry(){}


    public int getId() {
        return id;
    }

    public String getStudentName() {
        return mStudentName;
    }

    public void setStudentName(String studentName) {
        mStudentName = studentName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentRegNo() {
        return mStudentRegNo;
    }

    public void setStudentRegNo(String studentRegNo) {
        mStudentRegNo = studentRegNo;
    }

    public boolean isMme540() {
        return isMme540;
    }

    public void setMme540(boolean mme540) {
        isMme540 = mme540;
    }

    public boolean isMme552() {
        return isMme552;
    }

    public void setMme552(boolean mme552) {
        isMme552 = mme552;
    }

    public boolean isMme545() {
        return isMme545;
    }

    public void setMme545(boolean mme545) {
        isMme545 = mme545;
    }

    public boolean isMme582() {
        return isMme582;
    }

    public void setMme582(boolean mme582) {
        isMme582 = mme582;
    }

    public boolean isItDefense() {
        return isItDefense;
    }

    public void setItDefense(boolean itDefense) {
        isItDefense = itDefense;
    }
}
