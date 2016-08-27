package unittesting.examzen.com.example.CreditCardBinder;

import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import unittesting.examzen.com.example.Lib.SectionedRecyclerViewAdapter;
import unittesting.examzen.com.example.R;

/**
 * Created by Tatyabhau Chavan on 8/27/2016.
 */
public class ImplementCustomAdapter extends SectionedRecyclerViewAdapter<ImplementCustomAdapter.ViewHolder> {


    @Override
    public int getSectionCount() {
        return 3;
    }

    @Override
    public int getItemCount(int section) {
        if (section % 2 == 0)
            return 4; // even sections get 4 items
        return 8; // odd get 8
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder, int section) {
        holder.title.setText(String.format("Section %d", section));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int section, int relativePosition, int absolutePosition) {
        holder.title.setText(String.format("S:%d, P:%d, A:%d", section, relativePosition, absolutePosition));
    }

    @Override
    public int getItemViewType(int section, int relativePosition, int absolutePosition) {
        if (section == 1)
            return 0; // VIEW_TYPE_HEADER is -2, VIEW_TYPE_ITEM is -1. You can return 0 or greater.
        return super.getItemViewType(section, relativePosition, absolutePosition);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                layout = R.layout.list_item_header;
                break;
            case VIEW_TYPE_ITEM:
                layout = R.layout.list_item_main;
                break;
            default:
                layout = R.layout.list_item_main_bold;
                break;
        }

        View v = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        return new ViewHolder(v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
