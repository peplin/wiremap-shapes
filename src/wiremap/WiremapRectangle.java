package wiremap;

public class WiremapRectangle extends WiremapPositionedShape {
    protected float mWidth;
    protected float mHeight;
    protected float mDepth;
    protected int mBorderHeight;
    protected int mBorderColor;

    /**
     * z >= 0, z <= mDepthThickness
     */
    public WiremapRectangle(Wiremap map, float x, float y, float z,
            int baseColor, float width, float height, float depth,
            int borderHeight, int borderColor) {
        super(map, x, y, z, baseColor);
        setSize(width, height, depth);
        setBorderHeight(borderHeight);
        setBorderColor(borderColor);
    }

    public void display() {
        mMap.getParent().pushMatrix();
        for(int i = 0; i < mMap.getWireCount(); i++) {
            if(mMap.getWireDepth(i) >= 0
                    && (mMap.getWireX(i) >= (mX - mWidth / 2))
                    && (mMap.getWireX(i) <= (mX + mWidth / 2))) {
                double distanceToCenter =
                        Math.sqrt(Math.pow(mMap.getWireX(i) - mX, 2)
                                + Math.pow(mMap.getWireZ(i) - mZ, 2));
                if(distanceToCenter <= mDepth / 2) {
                    double yMinProjection =
                            (mY + mHeight / 2) * mMap.getDepth()
                                    / mMap.getWireZ(i);
                    double yMaxProjection =
                            (mY - mHeight / 2) * mMap.getDepth()
                                    / mMap.getWireZ(i);

                    WiremapSliver sliver =
                            new WiremapSliver(mMap,
                                    i,
                                    (int) (yMaxProjection * mMap.getPixelsPerInch()),
                                    mBaseColor,
                                    (int) (yMinProjection - yMaxProjection)
                                            * mMap.getPixelsPerInch(),
                                    0,
                                    0);
                    sliver.display();
                }
            }
        }
        mMap.getParent().popMatrix();
    }

    public void setSize(float width, float height, float depth) {
        mWidth = width;
        mHeight = height;
        mDepth = depth;
    }

    public void setBorderHeight(int height) {
        mBorderHeight = height;
    }

    public void setBorderColor(int borderColor) {
        mBorderColor = borderColor;
    }
}
