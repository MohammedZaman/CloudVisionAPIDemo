package com.example.mohammedzaman.cloudvisionapidemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawingView extends View {
    private Paint paint = new Paint();

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    private Bitmap bitmap;

    public List<Square> getShape() {
        return shape;
    }

    public void setShape(List<Square> shape) {
        this.shape = shape;
    }

    public void addShape(Square square){
        this.shape.add(square);

    };

    private List<Square> shape = new ArrayList<>();
    public DrawingView(Context context) {
        super(context);


    }
    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DrawingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {

    }




    @Override
    protected void onDraw(Canvas canvas ) {
        super.onDraw(canvas);


        paint.setColor(Color.RED);
        paint.setStrokeWidth(5f);
        if(bitmap != null) {
            Canvas s = new Canvas(bitmap);


            for (Square aShape : shape) {
                for (int i = 0; i < aShape.getVertices().size(); i++) {

                    s.drawLine(aShape.getVertices().get(0).x, aShape.getVertices().get(0).y, aShape.getVertices().get(1).x, aShape.getVertices().get(1).y, paint);
                    s.drawLine(aShape.getVertices().get(1).x, aShape.getVertices().get(1).y, aShape.getVertices().get(2).x, aShape.getVertices().get(2).y, paint);
                    s.drawLine(aShape.getVertices().get(2).x, aShape.getVertices().get(2).y, aShape.getVertices().get(3).x, aShape.getVertices().get(3).y, paint);
                    s.drawLine(aShape.getVertices().get(3).x, aShape.getVertices().get(3).y, aShape.getVertices().get(0).x, aShape.getVertices().get(0).y, paint);
                }


            }
        }




    }

    public void refresh(){
        this.invalidate();

    }



    public void clear(){
        this.shape.clear();
    }

//    public BitmapDrawable getCanavs(Bitmap sbitmap){
//
//
//        paint.setColor(Color.RED);
//        paint.setStrokeWidth(5f);
//
//
//        Bitmap tempBitmap = Bitmap.createBitmap(sbitmap.getWidth(), sbitmap.getHeight(), Bitmap.Config.RGB_565);
//        Canvas tempCanvas = new Canvas(tempBitmap);
//        tempCanvas.drawBitmap(sbitmap, 0, 0, null);
//
//        for(Square aShape : shape ){
//            for(int i = 0; i < aShape.getVertices().size(); i++) {
//
//                tempCanvas.drawLine(aShape.getVertices().get(0).x, aShape.getVertices().get(0).y, aShape.getVertices().get(1).x, aShape.getVertices().get(1).y,paint);
//                tempCanvas.drawLine(aShape.getVertices().get(1).x, aShape.getVertices().get(1).y, aShape.getVertices().get(2).x, aShape.getVertices().get(2).y,paint);
//                tempCanvas.drawLine(aShape.getVertices().get(2).x, aShape.getVertices().get(2).y, aShape.getVertices().get(3).x,aShape.getVertices().get(3).y,paint);
//                tempCanvas.drawLine(aShape.getVertices().get(3).x, aShape.getVertices().get(3).y, aShape.getVertices().get(0).x,aShape.getVertices().get(0).y,paint);
//            }
//
//
//        }
//
//
//        return new BitmapDrawable(getResources(), tempBitmap);
//    }



}
