import wiremap.Wiremap;
import wiremap.WiremapSphere;

Wiremap map;
WiremapSphere sphere;

void setup() {
    size(1024, 768, P3D);

    map = new Wiremap(this, 256, 90, 36, 36, 48, .1875, .1875, 4,
            "depth256.txt");

    sphere = new WiremapSphere(
            map, 200, 300, 10, color(267, 120, 45), 5);
}

void draw() {
    background(0);

    sphere.setPosition(mouseX, 300, map(mouseX, 0, 1024, 0, 20));
    sphere.display();
}

