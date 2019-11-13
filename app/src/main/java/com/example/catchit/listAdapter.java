package com.example.catchit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class listAdapter extends ArrayAdapter  {
    private Context mContext;
    //private DbHelper mDbHelper;
    private Fragment_list mFragment_list;

    public listAdapter(Context context, ArrayList<String> list, DbHelper dbHelper, Fragment_list fragment_list) {
        super(context, R.layout.row , list);
        mContext = context;
      //  mDbHelper = dbHelper;
        mFragment_list = fragment_list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.row,parent,false);

        final String currentwork = (String) getItem(position);

        TextView textView = convertView.findViewById(R.id.task_title);
        textView.setText(currentwork);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,TaskNote.class);
                intent.putExtra(TaskNote.EXTRA_MESSAGE,currentwork);
                mContext.startActivity(intent);
                mFragment_list.mAdapter.notifyDataSetChanged();
                mFragment_list.loadTaskList();
            }
        });
        return convertView;
    }
}
