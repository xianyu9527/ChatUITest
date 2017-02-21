package com.example.qiaozhennan.chatuitest;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    EditText inputText;
    Button sent;
    private ChatAdapter adapter;
    private List<MSG> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        inputText= (EditText) findViewById(R.id.input_text);
        sent= (Button) findViewById(R.id.sent);
        initMsg();

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new ChatAdapter(list);
        mRecyclerView.setAdapter(adapter);
        sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString().trim();
                if (!"".equals(content)){
                    MSG msg = new MSG(content,MSG.TYPE_SEND);
                    list.add(msg);
                    adapter.notifyItemInserted(list.size()-1);
                    mRecyclerView.scrollToPosition(list.size()-1);
                    inputText.setText("");
                }else {
                    Toast.makeText(MainActivity.this,"消息不能为空！",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



    private void initMsg() {
        MSG msg1 = new MSG("Hello nice to meet you!",MSG.TYPE_SEND);
        MSG msg2 = new MSG("Hello nice to meet you too!",MSG.TYPE_RECEIVED);
        MSG msg3 = new MSG("what is your name!",MSG.TYPE_RECEIVED);
        list.add(msg1);
        list.add(msg2);
        list.add(msg3);
    }

}
