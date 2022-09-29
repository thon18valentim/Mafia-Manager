package br.com.up.mafia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private ArrayList<String> actions;

    public HistoryAdapter(ArrayList<String> item){
        this.actions = item;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View layout = layoutInflater.inflate(R.layout.view_item_history, parent, false);


        return new HistoryViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        String historyItem = actions.get(position);

        TextView textViewName = holder.itemView.findViewById(R.id.text_view_item_name);
        textViewName.setText(historyItem);
    }

    @Override
    public int getItemCount() {

        return actions.size();
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder{

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
