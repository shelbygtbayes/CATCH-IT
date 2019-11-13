package com.example.catchit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment_list extends Fragment implements View.OnClickListener {
    DbHelper dbHelper;
    ArrayAdapter mAdapter;
    ListView lstTask;
    private EditText itemET;
    private Button btn;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        dbHelper = new DbHelper(getActivity());
        lstTask = view.findViewById(R.id.lstTask);
        btn = view.findViewById(R.id.add_btn);
        btn.setOnClickListener(this);
        itemET = view.findViewById(R.id.item_edit_text);
        loadTaskList();
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        loadTaskList();
    }
    public void loadTaskList() {
        ArrayList<String> taskList = dbHelper.getTaskList();
        if (mAdapter == null) {
            mAdapter = new listAdapter(getActivity(), taskList, dbHelper, this);
            lstTask.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_btn:
                String taskEntered = itemET.getText().toString();
                if(taskEntered.length()==0)
                {
                    itemET.setText("");
                    Toast.makeText(getActivity(), "Please Enter Task", Toast.LENGTH_SHORT).show();
                }
                else {
                    dbHelper.insertNewTask(taskEntered);
                    itemET.setText("");
                    Toast.makeText(getActivity(), "Task Noted", Toast.LENGTH_SHORT).show();
                }
                loadTaskList();
                break;

        }
    }

}