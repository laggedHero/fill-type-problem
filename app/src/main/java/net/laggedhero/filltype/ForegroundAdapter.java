package net.laggedhero.filltype;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ForegroundAdapter extends RecyclerView.Adapter<SomeViewHolder> {
    @Override
    public SomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final FrameLayout frameLayout = new FrameLayout(parent.getContext());

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );

        frameLayout.setLayoutParams(params);

        frameLayout.setBackgroundColor(ContextCompat.getColor(parent.getContext(), R.color.colorAccent));

        TextView textView = new TextView(parent.getContext());
        textView.setText("Foreground");
        textView.setTextColor(ContextCompat.getColor(parent.getContext(), R.color.white));

        frameLayout.addView(textView);

        return new SomeViewHolder(frameLayout);
    }

    @Override
    public void onBindViewHolder(SomeViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
