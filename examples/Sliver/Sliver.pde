import wiremap.Wiremap;
import wiremap.WiremapSliver;

Wiremap map;
WiremapSliver sliver;

void setup() {
    size(1024, 768, P3D);

    map = new Wiremap(this, 256, 90, 36, 36, 48, .1875, .1875, 3,
            "depth256.txt");

    sliver = new WiremapSliver(map, 0, 200, color(265, 120, 45),
            150, 5, color(255, 255, 255));
}

void draw() {
    background(0);

    
    for(int i = 0; i < map.getWireCount(); i++) {
        sliver.display();
        sliver.setWire(i);
        sliver.setStartingHeight(mouseY);

    }
}

