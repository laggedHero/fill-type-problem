package net.laggedhero.filltype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
    }

    private void setUp() {
        CustomRecyclerView bgView = (CustomRecyclerView) findViewById(R.id.background_view);
        CustomRecyclerView fgView = (CustomRecyclerView) findViewById(R.id.foreground_view);

        bgView.setLayoutManager(new LinearLayoutManager(this));
        fgView.setLayoutManager(new LinearLayoutManager(this));

        bgView.setAdapter(new BackgroundAdapter());
        fgView.setAdapter(new ForegroundAdapter());

        fgView.setCutToSize(100);
    }
}
