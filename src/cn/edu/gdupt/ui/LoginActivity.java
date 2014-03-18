package cn.edu.gdupt.ui;

import android.os.Bundle;
import android.view.Window;

public class LoginActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(cn.edu.gdupt.R.layout.activity_login_view);
		setAllowFullScreen(isAllowFullScreen());
		
	}
}
