package cn.edu.gdupt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import cn.edu.gdupt.R;

public class HorizontalBar extends View {

	public HorizontalBar(Context context) {
		super(context);
		 this.inflate(context, R.layout.horizontalbar, null);
		// TODO Auto-generated constructor stub
	}
	
	public HorizontalBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.inflate(context, R.layout.horizontalbar, null);
        //LayoutInflater inflater = LayoutInflater.from(context);
        //inflater.inflate(R.layout.maintab, null);
        //init(attrs, 0);
}

}
