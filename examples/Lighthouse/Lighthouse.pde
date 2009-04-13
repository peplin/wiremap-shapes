import wiremap.Wiremap;
import wiremap.WiremapLighthouse;

Wiremap map;
WiremapLighthouse lighthouse;

float rotation = 0;

void setup() {
    size(1024, 768);

    map = new Wiremap(this, 256, 90, 36, 48, .1875, .1875, 4,
            "depth256.txt");

    lighthouse = new WiremapLighthouse(map, mouseX, mouseY, 10, color(265, 120, 45),
            10, 10, 5, color(255, 255, 255));
}

void draw() {
    background(0);

    lighthouse.setPosition(mouseX, mouseY, 10);
    lighthouse.rotate(rotation);
    lighthouse.display();
    
    rotation += .02;
}

