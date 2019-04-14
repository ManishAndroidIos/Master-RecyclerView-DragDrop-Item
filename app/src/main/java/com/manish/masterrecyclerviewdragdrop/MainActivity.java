package com.manish.masterrecyclerviewdragdrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.manish.masterrecyclerviewdragdrop.Adapter.RecyclerViewAdapterDragDrop;
import com.manish.masterrecyclerviewdragdrop.Interface.DragDropListener;
import com.manish.masterrecyclerviewdragdrop.Interface.ItemCallbackMove;
import com.manish.masterrecyclerviewdragdrop.Model.DataModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DragDropListener {
    RecyclerView recyclerView;
    RecyclerViewAdapterDragDrop recyclerViewAdapterDragDrop;
    ArrayList<String> stringArrayList = new ArrayList<>();
    ItemTouchHelper touchHelper;
    ArrayList<DataModel> dataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        dataModels= new ArrayList<>();
        RecyclerViewDataModel();
    }




    private void RecyclerViewDataModel() {
        dataModels.add(new DataModel("Alpha", "Android 1.0", "1","September 23, 2008",R.drawable.one));
        dataModels.add(new DataModel("Beta", "Android 1.1", "2","February 9, 2009",R.drawable.two));
        dataModels.add(new DataModel("Cupcake", "Android 1.5", "3","April 27, 2009",R.drawable.cupcake));
        dataModels.add(new DataModel("Donut","Android 1.6","4","September 15, 2009",R.drawable.donut));
        dataModels.add(new DataModel("Eclair", "Android 2.0", "5","October 26, 2009",R.drawable.eclair));
        dataModels.add(new DataModel("Froyo", "Android 2.2", "8","May 20, 2010",R.drawable.froyo));
        dataModels.add(new DataModel("Gingerbread", "Android 2.3", "9","December 6, 2010",R.drawable.gingerbread));
        dataModels.add(new DataModel("Honeycomb","Android 3.0","11","February 22, 2011",R.drawable.honeycomb));
        dataModels.add(new DataModel("Ice Cream Sandwich", "Android 4.0", "14","October 18, 2011",R.drawable.ics));
        dataModels.add(new DataModel("Jelly Bean", "Android 4.2", "16","July 9, 2012",R.drawable.jellybean));
        dataModels.add(new DataModel("Kitkat", "Android 4.4", "19","October 31, 2013",R.drawable.kitkat));
        dataModels.add(new DataModel("Lollipop","Android 5.0","21","November 12, 2014",R.drawable.lollipop));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015",R.drawable.marsh));
        dataModels.add(new DataModel("Nougat", "Android 7.0", "24","August 22, 2016",R.drawable.nougat));
        dataModels.add(new DataModel("Oreo", "Android 8.1", "27","March 21, 2017",R.drawable.oreo));
        dataModels.add(new DataModel("Pie", "Android 9", "27","March 7, 2018",R.drawable.pie));

        recyclerViewAdapterDragDrop = new RecyclerViewAdapterDragDrop(this,dataModels,this);

        ItemTouchHelper.Callback callback =
                new ItemCallbackMove(recyclerViewAdapterDragDrop);
        touchHelper  = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(recyclerViewAdapterDragDrop);
    }

    @Override
    public void requestDrag(RecyclerView.ViewHolder viewHolder) {
        touchHelper.startDrag(viewHolder);
    }



}
