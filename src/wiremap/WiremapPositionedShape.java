package wiremap;

public abstract class WiremapPositionedShape extends WiremapShape {
    protected float mX;
    protected float mY;
    protected float mZ;
    protected float mRadius;

    /**
     * z >= 0, z <= mDepthThickness (inches)
     */
    public WiremapPositionedShape(Wiremap map, float x, float y, float z,
            int baseColor) {
        super(map, baseColor);
        setPosition(x, y, z);
    }

    public void setPosition(float x, float y, float z) {
        mX = translateProcessingXToWiremapX(x);
        mY = translateProcessingYToWiremapY(y);
        mZ = translateProcessingZToWiremapZ(z);
    }
}
