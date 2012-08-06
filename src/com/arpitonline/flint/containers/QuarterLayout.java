package com.arpitonline.flint.containers;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

import com.arpitonline.flint.R;


public class QuarterLayout extends ViewGroup {
	
	private String orientation = "vertical";
	

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		Log.d("QuarterLayout", "Setting orientation > "+orientation);
		this.orientation = orientation;
	}

	public QuarterLayout(Context context) {
		super(context);
	}

	public QuarterLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.QuarterLayout);
		CharSequence o = arr.getString(R.styleable.QuarterLayout_orientation);
		if(o != null){
			this.orientation = o.toString();
		}
		arr.recycle();
	}

	public QuarterLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		int count = getChildCount();
		
	}
	
	@Override 
	public ViewGroup.LayoutParams generateLayoutParams (AttributeSet attrs){
		LayoutParams params = new QuarterLayout.LayoutParams(getContext(), attrs);
		return params;
	}
	
	/**
	 * This seems to be called on a child to see if the layoutparams supplied
	 * here are something this class can understand. If not, generateDefaultLayoutParams 
	 * will be called.
	 */
	@Override
	protected boolean checkLayoutParams (ViewGroup.LayoutParams p){
		return p instanceof LayoutParams;
	}
	
	@Override
	protected ViewGroup.LayoutParams generateDefaultLayoutParams (){
		return new LayoutParams(getContext(), null);
	}
	
	
	public class LayoutParams extends ViewGroup.LayoutParams{
		
		private int position = -1;
		
		
		public LayoutParams(Context context, AttributeSet attrs) {
			super(context, attrs);	
			TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.QuarterLayout_LayoutParams);
			int wt = arr.getInteger(R.styleable.QuarterLayout_LayoutParams_item_weight,-1);
			Log.d("QuarterLayout", " Wt > "+wt);
		}
		
	}

}
