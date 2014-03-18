package cn.edu.gdupt.ui;

import cn.edu.gdupt.R;
import cn.edu.gdupt.common.ImageUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class MineActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_user_detail);
		
		ImageView imageView = (ImageView)findViewById(R.id.imageView3);
		imageView.setImageResource(R.drawable.login_logo);
		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.tuijian01);
		bm=ImageUtil.toRoundBitmap(bm,000);
		
		Bitmap drawRound = ImageUtil.drawRound(bm);
		
		imageView.setImageBitmap(drawRound);
		
		ImageView imageView2 = (ImageView)findViewById(R.id.imageView3);
		imageView.setImageResource(R.drawable.login_logo);
		Bitmap bm2 = BitmapFactory.decodeResource(getResources(), R.drawable.tuijian01);
		bm=ImageUtil.toRoundBitmap(bm2,000);
		
		Bitmap drawRound2 = ImageUtil.drawRound(bm);
		
		imageView2.setImageBitmap(drawRound);
		
		ImageView imageView3 = (ImageView)findViewById(R.id.imageView3);
		imageView.setImageResource(R.drawable.login_logo);
		Bitmap bm3 = BitmapFactory.decodeResource(getResources(), R.drawable.tuijian01);
		bm=ImageUtil.toRoundBitmap(bm,000);
		
		Bitmap drawRound3 = ImageUtil.drawRound(bm3);
		
		imageView3.setImageBitmap(drawRound);

	}
	
}
