package com.example.footballinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MatchesAdapter extends BaseAdapter {

    ArrayList<MatchInfo> list = new ArrayList<>();

    public void setList(ArrayList<MatchInfo> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main,null);
        }

        TextView homeTeamName = view.findViewById(R.id.homeTeam);
        homeTeamName.setText(list.get(i).getTeamhouse());

        TextView guestTeamName = view.findViewById(R.id.guestTeam);
        guestTeamName.setText(list.get(i).getTeamguest());

        TextView homeGoals = view.findViewById(R.id.homeGoals);
        //homeGoals.setText(list.get(i).get);

        return null;
    }
}
