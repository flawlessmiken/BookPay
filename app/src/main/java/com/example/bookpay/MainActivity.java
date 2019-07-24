package com.example.bookpay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookpay.database.AppDatabase;
import com.example.bookpay.database.AppExecutors;
import com.example.bookpay.database.BookEntry;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BookPayAdapter.ItemClickListener {


    private AppDatabase mDb;
    private BookPayAdapter mBookPayAdapter;
    private RecyclerView mRecyclerView;
    private String openingTag =  "552";
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent  loadIntent = getIntent();
        if(loadIntent.hasExtra(Intent.EXTRA_TEXT)){
            openingTag = loadIntent.getStringExtra(Intent.EXTRA_TEXT);
        }

       toolbar.setTitle("MME ");

        mDb = AppDatabase.getInstance(getApplicationContext());

        LinearLayoutManager lm = new LinearLayoutManager(this);

        mRecyclerView = findViewById(R.id.recyclerViewTasks);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), lm.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        // Set the layout for the RecyclerView to be a linear layout, which measures and
        // positions mBookEntries within a RecyclerView into a linear list
        mRecyclerView.setLayoutManager(lm);

        // Initialize the adapter and attach it to the RecyclerView
        mBookPayAdapter = new BookPayAdapter(this, this);
        mRecyclerView.setAdapter(mBookPayAdapter);
    }


    public void setTagAndQuery(){

        switch (openingTag){
            case "540":
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        final List<BookEntry> bookEntries = mDb.mBookDao().loadMME540();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mBookPayAdapter.setBookEntries(bookEntries);
                            }
                        });
                    }
                });
                break;

            case "545":
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        final List<BookEntry> bookEntries = mDb.mBookDao().loadMME545();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mBookPayAdapter.setBookEntries(bookEntries);
                            }
                        });
                    }
                });
                break;
            case "552":
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        final List<BookEntry> bookEntries = mDb.mBookDao().loadMME552();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mBookPayAdapter.setBookEntries(bookEntries);
                            }
                        });
                    }
                });
                break;

            case "582":
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        final List<BookEntry> bookEntries = mDb.mBookDao().loadMME582();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mBookPayAdapter.setBookEntries(bookEntries);
                            }
                        });
                    }
                });
                break;

            case "IT_DEF":
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        final List<BookEntry> bookEntries = mDb.mBookDao().loadItDefensePaid();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mBookPayAdapter.setBookEntries(bookEntries);
                            }
                        });
                    }
                });
                break;

        }




    }



    @Override
    protected void onResume() {
        super.onResume();
        setTagAndQuery();
    }

    @Override
    public void onItemClickListener(int itemId) {

    }

    public void onAddButtonClicked(){
        Intent intent = new Intent(MainActivity.this,StudentSelectActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,openingTag);
        startActivity(intent);
    }

    public void addDummy(View view) {
        onAddButtonClicked();

    }
}






