package edu.tdt.appstudent2.adapters.tkb;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.List;

import edu.tdt.appstudent2.R;
import edu.tdt.appstudent2.models.tkb.TkbMonhocShowItem;
import edu.tdt.appstudent2.utils.ColorGenerator;
import edu.tdt.appstudent2.utils.GradientGenerator;

/**
 * Created by Bichan on 7/19/2016.
 */
public class TkbNgayRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<TkbMonhocShowItem> lists;

    ColorGenerator generator = ColorGenerator.TKB;
    GradientGenerator generator2 = GradientGenerator.COLOR;


    public TkbNgayRecyclerViewAdapter(List<TkbMonhocShowItem> lists){
        this.lists = lists;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_tkb_monhoc, parent, false);
        RecyclerView.ViewHolder viewHolder = new MonhocViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TkbMonhocShowItem tkbMonhocShowItem = lists.get(position);
        MonhocViewHolder monhocViewHolder = (MonhocViewHolder) holder;
        monhocViewHolder.pos.setText(tkbMonhocShowItem.getPos());
        monhocViewHolder.timeStart.setText(tkbMonhocShowItem.getTimeStart());
        monhocViewHolder.timeFinish.setText(tkbMonhocShowItem.getTimeFinish());
        monhocViewHolder.tenMH.setText(tkbMonhocShowItem.getTenMH());
        monhocViewHolder.maMH.setText(tkbMonhocShowItem.getMaMH());
        monhocViewHolder.nhom.setText(tkbMonhocShowItem.getNhom());
        monhocViewHolder.to.setText(tkbMonhocShowItem.getTo());
        monhocViewHolder.phong.setText(tkbMonhocShowItem.getPhong());
        /*if(position + 1 == lists.size()){
            monhocViewHolder.line.setVisibility(View.GONE);
        }else {
            monhocViewHolder.line.setVisibility(View.GONE);
        }*/

        int color = generator.getColor(tkbMonhocShowItem.getPos());
        GradientDrawable backgroundGradient = (GradientDrawable)monhocViewHolder.pos.getBackground();
        //backgroundGradient.setStroke(5, color);
        backgroundGradient.setColor(color);

        String[] colors = generator2.getColor(tkbMonhocShowItem.getTenMH());

        GradientDrawable backgroundGradient2 = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{Color.parseColor(colors[0]), Color.parseColor(colors[1])});
        backgroundGradient2.setCornerRadius(10);
        monhocViewHolder.layout.setBackground(backgroundGradient2);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class MonhocViewHolder extends RecyclerView.ViewHolder{
        public TextView pos, timeStart, timeFinish, tenMH, maMH, nhom, to, phong;
        public MaterialRippleLayout layout;
        public MonhocViewHolder(View itemView) {
            super(itemView);
            pos = (TextView) itemView.findViewById(R.id.pos_text);
            timeStart = (TextView) itemView.findViewById(R.id.time_start_text);
            timeFinish = (TextView) itemView.findViewById(R.id.time_finish_text);
            tenMH = (TextView) itemView.findViewById(R.id.tenMH_text);
            maMH = (TextView) itemView.findViewById(R.id.maMH_text);
            nhom = (TextView) itemView.findViewById(R.id.nhom_text);
            to = (TextView) itemView.findViewById(R.id.to_text);
            phong = (TextView) itemView.findViewById(R.id.phong_text);
            layout = (MaterialRippleLayout) itemView.findViewById(R.id.layout);
        }
    }
}
