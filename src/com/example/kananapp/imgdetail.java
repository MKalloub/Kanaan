package com.example.kananapp;

import java.io.File;



import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.FloatMath;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class imgdetail  extends Fragment implements OnTouchListener{
	
	ImageView imageadv ;
	TextView det ;
	// these matrices will be used to move and zoom image
    private Matrix matrix = new Matrix();
    private Matrix savedMatrix = new Matrix();
    // we can be in one of these 3 states
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int mode = NONE;
    // remember some things for zooming
    private PointF start = new PointF();
    private PointF mid = new PointF();
    private float oldDist = 1f;
    private float d = 0f;
    private float newRot = 0f;
    private float[] lastEvent = null;
	
	int counter = 0 ;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
	View view = inflater.inflate(R.layout .imgdetail, container, false);

	

		return view;
	}
	
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		 String url = getArguments().getString("Image"); 
		 String de = getArguments().getString("Title"); 

		 Button n = (Button)getView().findViewById(R.id.button1) ;
		 Button p = (Button)getView().findViewById(R.id.button2) ;

		 
		 
		 
		 n.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				counter ++ ;
				
				
				if (counter== 0 ) {
					
					
				}
				else if (counter== 1) {
					
					ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
					 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.a);

					 touch.setImageBitmap(largeIcon);
					
					
				}
				
else if (counter== 2) {
					
	ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
	 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.b);

	 touch.setImageBitmap(largeIcon);
					
					
				}
				
				
else if (counter== 3) {
	ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
	 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.c);

	 touch.setImageBitmap(largeIcon);
	
	
	
}
				
				
else if (counter== 4) {
	
	ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
	 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.d);

	 touch.setImageBitmap(largeIcon);
	
	
}
				
else if (counter== 5) {
	
	
	ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
	 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.e);

	 touch.setImageBitmap(largeIcon);
	
}
				
				
				
else if (counter== 6) {
	
	ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
	 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.gggg);

	 touch.setImageBitmap(largeIcon);
	
	
}
	
				
else if (counter== 7) {
	
	ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
	 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.g);

	 touch.setImageBitmap(largeIcon);
	
	
}
	
				
				
else if (counter== 8) {
	
	ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
	 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.h);

	 touch.setImageBitmap(largeIcon);
	
	
}
				
				
else {
	
	ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
	 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.i);

	 touch.setImageBitmap(largeIcon);
	
	 
	 counter = 1 ;
	
}
	
				
				
				
			}
		});
		 
		 p.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
				
					counter -- ;
					
					if (counter== 0 ) {
						
						
					}
					else if (counter== 1) {
						
						ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
						 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.a);

						 touch.setImageBitmap(largeIcon);
						
						
					}
					
	else if (counter== 2) {
						
		ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
		 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.b);

		 touch.setImageBitmap(largeIcon);
						
						
					}
					
					
	else if (counter== 3) {
		ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
		 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.c);

		 touch.setImageBitmap(largeIcon);
		
		
		
	}
					
					
	else if (counter== 4) {
		
		ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
		 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.d);

		 touch.setImageBitmap(largeIcon);
		
		
	}
					
	else if (counter== 5) {
		
		
		ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
		 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.e);

		 touch.setImageBitmap(largeIcon);
		
	}
					
					
					
	else if (counter== 6) {
		
		ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
		 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.gggg);

		 touch.setImageBitmap(largeIcon);
		
		
	}
		
					
	else if (counter== 7) {
		
		ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
		 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.g);

		 touch.setImageBitmap(largeIcon);
		
		
	}
		
					
					
	else if (counter== 8) {
		
		ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
		 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.h);

		 touch.setImageBitmap(largeIcon);
		
		
	}
					
					
	else {
		
		ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);	
		 Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.i);

		 touch.setImageBitmap(largeIcon);
		
		 
		 counter = 1 ;
		
	}
					
					
				}
			});
		 
		 
		 
		// TouchImageView img = new TouchImageView(getActivity()); 
		//  imageadv = (ImageView) getView().findViewById(R.id.imageView1) ;
		 // imageadv.setOnTouchListener(this);
		 ZoomableImageView touch = (ZoomableImageView)getView().findViewById(R.id.IMAGEID);
			File imgFile = new  File(url);

			if(imgFile.exists()){

			    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
			    touch.setImageBitmap(myBitmap);
			  // imageadv.setImageBitmap(myBitmap);
			    //img.setImageBitmap(myBitmap);

			}
			
			
			  // img.setMaxZoom(4f); 

		  
		   
		 //  imageadv.setOnTouchListener(this);
		 //  imageadv.setOnTouchListener(new ChoiceTouchListener());
		   
		   det = (TextView) getView().findViewById(R.id.textView1) ;
det.setText(de) ;
		

Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
        "GE.Thameen.Book.otf");
det.setTypeface(tf);	




		
		
		//Toast.makeText(getActivity(), url, Toast.LENGTH_LONG).show() ;

		
	}


	 public boolean onTouch(View v, MotionEvent event) {
	        // handle touch events here
	        ImageView view = (ImageView) v;
	        switch (event.getAction() & MotionEvent.ACTION_MASK) {
	            case MotionEvent.ACTION_DOWN:
	                savedMatrix.set(matrix);
	                start.set(event.getX(), event.getY());
	                mode = DRAG;
	                lastEvent = null;
	                break;
	            case MotionEvent.ACTION_POINTER_DOWN:
	                oldDist = spacing(event);
	                if (oldDist > 10f) {
	                    savedMatrix.set(matrix);
	                    midPoint(mid, event);
	                    mode = ZOOM;
	                }
	                lastEvent = new float[4];
	                lastEvent[0] = event.getX(0);
	                lastEvent[1] = event.getX(1);
	                lastEvent[2] = event.getY(0);
	                lastEvent[3] = event.getY(1);
	                d = rotation(event);
	                break;
	            case MotionEvent.ACTION_UP:
	            case MotionEvent.ACTION_POINTER_UP:
	                mode = NONE;
	                lastEvent = null;
	                break;
	            case MotionEvent.ACTION_MOVE:
	                if (mode == DRAG) {
	                    matrix.set(savedMatrix);
	                    float dx = event.getX() - start.x;
	                    float dy = event.getY() - start.y;
	                    matrix.postTranslate(dx, dy);
	                } else if (mode == ZOOM) {
	                    float newDist = spacing(event);
	                    if (newDist > 10f) {
	                        matrix.set(savedMatrix);
	                        float scale = (newDist / oldDist);
	                        matrix.postScale(scale, scale, mid.x, mid.y);
	                    }
	                    if (lastEvent != null && event.getPointerCount() == 3) {
	                        newRot = rotation(event);
	                        float r = newRot - d;
	                        float[] values = new float[9];
	                        matrix.getValues(values);
	                        float tx = values[2];
	                        float ty = values[5];
	                        float sx = values[0];
	                        float xc = (view.getWidth() / 2) * sx;
	                        float yc = (view.getHeight() / 2) * sx;
	                        matrix.postRotate(r, tx + xc, ty + yc);
	                    }
	                }
	                break;
	        }

	        view.setImageMatrix(matrix);
	        return true;
	    }

	    /**
	     * Determine the space between the first two fingers
	     */
	    private float spacing(MotionEvent event) {
	        float x = event.getX(0) - event.getX(1);
	        float y = event.getY(0) - event.getY(1);
	        return FloatMath.sqrt(x * x + y * y);
	    }

	    /**
	     * Calculate the mid point of the first two fingers
	     */
	    private void midPoint(PointF point, MotionEvent event) {
	        float x = event.getX(0) + event.getX(1);
	        float y = event.getY(0) + event.getY(1);
	        point.set(x / 2, y / 2);
	    }

	    /**
	     * Calculate the degree to be rotated by.
	     *
	     * @param event
	     * @return Degrees
	     */
	    private float rotation(MotionEvent event) {
	        double delta_x = (event.getX(0) - event.getX(1));
	        double delta_y = (event.getY(0) - event.getY(1));
	        double radians = Math.atan2(delta_y, delta_x);
	        return (float) Math.toDegrees(radians);
	    }
	}