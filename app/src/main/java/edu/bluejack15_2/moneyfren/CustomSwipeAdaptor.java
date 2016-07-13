package edu.bluejack15_2.moneyfren;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Even on 7/12/2016.
 */
public class CustomSwipeAdaptor extends PagerAdapter{

    private String[] textTitle = {"Home","List Target", "Saving Money", "Report Money"};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdaptor(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return textTitle.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);

        TextView textView = (TextView) item_view.findViewById(R.id.swipe_layout_txtTitle);
        TextView textView1 = (TextView) item_view.findViewById(R.id.swipe_layout_txtCount);

        textView.setText(textTitle[position]);
        textView1.setText("Position: "+position);
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
