package Notifi.com;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{

    private final ArrayList<NotiData> mDataList;
    public MyRecyclerAdapter(ArrayList<NotiData> dataArrayList) {
        mDataList = dataArrayList;
    }


    //뷰 홀더를 생성하는 부분, 레이아웃을 만드는 부분
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }


    //뷰 홀더에 데이터를 설정하는 부분
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotiData item = mDataList.get(position);
        holder.app_name.setText(item.getApp_name());
        holder.title.setText(item.getTitle_of());
        holder.contents.setText(item.getContent_of());

    }


    //아이템의 수
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    void addItem(NotiData data) {
        // 외부에서 item을 추가시킬 함수입니다.
        mDataList.add(data);
    }


    //각각의 아이템의 리퍼런스를 저장할 뷰 홀더 클래스
    //반드시 RecyclerView.ViewHolder를 상속해야함
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView app_name;
        TextView title;
        TextView contents;

        public ViewHolder(View itemView){
            super(itemView);
            app_name = itemView.findViewById(R.id.App_Name);
            title = itemView.findViewById(R.id.Title);
            contents = itemView.findViewById(R.id.Content);
        }

    }


}
