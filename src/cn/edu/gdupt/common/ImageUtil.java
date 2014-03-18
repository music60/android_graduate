package cn.edu.gdupt.common;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.Log;

public class ImageUtil {
	
	
	//描边
	public static Bitmap drawRound(Bitmap bitmap){
		
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		
		Log.e("wd", width+"");
		Log.e("ht", height+"");
		
		float roundPx = 0;
		float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
		if (width <= height) {
			roundPx = width / 2;

			left = 0;
			top = 0;
			right = width;
			bottom = width;

			height = width;

			dst_left = 0;
			dst_top = 0;
			dst_right = width;
			dst_bottom = width;
		} else {
			roundPx = height / 2;

			float clip = (width - height) / 2;

			left = clip;
			right = width - clip;
			top = 0;
			bottom = height;
			width = height;

			dst_left = 0;
			dst_top = 0;
			dst_right = height;
			dst_bottom = height;
		}

		
		Bitmap output = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
//		paint.setStrokeWidth(5);
		
		final Rect src = new Rect((int) left-7, (int) top-7, (int) right-7, (int) bottom-7);
		final Rect dst = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
		final RectF rectF = new RectF(dst);
		//paint.setStyle(Paint.Style.STROKE);
		//设置边框宽度
		paint.setStrokeWidth(5);
		paint.setAntiAlias(true);// 设置画笔无锯齿
		canvas.drawCircle(width/2,height/2, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));// 设置两张图片相交时的模式,参考http://trylovecatch.iteye.com/blog/1189452
		canvas.drawBitmap(bitmap, src, dst, paint); // 以Mode.SRC_IN模式合并bitmap和已经draw了的Circle
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(14);
		canvas.drawCircle(width/2,height/2, roundPx-7, paint);
		return output;
	}
	
	/**
	 * 转换图片成圆形
	 * 
	 * @param bitmap 传入Bitmap对象
	 *            
	 * @return
	 */
	public static Bitmap toRoundBitmap(Bitmap bitmap) {
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		float roundPx;
		float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
		if (width <= height) {
			roundPx = width / 2;

			left = 0;
			top = 0;
			right = width;
			bottom = width;

			height = width;

			dst_left = 0;
			dst_top = 0;
			dst_right = width;
			dst_bottom = width;
		} else {
			roundPx = height / 2;

			float clip = (width - height) / 2;

			left = clip;
			right = width - clip;
			top = 0;
			bottom = height;
			width = height;

			dst_left = 0;
			dst_top = 0;
			dst_right = height;
			dst_bottom = height;
		}

		Bitmap output = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final Paint paint = new Paint();
		final Rect src = new Rect((int) left, (int) top, (int) right, (int) bottom);
		final Rect dst = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
		final RectF rectF = new RectF(dst);

		paint.setAntiAlias(true);// 设置画笔无锯齿

		canvas.drawARGB(0, 0, 0, 0); // 填充整个Canvas
//		canvas.drawRoundRect(rectF, roundPx, roundPx+35, paint);
		// 以下有两种方法画圆,drawRounRect和drawCircle
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);// 画圆角矩形，第一个参数为图形显示区域，第二个参数和第三个参数分别是水平圆角半径和垂直圆角半径。
		// canvas.drawCircle(roundPx, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));// 设置两张图片相交时的模式,参考http://trylovecatch.iteye.com/blog/1189452
		canvas.drawBitmap(bitmap, src, dst, paint); // 以Mode.SRC_IN模式合并bitmap和已经draw了的Circle
		
		
		return output;
	}
	/**
	 * 转换图片成圆形
	 * 
	 * @param bitmap 传入Bitmap对象
	 *            
	 * @return
	 */
	public static Bitmap toRoundBitmap(Bitmap bitmap,int color) {
		
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		float roundPx;
		
		float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
		if (width <= height) {
			roundPx = width / 2;
			
			left = 0;
			top = 0;
			right = width;
			bottom = width;
			
			height = width;
			
			dst_left = 0;
			dst_top = 0;
			dst_right = width;
			dst_bottom = width;
		} else {
			roundPx = height / 2;
			
			float clip = (width - height) / 2;
			
			left = clip;
			right = width - clip;
			top = 0;
			bottom = height;
			width = height;
			
			dst_left = 0;
			dst_top = 0;
			dst_right = height;
			dst_bottom = height;
		}
		
		Bitmap output = Bitmap.createBitmap(width+15, height+15, Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		
		final Paint paint = new Paint();
		final Rect src = new Rect((int) left, (int) top, (int) right, (int) bottom);
		final Rect dst = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
		final Rect dst2 = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
		final RectF rectF = new RectF(dst);
		final RectF rectF2 = new RectF(dst2);
		
		paint.setAntiAlias(true);// 设置画笔无锯齿
		
		canvas.drawARGB(0, 0, 0, 0); // 填充整个Canvas
		
		// 以下有两种方法画圆,drawRounRect和drawCircle
		paint.setColor(Color.WHITE);
		canvas.drawRoundRect(rectF, roundPx, roundPx+5, paint);
		
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);// 画圆角矩形，第一个参数为图形显示区域，第二个参数和第三个参数分别是水平圆角半径和垂直圆角半径。
		canvas.drawCircle(roundPx, roundPx, roundPx, paint);
		
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));// 设置两张图片相交时的模式,参考http://trylovecatch.iteye.com/blog/1189452
		canvas.drawBitmap(bitmap, src, dst, paint); // 以Mode.SRC_IN模式合并bitmap和已经draw了的Circle
		canvas.drawARGB(1, 255, 255, 255); // 填充整个Canvas
		canvas.drawRoundRect(rectF2, roundPx, roundPx, paint);
		canvas.drawBitmap(bitmap, src, dst, paint);
		
		paint.setXfermode(new PorterDuffXfermode(Mode.SCREEN));
		paint.setColor(Color.WHITE);
		paint.setAlpha(1);
		canvas.drawARGB(1, 255, 255, 255); // 填充整个Canvas
		paint.setStrokeWidth(5);
		canvas.drawCircle(roundPx, roundPx, roundPx-12, paint);
		
		return output;
	}
	
	/**
	 * 设置圆角图片
	 * @param bitmap 
	 * @param roundPx 圆角大小 
	 * @return
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap,float roundPx) {  
	    Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),  
	        bitmap.getHeight(), Config.ARGB_8888);  
	    Canvas canvas = new Canvas(output);  
	  
	  
	    final int color = 0xff424242;  
	    final Paint paint = new Paint();  
	    final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());  
	    final RectF rectF = new RectF(rect);  
//	    final float roundPx = 12;  
	  
	  
	    paint.setAntiAlias(true);  
	    canvas.drawARGB(0, 0, 0, 0);  
	    paint.setColor(color);  
	    canvas.drawRoundRect(rectF, roundPx, roundPx, paint);  
	  
	  
	    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));  
	    canvas.drawBitmap(bitmap, rect, rect, paint);  
	  
	  
	    return output;  
	   
	} 
	
	
	/***
	 * 设置图片倒影
	 * @param originalBitmap
	 * @return
	 */
	public static Bitmap createReflectedImage(Bitmap originalBitmap) {  
        // 图片与倒影间隔距离  
        final int reflectionGap = 4;  
          
        // 图片的宽度  
        int width = originalBitmap.getWidth();  
        // 图片的高度  
        int height = originalBitmap.getHeight();  
          
        Matrix matrix = new Matrix();  
        // 图片缩放，x轴变为原来的1倍，y轴为-1倍,实现图片的反转  
        matrix.preScale(1, -1);  
        // 创建反转后的图片Bitmap对象，图片高是原图的一半。  
        Bitmap reflectionBitmap = Bitmap.createBitmap(originalBitmap, 0,  
                height / 2, width, height / 2, matrix, false);  
        // 创建标准的Bitmap对象，宽和原图一致，高是原图的1.5倍。  
        Bitmap withReflectionBitmap = Bitmap.createBitmap(width, (height  
                + height / 2 + reflectionGap), Config.ARGB_8888);  
  
        // 构造函数传入Bitmap对象，为了在图片上画图  
        Canvas canvas = new Canvas(withReflectionBitmap);  
        // 画原始图片  
        canvas.drawBitmap(originalBitmap, 0, 0, null);  
  
        // 画间隔矩形  
        Paint defaultPaint = new Paint();  
        canvas.drawRect(0, height, width, height + reflectionGap, defaultPaint);  
  
        // 画倒影图片  
        canvas.drawBitmap(reflectionBitmap, 0, height + reflectionGap, null);  
  
        // 实现倒影效果  
        Paint paint = new Paint();  
        LinearGradient shader = new LinearGradient(0, originalBitmap.getHeight(),   
                0, withReflectionBitmap.getHeight(), 0x70ffffff, 0x00ffffff,  
                TileMode.MIRROR);  
        paint.setShader(shader);  
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));  
  
        // 覆盖效果  
        canvas.drawRect(0, height, width, withReflectionBitmap.getHeight(), paint);  
  
        return withReflectionBitmap;  
    }  


}
