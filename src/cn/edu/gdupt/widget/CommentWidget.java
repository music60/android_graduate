package cn.edu.gdupt.widget;

import cn.edu.gdupt.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class CommentWidget extends LinearLayout {
	
	
	
	public CommentWidget(Context context) {
		super(context,null);
		// TODO Auto-generated constructor stub
	}

	public CommentWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context).inflate(R.layout.widget_comment,this,true);
		setWillNotDraw(false);
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		Paint paint = new Paint();
		//canvas.drawPaint(paint);
		paint.setColor(Color.GREEN);
		paint.setStrokeWidth(3);
		//canvas.drawRect(0,0,this.getWidth(),this.getHeight());
		canvas.drawLine(0, canvas.getHeight(), canvas.getWidth(), canvas.getHeight(),paint);
	}
	

}
