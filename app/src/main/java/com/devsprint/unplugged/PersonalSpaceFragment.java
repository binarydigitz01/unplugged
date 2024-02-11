package com.devsprint.unplugged;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalSpaceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalSpaceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    public PersonalSpaceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PersonalSpaceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonalSpaceFragment newInstance(String param1, String param2) {
        PersonalSpaceFragment fragment = new PersonalSpaceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private ImageButton todo_button;
    private EditText todo_input;
    private ListView todo_list;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> todos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_space, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        ImageView imageView = (ImageView) getView().findViewById(R.id.foo);
        todo_button = getView().findViewById(R.id.add_todo_btn);
        todo_input = getView().findViewById(R.id.todo_input);
        todo_list = getView().findViewById(R.id.todo_list);
        todos = new ArrayList<String>();

        arrayAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, todos );
        todo_list.setAdapter(arrayAdapter);

        todo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = todo_input.getText().toString();
                todo_input.setText("");
                todos.add(text);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        setupListViewListener();

    }

    private void setupListViewListener() {
        todo_list.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        todos.remove(pos);
                        // Refresh the adapter
                        arrayAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }

                });
    }
}