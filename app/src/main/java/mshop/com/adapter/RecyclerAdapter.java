package mshop.com.adapter;

import android.content.Context;
import android.nfc.Tag;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mshop.com.applymaterial.R;
import mshop.com.model.LandScape;

import static android.content.ContentValues.TAG;

/**
 * Created by Ricky on 26/06/2016.
 */

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<LandScape> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<LandScape> data) {
        mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = mInflater.inflate(R.layout.file_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder  "+position);

        LandScape currentObj = mData.get(position);
        holder.setData(currentObj, position);
        holder.setListeners();
    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mData.size());
    }

    public void addItem(int position, LandScape landScape) {
        mData.add(position, landScape);
        notifyItemInserted(position);
        notifyItemMoved(position, mData.size()); // Pr régler le pb d'inconsistence au niveau de l'adapter
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView imgThumb, imgDelete, imgAdd;
        int position;
        LandScape current;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvxTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.imgRow);
            imgAdd = (ImageView) itemView.findViewById(R.id.img_row_add);
            imgDelete = (ImageView) itemView.findViewById(R.id.img_row_delete);
        }

        public void setData(LandScape currentObj, int position) {
            this.title.setText(currentObj.getTitle());
            this.imgThumb.setImageResource(currentObj.getImageID());
            this.position = position;
            this.current = currentObj;
        }

        @Override
        public void onClick(View view) {
            Log.i(TAG, "onClick before operation at position: "+position+" Size: "+mData.size());
            switch (view.getId()) {
                case R.id.img_row_delete:
                    removeItem(position);
                    break;
                case R.id.img_row_add:
                    addItem(position, current);
                    break;
            }
            Log.i(TAG, "onClick after operation - Size: "+mData.size());
        }

        public void setListeners() {
            imgAdd.setOnClickListener(MyViewHolder.this);
            imgDelete.setOnClickListener(MyViewHolder.this);
        }
    }

}
