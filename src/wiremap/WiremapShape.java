package wiremap;

public abstract class WiremapShape {
    protected Wiremap mMap;
    protected int mBaseColor;

    public WiremapShape(Wiremap map, int baseColor) {
        mMap = map;
        setBaseColor(baseColor);
    }

    protected float translateProcessingXToWiremapX(float x) {
        return x / (float)mMap.getParent().width * mMap.getMaplineLength() 
                - (mMap.getMaplineLength() / 2);
    }

    protected float translateProcessingYToWiremapY(float y) {
        return y / (float)mMap.getParent().height * mMap.getHeight();
    }

    protected float translateProcessingZToWiremapZ(float z) {
        return mMap.getDepth() - z;
    }

    public abstract void display();

    public void setBaseColor(int baseColor) {
        mBaseColor = baseColor;
    }
}
