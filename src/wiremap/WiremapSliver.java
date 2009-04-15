package wiremap;

public class WiremapSliver extends WiremapShape {
    private int mWire;
    private int mStartingHeight; // these coords are in Processing format
    private int mHeight;
    private int mCapHeight;
    private int mCapColor;

    public WiremapSliver(Wiremap map, int wire, int startingHeight,
            int baseColor, int height, int capHeight, int capColor) {
        super(map, baseColor);
        setWire(wire);
        setStartingHeight(startingHeight);
        setHeight(height);
        setCapHeight(capHeight);
        setCapColor(capColor);
    }

    public void display() {
        mMap.getParent().pushMatrix();
        mMap.getParent().noStroke();

        mMap.getParent().fill(mCapColor);
        // top dot for sliver
        float left = mWire * mMap.getParent().width / mMap.getWireCount();
        mMap.getParent().rect(left,
                mStartingHeight,
                mMap.getPixelsPerWire(),
                mCapHeight);

        if(mMap.isSimulation()) {
            mMap.getParent().translate(0,
                    0,
                    mMap.getMaximumDepth() - mMap.getWireDepth(mWire));
        }

        // bottom dot for sliver
        mMap.getParent().rect(left,
                mStartingHeight + mHeight,
                mMap.getPixelsPerWire(),
                mCapHeight);

        // filler for sliver
        mMap.getParent().fill(mBaseColor);
        mMap.getParent().rect(left,
                mStartingHeight + mCapHeight,
                mMap.getPixelsPerWire(),
                mHeight - mCapHeight);
        mMap.getParent().popMatrix();
    }

    public void setCapHeight(int height) {
        mCapHeight = height;
    }

    public void setCapColor(int capColor) {
        mCapColor = capColor;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    public void setWire(int wire) {
        mWire = wire;
    }

    public void setStartingHeight(int height) {
        mStartingHeight = height;
    }
}
