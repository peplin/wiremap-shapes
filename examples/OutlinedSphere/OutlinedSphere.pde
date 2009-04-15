import wiremap.Wiremap;
import wiremap.WiremapOutlinedSphere;

Wiremap map;
WiremapOutlinedSphere outlinedSphere;

void setup() {
    size(1024, 768, P3D);

    map = new Wiremap(this, 256, 90, 36, 36, 48, .1875, .1875, 4,
            "depth256.txt");

    outlinedSphere = new WiremapOutlinedSphere(
            map, 500, 200, 5, color(180, 90, 45), 5, 15,
            color(255, 255, 255));
}

void draw() {
    background(0);

    outlinedSphere.setPosition(mouseX, 300, map(mouseY, 0, 768, 0, 20));
    outlinedSphere.display();
}

