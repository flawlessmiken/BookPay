package com.example.bookpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookpay.database.AppDatabase;
import com.example.bookpay.database.AppExecutors;
import com.example.bookpay.database.BookEntry;

import java.util.List;

public class StudentSelectActivity extends AppCompatActivity implements StudentListAdapter.OnClickAction {

    Activity activity = StudentSelectActivity.this;
    RecyclerView rv;
    StudentListAdapter adapter;
    ActionMode actionMode;
    AppDatabase mDb;
    Toolbar toolbar;
    List<BookEntry> selectedForModification;
    private String openingTag;

    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_add_selected:
                    alertDialog();
                    mode.finish();
                    return true;
                default:
                    toolbar.setVisibility(View.VISIBLE);
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_select);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getIntent().hasExtra(Intent.EXTRA_TEXT)) {
            openingTag = "isMme" + getIntent().getStringExtra(Intent.EXTRA_TEXT);
        }


        mDb = AppDatabase.getInstance(getApplicationContext());

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final int count = mDb.mBookDao().getAllBooksCount();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!(count > 1)) {
                            addStudentsToDb();
                        }
                    }
                });

            }
        });


        LinearLayoutManager lm = new LinearLayoutManager(this);
        adapter = new StudentListAdapter(this, this);

        rv = findViewById(R.id.rcView);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), lm.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);



        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<BookEntry> bookEntries = mDb.mBookDao().loadAllBooks();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.addAll(bookEntries);
                    }
                });
            }
        });

        //adapter.setActionModeReceiver((StudentListAdapter.OnClickAction) activity);


    }


    private String[] studentNames = {
            "Eze  Chioma Rachael",
            "Chukwu Ikenna Elias",
            "Abaeme Nkechi Augustia",
            "Onoduamu Chidimma Cynthia",
            "Muotune praise",
            "Omaku Timothy",
            "Joe Onura  Johnmarie",
            "Iwuoha Chukwuweike Tochukwu",
            "Agu Henry Maduabuchi",
            "Ugwu Collins Onyeka",
            "Ugwu Chukwuemeka Emmanuel",
            "Ozougwu Kenechukwu Charles",
            "Edward Chukwuemeka",
            "Ngwu Samuel Chilotam",
            "Ogbodo Emmanuel Ogochukwu",
            "Asadu Chikwado Emmanuel",
            "Omeh Christian Ogbonna",
            "Nebo Vincent Onyedika",
            "Edeh kenechukwu Kingsley",
            "Chime Chukwuebuka Johnpaul",
            "Chinawaeze Joshua Chukwuemeka",
            "Ani Chinazaekpere Francis",
            "Akogwu Emmanuel Nnaemeka",
            "Itsoko Bawo Williams",
            "Ejimkaraonye Alex Eyinnaya",
            "Anieke Amarachukwu John",
            "Okoli Ebube Rapuluchukwu",
            "Nwajagu Prisca Chiagozim",
            "Ogbe Kingsley Chukwuemeka",
            "Okolie Innocent Anayochukwu",
            "Ugwu Gibson Ebuka",
            "Ugwu Raymond Arinze",
            "Nwanduka Chukwuebuka Paul",
            "Ekwe Nkechi Dorathy",
            "Obunna Chibuike Stanley",
            "Ndukpu Ofobuike Emmanuel",
            "Nwankwo Uchenna Emmanuel",
            "Chukwu Felix Chiemelie",
            "Obiekwe Charles",
            "Nwalobu Eugene Hyginus",
            "Ogbodo Godwin Chijoke",
            "Enwena Chiamaka perpetual",
            "Udoetuk Richmond Effiong",
            "Eze fidelis Chijekwu",
            "Oforagazie Ebuka Osmund",
            "Adiebo Onyema Stephen",
            "Agundu Chukwuebuka Fransics",
            "Kpesu Israel Jesuminene",
            "Ikwuegbu Christopher Torty",
            "Okolie Evan Chukwuemerie",
            "Ngene Michael Onyedikachi",
            "Agulu Chigozie",
            "Ekoh Nnamdi Stanley"
    };

    private String[] studentReg = {

            "2015030171270",
            "2015030171272",
            "2015030171683",
            "2015030173679",
            "Esut /2014/158860",
            "Esut /2014/158861",
            "Esut /2014/146526",
            "Esut /2014/146527",
            "Esut /2014/146528",
            "Esut /2014/146529",
            "Esut /2014/146530",
            "Esut /2014/146531",
            "Esut /2014/146532",
            "Esut /2014/146533",
            "Esut /2014/146534",
            "Esut /2014/146535",
            "Esut /2014/146536",
            "Esut /2014/146537",
            "Esut /2014/146538",
            "Esut /2014/146539",
            "Esut /2014/146540",
            "Esut /2014/146541",
            "Esut /2014/146542",
            "Esut /2014/158850",
            "Esut /2014/158851",
            "Esut /2014/158852",
            "Esut /2014/158853",
            "Esut /2014/158854",
            "Esut /2014/158855",
            "Esut /2014/158856",
            "Esut /2014/158857",
            "Esut /2014/158858",
            "Esut /2014/158859",
            "Esut /2014/158862",
            "Esut /2014/158863",
            "Esut /2014/158864",
            "Esut /2014/158865",
            "Esut /2014/158866",
            "Esut /2014/158867",
            "Esut /2014/158868",
            "Esut /2014/158869",
            "Esut /2014/158877",
            "Esut /2014/158878",
            "Esut /2014/158879",
            "Esut /2014/158880",
            "Esut /2014/158881",
            "Esut /2014/158883",
            "Esut /2014/158885",
            "Esut /2014/158886",
            "Esut /2014/158889",
            "Esut /2014/160748",
            "Esut /2014/158888",
            "Esut /2012/137939"
    };

    public void addStudentsToDb() {
        for (int i = 0; i < studentNames.length; i++) {
            final BookEntry bookEntry = new BookEntry(studentNames[i], studentReg[i],
                    false, false, false, false,false);

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    mDb.mBookDao().addStudent(bookEntry);
                }
            });
        }
    }

    @Override
    public void onClickAction(int selected) {


        if (actionMode == null) {
            actionMode = startActionMode(actionModeCallback);
            actionMode.setTitle("Selected: " + selected);
            toolbar.setVisibility(View.GONE);
        } else {
            if (selected == 0) {
                toolbar.setVisibility(View.VISIBLE);
                actionMode.finish();

            } else {
                actionMode.setTitle("Selected: " + selected);
                toolbar.setVisibility(View.GONE);
            }
        }


    }


    private void modifySelectedBookEnteries() {
        selectedForModification = adapter.getSelected();


        for (int i = 0; i < selectedForModification.size(); i++) {
            final BookEntry bookEntry = selectedForModification.get(i);
            switch (openingTag) {
                case "isMme540":
                    bookEntry.setMme540(true);
                    break;

                case "isMme545":
                    bookEntry.setMme545(true);
                    break;
                case "isMme552":
                    bookEntry.setMme552(true);
                    break;

                case "isMme582":
                    bookEntry.setMme582(true);
                    break;

                case "isMmeIT_DEF":
                    bookEntry.setItDefense(true);
                    break;
            }

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    mDb.mBookDao().updateStudentBookPayment(bookEntry);
                }
            });

        }

    }



    private void alertDialog(){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("ADD Dialog")
                .setMessage("Register "+adapter.getSelected().size() + " Students")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        modifySelectedBookEnteries();
                        Toast.makeText(activity, adapter.getSelected().size() + " selected", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .setNegativeButton("Cancel",null)
                .show();
    }
}
