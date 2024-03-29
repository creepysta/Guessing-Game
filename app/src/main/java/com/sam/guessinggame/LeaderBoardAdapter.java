package com.sam.guessinggame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmResults;

public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.LeaderBoardViewHolder> {

    private RealmResults<Player> playerResults;
    private Context context;

    public LeaderBoardAdapter(RealmResults<Player> playerResults, Context context) {
        this.playerResults = playerResults;
        this.context = context;
    }

    @NonNull
    @Override
    public LeaderBoardAdapter.LeaderBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leader_board_item, parent, false);
        return new LeaderBoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderBoardAdapter.LeaderBoardViewHolder holder, int position) {
        Player player = playerResults.get(position);
        holder.name.setText(player.getName());
        holder.score.setText(String.valueOf(player.getRecentScore()));
        holder.maxScore.setText(String.valueOf(player.getMax_score()));
    }

    public int getItemCount() {
        return playerResults.size();
    }

    public class LeaderBoardViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView score;
        private TextView maxScore;


        public LeaderBoardViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_lb_tv);
            score = itemView.findViewById(R.id.score_lb_tv);
            maxScore = itemView.findViewById(R.id.max_lb_tv);
        }
    }

}
