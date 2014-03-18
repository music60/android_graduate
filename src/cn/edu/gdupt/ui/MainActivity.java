package cn.edu.gdupt.ui;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.edu.gdupt.R;

public class MainActivity extends BaseActivity {
	
	private boolean detail =false;
	private ViewPager viewPager;  
	private ArrayList<View> pageViews;  
	private ImageView imageView;  
	private ImageView[] imageViews; 
	 // 包裹滑动图片LinearLayout
	private ViewGroup main;
	private TextView main_introText;
	
	//子类滑动板块
	private LinearLayout tv1;
	private LinearLayout tv2;
	private LinearLayout tv3;
	private LinearLayout tv4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		//HorizontalScrollView hztsclv = (HorizontalScrollView)findViewById(R.id.main_hsv);
		/*ImageView image = (ImageView)findViewById(R.id.main_hsv_pic);*/
		LinearLayout mine_center = (LinearLayout)findViewById(R.id.mine_center);
		final LinearLayout main_intro = (LinearLayout)findViewById(R.id.main_intro);
		main_introText = (TextView)findViewById(R.id.main_introText);
		
		main_intro.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
//				if (MotionEvent.ACTION_DOWN==event.getAction()) {
//					Log.e("test", "down");
//				}
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					Log.e("test", "down");
					
					if (detail) {
						detail = false;
						main_introText.setText("《史记》不仅为中国之史学经典名著，同时还兼有经、史、子、集四部之特质，乃中国文化中最可宝贵之一大遗产。其纵述自轩辕迄汉武两千年事，原始察终，见盛 观衰，非仅一代良史，明为百王大法。太史公自诩此书「究天人之际，通古今之变...《史记》不仅为中国之史学经典名著，同时还兼有经、史、子、集四部之特质，乃中国文化中最可宝贵之一大遗产。其纵述自轩辕迄汉武两千年事，原始察终，见盛 观衰，非仅一代良史，明为百王大法。太史公自诩此书「究天人之际，通古今之变...");
					} else {
						main_introText.setText("《史记》不仅为中国之史学经典名著，同时还兼有经、史、子、集四部之特质，乃中国文化中最可宝贵之一大遗产。其纵述自轩辕迄汉武两千年事，原始察终，见盛 观衰，非仅一代良史，明为百王大法。太史公自诩此书「究天人之际，通古今之变...");
						detail = true;
					}
					break;
						case MotionEvent.ACTION_UP:
								Log.e("test", "up");	
					break;
						case MotionEvent.ACTION_MOVE:
							Log.e("test", "move");
							break;
						case MotionEvent.ACTION_OUTSIDE:
							Log.e("test", "outside");
							break;

				default:
					break;
				}
				return false;
			}
		});
		
		mine_center.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				redirectTo(LoginActivity.class);
				main_intro.getHeight();
				
//				main_intro.setTranslationY((float)(main_intro.getHeight()+20.0));
			}
		});
//		image.setScaleType(ScaleType.FIT_CENTER);
//		int height =hztsclv.getHeight();
//		int width =hztsclv.getWidth();
//		
		
//		ImageView img1 = new ImageView(this);
//		img1.setImageResource(R.drawable.main_sildebar);
//		hztsclv.addView(img1);
//		final TextView mTextView = (TextView)findViewById(com.example.graduate02.R.id.textView1);
//		setAllowDestroy(false,mTextView);
		/*new Thread(new Runnable() {
			@Override
			public void run() {
//			 	String url ="http://192.168.30.131:8080/graduate01/android/user/login.action?username=admin&password=admin";
			 	String url ="http://192.168.43.93:8080/graduate01/android/user/login.action?username=admin&password=admin";
		      	String json =  GsonUtil.getJson(url);
		      	json = json.replace("\\", "");
		      	json = json.replace("\"", "");
		      	Gson gson = new Gson();
		      	User user =null;
//		      	user=gson.fromJson(json, User.class);
		        user =gson.fromJson(json,new TypeToken<User>() {}.getType());
		                //mTextView.setText(user.getUsername());   //在TextView中显示  
		      	if (user!=null) {
//					mTextView.setText("not null "+user.getUsername()+"=" +json);
				} else {
					mTextView.setText("null"+json);
					
				}

			}
		}).start();*/
		initImg();
	}
	
	private void initImg(){
		
		 	LayoutInflater inflater = getLayoutInflater();  
	        View v1 = inflater.inflate(R.layout.item01, null);
	        View v2 = inflater.inflate(R.layout.item02, null);
	        View v3 = inflater.inflate(R.layout.item03, null);
	        View v4 = inflater.inflate(R.layout.item04, null);
	        
	        View v5 = inflater.inflate(R.layout.activity_main, null);
	        
	        pageViews = new ArrayList<View>();  
	        pageViews.add(v1);  
	        pageViews.add(v2);  
	        pageViews.add(v3);  
	        pageViews.add(v4);  
//	        pageViews.add(v5);  
	        
	        imageViews = new ImageView[pageViews.size()];  
	        main = (ViewGroup)inflater.inflate(R.layout.activity_main, null);  
	        
//	        ViewGroup group = (ViewGroup)main.findViewById(R.id.viewGroup);  
	        viewPager = (ViewPager)main.findViewById(R.id.guidePages);
	        
	        for (int i = 0; i < pageViews.size(); i++) {  
	            imageView = new ImageView(MainActivity.this);  
	            imageView.setLayoutParams(new LayoutParams(20,20));  
	            imageView.setPadding(20, 0, 20, 0);  
	            imageViews[i] = imageView;  
	            
//	            if (i == 0) {  
//	                //默认选中第一张图片
//	                imageViews[i].setBackgroundResource(R.drawable.page_indicator_focused);  
//	            } else {  
//	                imageViews[i].setBackgroundResource(R.drawable.page_indicator);  
//	            }  
//	            
//	            group.addView(imageViews[i]);  
	        }  
	        
	        setContentView(main);
//	        
//	        tv1 = (LinearLayout)v1.findViewById(R.id.linearLayout1);
//	        tv1.setOnClickListener(new LinearLayoutOnClickListener());
//	        tv2 = (LinearLayout)v2.findViewById(R.id.linearLayout1);
//	        tv2.setOnClickListener(new LinearLayoutOnClickListener());
//	        tv3 = (LinearLayout)v3.findViewById(R.id.linearLayout1);
//	        tv3.setOnClickListener(new LinearLayoutOnClickListener());
//	        tv4 = (LinearLayout)v4.findViewById(R.id.linearLayout1);
//	        tv4.setOnClickListener(new LinearLayoutOnClickListener());
	        
	        LinearLayout v43 =(LinearLayout)  main.findViewById(R.id.main_intro);
	        v43.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, "111", 1000).show();
				}
			});
	        LinearLayout v42 =(LinearLayout)  main.findViewById(R.id.mine_center);
	        v42.setOnClickListener(new OnClickListener() {
	        	
	        	@Override
	        	public void onClick(View v) {
	        		// TODO Auto-generated method stub
	        		redirectTo(CourseHomeActivity.class);
	        	}
	        });
	        
	        
	        viewPager.setAdapter(new GuidePageAdapter());  
	        viewPager.setOnPageChangeListener(new GuidePageChangeListener());  
	}
	
	
	class LinearLayoutOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			redirectTo(CourseHomeActivity.class);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

    
    // 指引页面数据适配器
    private class GuidePageAdapter extends PagerAdapter {  
  	  
        @Override  
        public int getCount() {  
            return pageViews.size();  
        }  
  
        @Override  
        public boolean isViewFromObject(View arg0, Object arg1) {  
            return arg0 == arg1;  
        }  
  
        @Override  
        public int getItemPosition(Object object) {  
            // TODO Auto-generated method stub  
            return super.getItemPosition(object);  
        }  
  
        @Override  
        public void destroyItem(View arg0, int arg1, Object arg2) {  
            // TODO Auto-generated method stub  
            ((ViewPager) arg0).removeView(pageViews.get(arg1));  
        }  
  
        @Override  
        public Object instantiateItem(View arg0, int arg1) {  
            // TODO Auto-generated method stub  
            ((ViewPager) arg0).addView(pageViews.get(arg1));  
            return pageViews.get(arg1);  
        }  
  
        @Override  
        public void restoreState(Parcelable arg0, ClassLoader arg1) {  
            // TODO Auto-generated method stub  
  
        }  
  
        @Override  
        public Parcelable saveState() {  
            // TODO Auto-generated method stub  
            return null;  
        }  
  
        @Override  
        public void startUpdate(View arg0) {  
            // TODO Auto-generated method stub  
  
        }  
  
        @Override  
        public void finishUpdate(View arg0) {  
            // TODO Auto-generated method stub  
  
        }  
    } 
    
    // 指引页面更改事件监听器
    private class GuidePageChangeListener implements OnPageChangeListener {  
    	  
        @Override  
        public void onPageScrollStateChanged(int arg0) {  
            // TODO Auto-generated method stub  
  
        }  
  
        @Override  
        public void onPageScrolled(int arg0, float arg1, int arg2) {  
            // TODO Auto-generated method stub  
  
        }  
  
        @Override  
        public void onPageSelected(int index) { 
//            for (int i = 0; i < imageViews.length; i++) {  
            	Toast.makeText(MainActivity.this, "abk"+index, 1000).show();
////                imageViews[arg0].setBackgroundResource(R.drawable.page_indicator_focused);
            	main_introText.setText(index+"...");
                
//                if (arg0 != i) {  
////                    imageViews[i].setBackgroundResource(R.drawable.page_indicator);  
//                }  
//            }
        }  
    }  
}
