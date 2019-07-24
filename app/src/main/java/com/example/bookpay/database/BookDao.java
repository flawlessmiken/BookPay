package com.example.bookpay.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by Flawless on 11/12/2018.
 */
@Dao
public interface BookDao {

    @Query("SELECT COUNT(mStudentName) FROM studentBook")
    int getAllBooksCount();

    @Query("SELECT * FROM studentBook ORDER BY mStudentName")
    List<BookEntry>loadAllBooks();

    @Query("SELECT * FROM studentBook WHERE :column = 1 ORDER BY mStudentName")
    List<BookEntry>loadAllBooksByColumnPassed(String column);

    @Query("SELECT * FROM studentBook WHERE isMme540 = 1 ORDER BY mStudentName")
    List<BookEntry>loadMME540();

    @Query("SELECT * FROM studentBook WHERE isMme545 = 1 ORDER BY mStudentName")
    List<BookEntry>loadMME545();

    @Query("SELECT * FROM studentBook WHERE isMme552 = 1 ORDER BY mStudentName")
    List<BookEntry>loadMME552();

    @Query("SELECT * FROM studentBook WHERE isItDefense = 1 ORDER BY mStudentName")
    List<BookEntry>loadItDefensePaid();

    @Query("SELECT * FROM studentBook WHERE isMme582 = 1 ORDER BY mStudentName")
    List<BookEntry>loadMME582();


    @Insert
    void addStudent(BookEntry bookEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateStudentBookPayment(BookEntry bookEntry);
}
