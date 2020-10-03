package th.ac.su.cp.quizgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import th.ac.su.cp.quizgame.model.Worditem;

public class WordListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        //สร้าง Adapter object
        MyAdapter adapter = new MyAdapter();
        //สร้าง Layout manager
        LinearLayoutManager lm = new LinearLayoutManager(WordListActivity.this);
        // เข้าถึง RecyclerView ในlayout
        RecyclerView rv = findViewById(R.id.word_list_recycler_view);
        rv.setLayoutManager(lm);// กำหนด layout manager ให้กับ RecycclerView
        rv.setAdapter(adapter);//กำหนด adapter ให้กับ RecycclerView

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        Worditem[] item = {
                 new Worditem(R.drawable.brunei,"Bandar Seri Begawan\nเมืองหลวง : ประเทศบรูไน"),
                 new Worditem(R.drawable.bangkok,"Bangkok\nเมืองหลวง : ประเทศไทย"),
                new Worditem(R.drawable.cambodia,"Phnom Penh\nเมืองหลวง : ประเทศกัมพูชา"),
                new Worditem(R.drawable.indonesia,"Jakarta\nเมืองหลวง : ประเทศอินโดนีเซีย"),
                new Worditem(R.drawable.malaysia,"Kuala Lumpur\nเมืองหลวง : ประเทศมาเลเซีย"),
                new Worditem(R.drawable.myanmar,"Naypyitaw\nเมืองหลวง : ประเทศพม่า"),
                new Worditem(R.drawable.philippines,"Manila\nเมืองหลวง : ประเทศฟิลิปปินส์"),
                new Worditem(R.drawable.singapore,"Singapore\nเมืองหลวง : ประเทศสิงคโปร์"),
                new Worditem(R.drawable.vientiane,"Vientiane\nเมืองหลวง : ประเทศลาว"),
                new Worditem(R.drawable.vietnam,"Hanoi\nเมืองหลวง : ประเทศเวียดนาม"),
        };

        public MyAdapter(){

        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_word, parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

                holder.imageView.setImageResource(item[position].imageResId);
                holder.wordTextView.setText(item[position].word);





        }

        @Override
        public int getItemCount() {
            return item.length;
        }

         class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView wordTextView;

            public MyViewHolder(@NonNull View itemView){
                super(itemView);
                imageView = itemView.findViewById(R.id.image_View);
                wordTextView = itemView.findViewById(R.id.word_text_View);
            }
        }
    }
}

