package org.itstep.listsdemo;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.SparseBooleanArray;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        mListView = findViewById(R.id.listView);
        items = new ArrayList<>();

//        mListView.setChoiceMode(ListView.CHOICE_MODE_NONE);
//        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,
//                android.R.layout.simple_list_item_single_choice,
                android.R.layout.simple_list_item_multiple_choice,
                items);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener((parent, view, position, id) ->
                Snackbar.make(mListView, position+ ": " + items.get(position), Snackbar.LENGTH_SHORT)
                .show());

//        int checkedItemPosition = mListView.getCheckedItemPosition();
        SparseBooleanArray checkedItemPositions = mListView.getCheckedItemPositions();

        fab.setOnClickListener(view -> {
            items.add("item " + (items.size() + 1));
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}