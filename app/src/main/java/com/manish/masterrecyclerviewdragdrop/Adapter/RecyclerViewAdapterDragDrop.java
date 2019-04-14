package com.manish.masterrecyclerviewdragdrop.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.manish.masterrecyclerviewdragdrop.Interface.DragDropListener;
import com.manish.masterrecyclerviewdragdrop.Interface.ItemCallbackMove;
import com.manish.masterrecyclerviewdragdrop.Model.DataModel;
import com.manish.masterrecyclerviewdragdrop.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;

public class RecyclerViewAdapterDragDrop extends RecyclerView.Adapter<RecyclerViewAdapterDragDrop.MyViewHolder> implements ItemCallbackMove.ItemTouchHelperContract {

    private ArrayList<DataModel> data;
    private final DragDropListener mdragDropListener;
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mversion_name,mversion_code,mversion_release_date,version_type;
        View rowView;
        ImageView mversion_image;
        LinearLayout relativeLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            rowView = itemView;
            mversion_name = itemView.findViewById(R.id.version_name);
            mversion_code = itemView.findViewById(R.id.version_code);
            mversion_release_date = itemView.findViewById(R.id.version_release_date);
            mversion_image = itemView.findViewById(R.id.version_image);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            version_type = itemView.findViewById(R.id.version_type);
        }
    }

    public RecyclerViewAdapterDragDrop(Context context, ArrayList<DataModel> data, DragDropListener dragDropListener) {
        mdragDropListener = dragDropListener;
        this.data = data;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_cardview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final DataModel dataModel = data.get(position);

        holder.mversion_name.setText(dataModel.getName());
        holder.mversion_code.setText("API: "+dataModel.getVersion_number());
        holder.mversion_release_date.setText(dataModel.getFeature());
        holder.version_type.setText(dataModel.getType());
        holder.mversion_image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() ==
                        MotionEvent.ACTION_DOWN) {
                    mdragDropListener.requestDrag(holder);
                }
                return false;
            }
        });

      //  holder.mversion_image.setImageDrawable(mContext.getResources().getDrawable(dataModel.getImage_uri()));
/*
        holder.relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() ==
                        MotionEvent.ACTION_DOWN) {
                    mdragDropListener.requestDrag(holder);
                }
                return false;
            }
        });
*/


        Picasso
                .get()
                .load(dataModel.getImage_uri())
                .into(holder.mversion_image);


        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext," Hold on Image to Drag and Drop thePotion "+dataModel.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    @Override
    public void onRowMoved(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(data, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(data, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onRowSelected(MyViewHolder myViewHolder) {
        myViewHolder.rowView.setBackgroundColor(Color.GRAY);

    }

    @Override
    public void onRowClear(MyViewHolder myViewHolder) {
        myViewHolder.rowView.setBackgroundColor(Color.WHITE);

    }
}

