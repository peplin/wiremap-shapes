package wiremap;

public class WiremapLighthouse extends WiremapPositionedShape {
    protected float mHeight;
    protected float mDepth;
    protected int mBorderHeight;
    protected int mBorderColor;
    protected double mRotation;

    /**
     * z >= 0, z <= mDepthThickness
     */
    public WiremapLighthouse(Wiremap map, float x, float y, float z, int baseColor,
            float height, float depth, int borderHeight, int borderColor) {
        super(map, x, y, z, baseColor);
        setSize(height, depth);
        setBorderHeight(borderHeight);
        setBorderColor(borderColor);
    }

    public void display() {
        mMap.getParent().pushMatrix();
        for(int i = 0; i < mMap.getWireCount(); i++) {
            double distanceToFrontLine =
                    mMap.getFieldDepth() / 2 - mMap.getWireX(i)
                            * Math.tan(mRotation);
            double distanceToBackLine =
                    mMap.getFieldDepth() / 2 + mMap.getWireX(i)
                            * Math.tan(mRotation);
            if(mMap.getWireDepth(i) >= 0
                    && (((mMap.getWireZ(i) - mMap.getFieldDepth() >= (distanceToFrontLine - mDepth / 2)) && (mMap.getWireZ(i)
                            - mMap.getFieldDepth() <= (distanceToFrontLine + mDepth / 2))) || ((mMap.getWireZ(i)
                            - mMap.getFieldDepth() >= (distanceToBackLine - mDepth / 2)) && (mMap.getWireZ(i)
                            - mMap.getFieldDepth() <= (distanceToBackLine + mDepth / 2))))) {
                WiremapSliver sliver =
                        new WiremapSliver(mMap,
                                i,
                                (int) (mY * mMap.getPixelsPerInch()),
                                mBaseColor,
                                (int) (mHeight),
                                0,
                                0);
                sliver.display();
            }
        }
        mMap.getParent().popMatrix();
    }

    public void setSize(float height, float depth) {
        mHeight = height;
        mDepth = depth;
    }

    public void setBorderHeight(int height) {
        mBorderHeight = height;
    }

    public void setBorderColor(int borderColor) {
        mBorderColor = borderColor;
    }

    public void rotate(float rotation) {
        mRotation += rotation;
    }
}
