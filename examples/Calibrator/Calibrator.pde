import wiremap.Wiremap;
import wiremap.WiremapSliver;

Wiremap map;
WiremapSliver sliver;;

void setup() {
    size(1024, 768);

    map = new Wiremap(this, 256, 90, 36, 48, .1875, .1875, 2,
            "depth256.txt");

    sliver = new WiremapSliver(map, 0, 0, color(255, 0, 0),
            height, 0, color(255, 0, 0));
    background(0);
}

void draw() {
    
    float thirdOfMaximumDepth = ((float) map.getMaximumDepth() + 1) / 3;

    for(int i = 0;  i < map.getWireCount(); i++) {
        if(map.getWireDepth(i) > thirdOfMaximumDepth 
                && map.getWireDepth(i) < thirdOfMaximumDepth * 2) {
            sliver.setBaseColor(color(255, 0, 0));
        } else if(map.getWireDepth(i) > thirdOfMaximumDepth * 2) {
            sliver.setBaseColor(color(0, 255, 0));
        } else {
            sliver.setBaseColor(color(0, 0, 255));
        }
        sliver.setWire(i);
        sliver.display();
    }
    noLoop();
}

