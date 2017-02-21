package com.example.qiaozhennan.chatuitest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by qiaozhennan on 2017/2/16.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHoder> {

    private List<MSG> msgsList;
     public ChatAdapter(List<MSG> msgsList){
         this.msgsList=msgsList;
     }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);

        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {
        MSG msg = msgsList.get(position);
        if (msg.getType()==MSG.TYPE_RECEIVED){
            holder.left_layout.setVisibility(View.VISIBLE);
            holder.right_layput.setVisibility(View.GONE);
            holder.msg_left.setText(msg.getContent());
        }else {
            holder.right_layput.setVisibility(View.VISIBLE);
            holder.left_layout.setVisibility(View.GONE);
            holder.msg_right.setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return msgsList.size();
    }

    static class ViewHoder extends RecyclerView.ViewHolder {
        LinearLayout left_layout;
        LinearLayout right_layput;
        TextView msg_left;
        TextView msg_right;


        public ViewHoder(View itemView) {
            super(itemView);
            left_layout = (LinearLayout) itemView.findViewById(R.id.left_layout);
            right_layput = (LinearLayout) itemView.findViewById(R.id.right_layout);
            msg_left = (TextView) itemView.findViewById(R.id.left_msg);
            msg_right = (TextView) itemView.findViewById(R.id.left_right);

        }
    }

}
