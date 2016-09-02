package net.laggedhero.filltype;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class CustomRecyclerView extends RecyclerView {

    private static final String TAG = "SnappyRecyclerView";

    private Canvas childCanvas;
    private Bitmap childBitmap;
    private Paint paint;
    private Path rect;
    private int cutSize;

    public CustomRecyclerView(Context context) {
        super(context);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void init() {
        childBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        childCanvas = new Canvas(childBitmap);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.TRANSPARENT);
        paint.setAlpha(0xFF);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public void setCutToSize(int size) {
        cutSize = size;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (cutSize == 0) {
            super.dispatchDraw(canvas);
            return;
        }

        if (childCanvas == null) {
            init();
        }

        childCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        super.dispatchDraw(childCanvas);

        childCanvas.save();

        final int width = getWidth();
        final int height = getHeight();

        rect = new Path();
        rect.addRect(
                0,
                height / 2 - cutSize / 2,
                width,
                height / 2 + cutSize / 2,
                Path.Direction.CW
        );
        rect.setFillType(Path.FillType.INVERSE_EVEN_ODD);

        childCanvas.drawPath(rect, paint);

        childCanvas.restore();

        canvas.drawBitmap(childBitmap, 0, 0, null);
    }
}
