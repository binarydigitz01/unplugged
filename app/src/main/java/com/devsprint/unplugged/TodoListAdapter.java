package com.devsprint.unplugged;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class TodoListAdapter extends ArrayAdapter<TodoItem> {

    private ArrayList<TodoItem> todos;
    Context mContext;
    public TodoListAdapter(ArrayList<TodoItem> todos,@NonNull Context context, int resource) {
        super(context, resource);
        this.todos = todos;
        mContext = context;
    }
}
