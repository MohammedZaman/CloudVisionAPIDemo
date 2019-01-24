/*
 * DrawingView.java
 *
 * @author Mohammed Zaman
 *
 * A custom View class to overlay the image for the bounding Boxes to be drawn
 *
 * This class requires a bitmap to be set in order for the bounding boxes to be drawn.
 * Shapes have to be added to the List<> so they can be looped out and drawn on the canvas
 * to highlight the faces detected.
 *
 *
 *
 */




package com.example.mohammedzaman.cloudvisionapidemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
public class DrawingView extends View {

    private Paint paint = new Paint();
    private List<Square> shape = new ArrayList<>();
    private Bitmap bitmap;





    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public List<Square> getShape() {
        return shape;
    }

    public void setShape(List<Square> shape) {
        this.shape = shape;
    }

    public void addShape(Square square){
        this.shape.add(square);
    }


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
                // looping each Square object
                for (int i = 0; i < aShape.getVertices().size();i++) {
                    if(aShape.getVertices().size() == 4) {
                        // looping the vertices into drawLine to create Bounding box
                        s.drawLine(aShape.getVertices().get(0).x, aShape.getVertices().get(0).y, aShape.getVertices().get(1).x, aShape.getVertices().get(1).y, paint);
                        s.drawLine(aShape.getVertices().get(1).x, aShape.getVertices().get(1).y, aShape.getVertices().get(2).x, aShape.getVertices().get(2).y, paint);
                        s.drawLine(aShape.getVertices().get(2).x, aShape.getVertices().get(2).y, aShape.getVertices().get(3).x, aShape.getVertices().get(3).y, paint);
                        s.drawLine(aShape.getVertices().get(3).x, aShape.getVertices().get(3).y, aShape.getVertices().get(0).x, aShape.getVertices().get(0).y, paint);
                    }
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



}
