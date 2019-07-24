/*
* Copyright (C) 2016 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.bookpay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.bookpay.database.BookEntry;
import com.example.bookpay.utils.ColorUtils;

import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * This BookPayAdapter creates and binds ViewHolders, that hold the description and priority of a task,
 * to a RecyclerView to efficiently display data.
 */
public class BookPayAdapter extends RecyclerView.Adapter<BookPayAdapter.BookPayViewHolder> {


    final private ItemClickListener mItemClickListener;
    // Class variables for the List that holds task data and the Context
    private List<BookEntry> mBookEntries;
    private Context mContext;
    int backgroundColorForViewHolder;

    /**
     * Constructor for the BookPayAdapter that initializes the Context.
     *
     * @param context  the current Context
     * @param listener the ItemClickListener
     */
    public BookPayAdapter(Context context, ItemClickListener listener) {
        mContext = context;
        mItemClickListener = listener;
    }

    /**
     * Called when ViewHolders are created to fill a RecyclerView.
     *
     * @return A new TaskViewHolder that holds the view for each task
     */
    @Override
    public BookPayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the task_layout to a view
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.entry_layout, parent, false);



        return new BookPayViewHolder(view);


    }

    /**
     * Called by the RecyclerView to display data at a specified position in the Cursor.
     *
     * @param holder   The ViewHolder to bind Cursor data to
     * @param position The position of the data in the Cursor
     */
    @Override
    public void onBindViewHolder(BookPayViewHolder holder, int position) {
        // Determine the values of the wanted data
        BookEntry bookEntry = mBookEntries.get(position);
        holder.StudentName.setText(bookEntry.getStudentName());
        holder.RegNo.setText(bookEntry.getStudentRegNo());
        holder.firstLetter.setText(String.valueOf(bookEntry.getStudentName().charAt(0)));


        Random random = new Random();
        int intRandom = random.nextInt(17);

        int backgroundColorForViewHolder = ColorUtils
                .getCircularImageBackgroundColorFromInstance(mContext, intRandom);
        holder.firstLetter.setTextColor(backgroundColorForViewHolder);
        holder.mCircleImageView.setBorderColor(backgroundColorForViewHolder);

    }




    /**
     * Returns the number of mBookEntries to display.
     */
    @Override
    public int getItemCount() {
        if (mBookEntries == null) {
            return 0;
        }
        return mBookEntries.size();
    }

    public void setBookEntries(List<BookEntry> bookEntries) {
        mBookEntries = bookEntries;
        notifyDataSetChanged();
    }

    public interface ItemClickListener {
        void onItemClickListener(int itemId);
    }

    // Inner class for creating ViewHolders
    class BookPayViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        // Class variables for the task description and priority TextViews
        TextView StudentName;
        TextView RegNo;
        CircleImageView mCircleImageView;
        TextView firstLetter;


        /**
         * Constructor for the TaskViewHolders.
         *
         * @param itemView The view inflated in onCreateViewHolder
         */
        public BookPayViewHolder(View itemView) {
            super(itemView);

            StudentName = itemView.findViewById(R.id.tvName);
            RegNo = itemView.findViewById(R.id.tvRegNo);
            firstLetter = itemView.findViewById(R.id.tv_firstLetter);
            mCircleImageView = (CircleImageView) itemView.findViewById(R.id.circle);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int elementId = mBookEntries.get(getAdapterPosition()).getId();
            mItemClickListener.onItemClickListener(elementId);
        }
    }
}