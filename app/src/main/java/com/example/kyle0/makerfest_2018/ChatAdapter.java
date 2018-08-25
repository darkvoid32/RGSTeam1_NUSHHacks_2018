package com.example.kyle0.makerfest_2018;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    private List<Message> messageList;
    private Context context;
    protected ChatAdapter.OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected TextView name, date, time , text;


        public MyViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.chrl_name);
            date = (TextView) view.findViewById(R.id.chrl_date);
            time = (TextView) view.findViewById(R.id.chrl_time);
            text = (TextView) view.findViewById(R.id.chrl_message);

            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getAdapterPosition());
            }
        }
    }

    public void setOnItemClickListener(final ChatAdapter.OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    public ChatAdapter(List<Message> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_row_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Message message = messageList.get(position);

        if(messageList.size() > 0){
            holder.name.setText(message.getName());
            holder.name.setTextColor(Color.WHITE);
            holder.date.setText(message.getDate());
            holder.time.setText(message.getTime());
            holder.text.setText(message.getMessage());
            if(message.getColor().equals("angry")){
                holder.text.setTextColor(Color.RED);
            }
            else if(message.getColor().equals("sad")){
                holder.text.setTextColor(Color.BLUE);
            }
            else if(message.getColor().equals("happy")){
                holder.text.setTextColor(Color.YELLOW);
            }
            else if(message.getColor().equals("disgust")){
                holder.text.setTextColor(Color.GREEN);
            }
            else if(message.getColor().equals("neutral")){
                holder.text.setTextColor(Color.WHITE);
            }
            else if(message.getColor().equals("fearful")){
                holder.text.setTextColor(Color.parseColor("#800080"));

            }

        }


    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public void setMessageList(List<Message> messageList){
        this.messageList = messageList;
        notifyDataSetChanged();
    }

    public List<Message> getMessageList() {
        return messageList;
    }
}
