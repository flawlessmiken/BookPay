package com.example.bookpay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookpay.database.BookEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flawless on 11/13/2018.
 */

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.RecyclerViewHolder>{


    Context context;
    LayoutInflater inflater;
    List<BookEntry> mBookEntries, selected;



    public interface OnClickAction {
        public void onClickAction(int position);
    }

    final private OnClickAction mItemClickListener;

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv,tvReg;
        CheckBox mCheckBox;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            tvReg = (TextView) itemView.findViewById(R.id.tvRegNo);
            mCheckBox = (CheckBox)itemView.findViewById(R.id.checkBox);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


        }
    }

    public StudentListAdapter(Context context, OnClickAction itemClickListener) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        mItemClickListener = itemClickListener;
        this.selected = new ArrayList<>();
        this.mBookEntries = new ArrayList<>();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.single_student, parent, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        viewHolder.setIsRecyclable(false);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        final BookEntry studentName = mBookEntries.get(position);
        holder.tv.setText(studentName.getStudentName());
        holder.tv.setTag(holder);
        holder.tvReg.setText(studentName.getStudentRegNo());
        holder.mCheckBox.setChecked(selected.contains(studentName));


        holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {



                if (selected.contains(studentName)) {
                    selected.remove(studentName);
                    unhighlightView(holder);
                    holder.mCheckBox.setChecked(false);

                } else {
                    selected.add(studentName);
                    highlightView(holder);
                    holder.mCheckBox.setChecked(true);

                }
                int selectedSize =selected.size();
                mItemClickListener.onClickAction(selectedSize);
            }
        });

        if (selected.contains(studentName))
            highlightView(holder);
        else
            unhighlightView(holder);
    }

    public void addAll(List<BookEntry> items) {
        this.mBookEntries = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mBookEntries.size();
    }

    private void highlightView(RecyclerViewHolder holder) {
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorListSelect));
    }

    private void unhighlightView(RecyclerViewHolder holder) {
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
    }



    public List<BookEntry> getSelected() {
        return selected;
    }



}
