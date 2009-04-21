package wiremap;

public class WiremapSphere extends WiremapPositionedShape {
    protected float mRadius;

    /**
     * z >= 0, z <= mDepthThickness
     */
    public WiremapSphere(Wiremap map, float x, float y, float z, int baseColor,
            float radius) {
        super(map, x, y, z, baseColor);
        setRadius(radius);
    }

    public void display() {
        mMap.getParent().pushMatrix();
        displayCenter();
        mMap.getParent().popMatrix();
    }

    protected void displayCenter() {
        for(int i = 0; i < mMap.getWireCount(); i++) {
            // if a wire's x coord is close enough to the globe's center
            if(mMap.getWireDepth(i) >= 0
                    && (mMap.getWireX(i) >= (mX - mRadius))
                    && (mMap.getWireX(i) <= (mX + mRadius))) {
                // find the distance from the wire to the globe's center
                double distanceToCenter;
                double actualDistance =
                        Math.sqrt(Math.pow(mMap.getWireX(i) - mX, 2)
                                + Math.pow(mMap.getWireZ(i) - mZ, 2));
                if(mMap.getWireZ(i) < mZ) {
                    distanceToCenter =
                            Math.sqrt(Math.pow(mMap.getWireX(i) - mX, 2)
                                    + Math.pow(mMap.getWireZ(i)
                                            + mMap.getDepthUnit() / 2 - mZ, 2));
                } else {
                    distanceToCenter =
                            Math.sqrt(Math.pow(mMap.getWireX(i) - mX, 2)
                                    + Math.pow(mMap.getWireZ(i)
                                            - mMap.getDepthUnit() / 2 - mZ, 2));
                }
                // if the wire's xz coord is close enough to the globe's center
                if(distanceToCenter <= mRadius) {
                    // find the height of the globe at that point
                    double centerY =
                            Math.sqrt(Math.pow(mRadius, 2)
                                    - Math.pow(actualDistance, 2));
                    double yMinProjection =
                            (mY + centerY) * mMap.getDepth() / mMap.getWireZ(i);
                    double yMaxProjection =
                            (mY - centerY) * mMap.getDepth() / mMap.getWireZ(i);

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
    }

    public void setRadius(float radius) {
        mRadius = radius;
    }
}
