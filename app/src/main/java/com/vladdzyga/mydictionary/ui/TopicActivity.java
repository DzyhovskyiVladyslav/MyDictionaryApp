package com.vladdzyga.mydictionary.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.vladdzyga.mydictionary.R;
import com.vladdzyga.mydictionary.model.Topic;
import com.vladdzyga.mydictionary.viewmodel.TopicViewModel;
import java.util.List;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 18:10
 */
public class TopicActivity extends AppCompatActivity {

    private TopicViewModel topicViewModel;
    private ArrayAdapter<Topic> adapter;
    private int dictionaryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        final EditText editTopicName = findViewById(R.id.edit_topic_name);
        Button btnAddTopic = findViewById(R.id.btn_add_topic);
        ListView listTopics = findViewById(R.id.list_topics);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listTopics.setAdapter(adapter);

        topicViewModel = new ViewModelProvider(this).get(TopicViewModel.class);
        topicViewModel.getTopicsForDictionary(dictionaryId).observe(this, new Observer<List<Topic>>() {
            @Override
            public void onChanged(List<Topic> topics) {
                adapter.clear();
                adapter.addAll(topics);
            }
        });

        btnAddTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTopicName.getText().toString();
                Topic topic = new Topic();
                topic.name = name;
                topic.dictionaryId = dictionaryId;
                topicViewModel.insert(topic);
            }
        });
    }
}
